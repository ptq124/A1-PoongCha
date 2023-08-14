package com.poongcha.car.application.mapper;

import com.poongcha.car.application.dto.CarTypeCreateRequest;
import com.poongcha.car.application.dto.CarTypeDefaultResponse;
import com.poongcha.car.domain.CarType;
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
}
