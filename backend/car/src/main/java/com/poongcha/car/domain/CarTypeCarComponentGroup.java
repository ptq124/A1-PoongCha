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
@Table(name = "car_type_car_component_groups")
public class CarTypeCarComponentGroup {
    @Column("car_component_group_id")
    private AggregateReference<CarComponentGroup, Long> carComponentGroup;

    public CarTypeCarComponentGroup(final long carComponentGroupId) {
        this.carComponentGroup = new IdOnlyAggregateReference<>(carComponentGroupId);
    }
}
