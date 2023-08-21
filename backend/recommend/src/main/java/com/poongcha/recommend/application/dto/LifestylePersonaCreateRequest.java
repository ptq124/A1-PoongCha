package com.poongcha.recommend.application.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LifestylePersonaCreateRequest {
    private String representativePhrase;
    private String profileImageUrl;
    private String profileName;
    private String profileIntroduction;
    private String coverImageUrl;
    private List<LifestyleInterviewCreateRequest> interviews;
    private List<Long> additionalQuestionOptionIds;
    private List<Long> lifestylePersonaSituationTagIds;
}
