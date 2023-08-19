package com.poongcha.car.application.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarEstimateOptionGroupResponse {
    private long id;
    private String name;
    private long additionalPrice;
    private List<CarEstimateOptionResponse> options;
}
