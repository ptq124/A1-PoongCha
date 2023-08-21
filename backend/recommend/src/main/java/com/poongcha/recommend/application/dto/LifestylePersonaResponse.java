package com.poongcha.recommend.application.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LifestylePersonaResponse {
    private long id;
    private LifestylePersonaProfileResponse profile;
    public List<String> situationTags = new ArrayList<>();
    private String representativePhrase;
    private String coverImageUrl;
    private List<LifestyleInterviewResponse> interviews;
}
