package com.poongcha.car.domain.carestimate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_estimates")
public class CarEstimate {
    @Column("id")
    @Id
    private Long id;

    @Column("car_exterior_color_id")
    private Long carExteriorColorId;

    @Column("car_interior_color_id")
    private Long carInteriorColorId;

    @Column("trim_id")
    private Long trimId;

    @Column("estimate_code")
    private String estimateCode;

    @MappedCollection(idColumn = "car_estimate_id")
    private Set<CarEstimateCarComponent> carEstimateCarComponents = new HashSet<>();

    @MappedCollection(idColumn = "car_estimate_id")
    private Set<CarEstimateOptionGroup> carEstimateOptionGroups = new HashSet<>();

    public CarEstimate(
            final Long trimId,
            final Set<Long> carEstimateCarComponents,
            final Long carExteriorColorId,
            final Long carInteriorColorId,
            final Set<Long> carEstimateOptionGroups
    ) {
        this.carExteriorColorId = carExteriorColorId;
        this.carInteriorColorId = carInteriorColorId;
        this.trimId = trimId;
        this.estimateCode = UUID.randomUUID().toString();
        this.carEstimateCarComponents.addAll(
                carEstimateCarComponents.stream()
                        .map(CarEstimateCarComponent::new)
                        .collect(Collectors.toUnmodifiableList())
        );
        this.carEstimateOptionGroups.addAll(
                carEstimateOptionGroups.stream()
                        .map(CarEstimateOptionGroup::new)
                        .collect(Collectors.toUnmodifiableList())
        );
    }

    public List<Long> carComponentIds() {
        return this.carEstimateCarComponents.stream()
                .map(CarEstimateCarComponent::carComponentId)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Long> carOptionGroupIds() {
        return this.carEstimateOptionGroups.stream()
                .map(CarEstimateOptionGroup::carOptionGroupId)
                .collect(Collectors.toUnmodifiableList());
    }
}
