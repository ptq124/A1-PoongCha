package com.poongcha.car.domain.caroptiongroup;

import com.poongcha.car.domain.common.AdditionalPrice;
import com.poongcha.car.exception.BadRequestException;
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

    @MappedCollection(idColumn = "car_option_group_id")
    private Set<CarOptionTagCarOptionGroup> tags = new HashSet<>();

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

    public void addIncompatibleCarOptionGroup(final int size, final List<CarOptionGroup> incompatibleCarOptionGroups) {
        validationAddIncompatibleCarOptionGroup(size, incompatibleCarOptionGroups);

        incompatibleCarOptionGroups.forEach(carOptionGroup -> {
                    this.incompatibleCarOptionGroups.add(new IncompatibleCarOptionGroup(carOptionGroup.id));
                    carOptionGroup.incompatibleCarOptionGroups.add(new IncompatibleCarOptionGroup(this.id));
                }
        );
    }

    private void validationAddIncompatibleCarOptionGroup(
            final int incompatibleCarOptionGroupRequestSize,
            final List<CarOptionGroup> incompatibleCarOptionGroups
    ) {
        if (
                incompatibleCarOptionGroupRequestSize != incompatibleCarOptionGroups.size()
                        || isContainSameId(incompatibleCarOptionGroups)
        ) {
            throw new BadRequestException("양립 불가능한 차량 옵션 그룹 설정에 실패했습니다.");
        }
    }

    private boolean isContainSameId(final List<CarOptionGroup> incompatibleCarOptionGroups) {
        return incompatibleCarOptionGroups.stream().anyMatch(carOptionGroup -> carOptionGroup.id.equals(this.id));
    }

    public List<Long> incompatibleCarOptionGroupIds() {
        return this.incompatibleCarOptionGroups.stream()
                .map(IncompatibleCarOptionGroup::incompatibleCarOptionGroupId)
                .collect(Collectors.toUnmodifiableList());
    }

    public void addOptionTag(final List<Long> tagIds) {
        tagIds.forEach(tagId -> this.tags.add(new CarOptionTagCarOptionGroup(tagId)));
    }

    public List<Long> optionTagIds() {
        return this.tags.stream()
                .map(CarOptionTagCarOptionGroup::carOptionTagId)
                .collect(Collectors.toUnmodifiableList());
    }
}
