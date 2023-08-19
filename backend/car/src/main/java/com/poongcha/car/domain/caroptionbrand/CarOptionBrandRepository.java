package com.poongcha.car.domain.caroptionbrand;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface CarOptionBrandRepository extends Repository<CarOptionBrand, Long> {
    CarOptionBrand save(final CarOptionBrand carOptionBrand);

    List<CarOptionBrand> findAllByCarOptionGroup(final long id);
}
