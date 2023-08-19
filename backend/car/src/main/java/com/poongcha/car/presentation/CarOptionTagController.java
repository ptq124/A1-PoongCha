package com.poongcha.car.presentation;

import com.poongcha.car.application.caroptiontag.CarOptionTagCommandService;
import com.poongcha.car.application.caroptiontag.CarOptionTagQueryService;
import com.poongcha.car.application.dto.CarOptionTagCreateRequest;
import com.poongcha.car.application.dto.CarOptionTagResponse;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionTagController {
    private final CarOptionTagCommandService carOptionTagCommandService;
    private final CarOptionTagQueryService carOptionTagQueryService;

    @PostMapping("/api/option-tag")
    public ResponseEntity<Void> create(@RequestBody final CarOptionTagCreateRequest carOptionTagCreateRequest) {
        long createCarOptionTagId = carOptionTagCommandService.create(carOptionTagCreateRequest);

        return ResponseEntity.created(URI.create("/api/option-tag/" + createCarOptionTagId)).build();
    }

    @GetMapping("/api/option-tag/{id}")
    public ResponseEntity<CarOptionTagResponse> findById(@PathVariable("id") long optionTagId) {
        return ResponseEntity.ok().body(carOptionTagQueryService.findById(optionTagId));
    }

    @GetMapping("/api/option-tag")
    public ResponseEntity<List<CarOptionTagResponse>> findAll() {
        return ResponseEntity.ok().body(carOptionTagQueryService.findAll());
    }
}
