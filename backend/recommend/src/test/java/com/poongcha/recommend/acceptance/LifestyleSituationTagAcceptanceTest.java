package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_생성_요청;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라이프스타일 상황 태그 관련 기능")
public class LifestyleSituationTagAcceptanceTest extends RecommendAcceptanceTest {
    @DisplayName("라이프스타일 상황 태그 생성")
    @Test
    void 라이프스타일_상황_태그_생성() {
        // WHEN
        var response = 라이프스타일_상황_태그_생성_요청("주행안전");

        // THEN
        라이프스타일_상황_태그_응답_검증(response, "/lifestyle-persona-situation-tag");
    }
}
