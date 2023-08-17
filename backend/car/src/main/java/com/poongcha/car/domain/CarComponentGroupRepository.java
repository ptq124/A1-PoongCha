package com.poongcha.car.domain;

import org.springframework.data.repository.Repository;

public interface CarComponentGroupRepository extends Repository<CarComponentGroup, Long> {
    CarComponentGroup save(final CarComponentGroup carComponentGroup);
}
