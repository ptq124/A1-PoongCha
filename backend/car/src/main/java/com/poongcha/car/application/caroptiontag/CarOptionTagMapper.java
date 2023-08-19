package com.poongcha.car.application.caroptiontag;

import com.poongcha.car.application.dto.CarOptionTagCreateRequest;
import com.poongcha.car.application.dto.CarOptionTagResponse;
import com.poongcha.car.domain.caroptiontag.CarOptionTag;
import com.poongcha.car.domain.caroptiontag.CarOptionTagImage;
import com.poongcha.car.domain.caroptiontag.CarOptionTagName;
import org.springframework.stereotype.Component;

@Component
public class CarOptionTagMapper {
    public CarOptionTag toEntity(final CarOptionTagCreateRequest carOptionTagCreateRequest) {
        return new CarOptionTag(
                new CarOptionTagName(carOptionTagCreateRequest.getTagName()),
                new CarOptionTagImage(
                        carOptionTagCreateRequest.getSituationImageUrl(),
                        carOptionTagCreateRequest.getIconImageUrl()
                )
        );
    }

    public CarOptionTagResponse toCarOptionTagResponse(final CarOptionTag carOptionTag) {
        return new CarOptionTagResponse(
                carOptionTag.getId(),
                carOptionTag.getCarOptionTagName().getValue(),
                carOptionTag.getCarOptionTagImage().situationImageUrl(),
                carOptionTag.getCarOptionTagImage().iconImageUrl()
        );
    }
}
