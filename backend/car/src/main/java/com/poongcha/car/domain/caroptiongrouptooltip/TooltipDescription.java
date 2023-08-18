package com.poongcha.car.domain.caroptiongrouptooltip;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TooltipDescription {
    @Column("tooltip_description")
    private String tooltipDescription;
}
