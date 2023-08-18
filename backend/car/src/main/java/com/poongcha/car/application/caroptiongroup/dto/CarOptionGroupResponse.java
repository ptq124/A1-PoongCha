package com.poongcha.car.application.caroptiongroup.dto;

import com.poongcha.car.application.caroption.dto.CarOptionResponse;
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
    private List<CarOptionResponse> options;
}
