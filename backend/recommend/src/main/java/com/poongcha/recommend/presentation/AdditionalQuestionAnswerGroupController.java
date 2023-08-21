package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.additionalquestionanswer.AdditionalQuestionAnswerGroupCommandService;
import com.poongcha.recommend.application.additionalquestionanswer.AdditionalQuestionAnswerGroupQueryService;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdditionalQuestionAnswerGroupController {
    private final AdditionalQuestionAnswerGroupCommandService additionalQuestionAnswerGroupCommandService;
    private final AdditionalQuestionAnswerGroupQueryService additionalQuestionAnswerGroupQueryService;

    @PostMapping("/answer")
    public ResponseEntity<Void> create(
            @RequestBody final AdditionalQuestionAnswerGroupCreateRequest additionalQuestionAnswerGroupCreateRequest
    ) {
        long createAdditionalQuestionAnswerGroupId = additionalQuestionAnswerGroupCommandService.create(
                additionalQuestionAnswerGroupCreateRequest
        );

        return ResponseEntity.created(URI.create("/answer/" + createAdditionalQuestionAnswerGroupId)).build();
    }

    @GetMapping("/answer/{id}")
    public ResponseEntity<AdditionalQuestionAnswerGroupResponse> findById(@PathVariable("id") final long id) {
        return ResponseEntity.ok().body(additionalQuestionAnswerGroupQueryService.findById(id));
    }
}
