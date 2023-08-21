package com.poongcha.recommend.domain.lifestylepersona;

import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
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
@Table(name = "lifestyle_persona_lifestyle_persona_situation_tags")
public class LifestylePersonaLifestylePersonaSituationTag {
    @Column("id")
    @Id
    private Long id;

    @Column("lifestyle_persona_situation_tag_id")
    private AggregateReference<LifestylePersonaSituationTag, Long> lifestylePersonaSituationTag;

    public LifestylePersonaLifestylePersonaSituationTag(final long id) {
        this.lifestylePersonaSituationTag = new IdOnlyAggregateReference<>(id);
    }

    public Long lifestylePersonaSituationTagId() {
        return this.lifestylePersonaSituationTag.getId();
    }
}
