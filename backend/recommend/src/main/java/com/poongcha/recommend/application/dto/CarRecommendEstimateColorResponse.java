package com.poongcha.recommend.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CarRecommendEstimateColorResponse {
    private long id;
    private String name;
    private String imageUrl;
}
