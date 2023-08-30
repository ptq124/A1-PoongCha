package com.poongcha.recommend.application.recommendationfeedback;

import com.poongcha.recommend.application.dto.RecommendationFeedbackCreateRequest;
import com.poongcha.recommend.domain.recommendationfeedback.RecommendationFeedback;
import com.poongcha.recommend.domain.recommendationfeedback.RecommendationFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RecommendationFeedbackCommandService {
    private final RecommendationFeedbackRepository recommendationFeedbackRepository;
    private final RecommendationFeedbackMapper recommendationFeedbackMapper;

    public long create(final RecommendationFeedbackCreateRequest recommendationFeedbackCreateRequest) {
        RecommendationFeedback recommendationFeedback = recommendationFeedbackMapper.toEntity(
                recommendationFeedbackCreateRequest
        );

        return recommendationFeedbackRepository.save(recommendationFeedback).getId();
    }
}
