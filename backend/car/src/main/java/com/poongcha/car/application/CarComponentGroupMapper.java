package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import com.poongcha.car.domain.CarComponentGroup;
import com.poongcha.car.domain.CarComponentGroupName;
import com.poongcha.car.domain.SelectionHelpTooltip;
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
