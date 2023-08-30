package com.poongcha.car.domain.caroptiongroup;

import com.poongcha.car.domain.caroptiontag.CarOptionTag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_option_tag_car_option_groups")
public class CarOptionTagCarOptionGroup {
    @Column("car_option_tag_id")
    private AggregateReference<CarOptionTag, Long> carOptionTag;

    public CarOptionTagCarOptionGroup(final long carOptionTagId) {
        this.carOptionTag = new IdOnlyAggregateReference<>(carOptionTagId);
    }

    public long carOptionTagId() {
        return this.carOptionTag.getId();
    }
}
