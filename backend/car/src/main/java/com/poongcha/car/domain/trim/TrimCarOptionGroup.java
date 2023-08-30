package com.poongcha.car.domain.trim;

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
@Table(name = "trim_car_option_groups")
public class TrimCarOptionGroup {
    @Column("car_option_group_id")
    private AggregateReference<CarOptionGroup, Long> optionGroup;

    public TrimCarOptionGroup(final Long optionGroupId) {
        this.optionGroup = new IdOnlyAggregateReference<>(optionGroupId);
    }

    public long optionGroupId() {
        return optionGroup.getId();
    }
}
