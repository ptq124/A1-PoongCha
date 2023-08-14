package com.poongcha.car.domain;

import org.springframework.data.repository.Repository;

public interface TrimRepository extends Repository<Trim, Long> {
    Trim save(final Trim trim);
}
