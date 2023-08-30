package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_ID_목록_조회_요청;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_ID_목록_조회_응답_검증;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_ID_조회_요청;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_ID_조회_응답_검증;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("추가 질문 관련 기능")
public class AdditionalQuestionAcceptanceTest extends RecommendAcceptanceTest {
    @DisplayName("추가 질문 생성")
    @Test
    void 추가_질문_생성() {
        // WHEN
        var response = 추가_질문_생성_요청(
                "운전 경력",
                "운전 경력이 어떻게 되시나요?",
                List.of("1년 이하", "3년 이하", "5년 이상")
        );

        // THEN
        추가_질문_생성_응답_검증(response, "/question/1");
    }

    @DisplayName("추가 질문 ID 조회")
    @Test
    void 추가_질문_ID_조회() {
        // GIVEN
        String topic = "운전 경력";
        String description = "운전 경력이 어떻게 되시나요?";
        List<String> options = List.of("1년 이하", "3년 이하", "5년 이상");
        추가_질문_생성_요청(topic, description, options);

        // WHEN
        var response = 추가_질문_ID_조회_요청(1L);

        // THEN
        추가_질문_ID_조회_응답_검증(response, 1, topic, description, new Integer[]{1, 2, 3}, options.toArray(new String[3]));
    }

    @DisplayName("추가 질문 ID 목록 조회")
    @Test
    void 추가_질문_ID_목록_조회() {
        // GIVEN
        String topic1 = "운전 경력";
        String description1 = "운전 경력이 어떻게 되시나요?";
        List<String> options1 = List.of("1년 이하", "3년 이하", "5년 이상");
        추가_질문_생성_요청(topic1, description1, options1);
        String topic2 = "가족 구성원";
        String description2 = "가족 구성원이 어떻게 되시나요?";
        List<String> options2 = List.of("1인", "2인", "3 ~ 4인", "5인 이상");
        추가_질문_생성_요청(topic2, description2, options2);
        String topic3 = "나이";
        String description3 = "나이가 어떻게 되시나요?";
        List<String> options3 = List.of("20대", "30대", "40대", "50대 이상");
        추가_질문_생성_요청(topic3, description3, options3);

        // WHEN
        var response = 추가_질문_ID_목록_조회_요청(List.of(2L, 3L));

        // THEN
        추가_질문_ID_목록_조회_응답_검증(
                response,
                List.of(2, 3),
                List.of(topic2, topic3),
                List.of(description2, description3),
                List.of(new Integer[]{4, 5, 6, 7}, new Integer[]{8, 9, 10, 11}),
                List.of(options2.toArray(new String[4]), options3.toArray(new String[4]))
        );
    }
}
