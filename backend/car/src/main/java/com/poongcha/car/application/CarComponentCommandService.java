package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarComponentCreateRequest;
import com.poongcha.car.domain.CarComponent;
import com.poongcha.car.domain.CarComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarComponentCommandService {
    private final CarComponentRepository carComponentRepository;
    private final CarComponentMapper carComponentMapper;

    public long create(final CarComponentCreateRequest carComponentCreateRequest) {
        CarComponent carComponent = carComponentMapper.toEntity(carComponentCreateRequest);
        return carComponentRepository.save(carComponent).getId();
    }
}
