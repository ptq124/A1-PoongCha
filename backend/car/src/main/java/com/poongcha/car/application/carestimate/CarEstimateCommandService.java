package com.poongcha.car.application.carestimate;

import com.poongcha.car.application.dto.CarEstimateCreateRequest;
import com.poongcha.car.domain.carestimate.CarEstimate;
import com.poongcha.car.domain.carestimate.CarEstimateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarEstimateCommandService {
    private final CarEstimateRepository carEstimateRepository;
    private final CarEstimateMapper carEstimateMapper;

    public String create(final CarEstimateCreateRequest carEstimateCreateRequest) {
        CarEstimate carEstimate = carEstimateMapper.toEntity(carEstimateCreateRequest);

        return carEstimateRepository.save(carEstimate).getEstimateCode();
    }
}
