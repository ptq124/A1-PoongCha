package com.poongcha.recommend.application.additionalanswer;

import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupCreateRequest;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswer;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AdditionalQuestionAnswerGroupMapper {
    public AdditionalQuestionAnswerGroup toEntity(
            final AdditionalQuestionAnswerGroupCreateRequest additionalQuestionAnswerGroupCreateRequest
    ) {
        return new AdditionalQuestionAnswerGroup(
                additionalQuestionAnswerGroupCreateRequest.getAnswers().stream()
                        .map(this::createAdditionalQuestionAnswer)
                        .collect(Collectors.toSet())
        );
    }

    private AdditionalQuestionAnswer createAdditionalQuestionAnswer(
            final AdditionalQuestionAnswerCreateRequest additionalQuestionAnswerCreateRequest
    ) {
        return new AdditionalQuestionAnswer(additionalQuestionAnswerCreateRequest.getAnswerId());
    }
}
