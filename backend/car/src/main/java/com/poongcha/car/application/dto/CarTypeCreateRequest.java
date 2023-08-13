package com.poongcha.car.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarTypeCreateRequest {
    private final String carTypeName;
    private final String imageUrl;
}
