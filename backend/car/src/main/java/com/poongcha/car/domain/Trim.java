package com.poongcha.car.domain;

import java.util.HashSet;
import java.util.Set;
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

    public void addCarColor(final long carColorId) {
        trimCarColors.add(new TrimCarColor(carColorId));
    }
}
