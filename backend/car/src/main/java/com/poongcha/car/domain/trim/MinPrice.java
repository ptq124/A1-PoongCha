package com.poongcha.car.domain.trim;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
public class MinPrice {
    @Column("min_price")
    private final long value;
}
