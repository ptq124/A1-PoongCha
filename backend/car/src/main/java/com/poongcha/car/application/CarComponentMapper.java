package com.poongcha.car.application;

import com.poongcha.car.application.dto.CarComponentCreateRequest;
import com.poongcha.car.domain.AdditionalPrice;
import com.poongcha.car.domain.CarComponent;
import com.poongcha.car.domain.CarComponentName;
import com.poongcha.car.domain.DescriptionImageUrl;
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
