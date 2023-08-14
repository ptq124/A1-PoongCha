package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("트림 인수 테스트")
public class TrimAcceptanceTest extends DocumentationTest {
    @DisplayName("트림 생성")
    @Test
    void 트림_생성() {
        // GIVEN
        var trimName = "Le Blanc";
        var imageUrl = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
        var minPrice = 48_000_000;
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );

        // WHEN
        var response = 트림_생성_요청(trimName, imageUrl, minPrice, 1L);

        // THEN
        트림_생성_응답_검증(response, "/api/trim/1");
    }

    @DisplayName("존재하지 않는 차종으로 트림 생성")
    @Test
    void 존재하지_않는_차종으로_트림_생성() {
        // GIVEN
        var trimName = "Le Blanc";
        var imageUrl = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
        var minPrice = 48_000_000;
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );

        // WHEN
        var response = 존재하지_않는_차종으로_트림_생성_요청(trimName, imageUrl, minPrice, 23819213431358L);

        // THEN
        존재하지_않는_차종으로_트림_생성_응답_검증(response);
    }

    @DisplayName("트림 ID로 조회")
    @Test
    void 트림_ID_조회() {
        // GIVEN
        var trimName = "Le Blanc";
        var imageUrl = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
        var minPrice = 48_000_000L;
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimName, imageUrl, minPrice, 1L);

        // WHEN
        var response = 트림_ID_조회_요청(1L);

        // THEN
        트림_ID_조회_응답_검증(response, 1L, trimName, imageUrl, minPrice, 1L);
    }

    @DisplayName("존재하지 않는 트림 ID로 조회")
    @Test
    void 존재하지_않는_트림_ID_조회() {
        // GIVEN
        var trimName = "Le Blanc";
        var imageUrl = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
        var minPrice = 48_000_000L;
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimName, imageUrl, minPrice, 1L);

        // WHEN
        var response = 존재하지_않는_트림_ID_조회_요청(23123981237121123L);

        // THEN
        존재하지_않는_트림_ID_조회_응답_검증(response);
    }
}
