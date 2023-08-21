package com.poongcha.recommend.domain.additionalquestionanswer;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface AdditionalQuestionAnswerGroupRepository extends Repository<AdditionalQuestionAnswerGroup, Long> {
    AdditionalQuestionAnswerGroup save(final AdditionalQuestionAnswerGroup additionalQuestionAnswerGroup);

    Optional<AdditionalQuestionAnswerGroup> findById(final long id);
}
