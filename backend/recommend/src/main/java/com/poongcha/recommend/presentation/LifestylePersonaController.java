package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.dto.LifestylePersonaCreateRequest;
import com.poongcha.recommend.application.dto.LifestylePersonaResponse;
import com.poongcha.recommend.application.lifestylepersona.LifestylePersonaCommandService;
import com.poongcha.recommend.application.lifestylepersona.LifestylePersonaQueryService;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LifestylePersonaController {
    private final LifestylePersonaCommandService lifestylePersonaCommandService;
    private final LifestylePersonaQueryService lifestylePersonaQueryservice;

    @PostMapping("/lifestyle-persona")
    public ResponseEntity<Void> create(@RequestBody LifestylePersonaCreateRequest lifestylePersonaCreateRequest) {
        long createLifestylePersonaId = lifestylePersonaCommandService.create(lifestylePersonaCreateRequest);

        return ResponseEntity.created(URI.create("/lifestyle-persona/" + createLifestylePersonaId)).build();
    }

    @GetMapping("/lifestyle-persona")
    public ResponseEntity<List<LifestylePersonaResponse>> findAll() {
        return ResponseEntity.ok().body(lifestylePersonaQueryservice.findAll());
    }
}
