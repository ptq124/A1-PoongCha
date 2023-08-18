package com.poongcha.car.domain.caroptiongroup;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface CarOptionGroupRepository extends Repository<CarOptionGroup, Long> {
    CarOptionGroup save(final CarOptionGroup carOptionGroup);

    <S extends CarOptionGroup> Iterable<S> saveAll(Iterable<S> entities);

    Optional<CarOptionGroup> findById(final long id);

    @Query("select * from car_option_groups where id = :id")
    Optional<CarOptionGroup> findByIdWithLock(final long id);

    List<CarOptionGroup> findAllByIdIn(final List<Long> ids);

    @Query("select * from car_option_groups where id in (:ids)")
    List<CarOptionGroup> findAllByIdInWithLock(final @Param("ids") List<Long> ids);
}
