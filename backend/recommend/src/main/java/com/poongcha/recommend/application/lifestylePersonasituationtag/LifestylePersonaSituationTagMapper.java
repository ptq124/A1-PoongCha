package com.poongcha.recommend.application.lifestylePersonasituationtag;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagCreateRequest;
import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagResponse;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.TagName;
import org.springframework.stereotype.Component;

@Component
public class LifestylePersonaSituationTagMapper {
    public LifestylePersonaSituationTag toEntity(
            final LifestylePersonaSituationTagCreateRequest lifestylePersonaSituationTagCreateRequest) {
        return new LifestylePersonaSituationTag(new TagName(lifestylePersonaSituationTagCreateRequest.getTagName()));
    }

    public LifestylePersonaSituationTagResponse toLifeStylePersonaSituationTagResponse(
            final LifestylePersonaSituationTag lifestylePersonaSituationTag
    ) {
        return new LifestylePersonaSituationTagResponse(
                lifestylePersonaSituationTag.getId(),
                lifestylePersonaSituationTag.getTagName().getValue()
        );
    }
}
