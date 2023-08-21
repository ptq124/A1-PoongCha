package com.poongcha.recommend.domain.additionalquestionanswer;

import org.springframework.data.repository.Repository;

public interface AdditionalQuestionAnswerGroupRepository extends Repository<AdditionalQuestionAnswerGroup, Long> {
    AdditionalQuestionAnswerGroup save(final AdditionalQuestionAnswerGroup additionalQuestionAnswerGroup);
}
