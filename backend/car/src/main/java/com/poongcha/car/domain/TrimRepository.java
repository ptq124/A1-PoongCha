package com.poongcha.car.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface TrimRepository extends Repository<Trim, Long> {
    Trim save(final Trim trim);

    Optional<Trim> findById(final long id);

    List<Trim> findAllByCarType(final long id);
}
