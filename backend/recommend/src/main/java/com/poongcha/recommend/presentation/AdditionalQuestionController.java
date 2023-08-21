package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.additionalquestion.AdditionalQuestionCommandService;
import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdditionalQuestionController {
    private final AdditionalQuestionCommandService additionalQuestionCommandService;

    @PostMapping("/question")
    public ResponseEntity<Void> create(
            @RequestBody final AdditionalQuestionCreateRequest additionalQuestionCreateRequest
    ) {
        long createAdditionalQuestionId = additionalQuestionCommandService.create(additionalQuestionCreateRequest);

        return ResponseEntity.created(URI.create("/question/" + createAdditionalQuestionId)).build();
    }
}
