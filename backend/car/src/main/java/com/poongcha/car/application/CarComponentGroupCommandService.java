package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import com.poongcha.car.domain.CarComponentGroup;
import com.poongcha.car.domain.CarComponentGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarComponentGroupCommandService {
    private final CarComponentGroupRepository carComponentGroupRepository;
    private final CarComponentGroupMapper carComponentGroupMapper;

    public long create(final CarComponentGroupCreateRequest carComponentGroupCreateRequest) {
        CarComponentGroup carComponentGroup = carComponentGroupMapper.toEntity(carComponentGroupCreateRequest);
        return carComponentGroupRepository.save(carComponentGroup).getId();
    }
}
