package com.poongcha.recommend.acceptance;

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
}
