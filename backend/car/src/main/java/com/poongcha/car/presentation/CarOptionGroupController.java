package com.poongcha.car.presentation;

import com.poongcha.car.application.caroptiongroup.CarOptionGroupCommandService;
import com.poongcha.car.application.caroptiongroup.dto.CarOptionGroupCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionGroupController {
    private final CarOptionGroupCommandService carOptionGroupCommandService;

    @PostMapping("/api/option-group")
    public ResponseEntity<Void> createCarOptionGroup(
            @RequestBody final CarOptionGroupCreateRequest carOptionGroupCreateRequest
    ) {
        long createCarOptionGroupId = carOptionGroupCommandService.create(carOptionGroupCreateRequest);

        return ResponseEntity.created(URI.create("/api/option-group/" + createCarOptionGroupId)).build();
    }
}
