package com.poongcha.car.domain.carcomponentgroup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
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

    @MappedCollection(idColumn = "car_component_group_id")
    private Set<CarComponentGroupCarComponent> carComponentGroupCarComponents = new HashSet<>();

    public CarComponentGroup(
            final CarComponentGroupName carComponentGroupName,
            final SelectionHelpTooltip selectionHelpTooltip
    ) {
        this.carComponentGroupName = carComponentGroupName;
        this.selectionHelpTooltip = selectionHelpTooltip;
    }

    public void addCarComponent(final List<Long> carComponentIds) {
        carComponentIds.forEach(
                carComponentId -> carComponentGroupCarComponents.add(new CarComponentGroupCarComponent(carComponentId))
        );
    }

    public List<Long> carComponentIds() {
        return carComponentGroupCarComponents.stream()
                .map(carComponentGroupCarComponent -> carComponentGroupCarComponent.getCarComponent().getId())
                .collect(Collectors.toList());
    }
}
