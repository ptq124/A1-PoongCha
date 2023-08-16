package com.poongcha.car.domain;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface CarColorRepository extends Repository<CarColor, Long> {
    CarColor save(final CarColor carColor);

    List<CarColor> findAllByIdIn(final List<Long> ids);
}
