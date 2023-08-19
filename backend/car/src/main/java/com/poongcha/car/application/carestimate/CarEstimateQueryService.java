package com.poongcha.car.application.carestimate;

import com.poongcha.car.application.dto.CarEstimateCarColorResponse;
import com.poongcha.car.application.dto.CarEstimateCarComponentResponse;
import com.poongcha.car.application.dto.CarEstimateCarTypeResponse;
import com.poongcha.car.application.dto.CarEstimateOptionGroupResponse;
import com.poongcha.car.application.dto.CarEstimateOptionResponse;
import com.poongcha.car.application.dto.CarEstimateResponse;
import com.poongcha.car.application.dto.CarEstimateTrimResponse;
import com.poongcha.car.domain.carcolor.CarColor;
import com.poongcha.car.domain.carcolor.CarColorRepository;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponent.CarComponentRepository;
import com.poongcha.car.domain.carestimate.CarEstimate;
import com.poongcha.car.domain.carestimate.CarEstimateRepository;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroption.CarOptionRepository;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupRepository;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.cartype.CarTypeRepository;
import com.poongcha.car.domain.trim.Trim;
import com.poongcha.car.domain.trim.TrimRepository;
import com.poongcha.car.exception.BadRequestException;
import com.poongcha.car.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarEstimateQueryService {
    private final CarEstimateRepository carEstimateRepository;
    private final CarTypeRepository carTypeRepository;
    private final CarComponentRepository carComponentRepository;
    private final TrimRepository trimRepository;
    private final CarColorRepository carColorRepository;
    private final CarOptionGroupRepository optionGroupRepository;
    private final CarOptionRepository optionRepository;

    public CarEstimateResponse findById(final long carEstimateId) {
        CarEstimate carEstimate = carEstimateRepository.findById(carEstimateId)
                .orElseThrow(() -> new NotFoundException("견적이 존재하지 않습니다."));

        Trim trim = trimRepository.findById(carEstimate.getTrimId())
                .orElseThrow(() -> new BadRequestException("트림이 존재하지 않습니다."));

        CarType carType = carTypeRepository.findById(trim.getCarType().getId())
                .orElseThrow(() -> new BadRequestException("차종이 존재하지 않습니다."));

        List<CarComponent> components = carComponentRepository.findAllByIdIn(carEstimate.carComponentIds());

        CarColor exteriorCarColor = carColorRepository.findById(carEstimate.getCarExteriorColorId())
                .orElseThrow(() -> new BadRequestException("외장 색상이 존재하지 않습니다."));

        CarColor interiorCarColor = carColorRepository.findById(carEstimate.getCarInteriorColorId())
                .orElseThrow(() -> new BadRequestException("내장 색상이 존재하지 않습니다."));

        return new CarEstimateResponse(
                carEstimate.getId(),
                new CarEstimateCarTypeResponse(
                        carType.getId(),
                        carType.getCarTypeName().getValue(),
                        carType.getImageUrl().getValue()
                ),
                new CarEstimateTrimResponse(
                        trim.getId(),
                        trim.getTrimName().getValue(),
                        trim.getImageUrl().getValue(),
                        trim.getMinPrice().getValue()
                ),
                components.stream()
                        .map(carComponent -> new CarEstimateCarComponentResponse(
                                carComponent.getId(),
                                carComponent.getCarComponentName().getValue(),
                                carComponent.getCarComponentName().getValue(),
                                carComponent.getAdditionalPrice().getValue()
                        )).collect(Collectors.toUnmodifiableList()),
                new CarEstimateCarColorResponse(
                        exteriorCarColor.getId(),
                        exteriorCarColor.getCarColorName().getValue(),
                        exteriorCarColor.getImageUrl().getValue(),
                        exteriorCarColor.getCarColorType().name()
                ),
                new CarEstimateCarColorResponse(
                        interiorCarColor.getId(),
                        interiorCarColor.getCarColorName().getValue(),
                        interiorCarColor.getImageUrl().getValue(),
                        interiorCarColor.getCarColorType().name()
                ),
                createCarEstimateOptionResponse(carEstimate)
        );
    }

    private List<CarEstimateOptionGroupResponse> createCarEstimateOptionResponse(final CarEstimate carEstimate) {
        return optionGroupRepository.findAllByIdIn(carEstimate.carOptionGroupIds()).stream()
                .map(carOptionGroup -> {
                    List<CarOption> carOptions = optionRepository.findAllByIdIn(carOptionGroup.optionIds());
                    return new CarEstimateOptionGroupResponse(
                            carOptionGroup.getId(),
                            carOptionGroup.getName().getValue(),
                            carOptionGroup.getAdditionalPrice().getValue(),
                            carOptions.stream()
                                    .map(carOption -> new CarEstimateOptionResponse(
                                            carOption.getId(),
                                            carOption.getCarOptionName().getValue(),
                                            carOption.getImageUrl().getValue()
                                    )).collect(Collectors.toUnmodifiableList())
                    );
                }).collect(Collectors.toUnmodifiableList());
    }
}
