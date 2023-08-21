package com.poongcha.recommend.application.additionalquestion;

import com.poongcha.recommend.application.dto.AdditionalQuestionResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestion;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionRepository;
import com.poongcha.recommend.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AdditionalQuestionQueryService {
    private final AdditionalQuestionRepository additionalQuestionRepository;
    public final AdditionalQuestionMapper additionalQuestionMapper;

    public AdditionalQuestionResponse findById(final long id) {
        AdditionalQuestion additionalQuestion = additionalQuestionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("추가 질문을 찾을 수 없습니다."));

        return additionalQuestionMapper.toAdditionalQuestionResponse(additionalQuestion);
    }

    public List<AdditionalQuestionResponse> findAllBy(final List<Long> ids) {
        List<AdditionalQuestion> additionalQuestions = additionalQuestionRepository.findAllByIdIn(ids);

        return additionalQuestions.stream()
                .map(additionalQuestionMapper::toAdditionalQuestionResponse)
                .collect(Collectors.toUnmodifiableList());
    }
}
