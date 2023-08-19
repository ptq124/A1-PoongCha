package com.poongcha.car.application.caroptiontag;

import com.poongcha.car.application.dto.CarOptionTagCreateRequest;
import com.poongcha.car.domain.caroptiontag.CarOptionTag;
import com.poongcha.car.domain.caroptiontag.CarOptionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarOptionTagCommandService {
    private final CarOptionTagMapper carOptionTagMapper;
    private final CarOptionTagRepository carOptionTagRepository;

    public long create(final CarOptionTagCreateRequest carOptionTagCreateRequest) {
        CarOptionTag carOptionTag = carOptionTagMapper.toEntity(carOptionTagCreateRequest);

        return carOptionTagRepository.save(carOptionTag).getId();
    }
}
