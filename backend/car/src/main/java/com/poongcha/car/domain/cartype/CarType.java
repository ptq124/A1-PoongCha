package com.poongcha.car.domain.cartype;

import com.poongcha.car.domain.common.ImageUrl;
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
@Table(name = "car_types")
public class CarType {
    @Column(value = "id")
    @Id
    private Long id;

    @Embedded.Empty
    private CarTypeName carTypeName;

    @Embedded.Empty
    private ImageUrl imageUrl;

    @MappedCollection(idColumn = "car_type_id")
    private Set<CarTypeCarComponentGroup> carTypeCarComponentGroups;

    public CarType(final String carTypeName, final String imageUrl) {
        this.carTypeName = new CarTypeName(carTypeName);
        this.imageUrl = new ImageUrl(imageUrl);
    }

    public void addCarComponentGroup(final List<Long> carComponentGroupIds) {
        carComponentGroupIds.forEach(
                carComponentGroupId -> carTypeCarComponentGroups.add(new CarTypeCarComponentGroup(carComponentGroupId))
        );
    }

    public List<Long> carComponentGroupIds() {
        return carTypeCarComponentGroups.stream()
                .map(carTypeCarComponentGroup -> carTypeCarComponentGroup.getCarComponentGroup().getId())
                .collect(Collectors.toList());
    }
}
