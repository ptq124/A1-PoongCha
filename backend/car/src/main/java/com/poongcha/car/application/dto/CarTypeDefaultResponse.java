package com.poongcha.car.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarTypeDefaultResponse {
    private final long id;
    private final String carTypeName;
    private final String imageUrl;
}
