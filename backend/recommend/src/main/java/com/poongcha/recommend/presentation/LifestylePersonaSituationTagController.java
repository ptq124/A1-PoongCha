package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagCreateRequest;
import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagResponse;
import com.poongcha.recommend.application.lifestylePersonasituationtag.LifestylePersonaSituationTagCommandService;
import com.poongcha.recommend.application.lifestylePersonasituationtag.LifestylePersonaSituationTagQueryService;
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
public class LifestylePersonaSituationTagController {
    private final LifestylePersonaSituationTagCommandService lifestylePersonaSituationTagCommandService;
    private final LifestylePersonaSituationTagQueryService lifestylePersonaSituationTagQueryService;

    @PostMapping("/lifestyle-persona-situation-tag")
    public ResponseEntity<Void> create(
            @RequestBody LifestylePersonaSituationTagCreateRequest lifestylePersonaSituationTagCreateRequest
    ) {
        lifestylePersonaSituationTagCommandService.create(lifestylePersonaSituationTagCreateRequest);

        return ResponseEntity.created(URI.create("/lifestyle-persona-situation-tag")).build();
    }

    @GetMapping("/lifestyle-persona-situation-tag")
    public ResponseEntity<List<LifestylePersonaSituationTagResponse>> findAll() {
        return ResponseEntity.ok().body(lifestylePersonaSituationTagQueryService.findAll());
    }
}
