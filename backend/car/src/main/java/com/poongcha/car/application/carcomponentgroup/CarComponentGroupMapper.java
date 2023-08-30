package com.poongcha.car.application.carcomponentgroup;

import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroupName;
import com.poongcha.car.domain.carcomponentgroup.SelectionHelpTooltip;
import org.springframework.stereotype.Component;

@Component
public class CarComponentGroupMapper {
    public CarComponentGroup toEntity(final CarComponentGroupCreateRequest carComponentGroupCreateRequest) {
        return new CarComponentGroup(
                new CarComponentGroupName(carComponentGroupCreateRequest.getCarComponentGroupName()),
                new SelectionHelpTooltip(carComponentGroupCreateRequest.getSelectionHelpTooltip())
        );
    }
}
