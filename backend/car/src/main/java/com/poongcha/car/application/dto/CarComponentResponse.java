package com.poongcha.car.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarComponentResponse {
    private long id;
    private String name;
    private String descriptionImageUrl;
    private long additionalPrice;
}
