package com.poongcha.recommend.application.additionalquestion;

import com.poongcha.recommend.application.dto.AdditionalQuestionCreateRequest;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AdditionalQuestionCommandService {
    private final AdditionalQuestionRepository additionalQuestionRepository;
    private final AdditionalQuestionMapper additionalQuestionMapper;

    public long create(final AdditionalQuestionCreateRequest additionalQuestionCreateRequest) {
        AdditionalQuestion additionalQuestion = additionalQuestionMapper.toEntity(additionalQuestionCreateRequest);

        return additionalQuestionRepository.save(additionalQuestion).getId();
    }
}
