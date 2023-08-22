package com.poongcha.recommend.domain.recommendationfeedback;

import org.springframework.data.repository.Repository;

public interface RecommendationFeedbackRepository extends Repository<RecommendationFeedback, Long> {

    RecommendationFeedback save(final RecommendationFeedback recommendationFeedback);
}
