package com.poongcha.car.domain.caroptiontag;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarOptionTagImage {
    @Column("situation_image_url")
    private String situationImageUrl;

    @Column("icon_image_url")
    private String iconImageUrl;

    public String situationImageUrl() {
        return this.situationImageUrl;
    }

    public String iconImageUrl() {
        return this.iconImageUrl;
    }
}
