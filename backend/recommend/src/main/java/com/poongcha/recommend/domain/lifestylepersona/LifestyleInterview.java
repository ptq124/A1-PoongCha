package com.poongcha.recommend.domain.lifestylepersona;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "lifestyle_interviews")
public class LifestyleInterview {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private Question question;

    @Embedded.Nullable
    private Answer answer;

    public LifestyleInterview(final Question question, final Answer answer) {
        this.question = question;
        this.answer = answer;
    }
}
