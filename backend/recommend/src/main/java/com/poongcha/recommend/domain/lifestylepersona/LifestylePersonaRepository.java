package com.poongcha.recommend.domain.lifestylepersona;

import org.springframework.data.repository.Repository;

public interface LifestylePersonaRepository extends Repository<LifestylePersona, Long> {
    LifestylePersona save(final LifestylePersona lifestylePersona);
}
