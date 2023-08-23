package com.poongcha.car.presentation;

import com.poongcha.car.application.carestimate.CarEstimateCommandService;
import com.poongcha.car.application.carestimate.CarEstimateQueryService;
import com.poongcha.car.application.dto.CarEstimateCreateRequest;
import com.poongcha.car.application.dto.CarEstimateResponse;
import com.poongcha.car.application.dto.CarEstimateCreateResponse;
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
public class CarEstimateController {
    private final CarEstimateCommandService carEstimateCommandService;
    private final CarEstimateQueryService carEstimateQueryService;

    @PostMapping("/estimate")
    public ResponseEntity<CarEstimateCreateResponse> create(
            @RequestBody final CarEstimateCreateRequest carEstimateCreateRequest
    ) {
        CarEstimateCreateResponse carEstimateCreateResponse = carEstimateCommandService.create(
                carEstimateCreateRequest
        );

        return ResponseEntity.created(URI.create("/estimate/" + carEstimateCreateResponse.getCode()))
                .body(carEstimateCreateResponse);
    }

    @GetMapping("/estimate/{estimate-code}")
    public ResponseEntity<CarEstimateResponse> findBy(@PathVariable("estimate-code") String estimateCode) {
        return ResponseEntity.ok().body(carEstimateQueryService.findByEstimateCode(estimateCode));
    }
}
