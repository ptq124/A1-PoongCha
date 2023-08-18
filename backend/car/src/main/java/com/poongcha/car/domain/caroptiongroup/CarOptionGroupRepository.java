package com.poongcha.car.domain.caroptiongroup;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface CarOptionGroupRepository extends Repository<CarOptionGroup, Long> {
    CarOptionGroup save(final CarOptionGroup carOptionGroup);

    Optional<CarOptionGroup> findById(final long id);
}
