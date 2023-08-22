package com.poongcha.recommend.domain.lifestylepersona;

import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "lifestyle_persona_additional_question_options")
public class LifestylePersonaAdditionalQuestionOption {
    @Column("id")
    @Id
    private Long id;

    @Column("additional_question_option_id")
    private AggregateReference<AdditionalQuestionOption, Long> additionalQuestionOption;

    public LifestylePersonaAdditionalQuestionOption(final Long id) {
        this.additionalQuestionOption = new IdOnlyAggregateReference<>(id);
    }
}
