package com.poongcha.car.domain;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface CarTypeRepository extends Repository<CarType, Long> {
    CarType save(final CarType carType);

    Optional<CarType> findById(final long id);
}
