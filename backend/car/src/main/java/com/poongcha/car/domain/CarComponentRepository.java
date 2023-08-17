package com.poongcha.car.domain;

import org.springframework.data.repository.Repository;

public interface CarComponentRepository extends Repository<CarComponent, Long> {
    CarComponent save(final CarComponent carComponent);
}
