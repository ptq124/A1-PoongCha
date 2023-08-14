package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
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
    private AggregateReference<Trim, Long> carType;

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
}
