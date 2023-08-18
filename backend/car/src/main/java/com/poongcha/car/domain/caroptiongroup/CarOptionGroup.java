package com.poongcha.car.domain.caroptiongroup;

import com.poongcha.car.domain.common.AdditionalPrice;
import java.util.Arrays;
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
@Table(name = "car_option_groups")
public class CarOptionGroup {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private CarOptionGroupName name;

    @Embedded.Nullable
    private AdditionalPrice additionalPrice;

    @Embedded.Nullable
    private SummaryDescription summaryDescription;

    @MappedCollection(idColumn = "car_option_group_id")
    private Set<CarOptionGroupCarOption> carOptions = new HashSet<>();

    @MappedCollection(idColumn = "car_option_group_id")
    private Set<IncompatibleCarOptionGroup> incompatibleCarOptionGroups = new HashSet<>();

    public CarOptionGroup(
            final CarOptionGroupName name,
            final AdditionalPrice additionalPrice,
            final SummaryDescription summaryDescription,
            final Long[] optionIds
    ) {
        this.name = name;
        this.additionalPrice = additionalPrice;
        this.summaryDescription = summaryDescription;
        this.carOptions.addAll(
                Arrays.stream(optionIds)
                        .map(CarOptionGroupCarOption::new)
                        .collect(Collectors.toList())
        );
    }

    public List<Long> optionIds() {
        return this.carOptions.stream()
                .map(CarOptionGroupCarOption::optionId)
                .collect(Collectors.toUnmodifiableList());
    }

    public void addIncompatibleCarOptionGroup(final List<CarOptionGroup> incompatibleCarOptionGroups) {
        incompatibleCarOptionGroups.forEach(carOptionGroup -> {
                    this.incompatibleCarOptionGroups.add(new IncompatibleCarOptionGroup(carOptionGroup.id));
                    carOptionGroup.incompatibleCarOptionGroups.add(new IncompatibleCarOptionGroup(this.id));
                }
        );
    }
}
