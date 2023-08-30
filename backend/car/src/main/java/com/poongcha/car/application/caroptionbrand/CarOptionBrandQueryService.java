package com.poongcha.car.application.caroptionbrand;

import com.poongcha.car.application.dto.CarOptionBrandResponse;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrand;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrandRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarOptionBrandQueryService {
    private final CarOptionBrandRepository carOptionBrandRepository;
    private final CarOptionBrandMapper carOptionBrandMapper;

    public List<CarOptionBrandResponse> findAllByOptionGroupId(final long optionGroupId) {
        List<CarOptionBrand> carOptionBrands = carOptionBrandRepository.findAllByCarOptionGroup(optionGroupId);

        return carOptionBrandMapper.toCarOptionBrandResponse(carOptionBrands);
    }
}
