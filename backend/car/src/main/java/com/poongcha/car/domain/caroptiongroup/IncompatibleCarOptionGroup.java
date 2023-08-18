package com.poongcha.car.domain.caroptiongroup;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "incompatible_car_option_groups")
public class IncompatibleCarOptionGroup {
    @Column("incompatible_car_option_group_id")
    private AggregateReference<CarOptionGroup, Long> incompatibleCarOptionGroup;

    public IncompatibleCarOptionGroup(final long incompatibleCarOptionGroupId) {
        this.incompatibleCarOptionGroup = new IdOnlyAggregateReference<>(incompatibleCarOptionGroupId);
    }
}
