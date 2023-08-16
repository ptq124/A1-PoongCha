package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarColorAddIncompatibleColorRequest;
import com.poongcha.car.application.dto.CarColorCreateRequest;
import com.poongcha.car.application.mapper.CarColorMapper;
import com.poongcha.car.domain.CarColor;
import com.poongcha.car.domain.CarColorRepository;
import com.poongcha.car.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarColorCommandService {
    private final CarColorRepository carColorRepository;
    private final CarColorMapper carColorMapper;

    public long create(final CarColorCreateRequest carColorCreateRequest) {
        CarColor carColor = carColorMapper.toEntity(carColorCreateRequest);
        return carColorRepository.save(carColor).getId();
    }

    public long add(
            final long carColorId,
            final CarColorAddIncompatibleColorRequest carColorAddIncompatibleColorRequest
    ) {
        CarColor carColor = carColorRepository.findByIdWithLock(carColorId)
                .orElseThrow(() -> new BadRequestException("차량 색상이 존재하지 않습니다."));
        carColor.addIncompatibleColor(carColorAddIncompatibleColorRequest.getIds());
        return carColor.getId();
    }
}
