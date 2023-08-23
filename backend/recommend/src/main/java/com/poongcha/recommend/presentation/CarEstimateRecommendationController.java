package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.carestimaterecommandation.CarEstimateRecommendationCommandService;
import com.poongcha.recommend.application.dto.CarEstimateRecommendationCreateRequest;
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

    @PostMapping("/recommend")
    public ResponseEntity<Void> create(
            @RequestBody final CarEstimateRecommendationCreateRequest carEstimateRecommendationRequest
    ) {
        long createCarEstimateRecommendationId = carEstimateRecommendationCommandService
                .create(carEstimateRecommendationRequest);

        return ResponseEntity.created(URI.create("/recommend/" + createCarEstimateRecommendationId)).build();
    }
}
