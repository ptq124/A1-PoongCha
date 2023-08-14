package com.poongcha.car.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
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

    private AggregateReference<Trim, Long> carTypeId;

    public Trim(final TrimName trimName, final ImageUrl imageUrl, final AggregateReference<Trim, Long> carTypeId) {
        this.trimName = trimName;
        this.imageUrl = imageUrl;
        this.carTypeId = carTypeId;
    }
}
