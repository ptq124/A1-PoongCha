package com.poongcha.car.application;

import com.poongcha.car.application.dto.TrimAddCarColorRequest;
import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.mapper.TrimMapper;
import com.poongcha.car.domain.Trim;
import com.poongcha.car.domain.TrimRepository;
import com.poongcha.car.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TrimCommandService {
    private final TrimRepository trimRepository;
    private final TrimMapper trimMapper;

    public long create(final TrimCreateRequest trimCreateRequest) {
        Trim trim = trimMapper.toEntity(trimCreateRequest);
        return trimRepository.save(trim).getId();
    }

    public long add(final long trimId, final TrimAddCarColorRequest trimAddTrimColorRequest) {
        Trim trim = trimRepository.findById(trimId)
                .orElseThrow(() -> new BadRequestException("트림이 존재하지 않습니다."));
        trim.addCarColor(trimAddTrimColorRequest.getColorId());
        return trimRepository.save(trim).getId();
    }
}
