package com.poongcha.car.domain;

import org.springframework.data.repository.Repository;

public interface CarColorRepository extends Repository<CarColor, Long> {
    CarColor save(final CarColor carColor);
}
