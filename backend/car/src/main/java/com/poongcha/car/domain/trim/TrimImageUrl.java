package com.poongcha.car.domain.trim;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TrimImageUrl {
    @Column(value = "trim_exterior_image_url")
    private String exterior;

    @Column(value = "trim_interior_image_url")
    private String interior;

    @Column(value = "trim_rotation_image_base_url")
    private String rotation;
}
