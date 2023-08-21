package com.poongcha.recommend.application.additionalquestion;

import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionOptionNameResponse;
import com.poongcha.recommend.application.dto.AdditionalQuestionResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOptionName;
import com.poongcha.recommend.domain.additionalquestion.Description;
import com.poongcha.recommend.domain.additionalquestion.Topic;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AdditionalQuestionMapper {
    public AdditionalQuestion toEntity(final AdditionalQuestionCreateRequest additionalQuestionCreateRequest) {
        return new AdditionalQuestion(
                new Topic(additionalQuestionCreateRequest.getTopic()),
                new Description(additionalQuestionCreateRequest.getDescription()),
                createAdditionalQuestionOptionName(additionalQuestionCreateRequest.getOptions())
        );
    }

    private List<AdditionalQuestionOptionName> createAdditionalQuestionOptionName(
            final List<String> additionalQuestionOptionNames
    ) {
        return additionalQuestionOptionNames.stream()
                .map(AdditionalQuestionOptionName::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public AdditionalQuestionResponse toAdditionalQuestionResponse(final AdditionalQuestion additionalQuestion) {
        return new AdditionalQuestionResponse(
                additionalQuestion.getId(),
                additionalQuestion.getTopic().getValue(),
                additionalQuestion.getDescription().getValue(),
                createAdditionalQuestionOptionNameResponse(additionalQuestion.getAdditionalQuestionOptions())
        );
    }

    private List<AdditionalQuestionOptionNameResponse> createAdditionalQuestionOptionNameResponse(
            final Set<AdditionalQuestionOption> additionalQuestionOptions
    ) {
        return additionalQuestionOptions.stream()
                .map(this::createAdditionalQuestionOptionNameResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    private AdditionalQuestionOptionNameResponse createAdditionalQuestionOptionNameResponse(
            final AdditionalQuestionOption additionalQuestionOption
    ) {
        return new AdditionalQuestionOptionNameResponse(
                additionalQuestionOption.getId(),
                additionalQuestionOption.getAdditionalQuestionOptionName().getValue()
        );
    }
}
