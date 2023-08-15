package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종_ID로_트림_목록_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종_ID로_트림_목록_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.차종_ID로_트림_목록_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.차종_ID로_트림_목록_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림에_차량_색상_설정_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림에_차량_색상_설정_응답_검증;

import com.poongcha.car.util.DocumentationTest;
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

    @DisplayName("차종 ID로 트림 목록 조회")
    @Test
    void 차종_ID로_트림_목록_조회() {
        // GIVEN
        var trimName1 = "Le Blanc";
        var imageUrl1 = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
        var minPrice1 = 48_000_000L;
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimName1, imageUrl1, minPrice1, 1L);
        var trimName2 = "Le Blanc";
        var imageUrl2 = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
        var minPrice2 = 45_000_000L;
        차종_생성_요청(
                "sonata",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimName2, imageUrl2, minPrice2, 2L);
        var trimName3 = "Premium";
        var imageUrl3 = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
        var minPrice3 = 52_000_000L;
        트림_생성_요청(trimName3, imageUrl3, minPrice3, 2L);

        // WHEN
        var response = 차종_ID로_트림_목록_조회_요청(2L);

        // THEN
        차종_ID로_트림_목록_조회_응답_검증(
                response,
                new Long[]{2L, 3L},
                new String[]{trimName2, trimName3},
                new String[]{imageUrl2, imageUrl3},
                new Long[]{minPrice2, minPrice3},
                new Long[]{2L, 2L}
        );
    }

    @DisplayName("존재하지 않는 차종 ID로 트림 조회")
    @Test
    void 존재하지_않는_차종_ID로_트림_목록_조회() {
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
        var response = 존재하지_않는_차종_ID로_트림_목록_조회_요청(1341394823482340L);

        // THEN
        존재하지_않는_차종_ID로_트림_목록_조회_응답_검증(response);
    }

    @DisplayName("트림에 차량 색상 설정")
    @Test
    void 트림에_차량_색상_설정() {
        // GIVEN
        var carTypeName = "sonata";
        var carTypeImageUrl = "https://www.naver.com/image-url.jpg";
        차종_생성_요청(carTypeName, carTypeImageUrl);
        var trimName = "premium";
        var trimImageUrl = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        var minPrice = 1_200_000;
        var carTypeId = 1L;
        트림_생성_요청(trimName, trimImageUrl, minPrice, carTypeId);
        var carColorName = "red";
        var imageUrl = "https://www.naver.com/color/red.jpg";
        var carColorType = "INTERIOR";
        차량_색상_생성_요청(carColorName, imageUrl, carColorType);
        var carColorId = 1L;
        var trimId = 1L;

        // WHEN
        var response = 트림에_차량_색상_설정_요청(carColorId, trimId);

        // THEN
        트림에_차량_색상_설정_응답_검증(response, "/api/trim/1/color");
    }
}
