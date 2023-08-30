package com.poongcha.car.application.caroptiontag;

import com.poongcha.car.application.dto.CarOptionTagCreateRequest;
import com.poongcha.car.application.dto.CarOptionTagResponse;
import com.poongcha.car.domain.caroptiontag.CarOptionTag;
import com.poongcha.car.domain.caroptiontag.CarOptionTagImage;
import com.poongcha.car.domain.caroptiontag.CarOptionTagName;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarOptionTagMapper {
    public CarOptionTag toEntity(final CarOptionTagCreateRequest carOptionTagCreateRequest) {
        return new CarOptionTag(
                new CarOptionTagName(carOptionTagCreateRequest.getName()),
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

    public List<CarOptionTagResponse> toCarOptionTagResponse(final List<CarOptionTag> optionTags) {
        return optionTags.stream()
                .map(this::toCarOptionTagResponse)
                .collect(Collectors.toUnmodifiableList());
    }
}
