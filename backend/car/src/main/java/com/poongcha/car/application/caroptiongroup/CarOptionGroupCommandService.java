package com.poongcha.car.application.caroptiongroup;

import com.poongcha.car.application.caroptiongroup.dto.CarOptionGroupCreateRequest;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarOptionGroupCommandService {
    private final CarOptionGroupRepository carOptionGroupRepository;
    private final CarOptionGroupMapper carOptionGroupMapper;

    public long create(final CarOptionGroupCreateRequest carOptionGroupCreateRequest) {
        CarOptionGroup carOptionGroup = carOptionGroupMapper.toEntity(carOptionGroupCreateRequest);

        return carOptionGroupRepository.save(carOptionGroup).getId();
    }
}
