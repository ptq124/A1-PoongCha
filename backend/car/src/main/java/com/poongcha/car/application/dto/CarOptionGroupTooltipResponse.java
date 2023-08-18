package com.poongcha.car.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarOptionGroupTooltipResponse {
    private long id;
    private String imageUrl;
    private String tooltipDescription;
}
