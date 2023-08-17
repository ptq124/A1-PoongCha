package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_component_groups")
public class CarComponentGroup {
    @Column(value = "id")
    @Id
    private Long id;

    @Embedded.Empty
    private CarComponentGroupName carComponentGroupName;

    @Embedded.Empty
    private SelectionHelpTooltip selectionHelpTooltip;

    public CarComponentGroup(
            final CarComponentGroupName carComponentGroupName,
            final SelectionHelpTooltip selectionHelpTooltip
    ) {
        this.carComponentGroupName = carComponentGroupName;
        this.selectionHelpTooltip = selectionHelpTooltip;
    }
}
