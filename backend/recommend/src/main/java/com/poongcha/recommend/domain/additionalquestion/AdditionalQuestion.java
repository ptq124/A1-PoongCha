package com.poongcha.recommend.domain.additionalquestion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "additional_questions")
public class AdditionalQuestion {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private Topic topic;

    @Embedded.Nullable
    private Description description;

    @MappedCollection(idColumn = "additional_question_id")
    private Set<AdditionalQuestionOption> additionalQuestionOptions = new HashSet<>();

    public AdditionalQuestion(
            final Topic topic,
            final Description description,
            final List<AdditionalQuestionOption> additionalQuestionOptions
    ) {
        this.topic = topic;
        this.description = description;
        this.additionalQuestionOptions.addAll(additionalQuestionOptions);
    }
}
