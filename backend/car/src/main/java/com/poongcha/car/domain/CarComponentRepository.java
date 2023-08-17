package com.poongcha.car.domain;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface CarComponentRepository extends Repository<CarComponent, Long> {
    CarComponent save(final CarComponent carComponent);

    List<CarComponent> findAllByIdIn(List<Long> ids);
}
