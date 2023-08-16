package com.poongcha.car.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarColorDefaultResponse {
    private final long id;
    private final String name;
    private final String image;
    private final String type;
    private final List<Long> incompatibleColorIds;
}
