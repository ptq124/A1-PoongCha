package com.poongcha.car.domain.trim;

import com.poongcha.car.domain.common.ImageUrl;
import com.poongcha.car.domain.cartype.CarType;
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
            final TrimName trimName,
            final ImageUrl imageUrl,
            final MinPrice minPrice,
            final long carType
    ) {
        this.trimName = trimName;
        this.imageUrl = imageUrl;
        this.minPrice = minPrice;
        this.carType = new IdOnlyAggregateReference<>(carType);
    }

    public void addCarColor(
            final long carColorId,
            final TrimImageUrl trimImageUrl
    ) {
        TrimCarColor trimCarColor = new TrimCarColor(carColorId, trimImageUrl);
        trimCarColors.add(trimCarColor);
    }

    public String exteriorImageUrl(final long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimImageUrl)
                .map(TrimImageUrl::getExterior)
                .orElse(null);
    }

    public String interiorImageUrl(final long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimImageUrl)
                .map(TrimImageUrl::getInterior)
                .orElse(null);
    }

    public String rotationImageUrl(final Long carColorId) {
        return trimCarColorBy(carColorId)
                .map(TrimCarColor::getTrimImageUrl)
                .map(TrimImageUrl::getRotation)
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
