package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.carestimaterecommandation.CarEstimateRecommendationCommandService;
import com.poongcha.recommend.application.carestimaterecommandation.CarEstimateRecommendationQueryService;
import com.poongcha.recommend.application.dto.CarEstimateRecommendationCreateRequest;
import com.poongcha.recommend.application.dto.CarRecommendEstimateRequest;
import com.poongcha.recommend.application.dto.CarRecommendPersonaEstimateResponse;
import com.poongcha.recommend.application.dto.CarRecommendQuestionEstimateResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarEstimateRecommendationController {
    private final CarEstimateRecommendationCommandService carEstimateRecommendationCommandService;
    private final CarEstimateRecommendationQueryService carEstimateRecommendationQueryService;

    @PostMapping("/recommend")
    public ResponseEntity<Void> create(
            @RequestBody final CarEstimateRecommendationCreateRequest carEstimateRecommendationRequest
    ) {
        long createCarEstimateRecommendationId = carEstimateRecommendationCommandService
                .create(carEstimateRecommendationRequest);

        return ResponseEntity.created(URI.create("/recommend/" + createCarEstimateRecommendationId)).build();
    }

    @PostMapping("/recommend/estimate/question")
    public ResponseEntity<CarRecommendQuestionEstimateResponse> findByQuestion(
            @RequestBody final CarRecommendEstimateRequest carRecommendEstimateRequest
    ) {
        return ResponseEntity.ok().body(
                carEstimateRecommendationQueryService.findQuestionRecommendation(carRecommendEstimateRequest)
        );
    }

    @PostMapping("/recommend/estimate/persona")
    public ResponseEntity<CarRecommendPersonaEstimateResponse> findByPersona(
            @RequestBody final CarRecommendEstimateRequest carRecommendEstimateRequest
    ) {
        return ResponseEntity.ok().body(
                carEstimateRecommendationQueryService.findPersonaRecommendation(carRecommendEstimateRequest)
        );
    }
}
