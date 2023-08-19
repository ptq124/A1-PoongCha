package com.poongcha.car.domain.caroptiongrouptooltip;

import org.springframework.data.repository.Repository;

public interface CarOptionGroupTooltipRepository extends Repository<CarOptionGroupTooltip, Long> {
    CarOptionGroupTooltip save(final CarOptionGroupTooltip carOptionGroupTooltip);

    CarOptionGroupTooltip findByIdAndCarOptionGroup(long id, final long carOptionGroupTooltipId);
}
