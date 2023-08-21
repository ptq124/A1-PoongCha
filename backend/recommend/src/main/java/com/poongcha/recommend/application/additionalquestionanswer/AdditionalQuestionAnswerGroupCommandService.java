package com.poongcha.recommend.application.additionalquestionanswer;

import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupCreateRequest;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AdditionalQuestionAnswerGroupCommandService {
    private final AdditionalQuestionAnswerGroupRepository additionalQuestionAnswerGroupRepository;
    private final AdditionalQuestionAnswerGroupMapper additionalQuestionAnswerGroupMapper;

    public long create(final AdditionalQuestionAnswerGroupCreateRequest additionalQuestionAnswerGroupCreateRequest) {
        AdditionalQuestionAnswerGroup additionalQuestionAnswerGroup = additionalQuestionAnswerGroupMapper.toEntity(
                additionalQuestionAnswerGroupCreateRequest
        );

        return additionalQuestionAnswerGroupRepository.save(additionalQuestionAnswerGroup).getId();
    }
}
