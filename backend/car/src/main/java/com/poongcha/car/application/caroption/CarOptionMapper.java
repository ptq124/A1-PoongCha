package com.poongcha.car.application.caroption;

import com.poongcha.car.application.caroption.dto.CarOptionCreateRequest;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroption.CarOptionName;
import com.poongcha.car.domain.caroption.DetailDescription;
import com.poongcha.car.domain.caroption.InstallationLocation;
import com.poongcha.car.domain.common.ImageUrl;
import org.springframework.stereotype.Component;

@Component
public class CarOptionMapper {
    public CarOption toEntity(final CarOptionCreateRequest carOptionCreateRequest) {
        return new CarOption(
                new CarOptionName(carOptionCreateRequest.getCarOptionName()),
                new ImageUrl(carOptionCreateRequest.getImageUrl()),
                InstallationLocation.valueOf(carOptionCreateRequest.getInstallationLocation()),
                new DetailDescription(carOptionCreateRequest.getDetailDescription())
        );
    }
}
