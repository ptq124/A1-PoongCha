package com.poongcha.car.domain.carestimate;

import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_estimate_car_option_groups")
public class CarEstimateOptionGroup {
    @Column("car_option_group_id")
    private AggregateReference<CarOptionGroup, Long> carOptionGroup;

    public CarEstimateOptionGroup(final Long carOptionGroup) {
        this.carOptionGroup = new IdOnlyAggregateReference<>(carOptionGroup);
    }

    public long carOptionGroupId() {
        return carOptionGroup.getId();
    }
}
