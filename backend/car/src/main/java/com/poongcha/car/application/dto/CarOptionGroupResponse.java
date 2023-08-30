package com.poongcha.car.application.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarOptionGroupResponse {
    private long id;
    private String name;
    private long additionalPrice;
    private String summaryDescription;
    private List<String> tagNames;
    private List<Long> incompatibleCarOptionGroupIds;
    private List<CarOptionResponse> options;
}
