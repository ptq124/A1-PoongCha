package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarTypeCreateRequest;
import com.poongcha.car.application.mapper.CarTypeMapper;
import com.poongcha.car.domain.CarType;
import com.poongcha.car.domain.CarTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarTypeCommandService {
    private final CarTypeRepository carTypeRepository;
    private final CarTypeMapper carTypeMapper;

    public long create(final CarTypeCreateRequest carTypeCreateRequest) {
        CarType carType = carTypeMapper.toEntity(carTypeCreateRequest);
        return carTypeRepository.save(carType).getId();
    }
}
