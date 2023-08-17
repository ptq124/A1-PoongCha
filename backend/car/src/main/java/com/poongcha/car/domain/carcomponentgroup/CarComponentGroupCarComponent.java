package com.poongcha.car.domain.carcomponentgroup;

import com.poongcha.car.domain.carcomponent.CarComponent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_component_group_car_components")
public class CarComponentGroupCarComponent {
    @Column("car_component_id")
    private AggregateReference<CarComponent, Long> carComponent;

    public CarComponentGroupCarComponent(final Long id) {
        this.carComponent = new IdOnlyAggregateReference<>(id);
    }
}
