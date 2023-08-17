package com.poongcha.car.application.cartype;

import com.poongcha.car.application.dto.CarComponentGroupResponse;
import com.poongcha.car.application.dto.CarComponentResponse;
import com.poongcha.car.application.dto.CarTypeCreateRequest;
import com.poongcha.car.application.dto.CarTypeDefaultResponse;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.cartype.CarType;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarTypeMapper {
    public CarType toEntity(final CarTypeCreateRequest carTypeCreateRequest) {
        return new CarType(carTypeCreateRequest.getCarTypeName(), carTypeCreateRequest.getImageUrl());
    }

    public CarTypeDefaultResponse toDefaultResponse(final CarType carType) {
        return new CarTypeDefaultResponse(
                carType.getId(),
                carType.getCarTypeName().getValue(),
                carType.getImageUrl().getValue()
        );
    }

    public CarComponentGroupResponse createCarComponentGroupResponse(
            final CarComponentGroup carComponentGroup,
            final List<CarComponent> carComponents
    ) {
        return new CarComponentGroupResponse(
                carComponentGroup.getId(),
                carComponentGroup.getCarComponentGroupName().getValue(),
                carComponentGroup.getSelectionHelpTooltip().getValue(),
                carComponents.stream()
                        .map(carComponent -> new CarComponentResponse(
                                carComponent.getId(),
                                carComponent.getCarComponentName().getValue(),
                                carComponent.getDescriptionImageUrl().getValue(),
                                carComponent.getAdditionalPrice().getValue()
                        )).collect(Collectors.toList())
        );
    }
}
