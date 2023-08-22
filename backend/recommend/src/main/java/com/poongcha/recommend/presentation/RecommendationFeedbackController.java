package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.dto.RecommendationFeedbackCreateRequest;
import com.poongcha.recommend.application.recommendationfeedback.RecommendationFeedbackCommandService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecommendationFeedbackController {
    private final RecommendationFeedbackCommandService recommendationFeedbackCommandService;

    @PostMapping("/feedback")
    public ResponseEntity<Void> create(
            @RequestBody RecommendationFeedbackCreateRequest recommendationFeedbackCreateRequest
    ) {
        long recommendationFeedbackId = recommendationFeedbackCommandService.create(
                recommendationFeedbackCreateRequest
        );

        return ResponseEntity.created(URI.create("/feedback/" + recommendationFeedbackId)).build();
    }
}
