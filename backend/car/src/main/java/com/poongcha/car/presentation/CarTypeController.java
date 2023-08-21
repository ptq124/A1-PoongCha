package com.poongcha.car.presentation;

import com.poongcha.car.application.cartype.CarTypeCommandService;
import com.poongcha.car.application.cartype.CarTypeQueryService;
import com.poongcha.car.application.dto.CarComponentGroupResponse;
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

    @PostMapping("/car-type")
    public ResponseEntity<Void> createCarType(@RequestBody final CarTypeCreateRequest carTypeCreateRequest) {
        long createCarTypeId = carTypeCommandService.create(carTypeCreateRequest);
        return ResponseEntity.created(URI.create("/car-type/" + createCarTypeId)).build();
    }

    @GetMapping("/car-type/{id}")
    public ResponseEntity<CarTypeDefaultResponse> findById(@PathVariable(value = "id") final long carTypeId) {
        return ResponseEntity.ok().body(carTypeQueryService.findById(carTypeId));
    }

    @GetMapping("/car-type")
    public ResponseEntity<List<CarTypeDefaultResponse>> findAll() {
        return ResponseEntity.ok().body(carTypeQueryService.findAll());
    }

    @PostMapping("/car-type/{id}/component-group")
    public ResponseEntity<Void> addCarComponentGroup(
            @PathVariable(name = "id") final long carTypeId,
            @RequestBody final CarTypeAddCarComponentGroupRequest carTypeAddCarComponentGroupRequest
    ) {
        long addCarComponentGroupCarTypeId = carTypeCommandService.add(carTypeId, carTypeAddCarComponentGroupRequest);
        return ResponseEntity
                .created(URI.create("/car-type/" + addCarComponentGroupCarTypeId + "/component-group"))
                .build();
    }

    @GetMapping("/car-type/{id}/component-group")
    public ResponseEntity<List<CarComponentGroupResponse>> addCarComponentGroup(
            @PathVariable(name = "id") final long carTypeId
    ) {
        return ResponseEntity.ok().body(carTypeQueryService.findCarComponentGroupBy(carTypeId));
    }
}
