package com.poongcha.car.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarColorCreateRequest {
    private final String carColorName;
    private final String imageUrl;
    private final String carColorType;
}
