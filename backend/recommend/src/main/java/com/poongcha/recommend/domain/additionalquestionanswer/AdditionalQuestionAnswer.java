package com.poongcha.recommend.domain.additionalquestionanswer;

import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "additional_question_answers")
public class AdditionalQuestionAnswer {
    @Column("additional_question_option_id")
    private AggregateReference<AdditionalQuestionOption, Long> additionalQuestionOption;

    public AdditionalQuestionAnswer(final Long additionalQuestionOptionId) {
        this.additionalQuestionOption = new IdOnlyAggregateReference<>(additionalQuestionOptionId);
    }

    public long additionalQuestionOptionId() {
        return additionalQuestionOption.getId();
    }
}
