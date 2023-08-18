package com.poongcha.car.application.cartype;

import com.poongcha.car.application.dto.CarTypeAddCarComponentGroupRequest;
import com.poongcha.car.application.dto.CarTypeCreateRequest;
import com.poongcha.car.domain.cartype.CarType;
import com.poongcha.car.domain.cartype.CarTypeRepository;
import com.poongcha.car.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarTypeCommandService {
    private final CarTypeRepository carTypeRepository;
    private final CarTypeMapper carTypeMapper;

    public long create(final CarTypeCreateRequest carTypeCreateRequest) {
        CarType carType = carTypeMapper.toEntity(carTypeCreateRequest);

        return carTypeRepository.save(carType).getId();
    }

    public long add(
            final long id,
            final CarTypeAddCarComponentGroupRequest carTypeAddCarComponentGroupRequest
    ) {
        CarType carType = carTypeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("차종을 찾을 수 없습니다."));

        carType.addCarComponentGroup(carTypeAddCarComponentGroupRequest.getCarComponentGroupIds());

        return carTypeRepository.save(carType).getId();
    }
}
