package com.poongcha.car.application.mapper;

import com.poongcha.car.application.dto.CarColorCreateRequest;
import com.poongcha.car.domain.CarColor;
import com.poongcha.car.domain.CarColorName;
import com.poongcha.car.domain.CarColorType;
import com.poongcha.car.domain.ImageUrl;
import org.springframework.stereotype.Component;

@Component
public class CarColorMapper {
    public CarColor toEntity(final CarColorCreateRequest carColorCreateRequest) {
        return new CarColor(
                new CarColorName(carColorCreateRequest.getCarColorName()),
                new ImageUrl(carColorCreateRequest.getImageUrl()),
                CarColorType.valueOf(carColorCreateRequest.getCarColorType())
        );
    }
}
