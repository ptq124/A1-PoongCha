package com.poongcha.car.application.trim;

import com.poongcha.car.application.carcolor.CarColorMapper;
import com.poongcha.car.application.dto.TrimCarColorResponse;
import com.poongcha.car.application.dto.TrimDefaultResponse;
import com.poongcha.car.domain.carcolor.CarColorRepository;
import com.poongcha.car.domain.trim.Trim;
import com.poongcha.car.domain.trim.TrimRepository;
import com.poongcha.car.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TrimQueryService {
    private final TrimRepository trimRepository;
    private final CarColorRepository carColorRepository;
    private final TrimMapper trimMapper;
    private final CarColorMapper carColorMapper;

    public TrimDefaultResponse findById(final long id) {
        Trim trim = trimRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Trim ID" + id + "가 존재하지 않습니다."));

        return trimMapper.toDefaultResponse(trim);
    }

    public List<TrimDefaultResponse> findAllByCarTypeId(final long carTypeId) {
        List<Trim> trims = trimRepository.findAllByCarType(carTypeId);

        if (trims.isEmpty()) {
            throw new NotFoundException("Car Type ID : " + carTypeId + "로 존재하는 트림을 찾을 수 없습니다.");
        }

        return trimMapper.toDefaultResponse(trims);
    }

    public List<TrimCarColorResponse> findCarTypeColors(final long carTypeId) {
        List<Trim> trims = trimRepository.findAllByCarType(carTypeId);

        if (trims.isEmpty()) {
            throw new NotFoundException("Car Type ID : " + carTypeId + "로 존재하는 트림을 찾을 수 없습니다.");
        }

        return trims.stream()
                .map(trim -> carColorMapper.toTrimCarColorResponse(
                        trim,
                        carColorRepository.findAllByIdIn(trim.carColorIds())
                )).collect(Collectors.toUnmodifiableList());
    }
}
