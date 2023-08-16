package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "trim_car_colors")
public class TrimCarColor {
    @Column("car_color_id")
    private AggregateReference<CarColor, Long> carColor;

    public TrimCarColor(final long carColorId) {
        this.carColor = new IdOnlyAggregateReference<>(carColorId);
    }
}
