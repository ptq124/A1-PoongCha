package com.poongcha.car.domain.caroptiongroup;

import org.springframework.data.repository.Repository;

public interface CarOptionGroupRepository extends Repository<CarOptionGroup, Long> {
    CarOptionGroup save(final CarOptionGroup carOptionGroup);
}
