package com.poongcha.car.domain.caroption;

import com.poongcha.car.domain.common.ImageUrl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_options")
public class CarOption {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private CarOptionName carOptionName;

    private InstallationLocation installationLocation;

    @Embedded.Nullable
    private ImageUrl imageUrl;

    @Embedded.Nullable
    private DetailDescription detailDescription;

    public CarOption(
            final CarOptionName carOptionName,
            final ImageUrl imageUrl,
            final InstallationLocation installationLocation,
            final DetailDescription detailDescription
    ) {
        this.carOptionName = carOptionName;
        this.imageUrl = imageUrl;
        this.installationLocation = installationLocation;
        this.detailDescription = detailDescription;
    }
}
