package com.poongcha.recommend.application.carestimaterecommandation;

import com.poongcha.recommend.application.dto.CarRecommendEstimateRequest;
import com.poongcha.recommend.application.dto.CarRecommendPersonaEstimateResponse;
import com.poongcha.recommend.application.dto.CarRecommendQuestionEstimateResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionRepository;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateRecommendation;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateRecommendationRepository;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaRepository;
import com.poongcha.recommend.exception.BadRequestException;
import com.poongcha.recommend.infra.client.CarContextClient;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarEstimateRecommendationQueryService {
    private final CarEstimateRecommendationRepository carEstimateRecommendationRepository;
    private final LifestylePersonaRepository lifestylePersonaRepository;
    private final AdditionalQuestionRepository additionalQuestionRepository;
    private final CarEstimateRecommendationMapper carEstimateRecommendationMapper;
    private final CarContextClient carContextClient;

    public CarRecommendQuestionEstimateResponse findQuestionRecommendation(
            final CarRecommendEstimateRequest carRecommendEstimateRequest
    ) {
        List<Long> answerIds = carRecommendEstimateRequest.getAnswers();
        answerIds.add(carRecommendEstimateRequest.getAge());
        CarEstimateRecommendation carEstimateRecommendation = carEstimateRecommendationRepository
                .findByCarEstimateRecommendationQuestionOptionIds(answerIds)
                .orElseThrow(() -> new BadRequestException("추천 견적이 존재하지 않습니다."));

        ResponseEntity<String> carEstimateResponse = carContextClient
                .findEstimate(carEstimateRecommendation.getCarEstimateCode());

        List<AdditionalQuestionOption> additionalQuestionOptions = additionalQuestionRepository
                .findAdditionalQuestionOptionsByAdditionalQuestionsOptionIdIn(
                        carEstimateRecommendation.carEstimateRecommendationQuestionOptionIds()
                );

        return carEstimateRecommendationMapper.toCarRecommendQuestionEstimateResponse(
                carEstimateResponse,
                additionalQuestionOptions
        );
    }

    public CarRecommendPersonaEstimateResponse findPersonaRecommendation(
            final CarRecommendEstimateRequest carRecommendEstimateRequest
    ) {
        LifestylePersona lifestylePersona = lifestylePersonaRepository
                .findById(carRecommendEstimateRequest.getPersona());
        List<Long> answerIds = new ArrayList<>();
        answerIds.addAll(lifestylePersona.lifestylePersonaAdditionalQuestionOptionIds());
        answerIds.add(carRecommendEstimateRequest.getAge());

        CarEstimateRecommendation carEstimateRecommendation = carEstimateRecommendationRepository
                .findByCarEstimateRecommendationQuestionOptionIds(answerIds)
                .orElseThrow(() -> new BadRequestException("추천 견적이 존재하지 않습니다."));

        ResponseEntity<String> carEstimateResponse = carContextClient
                .findEstimate(carEstimateRecommendation.getCarEstimateCode());

        return carEstimateRecommendationMapper.toCarRecommendPersonaEstimateResponse(
                lifestylePersona,
                carEstimateResponse
        );
    }
}
