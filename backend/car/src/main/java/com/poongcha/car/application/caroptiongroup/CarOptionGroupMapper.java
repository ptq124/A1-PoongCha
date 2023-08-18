package com.poongcha.car.application.caroptiongroup;

import com.poongcha.car.application.caroption.CarOptionMapper;
import com.poongcha.car.application.caroptiongroup.dto.CarOptionGroupCreateRequest;
import com.poongcha.car.application.caroptiongroup.dto.CarOptionGroupResponse;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupName;
import com.poongcha.car.domain.caroptiongroup.SummaryDescription;
import com.poongcha.car.domain.common.AdditionalPrice;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CarOptionGroupMapper {
    private final CarOptionMapper carOptionMapper;

    public CarOptionGroup toEntity(final CarOptionGroupCreateRequest carOptionGroupCreateRequest) {
        return new CarOptionGroup(
                new CarOptionGroupName(carOptionGroupCreateRequest.getCarOptionGroupName()),
                new AdditionalPrice(carOptionGroupCreateRequest.getAdditionalPrice()),
                new SummaryDescription(carOptionGroupCreateRequest.getSummaryDescription()),
                carOptionGroupCreateRequest.getCarOptionIds()
        );
    }

    public CarOptionGroupResponse toCarOptionGroupResponse(
            final CarOptionGroup carOptionGroup,
            final List<CarOption> carOptions
    ) {
        return new CarOptionGroupResponse(
                carOptionGroup.getId(),
                carOptionGroup.getName().getValue(),
                carOptionGroup.getAdditionalPrice().getValue(),
                carOptionGroup.getSummaryDescription().getValue(),
                carOptionMapper.toCarOptionResponse(carOptions)
        );
    }
}
