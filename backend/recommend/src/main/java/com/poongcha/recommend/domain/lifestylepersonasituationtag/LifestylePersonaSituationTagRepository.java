package com.poongcha.recommend.domain.lifestylepersonasituationtag;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface LifestylePersonaSituationTagRepository extends Repository<LifestylePersonaSituationTag, Long> {
    LifestylePersonaSituationTag save(final LifestylePersonaSituationTag lifestylePersonaSituationTag);

    List<LifestylePersonaSituationTag> findAll();

    List<LifestylePersonaSituationTag> findAllByIdIn(final List<Long> ids);
}
