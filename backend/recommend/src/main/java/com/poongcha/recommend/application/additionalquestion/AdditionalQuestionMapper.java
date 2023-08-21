package com.poongcha.recommend.application.additionalquestion;

import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import com.poongcha.recommend.application.dto.AdditionalQuestionOptionNameResponse;
import com.poongcha.recommend.application.dto.AdditionalQuestionResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOptionName;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionSequence;
import com.poongcha.recommend.domain.additionalquestion.Description;
import com.poongcha.recommend.domain.additionalquestion.Topic;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class AdditionalQuestionMapper {
    public AdditionalQuestion toEntity(final AdditionalQuestionCreateRequest additionalQuestionCreateRequest) {
        return new AdditionalQuestion(
                new Topic(additionalQuestionCreateRequest.getTopic()),
                new Description(additionalQuestionCreateRequest.getDescription()),
                createAdditionalQuestionOption(additionalQuestionCreateRequest.getOptions())
        );
    }

    private List<AdditionalQuestionOption> createAdditionalQuestionOption(
            final List<String> additionalQuestionOptionNames
    ) {
        return IntStream.range(0, additionalQuestionOptionNames.size())
                .mapToObj(i -> new AdditionalQuestionOption(
                        new AdditionalQuestionSequence(i + 1),
                        new AdditionalQuestionOptionName(additionalQuestionOptionNames.get(i))
                )).collect(Collectors.toUnmodifiableList());
    }

    public AdditionalQuestionResponse toAdditionalQuestionResponse(final AdditionalQuestion additionalQuestion) {
        return new AdditionalQuestionResponse(
                additionalQuestion.getId(),
                additionalQuestion.getTopic().getValue(),
                additionalQuestion.getDescription().getValue(),
                createAdditionalQuestionOptionResponse(additionalQuestion.getAdditionalQuestionOptions())
        );
    }

    private List<AdditionalQuestionOptionNameResponse> createAdditionalQuestionOptionResponse(
            final Set<AdditionalQuestionOption> additionalQuestionOptions
    ) {
        return additionalQuestionOptions.stream()
                .map(this::createAdditionalQuestionOptionResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    private AdditionalQuestionOptionNameResponse createAdditionalQuestionOptionResponse(
            final AdditionalQuestionOption additionalQuestionOption
    ) {
        return new AdditionalQuestionOptionNameResponse(
                additionalQuestionOption.getId(),
                additionalQuestionOption.getAdditionalQuestionSequence().getValue(),
                additionalQuestionOption.getAdditionalQuestionOptionName().getValue()
        );
    }
}
