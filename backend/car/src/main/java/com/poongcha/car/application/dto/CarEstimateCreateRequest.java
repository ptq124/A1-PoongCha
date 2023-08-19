package com.poongcha.car.application.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarEstimateCreateRequest {
    private long trimId;
    private List<Long> componentIds;
    private long exteriorId;
    private long interiorId;
    private List<Long> optionGroupIds;
}
