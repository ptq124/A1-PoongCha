package com.poongcha.car.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "trims")
public class Trim {
    @Column(value = "id")
    @Id
    private Long id;

    @Embedded.Empty
    private TrimName trimName;

    @Embedded.Empty
    private ImageUrl imageUrl;

    @Embedded.Empty
    private MinPrice minPrice;

    @Column("car_type_id")
    private AggregateReference<CarType, Long> carType;

    @MappedCollection(idColumn = "trim_id")
    private Set<TrimCarColor> trimCarColors = new HashSet<>();

    public Trim(
            final String trimName,
            final String imageUrl,
            final long minPrice,
            final long carType
    ) {
        this.trimName = new TrimName(trimName);
        this.imageUrl = new ImageUrl(imageUrl);
        this.minPrice = new MinPrice(minPrice);
        this.carType = new IdOnlyAggregateReference<>(carType);
    }

    public void addCarColor(
            final long carColorId,
            final TrimExteriorImageUrl trimExteriorImageUrl,
            final TrimInteriorImageUrl trimInteriorImageUrl,
            final TrimRotationImageBaseUrl trimRotationImageBaseUrl
    ) {
        TrimCarColor trimCarColor = new TrimCarColor(
                carColorId,
                trimExteriorImageUrl,
                trimInteriorImageUrl,
                trimRotationImageBaseUrl
        );
        trimCarColors.add(trimCarColor);
    }

    public String exteriorImageUrl(final long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimExteriorImageUrl)
                .map(TrimExteriorImageUrl::getValue)
                .orElse(null);
    }

    public String interiorImageUrl(final long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimInteriorImageUrl)
                .map(TrimInteriorImageUrl::getValue)
                .orElse(null);
    }

    public String rotationImageUrl(final Long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimRotationImageBaseUrl)
                .map(TrimRotationImageBaseUrl::getValue)
                .orElse(null);
    }

    private Optional<TrimCarColor> trimCarColorBy(final long carColorId) {
        return trimCarColors.stream()
                .filter(trimCarColor -> trimCarColor.isEqualCarColorId(carColorId))
                .findFirst();
    }

    public List<Long> carColorIds() {
        return trimCarColors.stream()
                .map(TrimCarColor::getCarColor)
                .map(AggregateReference::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
