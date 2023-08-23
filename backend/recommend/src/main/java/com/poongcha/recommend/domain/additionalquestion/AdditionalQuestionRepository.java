package com.poongcha.recommend.domain.additionalquestion;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface AdditionalQuestionRepository extends Repository<AdditionalQuestion, Long> {
    AdditionalQuestion save(final AdditionalQuestion additionalQuestion);

    Optional<AdditionalQuestion> findById(final long id);

    List<AdditionalQuestion> findAll();

    @Query("select * from additional_question_options where id in (:ids)")
    List<AdditionalQuestionOption> findAllByAdditionalQuestionsOptionIdIn(final List<Long> ids);

    @Query(
            "select * "
                    + "from additional_question_options "
                    + "where id in (select distinct additional_question_id from additional_question_options where id in (:ids) )"
    )
    List<AdditionalQuestion> findAllByAdditionalQuestionOptionIdIn(final List<Long> ids);
}
