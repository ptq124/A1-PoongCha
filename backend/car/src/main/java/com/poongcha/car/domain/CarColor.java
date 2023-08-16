package com.poongcha.car.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_colors")
public class CarColor {
    @Id
    private Long id;

    @Embedded.Empty
    private CarColorName carColorName;

    @Embedded.Empty
    private ImageUrl imageUrl;

    private CarColorType carColorType;

    @MappedCollection(idColumn = "car_color_id")
    private Set<IncompatibleCarColor> incompatibleCarColors = new HashSet<>();

    public CarColor(final CarColorName carColorName, final ImageUrl imageUrl, final CarColorType carColorType) {
        this.carColorName = carColorName;
        this.imageUrl = imageUrl;
        this.carColorType = carColorType;
    }

    public void addIncompatibleColor(final List<Long> incompatibleCarColorIds) {
        List<IncompatibleCarColor> incompatibleCarColorList = incompatibleCarColorIds.stream()
                .map(IncompatibleCarColor::new)
                .collect(Collectors.toList());

        incompatibleCarColors.addAll(incompatibleCarColorList);
    }

    public List<Long> incompatibleColorIds() {
        return this.incompatibleCarColors.stream()
                .map(IncompatibleCarColor::getIncompatibleCarColor)
                .map(AggregateReference::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
