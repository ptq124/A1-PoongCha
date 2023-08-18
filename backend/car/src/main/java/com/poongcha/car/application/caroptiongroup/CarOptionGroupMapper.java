package com.poongcha.car.application.caroptiongroup;

import com.poongcha.car.application.caroptiongroup.dto.CarOptionGroupCreateRequest;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupName;
import com.poongcha.car.domain.caroptiongroup.InstallationLocation;
import com.poongcha.car.domain.caroptiongroup.SummaryDescription;
import com.poongcha.car.domain.common.AdditionalPrice;
import org.springframework.stereotype.Component;

@Component
public class CarOptionGroupMapper {
    public CarOptionGroup toEntity(final CarOptionGroupCreateRequest carOptionGroupCreateRequest) {
        return new CarOptionGroup(
                new CarOptionGroupName(carOptionGroupCreateRequest.getCarOptionGroupName()),
                InstallationLocation.valueOf(carOptionGroupCreateRequest.getInstallationLocation()),
                new AdditionalPrice(carOptionGroupCreateRequest.getAdditionalPrice()),
                new SummaryDescription(carOptionGroupCreateRequest.getSummaryDescription())
        );
    }
}
