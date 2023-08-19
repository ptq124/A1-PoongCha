package com.poongcha.car.domain.caroptiontag;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "car_option_tags")
public class CarOptionTag {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private CarOptionTagName carOptionTagName;

    @Embedded.Nullable
    private CarOptionTagImage carOptionTagImage;

    public CarOptionTag(final CarOptionTagName carOptionTagName, final CarOptionTagImage carOptionTagImage) {
        this.carOptionTagName = carOptionTagName;
        this.carOptionTagImage = carOptionTagImage;
    }
}
