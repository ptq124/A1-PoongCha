package com.poongcha.recommend.application.recommendationfeedback;

import com.poongcha.recommend.application.dto.RecommendationFeedbackResponse;
import com.poongcha.recommend.domain.recommendationfeedback.RecommendationFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RecommendationFeedbackQueryService {
    private final RecommendationFeedbackRepository recommendationFeedbackRepository;
    private final RecommendationFeedbackMapper recommendationFeedbackMapper;

    public RecommendationFeedbackResponse findById(long id) {
        return recommendationFeedbackMapper.toRecommendationFeedbackResponse(
                recommendationFeedbackRepository.findById(id)
        );
    }
}
