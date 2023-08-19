package com.poongcha.car.application.caroptionbrand;

import com.poongcha.car.application.dto.CarOptionBrandCreateRequest;
import com.poongcha.car.application.dto.CarOptionBrandResponse;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrand;
import com.poongcha.car.domain.caroptionbrand.CarOptionBrandName;
import com.poongcha.car.domain.common.ImageUrl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarOptionBrandMapper {
    public CarOptionBrand toEntity(
            final long optionGroupId,
            final CarOptionBrandCreateRequest carOptionBrandCreateRequest
    ) {
        return new CarOptionBrand(
                new ImageUrl(carOptionBrandCreateRequest.getImageUrl()),
                new CarOptionBrandName(carOptionBrandCreateRequest.getBrandName()),
                optionGroupId
        );
    }

    public List<CarOptionBrandResponse> toCarOptionBrandResponse(final List<CarOptionBrand> carOptionBrands) {
        return carOptionBrands.stream()
                .map(this::toCarOptionBrandResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public CarOptionBrandResponse toCarOptionBrandResponse(final CarOptionBrand carOptionBrand) {
        return new CarOptionBrandResponse(
                carOptionBrand.getId(),
                carOptionBrand.getCarOptionBrandName().getValue(),
                carOptionBrand.getImageUrl().getValue()
        );
    }
}
