package com.poongcha.recommend.infra.client;

import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateCode;
import org.springframework.http.ResponseEntity;

public interface CarContextClient {
    ResponseEntity<String> findEstimate(CarEstimateCode carEstimateCode);
}
