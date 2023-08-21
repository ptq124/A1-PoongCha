package com.poongcha.recommend.domain.additionalquestionanswer;

import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "additional_question_answer_groups")
public class AdditionalQuestionAnswerGroup {
    @Column("id")
    @Id
    private Long id;

    @MappedCollection(idColumn = "additional_question_answer_group_id")
    private Set<AdditionalQuestionAnswer> additionalQuestionAnswers;

    public AdditionalQuestionAnswerGroup(final Set<AdditionalQuestionAnswer> additionalQuestionAnswers) {
        this.additionalQuestionAnswers = additionalQuestionAnswers;
    }
}
