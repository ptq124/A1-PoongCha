package com.poongcha.car.application.caroptionbrand;

import com.poongcha.car.application.dto.CarOptionBrandCreateRequest;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrand;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarOptionBrandCommandService {
    private final CarOptionBrandRepository carOptionBrandRepository;
    private final CarOptionBrandMapper carOptionBrandMapper;

    public long create(final long id, final CarOptionBrandCreateRequest carOptionBrandCreateRequest) {
        CarOptionBrand carOptionBrand = carOptionBrandMapper.toEntity(id, carOptionBrandCreateRequest);

        return carOptionBrandRepository.save(carOptionBrand).getId();
    }
}
