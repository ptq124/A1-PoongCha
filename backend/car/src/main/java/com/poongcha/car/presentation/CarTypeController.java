package com.poongcha.car.presentation;

import com.poongcha.car.application.CarTypeCommandService;
import com.poongcha.car.application.dto.CarTypeCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarTypeController {
    private final CarTypeCommandService carTypeCommandService;

    @PostMapping("/api/car-type")
    public ResponseEntity createCarType(@RequestBody final CarTypeCreateRequest carTypeCreateRequest) {
        long createCarTypeId = carTypeCommandService.create(carTypeCreateRequest);
        return ResponseEntity.created(URI.create("/api/car-type/" + createCarTypeId)).build();
    }
}
