package com.poongcha.car.application.carestimate;

import com.poongcha.car.application.dto.CarEstimateCarColorResponse;
import com.poongcha.car.application.dto.CarEstimateCarComponentResponse;
import com.poongcha.car.application.dto.CarEstimateCarTypeResponse;
import com.poongcha.car.application.dto.CarEstimateCreateRequest;
import com.poongcha.car.application.dto.CarEstimateOptionGroupResponse;
import com.poongcha.car.application.dto.CarEstimateOptionResponse;
import com.poongcha.car.application.dto.CarEstimateResponse;
import com.poongcha.car.application.dto.CarEstimateTrimResponse;
import com.poongcha.car.domain.carcolor.CarColor;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carestimate.CarEstimate;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.trim.Trim;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class CarEstimateMapper {
    public CarEstimate toEntity(final CarEstimateCreateRequest carEstimateCreateRequest) {
        return new CarEstimate(
                carEstimateCreateRequest.getTrimId(),
                new HashSet<>(carEstimateCreateRequest.getComponentIds()),
                carEstimateCreateRequest.getExteriorId(),
                carEstimateCreateRequest.getInteriorId(),
                new HashSet<>(carEstimateCreateRequest.getOptionGroupIds())
        );
    }

    public CarEstimateResponse toCarEstimateResponse(
            final CarEstimate carEstimate,
            final CarType carType,
            final Trim trim,
            final List<CarComponent> carComponents,
            final CarColor exteriorCarColor,
            final CarColor interiorCarColor,
            final List<CarOptionGroup> carOptionGroups,
            final List<List<CarOption>> carOptions
    ) {
        return new CarEstimateResponse(
                carEstimate.getId(),
                carEstimate.getEstimateCode(),
                createCarEstimateCarTypeResponse(carType),
                createCarEstimateTrimResponse(trim),
                createCarEstimateCarComponentResponses(carComponents),
                createCarEstimateCarColorResponse(exteriorCarColor),
                createCarEstimateCarColorResponse(interiorCarColor),
                createCarEstimateOptionGroupResponses(carOptionGroups, carOptions)
        );
    }

    private CarEstimateCarTypeResponse createCarEstimateCarTypeResponse(final CarType carType) {
        return new CarEstimateCarTypeResponse(
                carType.getId(),
                carType.getCarTypeName().getValue(),
                carType.getImageUrl().getValue()
        );
    }

    private CarEstimateTrimResponse createCarEstimateTrimResponse(final Trim trim) {
        return new CarEstimateTrimResponse(
                trim.getId(),
                trim.getTrimName().getValue(),
                trim.getImageUrl().getValue(),
                trim.getMinPrice().getValue()
        );
    }

    private List<CarEstimateCarComponentResponse> createCarEstimateCarComponentResponses(
            final List<CarComponent> carComponents
    ) {
        return carComponents.stream()
                .map(carComponent -> new CarEstimateCarComponentResponse(
                        carComponent.getId(),
                        carComponent.getCarComponentName().getValue(),
                        carComponent.getAdditionalPrice().getValue()
                )).collect(Collectors.toUnmodifiableList());
    }

    private CarEstimateCarColorResponse createCarEstimateCarColorResponse(final CarColor interiorCarColor) {
        return new CarEstimateCarColorResponse(
                interiorCarColor.getId(),
                interiorCarColor.getCarColorName().getValue(),
                interiorCarColor.getImageUrl().getValue(),
                interiorCarColor.getCarColorType().name()
        );
    }

    private List<CarEstimateOptionGroupResponse> createCarEstimateOptionGroupResponses(
            final List<CarOptionGroup> carOptionGroups,
            final List<List<CarOption>> carOptions
    ) {
        return IntStream.range(0, carOptionGroups.size())
                .mapToObj(i -> {
                    CarOptionGroup carOptionGroup = carOptionGroups.get(i);
                    List<CarOption> options = carOptions.get(i);
                    return new CarEstimateOptionGroupResponse(
                            carOptionGroup.getId(),
                            carOptionGroup.getName().getValue(),
                            carOptionGroup.getAdditionalPrice().getValue(),
                            options.stream()
                                    .map(carOption -> new CarEstimateOptionResponse(
                                            carOption.getId(),
                                            carOption.getCarOptionName().getValue(),
                                            carOption.getImageUrl().getValue()
                                    )).collect(Collectors.toUnmodifiableList())
                    );
                }).collect(Collectors.toUnmodifiableList());
    }
}
