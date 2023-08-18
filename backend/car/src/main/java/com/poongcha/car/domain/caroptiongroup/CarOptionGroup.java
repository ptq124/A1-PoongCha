package com.poongcha.car.domain.caroptiongroup;

import com.poongcha.car.domain.common.AdditionalPrice;
import java.util.Arrays;
import java.util.HashSet;
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

    private InstallationLocation installationLocation;

    @Embedded.Nullable
    private AdditionalPrice additionalPrice;

    @Embedded.Nullable
    private SummaryDescription summaryDescription;

    @MappedCollection(idColumn = "car_option_group_id")
    private Set<CarOptionGroupCarOption> carOptions = new HashSet<>();

    public CarOptionGroup(
            final CarOptionGroupName name,
            final InstallationLocation installationLocation,
            final AdditionalPrice additionalPrice,
            final SummaryDescription summaryDescription,
            final Long[] optionIds
    ) {
        this.name = name;
        this.installationLocation = installationLocation;
        this.additionalPrice = additionalPrice;
        this.summaryDescription = summaryDescription;
        this.carOptions.addAll(
                Arrays.stream(optionIds)
                        .map(CarOptionGroupCarOption::new)
                        .collect(Collectors.toList())
        );
    }
}
