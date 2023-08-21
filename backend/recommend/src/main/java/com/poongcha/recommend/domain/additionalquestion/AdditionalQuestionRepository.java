package com.poongcha.recommend.domain.additionalquestion;

import org.springframework.data.repository.Repository;

public interface AdditionalQuestionRepository extends Repository<AdditionalQuestion, Long> {
    AdditionalQuestion save(final AdditionalQuestion additionalQuestion);
}
