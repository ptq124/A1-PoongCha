package com.poongcha.car.presentation;

import com.poongcha.car.application.carcomponentgroup.CarComponentGroupCommandService;
import com.poongcha.car.application.dto.CarComponentGroupAddCarComponentRequest;
import com.poongcha.car.application.dto.CarComponentGroupCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarComponentGroupController {
    private final CarComponentGroupCommandService carComponentGroupCommandService;

    @PostMapping("/component-group")
    private ResponseEntity<Void> createCarComponentGroup(
            @RequestBody final CarComponentGroupCreateRequest carComponentGroupCreateRequest
    ) {
        long createCarComponentGroupId = carComponentGroupCommandService.create(carComponentGroupCreateRequest);
        return ResponseEntity.created(URI.create("/component-group/" + createCarComponentGroupId)).build();
    }

    @PostMapping("/component-group/{id}")
    private ResponseEntity<Void> addCarComponent(
            @PathVariable("id") final long carComponentId,
            @RequestBody final CarComponentGroupAddCarComponentRequest carComponentGroupAddCarComponentRequest
    ) {
        long addCarComponentGroupId = carComponentGroupCommandService.add(
                carComponentId,
                carComponentGroupAddCarComponentRequest
        );
        return ResponseEntity.created(URI.create("/component-group/" + addCarComponentGroupId)).build();
    }
}
