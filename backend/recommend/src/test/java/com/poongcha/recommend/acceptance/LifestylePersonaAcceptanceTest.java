package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.LifestylePersonaSteps.라이프스타일_퍼소나_생성_요청;
import static com.poongcha.recommend.acceptance.LifestylePersonaSteps.라이프스타일_퍼소나_생성_응답_검증;
import static com.poongcha.recommend.acceptance.LifestylePersonaSteps.라이프스타일_퍼소나_전체_조회_요청;
import static com.poongcha.recommend.acceptance.LifestylePersonaSteps.라이프스타일_퍼소나_전체_조회_응답_검증;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_생성_요청;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라이프스타일 퍼소나 관련 기능")
public class LifestylePersonaAcceptanceTest extends RecommendAcceptanceTest {
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
    }

    @DisplayName("라이프스타일 퍼소나 생성")
    @Test
    void 라이프스타일_퍼소나_생성() {
        // WHEN
        var response = 라이프스타일_퍼소나_생성_요청(
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

        // THEN
        라이프스타일_퍼소나_생성_응답_검증(response, "/lifestyle-persona/1");
    }


    @DisplayName("라이프스타일 퍼소나 전체 조회")
    @Test
    void 라이프스타일_퍼소나_전체_조회() {
        // GIVEN
        String representativePhrase1 = "가족과 함께 타서 안전을 중시해요.";
        String profileImageUrl1 = "www.naver.com/profile/image.png";
        String profileName1 = "김현대";
        String profileIntroduction1 = "우리 아이들과 함께 타는 차는 항상 안전해야 한다고 생각해요.";
        String coverImageUrl1 = "www.naver.com/cover/image.png";
        List<Integer> additionalQuestionOptionIds1 = List.of(1, 5, 19);
        List<Integer> lifestylePersonaSituationTagIds1 = List.of(1, 2);
        라이프스타일_퍼소나_생성_요청(
                representativePhrase1,
                profileImageUrl1,
                profileName1,
                profileIntroduction1,
                coverImageUrl1,
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
                additionalQuestionOptionIds1,
                lifestylePersonaSituationTagIds1
        );
        String representativePhrase2 = "매일 출퇴근하여 경제적이고 편안한 주행을 원해요.";
        String profileImageUrl2 = "www.naver.com/profile/image.png";
        String profileName2 = "김오토에버";
        String profileIntroduction2 = "매일 출퇴근하는 차량은 연비가 중요하다고 생각해요.";
        String coverImageUrl2 = "www.naver.com/cover/image.png";
        List<Integer> additionalQuestionOptionIds2 = List.of(3, 7, 17);
        List<Integer> lifestylePersonaSituationTagIds2 = List.of(2, 3);
        라이프스타일_퍼소나_생성_요청(
                representativePhrase2,
                profileImageUrl2,
                profileName2,
                profileIntroduction2,
                coverImageUrl2,
                List.of(
                        Map.of(
                                "question", "어떤 용도로 차를 사용하세요?",
                                "answer", "저는 차를 타고 출퇴근을 주로 합니다."
                        ),
                        Map.of(
                                "question", "차를 살 때 가장 중요하게 생각하는 부분이 뭔가요?",
                                "answer",
                                "저는 차를 살 때 경제적인 점을 가장 중요시 합니다. 펠리세이드는 연비가 좋은 편이라 경제적이라고 생각합니다."
                        )),
                additionalQuestionOptionIds2,
                lifestylePersonaSituationTagIds2
        );

        // WHEN
        var response = 라이프스타일_퍼소나_전체_조회_요청();

        // THEN
        라이프스타일_퍼소나_전체_조회_응답_검증(
                response,
                List.of(representativePhrase1, representativePhrase2),
                List.of(profileImageUrl1, profileImageUrl2),
                List.of(profileName1, profileName2),
                List.of(profileIntroduction1, profileIntroduction2),
                List.of(coverImageUrl1, coverImageUrl2),
                List.of(new String[]{"주행안전", "사용편의"}, new String[]{"사용편의", "추위/더위"})
        );
    }
}
