package com.poongcha.car.application.caroptiongroup;

import com.poongcha.car.application.dto.CarOptionGroupCreateRequest;
import com.poongcha.car.application.dto.OptionGroupAddIncompatibleOptionGroupRequest;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupRepository;
import com.poongcha.car.exception.NotFoundException;
import java.util.List;
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

    public long add(
            final long carOptionGroupId,
            final OptionGroupAddIncompatibleOptionGroupRequest optionGroupAddIncompatibleOptionGroupRequest
    ) {
        CarOptionGroup carOptionGroup = carOptionGroupRepository.findByIdWithLock(carOptionGroupId)
                .orElseThrow(() -> new NotFoundException("옵션 그룹을 찾을 수 없습니다."));

        List<CarOptionGroup> inCompatibleCarOptionGroups = carOptionGroupRepository.findAllByIdInWithLock(
                optionGroupAddIncompatibleOptionGroupRequest.getIncompatibleOptionGroupIds()
        );

        carOptionGroup.addIncompatibleCarOptionGroup(inCompatibleCarOptionGroups);

        carOptionGroupRepository.saveAll(inCompatibleCarOptionGroups);
        return carOptionGroupRepository.save(carOptionGroup).getId();
    }
}
