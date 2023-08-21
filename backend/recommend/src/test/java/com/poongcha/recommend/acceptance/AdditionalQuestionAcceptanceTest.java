package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_요청;
import static com.poongcha.recommend.acceptance.AdditionalQuestionSteps.추가_질문_생성_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("추가 질문 관련 기능")
public class AdditionalQuestionAcceptanceTest extends RecommendAcceptanceTest {
    @DisplayName("추가 질문 생성")
    @Test
    void 추가_질문_생성() {
        var response = 추가_질문_생성_요청(
                "운전 경력",
                "운전 경력이 어떻게 되시나요?",
                new String[]{"1년 이하", "3년 이하", "5년 이상"}
        );

        추가_질문_생성_응답_검증(response, "/question/1");
    }
}
