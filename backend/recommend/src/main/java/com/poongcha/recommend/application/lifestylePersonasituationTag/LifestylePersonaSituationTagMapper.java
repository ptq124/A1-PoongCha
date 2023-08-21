package com.poongcha.recommend.application.lifestylePersonasituationTag;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagCreateRequest;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.TagName;
import org.springframework.stereotype.Component;

@Component
public class LifestylePersonaSituationTagMapper {
    public LifestylePersonaSituationTag toEntity(final LifestylePersonaSituationTagCreateRequest lifestylePersonaSituationTagCreateRequest) {
        return new LifestylePersonaSituationTag(new TagName(lifestylePersonaSituationTagCreateRequest.getTagName()));
    }
}
