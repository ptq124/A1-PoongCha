package com.poongcha.car.domain.trim;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface TrimRepository extends Repository<Trim, Long> {
    Trim save(final Trim trim);

    Optional<Trim> findById(final long id);

    @Query("select * from trims where id = :id for update ")
    Optional<Trim> findByIdWithLock(final long id);

    List<Trim> findAllByCarType(final long id);
}
