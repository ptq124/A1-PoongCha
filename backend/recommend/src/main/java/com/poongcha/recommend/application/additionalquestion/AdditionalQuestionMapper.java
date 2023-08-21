package com.poongcha.recommend.application.additionalquestion;

import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOptionName;
import com.poongcha.recommend.domain.additionalquestion.Description;
import com.poongcha.recommend.domain.additionalquestion.Topic;
import java.util.List;
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
}
