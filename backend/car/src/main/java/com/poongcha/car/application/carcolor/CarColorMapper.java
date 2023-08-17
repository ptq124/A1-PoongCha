package com.poongcha.car.application.carcolor;

import com.poongcha.car.application.dto.CarColorCreateRequest;
import com.poongcha.car.application.dto.CarColorDefaultResponse;
import com.poongcha.car.application.dto.TrimCarColorResponse;
import com.poongcha.car.domain.carcolor.CarColor;
import com.poongcha.car.domain.carcolor.CarColorName;
import com.poongcha.car.domain.carcolor.CarColorType;
import com.poongcha.car.domain.common.ImageUrl;
import com.poongcha.car.domain.trim.Trim;
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

    public TrimCarColorResponse toTrimCarColorResponse(final Trim trim, final List<CarColor> carColors) {
        return new TrimCarColorResponse(
                trim.getId(),
                toCarColorDefaultResponses(trim, carColors)
        );
    }

    public List<CarColorDefaultResponse> toCarColorDefaultResponses(final Trim trim, final List<CarColor> carColors) {
        return carColors.stream()
                .map(carColor -> toCarColorDefaultResponse(trim, carColor))
                .collect(Collectors.toUnmodifiableList());
    }

    private CarColorDefaultResponse toCarColorDefaultResponse(final Trim trim, final CarColor carColor) {
        return new CarColorDefaultResponse(
                carColor.getId(),
                carColor.getCarColorName().getValue(),
                carColor.getImageUrl().getValue(),
                carColor.getCarColorType().name(),
                trimExteriorImageUrl(trim, carColor),
                trimInteriorImageUrl(trim, carColor),
                trimRotationImageBaseUrl(trim, carColor),
                carColor.incompatibleColorIds()
        );
    }

    private String trimRotationImageBaseUrl(final Trim trim, final CarColor carColor) {
        if (carColor.getCarColorType().equals(CarColorType.INTERIOR)) {
            return null;
        }
        return trim.rotationImageUrl(carColor.getId());
    }

    private String trimInteriorImageUrl(final Trim trim, final CarColor carColor) {
        if (carColor.getCarColorType().equals(CarColorType.EXTERIOR)) {
            return null;
        }
        return trim.interiorImageUrl(carColor.getId());
    }

    private String trimExteriorImageUrl(final Trim trim, final CarColor carColor) {
        if (carColor.getCarColorType().equals(CarColorType.INTERIOR)) {
            return null;
        }
        return trim.exteriorImageUrl(carColor.getId());
    }
}
