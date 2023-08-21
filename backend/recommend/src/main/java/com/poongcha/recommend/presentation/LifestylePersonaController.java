package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.dto.LifestylePersonaCreateRequest;
import com.poongcha.recommend.application.lifestylePersona.LifestylePersonaCommandService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LifestylePersonaController {
    private final LifestylePersonaCommandService lifestylePersonaCommandService;

    @PostMapping("/lifestyle-persona")
    public ResponseEntity<Void> create(@RequestBody LifestylePersonaCreateRequest lifestylePersonaCreateRequest) {
        long createLifestylePersonaId = lifestylePersonaCommandService.create(lifestylePersonaCreateRequest);

        return ResponseEntity.created(URI.create("/lifestyle-persona/" + createLifestylePersonaId)).build();
    }
}
