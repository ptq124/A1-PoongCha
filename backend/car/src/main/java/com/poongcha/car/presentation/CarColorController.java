package com.poongcha.car.presentation;

import com.poongcha.car.application.carcolor.CarColorCommandService;
import com.poongcha.car.application.dto.CarColorAddIncompatibleColorRequest;
import com.poongcha.car.application.dto.CarColorCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarColorController {
    private final CarColorCommandService carColorCommandService;

    @PostMapping("/color")
    private ResponseEntity<Void> createCarColor(@RequestBody final CarColorCreateRequest carColorCreateRequest) {
        long createCarColorId = carColorCommandService.create(carColorCreateRequest);
        return ResponseEntity.created(URI.create("/color/" + createCarColorId)).build();
    }

    @PostMapping("/color/{id}/incompatible")
    private ResponseEntity<Void> addIncompatibleColor(
            @PathVariable(value = "id") final long carColorId,
            @RequestBody final CarColorAddIncompatibleColorRequest carColorAddIncompatibleColorRequest
    ) {
        long setIncompatibleCarColorId = carColorCommandService.add(carColorId, carColorAddIncompatibleColorRequest);
        return ResponseEntity.created(URI.create("/color/" + setIncompatibleCarColorId)).build();
    }
}
