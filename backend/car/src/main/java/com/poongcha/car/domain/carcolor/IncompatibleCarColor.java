package com.poongcha.car.domain.carcolor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "incompatible_car_colors")
public class IncompatibleCarColor {
    @Column("incompatible_car_color_id")
    private AggregateReference<CarColor, Long> incompatibleCarColor;

    public IncompatibleCarColor(final long incompatibleCarColorId) {
        this.incompatibleCarColor = new IdOnlyAggregateReference<>(incompatibleCarColorId);
    }
}
