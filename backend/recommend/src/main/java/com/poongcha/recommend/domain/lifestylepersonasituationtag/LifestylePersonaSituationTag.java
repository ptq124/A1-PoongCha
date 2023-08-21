package com.poongcha.recommend.domain.lifestylepersonasituationtag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "lifestyle_persona_situation_tags")
public class LifestylePersonaSituationTag {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private TagName tagName;

    public LifestylePersonaSituationTag(final TagName tagName) {
        this.tagName = tagName;
    }
}
