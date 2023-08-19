package com.poongcha.car.domain.caroptiontag;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface CarOptionTagRepository extends Repository<CarOptionTag, Long> {
    CarOptionTag save(final CarOptionTag carOptionTag);

    Optional<CarOptionTag> findById(final long id);

    List<CarOptionTag> findAll();

    List<CarOptionTag> findAllByIdIn(final List<Long> ids);
}
