package com.poongcha.recommend.domain.additionalquestion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "additional_question_options")
public class AdditionalQuestionOption {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private AdditionalQuestionSequence additionalQuestionSequence;

    @Embedded.Nullable
    private AdditionalQuestionOptionName additionalQuestionOptionName;

    public AdditionalQuestionOption(
            final AdditionalQuestionSequence additionalQuestionSequence,
            final AdditionalQuestionOptionName additionalQuestionOptionName
    ) {
        this.additionalQuestionSequence = additionalQuestionSequence;
        this.additionalQuestionOptionName = additionalQuestionOptionName;
    }
}
