package com.poongcha.car.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarEstimateCarTypeResponse {
    private long id;
    private String name;
    private String imageUrl;
}
