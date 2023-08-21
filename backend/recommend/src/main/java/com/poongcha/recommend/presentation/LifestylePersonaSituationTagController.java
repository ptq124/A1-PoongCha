package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagCreateRequest;
import com.poongcha.recommend.application.lifestylePersonasituationTag.LifestylePersonaSituationTagCommandService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LifestylePersonaSituationTagController {
    private final LifestylePersonaSituationTagCommandService lifestylePersonaSituationTagCommandService;

    @PostMapping("/lifestyle-persona-situation-tag")
    public ResponseEntity<Void> create(@RequestBody LifestylePersonaSituationTagCreateRequest lifestylePersonaSituationTagCreateRequest) {
        lifestylePersonaSituationTagCommandService.create(lifestylePersonaSituationTagCreateRequest);

        return ResponseEntity.created(URI.create("/lifestyle-persona-situation-tag")).build();
    }
}
