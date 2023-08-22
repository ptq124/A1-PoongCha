package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_생성_요청;
import static com.poongcha.recommend.acceptance.RecommendationFeedbackSteps.추천_피드백_생성_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecommendationFeedbackAcceptanceTest extends RecommendAcceptanceTest {

    private static final FeedbackScore 좋음 = FeedbackScore.GOOD;
    private static final Long 견적ID = 1L;

    @DisplayName("추천 피드백 생성")
    @Test
    void 추천_피드백_생성() {
        // WHEN
        var response = 추천_피드백_생성_요청(좋음, 견적ID);

        // THEN
        추천_피드백_생성_응답_검증(response, "/feedback/1");
    }
}
