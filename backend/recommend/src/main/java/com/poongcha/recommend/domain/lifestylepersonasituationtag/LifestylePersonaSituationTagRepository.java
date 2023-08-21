package com.poongcha.recommend.domain.lifestylepersonasituationtag;

import org.springframework.data.repository.Repository;

public interface LifestylePersonaSituationTagRepository extends Repository<LifestylePersonaSituationTag, Long> {
    LifestylePersonaSituationTag save(final LifestylePersonaSituationTag lifestylePersonaSituationTag);
}
