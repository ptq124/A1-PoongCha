package com.poongcha.recommend.application.lifestylepersona;

import com.poongcha.recommend.application.dto.LifestyleInterviewResponse;
import com.poongcha.recommend.application.dto.LifestylePersonaCreateRequest;
import com.poongcha.recommend.application.dto.LifestylePersonaProfileResponse;
import com.poongcha.recommend.application.dto.LifestylePersonaResponse;
import com.poongcha.recommend.domain.lifestylepersona.Answer;
import com.poongcha.recommend.domain.lifestylepersona.CoverImageUrl;
import com.poongcha.recommend.domain.lifestylepersona.LifestyleInterview;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaProfile;
import com.poongcha.recommend.domain.lifestylepersona.Question;
import com.poongcha.recommend.domain.lifestylepersona.RepresentativePhrase;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class LifestylePersonaMapper {
    public LifestylePersona toEntity(final LifestylePersonaCreateRequest lifestylePersonaCreateRequest) {
        return new LifestylePersona(
                new RepresentativePhrase(lifestylePersonaCreateRequest.getRepresentativePhrase()),
                new LifestylePersonaProfile(
                        lifestylePersonaCreateRequest.getProfileImageUrl(),
                        lifestylePersonaCreateRequest.getProfileName(),
                        lifestylePersonaCreateRequest.getProfileIntroduction()
                ),
                new CoverImageUrl(lifestylePersonaCreateRequest.getCoverImageUrl()),
                lifestylePersonaCreateRequest.getInterviews().stream()
                        .map(lifestyleInterviewCreateRequest -> new LifestyleInterview(
                                new Question(lifestyleInterviewCreateRequest.getQuestion()),
                                new Answer(lifestyleInterviewCreateRequest.getAnswer())
                        )).collect(Collectors.toSet()),
                lifestylePersonaCreateRequest.getLifestylePersonaSituationTagIds(),
                lifestylePersonaCreateRequest.getAdditionalQuestionOptionIds()
        );
    }

    public LifestylePersonaResponse toLifeStylePersonResponse(
            final LifestylePersona lifestylePersona,
            final List<LifestylePersonaSituationTag> lifestylePersonaSituationTags
    ) {
        return new LifestylePersonaResponse(
                lifestylePersona.getId(),
                new LifestylePersonaProfileResponse(
                        lifestylePersona.getLifestylePersonaProfile().getName(),
                        lifestylePersona.getLifestylePersonaProfile().getImageUrl(),
                        lifestylePersona.getLifestylePersonaProfile().getIntroduction()
                ),
                lifestylePersonaSituationTags.stream()
                        .map(lifestylePersonaSituationTag -> lifestylePersonaSituationTag.getTagName().getValue())
                        .collect(Collectors.toUnmodifiableList()),
                lifestylePersona.getRepresentativePhrase().getValue(),
                lifestylePersona.getCoverImageUrl().getValue(),
                lifestylePersona.getLifestyleInterviews().stream()
                        .map(lifestyleInterview -> new LifestyleInterviewResponse(
                                lifestyleInterview.getQuestion().getValue(), lifestyleInterview.getAnswer().getAnswer()
                        )).collect(Collectors.toUnmodifiableList())
        );
    }
}
