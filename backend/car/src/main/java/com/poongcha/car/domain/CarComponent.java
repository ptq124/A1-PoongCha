package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_components")
public class CarComponent {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Empty
    private CarComponentName carComponentName;

    @Embedded.Empty
    private DescriptionImageUrl descriptionImageUrl;

    @Embedded.Empty
    private AdditionalPrice additionalPrice;

    public CarComponent(
            final CarComponentName carComponentName,
            final DescriptionImageUrl descriptionImageUrl,
            final AdditionalPrice additionalPrice
    ) {
        this.carComponentName = carComponentName;
        this.descriptionImageUrl = descriptionImageUrl;
        this.additionalPrice = additionalPrice;
    }
}
