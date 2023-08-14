package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarColorCreateRequest;
import com.poongcha.car.application.mapper.CarColorMapper;
import com.poongcha.car.domain.CarColor;
import com.poongcha.car.domain.CarColorRepository;
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
}
