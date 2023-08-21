package com.poongcha.recommend.application.additionalquestionanswer;

import com.poongcha.recommend.application.dto.AdditionalQuestionAnswerGroupResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionRepository;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroupRepository;
import com.poongcha.recommend.exception.NotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AdditionalQuestionAnswerGroupQueryService {
    private final AdditionalQuestionAnswerGroupRepository additionalQuestionAnswerGroupRepository;
    private final AdditionalQuestionRepository additionalQuestionRepository;
    private final AdditionalQuestionAnswerGroupMapper additionalQuestionAnswerGroupMapper;

    public AdditionalQuestionAnswerGroupResponse findById(final long id) {
        AdditionalQuestionAnswerGroup additionalQuestionAnswerGroup = additionalQuestionAnswerGroupRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("추가 질문 답변 그룹을 찾을 수 없습니다."));
        List<AdditionalQuestionOption> additionalQuestionOptions = additionalQuestionRepository
                .findAllByAdditionalQuestionsOptionIdIn(additionalQuestionAnswerGroup.additionalQuestionOptionIds());
        List<AdditionalQuestion> additionalQuestions = additionalQuestionRepository
                .findAllByAdditionalQuestionOptionIdIn(additionalQuestionAnswerGroup.additionalQuestionOptionIds());

        if (additionalQuestionOptions.size() != additionalQuestions.size()) {
            throw new RuntimeException("질문과 질문 선택의 길이가 일치하지 않습니다.");
        }

        return additionalQuestionAnswerGroupMapper.toAdditionalQuestionAnswerGroupResponse(
                additionalQuestionAnswerGroup,
                additionalQuestions,
                additionalQuestionAnswerGroup.additionalQuestionOptionIds()
        );
    }
}
