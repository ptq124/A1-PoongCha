package com.poongcha.recommend.application.additionalquestionanswer;

import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupResponse;
import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswer;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
import com.poongcha.recommend.exception.BadRequestException;
import java.util.List;
import java.util.Optional;
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

    public AdditionalQuestionAnswerGroupResponse toAdditionalQuestionAnswerGroupResponse(
            final AdditionalQuestionAnswerGroup additionalQuestionAnswerGroup,
            final List<AdditionalQuestion> additionalQuestions,
            final List<Long> additionalQuestionOptionIds
    ) {
        return new AdditionalQuestionAnswerGroupResponse(
                additionalQuestionAnswerGroup.getId(),
                additionalQuestions.stream()
                        .map(additionalQuestion -> {
                            AdditionalQuestionOption additionalQuestionOption = additionalQuestionOptionIds.stream()
                                    .map(additionalQuestion::findAdditionalQuestionOptionById)
                                    .filter(Optional::isPresent)
                                    .map(Optional::get)
                                    .findFirst()
                                    .orElseThrow(() -> new BadRequestException("잘못된 요청입니다."));

                            return new AdditionalQuestionAnswerResponse(
                                    additionalQuestion.getId(),
                                    additionalQuestionOption.getId()
                            );
                        }).collect(Collectors.toUnmodifiableList())
        );
    }
}
