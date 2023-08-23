package com.poongcha.car.application.trim;

import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.dto.TrimDefaultResponse;
import com.poongcha.car.application.dto.TrimRepresentativeOptionGroupResponse;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.common.ImageUrl;
import com.poongcha.car.domain.trim.MinPrice;
import com.poongcha.car.domain.trim.Trim;
import com.poongcha.car.domain.trim.TrimName;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TrimMapper {
    public Trim toEntity(final TrimCreateRequest trimCreateRequest) {
        return new Trim(
                new TrimName(trimCreateRequest.getTrimName()),
                new ImageUrl(trimCreateRequest.getImageUrl()),
                new MinPrice(trimCreateRequest.getMinPrice()),
                trimCreateRequest.getCarTypeId()
        );
    }

    public TrimDefaultResponse toDefaultResponse(final Trim trim, final List<CarOptionGroup> optionGroups) {
        return new TrimDefaultResponse(
                trim.getId(),
                trim.getTrimName().getValue(),
                trim.getImageUrl().getValue(),
                trim.getMinPrice().getValue(),
                trim.getCarType().getId(),
                optionGroups.stream()
                        .map(optionGroup -> new TrimRepresentativeOptionGroupResponse(
                                optionGroup.getId(),
                                optionGroup.getName().getValue()
                        )).collect(Collectors.toUnmodifiableList())
        );
    }
}
