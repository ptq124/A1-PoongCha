package com.poongcha.car.application.cartype;

import com.poongcha.car.application.dto.CarComponentGroupResponse;
import com.poongcha.car.application.dto.CarComponentResponse;
import com.poongcha.car.application.dto.CarTypeDefaultResponse;
import com.poongcha.car.domain.carcomponent.CarComponent;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroupRepository;
import com.poongcha.car.domain.carcomponent.CarComponentRepository;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.cartype.CarTypeRepository;
import com.poongcha.car.exception.HttpNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarTypeQueryService {
    private final CarTypeRepository carTypeRepository;
    private final CarComponentGroupRepository carComponentGroupRepository;
    private final CarComponentRepository carComponentRepository;
    private final CarTypeMapper carTypeMapper;

    public CarTypeDefaultResponse findById(final long id) {
        CarType carType = carTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CarType ID " + id + " 이 존재하지 않습니다."));
        return carTypeMapper.toDefaultResponse(carType);
    }

    public List<CarTypeDefaultResponse> findAll() {
        List<CarType> carTypes = carTypeRepository.findAll();
        return carTypes.stream()
                .map(carTypeMapper::toDefaultResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarComponentGroupResponse> findCarComponentGroupBy(final long id) {
        CarType carType = carTypeRepository.findById(id).orElseThrow(() -> new HttpNotFoundException("차종을 찾을 수 없습니다."));
        List<CarComponentGroup> carComponentGroups = carComponentGroupRepository
                .findAllByIdIn(carType.carComponentGroupIds());
        return carComponentGroups.stream()
                .map(carComponentGroup -> createCarComponentGroupResponse(
                        carComponentGroup,
                        carComponentRepository.findAllByIdIn(carComponentGroup.carComponentIds())
                )).collect(Collectors.toList());
    }

    private CarComponentGroupResponse createCarComponentGroupResponse(
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
