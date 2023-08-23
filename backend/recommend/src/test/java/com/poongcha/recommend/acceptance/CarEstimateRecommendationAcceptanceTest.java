package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추가_질문_추천_견적_조회_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추가_질문_추천_견적_조회_응답_검증;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.퍼소나_추천_견적_조회_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.퍼소나_추천_견적_조회_응답_검증;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추천_견적_생성_요청;
import static com.poongcha.recommend.acceptance.CarEstimateRecommendationSteps.추천_견적_생성_응답_검증;
import static com.poongcha.recommend.acceptance.LifestylePersonaSteps.라이프스타일_퍼소나_생성_요청;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_생성_요청;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
import java.util.Map;
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

        라이프스타일_상황_태그_생성_요청("주행안전");
        라이프스타일_상황_태그_생성_요청("사용편의");
        라이프스타일_상황_태그_생성_요청("추위/더위");

        라이프스타일_퍼소나_생성_요청(
                "가족과 함께 타서 안전을 중시해요.",
                "www.naver.com/profile/image.png",
                "김현대",
                "우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요.",
                "www.naver.com/cover/image.png",
                List.of(
                        Map.of(
                                "question", "어떤 용도로 차를 사용하세요?",
                                "answer", "저는 차를 타고 출퇴근도 하지만 주중에 아이들 픽업하거나 마트 갈 때도 자주 타곤 합니다."
                        ),
                        Map.of(
                                "question", "차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?",
                                "answer",
                                "저는 차를 살 때 안전을 중요하게 생각해요. 가족들이 같이 타는 차라 항상 사고에 경각심을 갖고 있죠. 펠리세이드는 그 점에서 뒷좌석 에어백도 터지는 모델이라 안심이 되는 편이에요."
                        )),
                List.of(1, 5, 19),
                List.of(1, 2)
        );
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

    @DisplayName("추가 질문에 따른 추천 견적 조회")
    @Test
    void 추가_질문_추천_견적_조회() {
        // GIVEN
        String estimateId = "k12b1ae0-cad0-4326-b2123-75173e4dd95al";
        List<Integer> optionIds = List.of(5, 9, 14, 16);
        추천_견적_생성_요청(estimateId, optionIds);

        // WHEN
        var response = 추가_질문_추천_견적_조회_요청(1, 1, optionIds);

        // THEN
        추가_질문_추천_견적_조회_응답_검증(
                response,
                "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png",
                1,
                "palisade",
                1,
                "Le Blanc",
                48_000_000,
                List.of(1),
                List.of("4WD"),
                List.of(2_000_000),
                1,
                "green",
                "www.naver.com/color/green.png",
                2,
                "red",
                "www.naver.com/color/red.png",
                List.of(1),
                List.of("컴포트 2"),
                List.of("www.naver.com/option/image.png"),
                List.of(1_000_000),
                List.of("옵션 그룹 요약 문구")
        );
    }

    @DisplayName("퍼소나에 따른 추천 견적 조회")
    @Test
    void 퍼소나_추천_견적_조회() {
        // GIVEN
        String estimateId = "k12b1ae0-cad0-4326-b2123-75173e4dd95al";
        List<Integer> optionIds = List.of(5, 9, 14, 16);
        추천_견적_생성_요청(estimateId, optionIds);

        // WHEN
        var response = 퍼소나_추천_견적_조회_요청(1, 1, optionIds);

        // THEN
        퍼소나_추천_견적_조회_응답_검증(
                response,
                "우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요.",
                "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png",
                1,
                "palisade",
                1,
                "Le Blanc",
                48_000_000,
                List.of(1),
                List.of("4WD"),
                List.of(2_000_000),
                1,
                "green",
                "www.naver.com/color/green.png",
                2,
                "red",
                "www.naver.com/color/red.png",
                List.of(1),
                List.of("컴포트 2"),
                List.of("www.naver.com/option/image.png"),
                List.of(1_000_000),
                List.of("옵션 그룹 요약 문구")
        );
    }
}
