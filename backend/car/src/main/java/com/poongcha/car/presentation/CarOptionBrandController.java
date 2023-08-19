package com.poongcha.car.presentation;


import com.poongcha.car.application.caroptionbrand.CarOptionBrandCommandService;
import com.poongcha.car.application.caroptionbrand.CarOptionBrandQueryService;
import com.poongcha.car.application.dto.CarOptionBrandCreateRequest;
import com.poongcha.car.application.dto.CarOptionBrandResponse;
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
public class CarOptionBrandController {
    private final CarOptionBrandCommandService carOptionBrandCommandService;
    private final CarOptionBrandQueryService carOptionBrandQueryService;

    @PostMapping("/api/option-group/{id}/brand")
    public ResponseEntity<Void> create(
            @PathVariable(name = "id") final long id,
            @RequestBody final CarOptionBrandCreateRequest carOptionBrandCreateRequest
    ) {
        carOptionBrandCommandService.create(id, carOptionBrandCreateRequest);

        return ResponseEntity.created(URI.create("/api/option-group/" + id + "/brand")).build();
    }

    @GetMapping("/api/option-group/{id}/brand")
    public ResponseEntity<List<CarOptionBrandResponse>> findAllByOptionGroupId(
            @PathVariable(name = "id") final long id
    ) {
        return ResponseEntity.ok().body(carOptionBrandQueryService.findAllByOptionGroupId(id));
    }
}
