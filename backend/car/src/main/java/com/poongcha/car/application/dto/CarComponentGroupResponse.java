package com.poongcha.car.application.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarComponentGroupResponse {
    private long id;
    private String name;
    private String selectionHelpTooltip;
    private List<CarComponentResponse> component;
}
