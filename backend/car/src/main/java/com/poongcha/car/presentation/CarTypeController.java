package com.poongcha.car.presentation;

import com.poongcha.car.application.cartype.CarTypeCommandService;
import com.poongcha.car.application.cartype.CarTypeQueryService;
import com.poongcha.car.application.dto.CarTypeAddCarComponentGroupRequest;
import com.poongcha.car.application.dto.CarTypeCreateRequest;
import com.poongcha.car.application.dto.CarTypeDefaultResponse;
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
public class CarTypeController {
    private final CarTypeCommandService carTypeCommandService;
    private final CarTypeQueryService carTypeQueryService;

    @PostMapping("/api/car-type")
    public ResponseEntity createCarType(@RequestBody final CarTypeCreateRequest carTypeCreateRequest) {
        long createCarTypeId = carTypeCommandService.create(carTypeCreateRequest);
        return ResponseEntity.created(URI.create("/api/car-type/" + createCarTypeId)).build();
    }

    @GetMapping("/api/car-type/{id}")
    public ResponseEntity<CarTypeDefaultResponse> findById(@PathVariable(value = "id") final long id) {
        CarTypeDefaultResponse carTypeDefaultResponse = carTypeQueryService.findById(id);
        return ResponseEntity.ok().body(carTypeDefaultResponse);
    }

    @GetMapping("/api/car-type")
    public ResponseEntity<List<CarTypeDefaultResponse>> findAll() {
        List<CarTypeDefaultResponse> carTypeDefaultResponses = carTypeQueryService.findAll();
        return ResponseEntity.ok().body(carTypeDefaultResponses);
    }

    @PostMapping("/api/car-type/{id}/component-group")
    public ResponseEntity addCarComponentGroup(
            @PathVariable(name = "id") long id,
            @RequestBody CarTypeAddCarComponentGroupRequest carTypeAddCarComponentGroupRequest
    ) {
        long addCarComponentGroupCarTypeId = carTypeCommandService.add(id, carTypeAddCarComponentGroupRequest);
        return ResponseEntity.created(
                URI.create("/api/car-type/" + addCarComponentGroupCarTypeId + "/component-group")
        ).build();
    }

    @GetMapping("/api/car-type/{id}/component-group")
    public ResponseEntity addCarComponentGroup(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(carTypeQueryService.findCarComponentGroupBy(id));
    }
}
