package com.poongcha.car.domain.caroption;

import org.springframework.data.repository.Repository;

public interface CarOptionRepository extends Repository<CarOption, Long> {
    CarOption save(final CarOption carOption);
}
