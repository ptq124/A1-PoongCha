package com.poongcha.car.domain;

import org.springframework.data.repository.Repository;

public interface CarTypeRepository extends Repository<CarType, Long> {
    CarType save(final CarType carType);
}
