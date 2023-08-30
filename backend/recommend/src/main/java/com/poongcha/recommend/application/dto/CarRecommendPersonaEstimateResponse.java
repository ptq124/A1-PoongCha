package com.poongcha.recommend.application.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarRecommendPersonaEstimateResponse {
    private String introduction;
    private CarRecommendationEstimateCarTypeResponse carType;
    private CarRecommendEstimateTrimResponse trim;
    private List<CarRecommendationEstimateComponentResponse> components;
    private CarRecommendEstimateColorResponse exteriorColor;
    private CarRecommendEstimateColorResponse interiorColor;
    private List<CarRecommendEstimateOptionResponse> optionGroups;

}
