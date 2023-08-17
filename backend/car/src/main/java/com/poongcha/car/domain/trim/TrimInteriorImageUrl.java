package com.poongcha.car.domain.trim;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TrimInteriorImageUrl {
    @Column(value = "trim_interior_image_url")
    private String value;
}
