package com.poongcha.car.presentation;

import com.poongcha.car.application.carcomponent.CarComponentCommandService;
import com.poongcha.car.application.dto.CarComponentCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarComponentController {
    private final CarComponentCommandService carComponentCommandService;

    @PostMapping("/component")
    private ResponseEntity<Void> createCarComponent(
            @RequestBody final CarComponentCreateRequest carComponentCreateRequest
    ) {
        long createCarComponentGroupId = carComponentCommandService.create(carComponentCreateRequest);
        return ResponseEntity.created(URI.create("/component/" + createCarComponentGroupId)).build();
    }
}
