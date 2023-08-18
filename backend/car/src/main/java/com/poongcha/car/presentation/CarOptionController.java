package com.poongcha.car.presentation;

import com.poongcha.car.application.caroption.CarOptionCommandService;
import com.poongcha.car.application.caroption.dto.CarOptionCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionController {
    private final CarOptionCommandService carOptionCommandService;

    @PostMapping("/api/option")
    public ResponseEntity<Void> createCarOption(@RequestBody final CarOptionCreateRequest carOptionCreateRequest) {
        long createCarOptionId = carOptionCommandService.create(carOptionCreateRequest);

        return ResponseEntity.created(URI.create("/api/option/" + createCarOptionId)).build();
    }
}
