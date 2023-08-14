package com.poongcha.car.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
public class TrimName {
    @Column("trim_name")
    private final String value;
}
