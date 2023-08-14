package com.poongcha.car.presentation;

import com.poongcha.car.application.TrimCommandService;
import com.poongcha.car.application.TrimQueryService;
import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.dto.TrimDefaultResponse;
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

    @PostMapping("/api/trim")
    public ResponseEntity createTrim(@RequestBody final TrimCreateRequest trimCreateRequest) {
        long createTrimId = trimCommandService.create(trimCreateRequest);
        return ResponseEntity.created(URI.create("/api/trim/" + createTrimId)).build();
    }

    @GetMapping("/api/trim/{id}")
    public ResponseEntity findTrimById(@PathVariable(value = "id") final long id) {
        TrimDefaultResponse trimDefaultResponse = trimQueryService.findById(id);
        return ResponseEntity.ok().body(trimDefaultResponse);
    }

    @GetMapping("/api/car-type/{car-type-id}/trim")
    public ResponseEntity<List> findAllTrimByCarTypeId(@PathVariable(value = "car-type-id") final long carTypeId) {
        List<TrimDefaultResponse> trimDefaultResponses = trimQueryService.findAllByCarTypeId(carTypeId);
        return ResponseEntity.ok().body(trimDefaultResponses);
    }
}
