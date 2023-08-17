package com.poongcha.car.domain.trim;

import com.poongcha.car.domain.carcolor.CarColor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "trim_car_colors")
public class TrimCarColor {
    @Column("car_color_id")
    private AggregateReference<CarColor, Long> carColor;

    @Embedded.Nullable
    private TrimExteriorImageUrl trimExteriorImageUrl;

    @Embedded.Nullable
    private TrimInteriorImageUrl trimInteriorImageUrl;

    @Embedded.Nullable
    private TrimRotationImageBaseUrl trimRotationImageBaseUrl;

    public TrimCarColor(
            final long carColorId,
            final TrimExteriorImageUrl trimExteriorImageUrl,
            final TrimInteriorImageUrl trimInteriorImageUrl,
            final TrimRotationImageBaseUrl trimRotationImageBaseUrl
    ) {
        this.carColor = new IdOnlyAggregateReference<>(carColorId);
        this.trimExteriorImageUrl = trimExteriorImageUrl;
        this.trimInteriorImageUrl = trimInteriorImageUrl;
        this.trimRotationImageBaseUrl = trimRotationImageBaseUrl;
    }

    public boolean isEqualCarColorId(final long id) {
        return carColor.getId().equals(id);
    }
}
