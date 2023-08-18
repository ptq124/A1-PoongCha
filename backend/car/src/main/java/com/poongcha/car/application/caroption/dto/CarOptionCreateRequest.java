package com.poongcha.car.application.caroption.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarOptionCreateRequest {
    private String carOptionName;
    private String imageUrl;
    private String detailDescription;
}
