package com.poongcha.car.application.carcomponent;

import com.poongcha.car.application.dto.CarComponentCreateRequest;
import com.poongcha.car.domain.common.AdditionalPrice;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponent.CarComponentName;
import com.poongcha.car.domain.carcomponent.DescriptionImageUrl;
import org.springframework.stereotype.Component;

@Component
public class CarComponentMapper {
    public CarComponent toEntity(final CarComponentCreateRequest carComponentCreateRequest) {
        return new CarComponent(
                new CarComponentName(carComponentCreateRequest.getCarComponentName()),
                new DescriptionImageUrl(carComponentCreateRequest.getDescriptionImageUrl()),
                new AdditionalPrice(carComponentCreateRequest.getAdditionalPrice())
        );
    }
}
