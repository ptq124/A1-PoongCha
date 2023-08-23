package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.recommendationfeedback.RecommendationFeedbackQueryService;
import com.poongcha.recommend.application.dto.RecommendationFeedbackCreateRequest;
import com.poongcha.recommend.application.dto.RecommendationFeedbackResponse;
import com.poongcha.recommend.application.recommendationfeedback.RecommendationFeedbackCommandService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecommendationFeedbackController {
    private final RecommendationFeedbackCommandService recommendationFeedbackCommandService;
    private final RecommendationFeedbackQueryService recommendationFeedbackQueryService;

    @PostMapping("/feedback")
    public ResponseEntity<Void> create(
            @RequestBody RecommendationFeedbackCreateRequest recommendationFeedbackCreateRequest
    ) {
        long recommendationFeedbackId = recommendationFeedbackCommandService.create(
                recommendationFeedbackCreateRequest
        );

        return ResponseEntity.created(URI.create("/feedback/" + recommendationFeedbackId)).build();
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<RecommendationFeedbackResponse> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(recommendationFeedbackQueryService.findById(id));
    }
}
