package com.poongcha.car.presentation;

import com.poongcha.car.application.carestimate.CarEstimateCommandService;
import com.poongcha.car.application.carestimate.CarEstimateQueryService;
import com.poongcha.car.application.dto.CarEstimateCreateRequest;
import com.poongcha.car.application.dto.CarEstimateResponse;
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

    @PostMapping("/api/estimate")
    public ResponseEntity<Void> create(@RequestBody final CarEstimateCreateRequest carEstimateCreateRequest) {
        long createCarEstimateId = carEstimateCommandService.create(carEstimateCreateRequest);

        return ResponseEntity.created(URI.create("/api/estimate/" + createCarEstimateId)).build();
    }

    @GetMapping("/api/estimate/{id}")
    public ResponseEntity<CarEstimateResponse> create(@PathVariable("id") final long carEstimateId) {
        return ResponseEntity.ok().body(carEstimateQueryService.findById(carEstimateId));
    }
}
