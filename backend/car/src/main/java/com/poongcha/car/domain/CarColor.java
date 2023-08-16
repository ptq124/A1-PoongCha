package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_colors")
public class CarColor {
    @Id
    private Long id;

    @Embedded.Empty
    private CarColorName carColorName;

    @Embedded.Empty
    private ImageUrl imageUrl;

    private CarColorType carColorType;

    public CarColor(final CarColorName carColorName, final ImageUrl imageUrl, final CarColorType carColorType) {
        this.carColorName = carColorName;
        this.imageUrl = imageUrl;
        this.carColorType = carColorType;
    }
}
