package com.poongcha.car.domain.carestimate;

import com.poongcha.car.domain.carcomponent.CarComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_estimate_car_component_groups")
public class CarEstimateCarComponent {
    @Column("car_component_id")
    private AggregateReference<CarComponent, Long> carComponent;

    public CarEstimateCarComponent(final Long carComponent) {
        this.carComponent = new IdOnlyAggregateReference<>(carComponent);
    }

    public long carComponentId() {
        return carComponent.getId();
    }
}
