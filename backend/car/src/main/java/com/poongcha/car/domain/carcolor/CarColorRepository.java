package com.poongcha.car.domain.carcolor;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface CarColorRepository extends Repository<CarColor, Long> {
    CarColor save(final CarColor carColor);

    Optional<CarColor> findById(final long id);

    List<CarColor> findAllByIdIn(final List<Long> ids);

    @Query("select * from car_colors where id = :id for update")
    Optional<CarColor> findByIdWithLock(final long id);
}
