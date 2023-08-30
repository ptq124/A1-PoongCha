package com.poongcha.car.application.carcomponent;

import com.poongcha.car.application.dto.CarComponentCreateRequest;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponent.CarComponentRepository;
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
