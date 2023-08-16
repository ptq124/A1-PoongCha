package com.poongcha.car.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
public class CarColorName {
    @Column("car_color_name")
    private final String value;
}
