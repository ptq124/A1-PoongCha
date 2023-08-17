package com.poongcha.car.domain.cartype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
public class CarTypeName {
    @Column("car_type_name")
    private final String value;
}
