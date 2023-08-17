package com.poongcha.car.domain.carcolor;

import com.poongcha.car.domain.common.ImageUrl;
import com.poongcha.car.exception.BadRequestException;
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

    public void addIncompatibleColor(final List<CarColor> carColors) {
        validationIncompatibleCarColor(carColors);
        incompatibleCarColors.addAll(toIncompatibleCarColors(carColors));
    }

    private void validationIncompatibleCarColor(final List<CarColor> incompatibleCarColors) {
        if (isPresentSameIdColor(incompatibleCarColors)) {
            throw new BadRequestException("같은 ID의 색상은 양립 불가능으로 설정할 수 없습니다.");
        }
        if (isPresentSameTypeColor(incompatibleCarColors)) {
            throw new BadRequestException("같은 색상 타입은 양립 불가능으로 설정할 수 없습니다.");
        }
    }

    private boolean isPresentSameIdColor(final List<CarColor> incompatibleCarColors) {
        return incompatibleCarColors.stream().anyMatch(carColor -> carColor.id.equals(this.id));
    }

    private boolean isPresentSameTypeColor(final List<CarColor> incompatibleCarColors) {
        return incompatibleCarColors.stream().anyMatch(carColor -> carColor.carColorType.equals(this.carColorType));
    }

    private List<IncompatibleCarColor> toIncompatibleCarColors(final List<CarColor> carColors) {
        return carColors.stream()
                .map(carColor -> new IncompatibleCarColor(carColor.id))
                .collect(Collectors.toList());
    }

    public List<Long> incompatibleColorIds() {
        return this.incompatibleCarColors.stream()
                .map(IncompatibleCarColor::getIncompatibleCarColor)
                .map(AggregateReference::getId)
                .collect(Collectors.toUnmodifiableList());
    }
}
