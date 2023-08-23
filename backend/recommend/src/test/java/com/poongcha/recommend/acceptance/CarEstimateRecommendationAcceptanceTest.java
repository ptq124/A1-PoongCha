package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추천_견적_생성_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추천_견적_생성_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("추천 견적 관련 기능")
public class CarEstimateRecommendationAcceptanceTest extends RecommendAcceptanceTest {
    @BeforeEach
    void setUp() {
        추가_질문_생성_요청("나이", "나이를 알려주세요.", List.of("20대", "30대", "40대", "50대 이상"));
        추가_질문_생성_요청("운전경력", "운전 경력이 어떻게 되시나요?", List.of("1년 이하", "3년 이하", "5년 이상"));
        추가_질문_생성_요청("가족 구성원", "가족 구성원이 어떻게 되시나요?", List.of("1인", "2인", "3~4인", "5인 이상"));
        추가_질문_생성_요청("목적", "어떤 목적으로 주로 차를 타시나요?", List.of("출퇴근용", "레저용", "가정용", "업무용"));
        추가_질문_생성_요청("가치", "자동차를 살때 어떤 가치가 가장 중요한가요?", List.of("디자인", "성능", "안전", "편의성"));

    }

    @DisplayName("추천 견적 생성")
    @Test
    void 추천_견적_생성() {
        // GIVEN
        String estimateId = "k12b1ae0-cad0-4326-b2123-75173e4dd95al";

        // WHEN
        var response = 추천_견적_생성_요청(estimateId, List.of(2, 5, 9, 14, 16));

        // THEN
        추천_견적_생성_응답_검증(response, "/recommend/1");
    }
}
