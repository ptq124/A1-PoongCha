package com.poongcha.car.domain.carestimate;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface CarEstimateRepository extends Repository<CarEstimate, Long> {
    CarEstimate save(final CarEstimate carEstimate);

    Optional<CarEstimate> findById(final long id);

    Optional<CarEstimate> findByEstimateCode(final String estimateCode);
}
