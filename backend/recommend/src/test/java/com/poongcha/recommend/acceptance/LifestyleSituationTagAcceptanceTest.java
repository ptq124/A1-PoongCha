package com.poongcha.recommend.acceptance;

import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_생성_요청;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_응답_검증;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_전체_조회_요청;
import static com.poongcha.recommend.acceptance.LifestyleSituationTagSteps.라이프스타일_상황_태그_전체_조회_응답_검증;

import com.poongcha.recommend.util.RecommendAcceptanceTest;
import java.util.List;
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

    @DisplayName("라이프스타일 상황 태그 전체 조회")
    @Test
    void 라이프스타일_상황_태그_전체_조회() {
        // GIVEN
        라이프스타일_상황_태그_생성_요청("주행안전");
        라이프스타일_상황_태그_생성_요청("사용편의");

        // WHEN
        var response = 라이프스타일_상황_태그_전체_조회_요청();

        // WHEN
        라이프스타일_상황_태그_전체_조회_응답_검증(
                response,
                List.of(1, 2),
                List.of("주행안전", "사용편의")
        );
    }
}
