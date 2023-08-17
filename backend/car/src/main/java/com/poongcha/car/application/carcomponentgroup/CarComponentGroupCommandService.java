package com.poongcha.car.application.carcomponentgroup;

import com.poongcha.car.application.carcomponentgroup.CarComponentGroupMapper;
import com.poongcha.car.application.dto.CarComponentGroupAddCarComponentRequest;
import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroupRepository;
import com.poongcha.car.exception.BadRequestException;
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

    public long add(
            final long carComponentGroupId,
            final CarComponentGroupAddCarComponentRequest carComponentGroupAddCarComponentRequest
    ) {
        CarComponentGroup carComponentGroup = carComponentGroupRepository.findByIdWithLock(carComponentGroupId)
                .orElseThrow(() -> new BadRequestException("차량 컴포넌트 그룹을 찾을 수 없습니다."));
        carComponentGroup.addCarComponent(carComponentGroupAddCarComponentRequest.getCarComponentIds());
        carComponentGroupRepository.save(carComponentGroup);
        return carComponentGroup.getId();
    }
}
