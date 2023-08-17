package com.poongcha.car.presentation;

import com.poongcha.car.application.CarComponentGroupCommandService;
import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarComponentGroupController {
    private final CarComponentGroupCommandService carComponentGroupCommandService;

    @PostMapping("/api/component-group")
    private ResponseEntity createCarComponentGroup(
            @RequestBody CarComponentGroupCreateRequest carComponentGroupCreateRequest
    ) {
        long createCarComponentGroupId = carComponentGroupCommandService.create(carComponentGroupCreateRequest);
        return ResponseEntity.created(URI.create("/api/component-group/" + createCarComponentGroupId)).build();
    }
}
