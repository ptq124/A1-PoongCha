package com.poongcha.car.presentation;

import com.poongcha.car.application.CarComponentCommandService;
import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
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

    @PostMapping("/api/component-group")
    private ResponseEntity createCarComponentGroup(
            @RequestBody CarComponentGroupCreateRequest carComponentGroupCreateRequest
    ) {
        long createCarComponentGroupId = carComponentCommandService.create(carComponentGroupCreateRequest);
        return ResponseEntity.created(URI.create("/api/component-group/" + createCarComponentGroupId)).build();
    }
}
