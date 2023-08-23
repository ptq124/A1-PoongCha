package com.poongcha.recommend.application.recommendationfeedback;

import com.poongcha.recommend.application.dto.RecommendationFeedbackCreateRequest;
import com.poongcha.recommend.domain.recommendationfeedback.FeedbackScore;
import com.poongcha.recommend.domain.recommendationfeedback.RecommendationFeedback;
import com.poongcha.recommend.application.dto.RecommendationFeedbackResponse;
import org.springframework.stereotype.Component;

@Component
public class RecommendationFeedbackMapper {
    public RecommendationFeedback toEntity(
            final RecommendationFeedbackCreateRequest recommendationFeedbackCreateRequest
    ) {
        return new RecommendationFeedback(
                FeedbackScore.valueOf(recommendationFeedbackCreateRequest.getFeedbackScore()),
                recommendationFeedbackCreateRequest.getEstimateId(),
                recommendationFeedbackCreateRequest.getAdditionalQuestionAnswerGroupId()
        );
    }

    public RecommendationFeedbackResponse toRecommendationFeedbackResponse(
            RecommendationFeedback recommendationFeedback) {
        return new RecommendationFeedbackResponse(
                recommendationFeedback.getId(),
                recommendationFeedback.getFeedbackScore().name(),
                recommendationFeedback.getEstimateId(),
                recommendationFeedback.getAdditionalQuestionAnswerGroup().getId()
        );
    }
}
