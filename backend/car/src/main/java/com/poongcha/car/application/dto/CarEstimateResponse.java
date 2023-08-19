package com.poongcha.car.application.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarEstimateResponse {
    private long id;
    private CarEstimateCarTypeResponse carType;
    private CarEstimateTrimResponse trim;
    private List<CarEstimateCarComponentResponse> components;
    private CarEstimateCarColorResponse exteriorColor;
    private CarEstimateCarColorResponse interiorColor;
    private List<CarEstimateOptionGroupResponse> optionGroups;
}
