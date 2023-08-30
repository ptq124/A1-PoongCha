package com.poongcha.car.application.cartype;

import com.poongcha.car.application.dto.CarComponentGroupResponse;
import com.poongcha.car.application.dto.CarTypeDefaultResponse;
import com.poongcha.car.domain.carcomponent.CarComponentRepository;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroup;
import com.poongcha.car.domain.carcomponentgroup.CarComponentGroupRepository;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.cartype.CarTypeRepository;
import com.poongcha.car.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarTypeQueryService {
    private final CarTypeRepository carTypeRepository;
    private final CarComponentGroupRepository carComponentGroupRepository;
    private final CarComponentRepository carComponentRepository;
    private final CarTypeMapper carTypeMapper;

    public CarTypeDefaultResponse findById(final long id) {
        CarType carType = carTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CarType ID " + id + " 이 존재하지 않습니다."));

        return carTypeMapper.toDefaultResponse(carType);
    }

    public List<CarTypeDefaultResponse> findAll() {
        return carTypeRepository.findAll().stream()
                .map(carTypeMapper::toDefaultResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarComponentGroupResponse> findCarComponentGroupBy(final long id) {
        CarType carType = carTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("차종을 찾을 수 없습니다."));

        List<CarComponentGroup> carComponentGroups = carComponentGroupRepository
                .findAllByIdIn(carType.carComponentGroupIds());

        return carComponentGroups.stream()
                .map(carComponentGroup -> carTypeMapper.createCarComponentGroupResponse(
                        carComponentGroup,
                        carComponentRepository.findAllByIdIn(carComponentGroup.carComponentIds())
                )).collect(Collectors.toList());
    }
}
