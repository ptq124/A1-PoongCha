package com.poongcha.car.presentation;

import com.poongcha.car.application.dto.TrimAddCarColorRequest;
import com.poongcha.car.application.dto.TrimCarColorResponse;
import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.dto.TrimDefaultResponse;
import com.poongcha.car.application.dto.TrimRepresentativeRequest;
import com.poongcha.car.application.trim.TrimCommandService;
import com.poongcha.car.application.trim.TrimQueryService;
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
public class TrimController {
    private final TrimCommandService trimCommandService;
    private final TrimQueryService trimQueryService;

    @PostMapping("/trim")
    public ResponseEntity<Void> createTrim(@RequestBody final TrimCreateRequest trimCreateRequest) {
        long createTrimId = trimCommandService.create(trimCreateRequest);
        return ResponseEntity.created(URI.create("/trim/" + createTrimId)).build();
    }

    @GetMapping("/trim/{id}")
    public ResponseEntity<TrimDefaultResponse> findTrimById(@PathVariable(value = "id") final long id) {
        return ResponseEntity.ok().body(trimQueryService.findById(id));
    }

    @GetMapping("/car-type/{car-type-id}/trim")
    public ResponseEntity<List<TrimDefaultResponse>> findAllTrimByCarTypeId(
            @PathVariable(value = "car-type-id") final long carTypeId
    ) {
        return ResponseEntity.ok().body(trimQueryService.findAllByCarTypeId(carTypeId));
    }

    @PostMapping("/trim/{id}/color")
    public ResponseEntity<Void> addTrimColor(
            @PathVariable(value = "id") final long trimId,
            @RequestBody final TrimAddCarColorRequest trimAddCarColorRequest
    ) {
        long addColorTrimId = trimCommandService.add(trimId, trimAddCarColorRequest);
        return ResponseEntity.created(URI.create("/trim/" + addColorTrimId + "/color")).build();
    }

    @GetMapping("/car-type/{id}/color")
    public ResponseEntity<List<TrimCarColorResponse>> findCarTypeColors(
            @PathVariable(value = "id") final long carTypeId
    ) {
        return ResponseEntity.ok().body(trimQueryService.findCarTypeColors(carTypeId));
    }

    @PostMapping("/trim/{id}/representative")
    public ResponseEntity<Void> representative(
            @PathVariable(value = "id") final long trimId,
            @RequestBody final TrimRepresentativeRequest trimRepresentativeRequest
    ) {
        return ResponseEntity.created(
                URI.create("/trim/" + trimCommandService.setRepresentative(trimId, trimRepresentativeRequest))
        ).build();
    }
}
