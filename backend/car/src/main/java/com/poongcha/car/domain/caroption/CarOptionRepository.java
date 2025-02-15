package com.poongcha.car.domain.caroption;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface CarOptionRepository extends Repository<CarOption, Long> {
    CarOption save(final CarOption carOption);

    List<CarOption> findAllByIdIn(final List<Long> ids);
}
