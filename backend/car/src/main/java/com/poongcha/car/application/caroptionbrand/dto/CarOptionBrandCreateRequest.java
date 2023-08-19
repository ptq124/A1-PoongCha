package com.poongcha.car.application.caroptionbrand.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarOptionBrandCreateRequest {
    private String brandName;
    private String imageUrl;
}
