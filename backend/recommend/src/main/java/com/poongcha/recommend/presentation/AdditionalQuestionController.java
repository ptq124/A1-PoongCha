package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.additionalquestion.AdditionalQuestionCommandService;
import com.poongcha.recommend.application.additionalquestion.AdditionalQuestionQueryService;
import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionResponse;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdditionalQuestionController {
    private final AdditionalQuestionCommandService additionalQuestionCommandService;
    private final AdditionalQuestionQueryService additionalQuestionQueryService;

    @PostMapping("/question")
    public ResponseEntity<Void> create(
            @RequestBody final AdditionalQuestionCreateRequest additionalQuestionCreateRequest
    ) {
        long createAdditionalQuestionId = additionalQuestionCommandService.create(additionalQuestionCreateRequest);

        return ResponseEntity.created(URI.create("/question/" + createAdditionalQuestionId)).build();
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<AdditionalQuestionResponse> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(additionalQuestionQueryService.findById(id));
    }

    @GetMapping("/question")
    public ResponseEntity<List<AdditionalQuestionResponse>> findById(@RequestParam("id") final List<Long> ids) {
        return ResponseEntity.ok().body(additionalQuestionQueryService.findAllBy(ids));
    }
}
