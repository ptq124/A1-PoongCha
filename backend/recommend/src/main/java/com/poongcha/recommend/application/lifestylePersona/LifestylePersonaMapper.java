package com.poongcha.recommend.application.lifestylePersona;

import com.poongcha.recommend.application.dto.LifestylePersonaCreateRequest;
import com.poongcha.recommend.domain.lifestylepersona.Answer;
import com.poongcha.recommend.domain.lifestylepersona.CoverImageUrl;
import com.poongcha.recommend.domain.lifestylepersona.LifestyleInterview;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaProfile;
import com.poongcha.recommend.domain.lifestylepersona.Question;
import com.poongcha.recommend.domain.lifestylepersona.RepresentativePhrase;
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
}
