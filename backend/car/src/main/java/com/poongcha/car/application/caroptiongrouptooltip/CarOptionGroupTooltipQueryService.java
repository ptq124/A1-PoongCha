package com.poongcha.car.application.caroptiongrouptooltip;

import com.poongcha.car.application.dto.CarOptionGroupTooltipResponse;
import com.poongcha.car.domain.caroptiongrouptooltip.CarOptionGroupTooltip;
import com.poongcha.car.domain.caroptiongrouptooltip.CarOptionGroupTooltipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarOptionGroupTooltipQueryService {
    private final CarOptionGroupTooltipRepository carOptionGroupTooltipRepository;
    private final CarOptionGroupTooltipMapper carOptionGroupTooltipMapper;

    public CarOptionGroupTooltipResponse findById(final long optionGroupId) {
        CarOptionGroupTooltip carOptionGroupTooltip = carOptionGroupTooltipRepository
                .findByCarOptionGroup(optionGroupId);

        return carOptionGroupTooltipMapper.toCarOptionGroupTooltipResponse(carOptionGroupTooltip);
    }
}
