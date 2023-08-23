package com.poongcha.recommend.application.carestimaterecommandation;

import com.poongcha.recommend.application.dto.CarEstimateRecommendationCreateRequest;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateCode;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateRecommendation;
import org.springframework.stereotype.Component;

@Component
public class CarEstimateRecommendationMapper {
    public CarEstimateRecommendation toEntity(
            final CarEstimateRecommendationCreateRequest carEstimateRecommendationCreateRequest
    ) {
        return new CarEstimateRecommendation(
                new CarEstimateCode(carEstimateRecommendationCreateRequest.getEstimateCode()),
                carEstimateRecommendationCreateRequest.getAdditionalQuestionOptionIds()
        );
    }
}
