package com.poongcha.car.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TrimCarColorResponse {
    private final long id;
    private final List<CarColorDefaultResponse> colors;
}
