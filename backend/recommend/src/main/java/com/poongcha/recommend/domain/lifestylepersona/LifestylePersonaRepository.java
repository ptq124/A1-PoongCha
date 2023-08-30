package com.poongcha.recommend.domain.lifestylepersona;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface LifestylePersonaRepository extends Repository<LifestylePersona, Long> {
    LifestylePersona save(final LifestylePersona lifestylePersona);

    List<LifestylePersona> findAll();

    LifestylePersona findById(long personaId);
}
