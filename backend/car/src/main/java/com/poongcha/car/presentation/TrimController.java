package com.poongcha.car.presentation;

import com.poongcha.car.application.TrimCommandService;
import com.poongcha.car.application.dto.TrimCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TrimController {
    private final TrimCommandService trimCommandService;

    @PostMapping("/api/trim")
    public ResponseEntity createTrim(@RequestBody TrimCreateRequest trimCreateRequest) {
        long createTrimId = trimCommandService.create(trimCreateRequest);
        return ResponseEntity.created(URI.create("/api/trim/" + createTrimId)).build();
    }
}
