package com.poongcha.recommend.domain.lifestylepersona;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
@Table(name = "lifestyle_personas")
public class LifestylePersona {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private RepresentativePhrase representativePhrase;

    @Embedded.Nullable
    private LifestylePersonaProfile lifestylePersonaProfile;

    @Embedded.Nullable
    private CoverImageUrl coverImageUrl;

    @MappedCollection(idColumn = "lifestyle_persona_id")
    private Set<LifestyleInterview> lifestyleInterviews = new HashSet<>();

    @MappedCollection(idColumn = "lifestyle_persona_id")
    private Set<LifestylePersonaLifestylePersonaSituationTag> lifestylePersonaLifestylePersonaSituationTags = new HashSet<>();

    @MappedCollection(idColumn = "lifestyle_persona_id")
    private Set<LifestylePersonaAdditionalQuestionOption> lifestylePersonaAdditionalQuestionOptions = new HashSet<>();

    public LifestylePersona(
            final RepresentativePhrase representativePhrase,
            final LifestylePersonaProfile lifestylePersonaProfile,
            final CoverImageUrl coverImageUrl,
            final Set<LifestyleInterview> lifestyleInterviews,
            final List<Long> lifestylePersonaSituationTagIds,
            final List<Long> additionalQuestionOptionIds
    ) {
        this.representativePhrase = representativePhrase;
        this.lifestylePersonaProfile = lifestylePersonaProfile;
        this.coverImageUrl = coverImageUrl;
        this.lifestyleInterviews = lifestyleInterviews;
        this.lifestylePersonaLifestylePersonaSituationTags.addAll(lifestylePersonaSituationTagIds.stream()
                .map(LifestylePersonaLifestylePersonaSituationTag::new)
                .collect(Collectors.toUnmodifiableList()));
        this.lifestylePersonaAdditionalQuestionOptions.addAll(additionalQuestionOptionIds.stream()
                .map(LifestylePersonaAdditionalQuestionOption::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<Long> lifestylePersonaSituationTagIds() {
        return this.lifestylePersonaLifestylePersonaSituationTags.stream()
                .map(LifestylePersonaLifestylePersonaSituationTag::lifestylePersonaSituationTagId)
                .collect(Collectors.toUnmodifiableList());
    }
}
