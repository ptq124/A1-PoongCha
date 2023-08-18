package com.poongcha.car.domain.caroptiongroup;

import com.poongcha.car.domain.caroption.CarOption;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_option_group_car_options")
public class CarOptionGroupCarOption {
    @Column("car_option_id")
    private AggregateReference<CarOption, Long> carOption;

    public CarOptionGroupCarOption(final Long carOptionId) {
        this.carOption = new IdOnlyAggregateReference<>(carOptionId);
    }

    public long optionId() {
        return carOption.getId();
    }
}
