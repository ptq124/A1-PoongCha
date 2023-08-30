package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionAnswerSteps.추가_질문_답변_생성_요청;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_ID_조회_요청;
import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_생성_요청;
import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_생성_응답_검증;
import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_조회_검증;

import com.poongcha.recommend.domain.recommendationfeedback.FeedbackScore;
import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecommendationFeedbackAcceptanceTest extends RecommendAcceptanceTest {
    private final int ageAdditionalQuestionId = 1;
    private final int drivingCareerAdditionalQuestionId = 2;
    private final int valueAdditionalQuestionId = 5;

    private static final FeedbackScore 좋음 = FeedbackScore.GOOD;
    private static final Long 견적ID = 1L;
    private static final Long 추가_질문_답변ID = 1L;

    @BeforeEach
    void setUp() {
        추가_질문_생성_요청("나이", "나이를 알려주세요.", List.of("20대", "30대", "40대", "50대 이상"));
        추가_질문_생성_요청("운전경력", "운전 경력이 어떻게 되시나요?", List.of("1년 이하", "3년 이하", "5년 이상"));
        추가_질문_생성_요청("가족 구성원", "가족 구성원이 어떻게 되시나요?", List.of("1인", "2인", "3~4인", "5인 이상"));
        추가_질문_생성_요청("목적", "어떤 목적으로 주로 차를 타시나요?", List.of("출퇴근용", "레저용", "가정용", "업무용"));
        추가_질문_생성_요청("가치", "자동차를 살때 어떤 가치가 가장 중요한가요?", List.of("디자인", "성능", "안전", "편의성"));
    }

    @DisplayName("추천 피드백 생성")
    @Test
    void 추천_피드백_생성() {
        // GIVEN
        추가_질문_답변_생성_요청(
                List.of(ageAdditionalQuestionId, drivingCareerAdditionalQuestionId, valueAdditionalQuestionId),
                List.of(1, 5, 19)
        );

        // WHEN
        var response = 추천_피드백_생성_요청(좋음, 견적ID, 추가_질문_답변ID);

        // THEN
        추천_피드백_생성_응답_검증(response, "/feedback/1");
    }

    @DisplayName("추천 피드백 조회")
    @Test
    void 추천_피드백_조회() {
        // GIVEN
        추가_질문_답변_생성_요청(
                List.of(ageAdditionalQuestionId, drivingCareerAdditionalQuestionId, valueAdditionalQuestionId),
                List.of(1, 5, 19)
        );
        추천_피드백_생성_요청(좋음, 견적ID, 추가_질문_답변ID);

        // WHEN
        var response = 추천_피드백_ID_조회_요청(1L);

        // THEN
        추천_피드백_조회_검증(response, 좋음, 견적ID, 추가_질문_답변ID);
    }
}
