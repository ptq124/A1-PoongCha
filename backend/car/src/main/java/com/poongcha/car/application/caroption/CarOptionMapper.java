package com.poongcha.car.application.caroption;

import com.poongcha.car.application.caroption.dto.CarOptionCreateRequest;
import com.poongcha.car.application.caroption.dto.CarOptionResponse;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroption.CarOptionName;
import com.poongcha.car.domain.caroption.DetailDescription;
import com.poongcha.car.domain.caroption.InstallationLocation;
import com.poongcha.car.domain.common.ImageUrl;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<CarOptionResponse> toCarOptionResponse(final List<CarOption> carOptions) {
        return carOptions.stream()
                .map(CarOptionMapper::toCarOptionResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public static CarOptionResponse toCarOptionResponse(final CarOption carOption) {
        return new CarOptionResponse(
                carOption.getId(),
                carOption.getCarOptionName().getValue(),
                carOption.getImageUrl().getValue(),
                carOption.getDetailDescription().getValue(),
                carOption.getInstallationLocation().name()
        );
    }
}
