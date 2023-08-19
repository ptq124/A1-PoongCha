package com.poongcha.car.domain.caroptiongrouptooltip;

import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.common.ImageUrl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_option_group_tooltips")
public class CarOptionGroupTooltip {
    @Column("id")
    @Id
    private long id;

    @Embedded.Nullable
    private ImageUrl imageUrl;

    @Embedded.Nullable
    private TooltipDescription tooltipDescription;

    @Column("car_option_group_id")
    private AggregateReference<CarOptionGroup, Long> carOptionGroup;

    public CarOptionGroupTooltip(
            final ImageUrl imageUrl,
            final TooltipDescription tooltipDescription,
            final long carOptionGroupId
    ) {
        this.imageUrl = imageUrl;
        this.tooltipDescription = tooltipDescription;
        this.carOptionGroup = new IdOnlyAggregateReference<>(carOptionGroupId);
    }
}
