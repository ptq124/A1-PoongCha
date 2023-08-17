package com.poongcha.car.domain.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
public class ImageUrl {
    @Column("image_url")
    private final String value;
}
