package com.poongcha.recommend.presentation;

import com.poongcha.recommend.application.additionalanswer.AdditionalQuestionAnswerGroupCommandService;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdditionalQuestionAnswerGroupController {
    private final AdditionalQuestionAnswerGroupCommandService additionalQuestionAnswerGroupCommandService;

    @PostMapping("/answer")
    public ResponseEntity<Void> create(
            @RequestBody final AdditionalQuestionAnswerGroupCreateRequest additionalQuestionAnswerGroupCreateRequest
    ) {
        long createAdditionalQuestionAnswerGroupId = additionalQuestionAnswerGroupCommandService.create(
                additionalQuestionAnswerGroupCreateRequest
        );

        return ResponseEntity.created(URI.create("/answer/" + createAdditionalQuestionAnswerGroupId)).build();
    }
}
