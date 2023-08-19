package com.poongcha.car.application.caroptiongrouptooltip;

import com.poongcha.car.application.dto.CarOptionGroupTooltipCreateRequest;
import com.poongcha.car.application.dto.CarOptionGroupTooltipResponse;
import com.poongcha.car.domain.caroptiongrouptooltip.CarOptionGroupTooltip;
import com.poongcha.car.domain.caroptiongrouptooltip.TooltipDescription;
import com.poongcha.car.domain.common.ImageUrl;
import org.springframework.stereotype.Component;

@Component
public class CarOptionGroupTooltipMapper {
    public CarOptionGroupTooltip toEntity(
            final long optionGroupId,
            final CarOptionGroupTooltipCreateRequest carOptionGroupTooltipCreateRequest
    ) {
        return new CarOptionGroupTooltip(
                new ImageUrl(carOptionGroupTooltipCreateRequest.getImageUrl()),
                new TooltipDescription(carOptionGroupTooltipCreateRequest.getTooltipDescription()),
                optionGroupId
        );
    }

    public CarOptionGroupTooltipResponse toCarOptionGroupTooltipResponse(
            final CarOptionGroupTooltip carOptionGroupTooltip
    ) {
        return new CarOptionGroupTooltipResponse(
                carOptionGroupTooltip.getId(),
                carOptionGroupTooltip.getImageUrl().getValue(),
                carOptionGroupTooltip.getTooltipDescription().getValue()
        );
    }
}
