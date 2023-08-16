package com.poongcha.car.application.mapper;

import com.poongcha.car.application.dto.CarColorCreateRequest;
import com.poongcha.car.application.dto.CarColorDefaultResponse;
import com.poongcha.car.domain.CarColor;
import com.poongcha.car.domain.CarColorName;
import com.poongcha.car.domain.CarColorType;
import com.poongcha.car.domain.ImageUrl;
import java.util.List;
import java.util.stream.Collectors;
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

    public CarColorDefaultResponse toCarColorDefaultResponse(final CarColor carColor) {
        return new CarColorDefaultResponse(
                carColor.getId(),
                carColor.getCarColorName().getValue(),
                carColor.getImageUrl().getValue(),
                carColor.getCarColorType().name(),
                carColor.incompatibleColorIds()
        );
    }

    public List<CarColorDefaultResponse> toCarColorDefaultResponses(final List<CarColor> carColors) {
        return carColors.stream()
                .map(this::toCarColorDefaultResponse)
                .collect(Collectors.toUnmodifiableList());
    }
}
