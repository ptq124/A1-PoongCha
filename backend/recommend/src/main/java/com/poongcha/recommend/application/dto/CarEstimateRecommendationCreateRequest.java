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
public class CarEstimateRecommendationCreateRequest {
    private String estimateCode;
    private List<Long> additionalQuestionOptionIds = new ArrayList<>();
}
