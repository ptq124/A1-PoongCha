package com.poongcha.car.application.caroptiongrouptooltip;

import com.poongcha.car.application.dto.CarOptionGroupTooltipCreateRequest;
import com.poongcha.car.domain.caroptiongrouptooltip.CarOptionGroupTooltip;
import com.poongcha.car.domain.caroptiongrouptooltip.CarOptionGroupTooltipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarOptionGroupTooltipCommandService {
    private final CarOptionGroupTooltipRepository carOptionGroupTooltipRepository;
    private final CarOptionGroupTooltipMapper carOptionGroupTooltipMapper;

    public long create(
            final long optionGroupId,
            final CarOptionGroupTooltipCreateRequest carOptionGroupTooltipCreateRequest
    ) {
        CarOptionGroupTooltip carOptionGroupTooltip = carOptionGroupTooltipMapper
                .toEntity(optionGroupId, carOptionGroupTooltipCreateRequest);

        return carOptionGroupTooltipRepository.save(carOptionGroupTooltip).getId();
    }
}
