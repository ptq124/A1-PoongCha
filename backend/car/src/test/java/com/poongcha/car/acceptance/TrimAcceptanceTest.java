package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarColorSteps.양립_불가능한_차량_색상_설정_요청;
import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종_ID로_트림_목록_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종_ID로_트림_목록_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종에_차량_색상_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종에_차량_색상_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_차종으로_트림_생성_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림에_차량_색상_설정_요청;
import static com.poongcha.car.acceptance.TrimSteps.존재하지_않는_트림에_차량_색상_설정_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.차종_ID로_트림_목록_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.차종_ID로_트림_목록_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.차종에_차량_색상_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.차종에_차량_색상_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림에_존재하지_않는_차량_색상_설정_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림에_존재하지_않는_차량_색상_설정_응답_검증;
import static com.poongcha.car.acceptance.TrimSteps.트림에_차량_색상_설정_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림에_차량_색상_설정_응답_검증;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("트림 인수 테스트")
public class TrimAcceptanceTest extends CarAcceptanceTest {
    private final String trimNameLeBlanc = "Le Blanc";
    private final String imageUrlLeBlanc = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
    private final long minPriceLeBlanc = 48_000_000;
    private final String trimNameCalligraphy = "Calligraphy";
    private final String imageUrlCalligraphy = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
    private final long minPriceCalligraphy = 45_000_000;
    private final String trimNamePremium = "Premium";
    private final String imageUrlPremium = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
    private final long minPricePremium = 52_000_000;
    private final String carColorNameRed = "red";
    private final String imageUrlRed = "https://www.naver.com/color/red.jpg";
    private final String carColorTypeInterior = "INTERIOR";
    private final String carColorNameBlue = "blue";
    private final String imageUrlBlue = "https://www.naver.com/color/blue.jpg";
    private final String carColorTypeExterior = "EXTERIOR";

    @DisplayName("트림 생성")
    @Test
    void 트림_생성() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );

        // WHEN
        var response = 트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);

        // THEN
        트림_생성_응답_검증(response, "/api/trim/1");
    }

    @DisplayName("존재하지 않는 차종으로 트림 생성")
    @Test
    void 존재하지_않는_차종으로_트림_생성() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );

        // WHEN
        var response = 존재하지_않는_차종으로_트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 23819213431358L);

        // THEN
        존재하지_않는_차종으로_트림_생성_응답_검증(response);
    }

    @DisplayName("트림 ID로 조회")
    @Test
    void 트림_ID_조회() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);

        // WHEN
        var response = 트림_ID_조회_요청(1L);

        // THEN
        트림_ID_조회_응답_검증(response, 1L, trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
    }

    @DisplayName("존재하지 않는 트림 ID로 조회")
    @Test
    void 존재하지_않는_트림_ID_조회() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);

        // WHEN
        var response = 존재하지_않는_트림_ID_조회_요청(23123981237121123L);

        // THEN
        존재하지_않는_트림_ID_조회_응답_검증(response);
    }

    @DisplayName("차종 ID로 트림 목록 조회")
    @Test
    void 차종_ID로_트림_목록_조회() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
        차종_생성_요청(
                "sonata",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청(trimNameCalligraphy, imageUrlCalligraphy, minPriceCalligraphy, 2L);
        트림_생성_요청(trimNamePremium, imageUrlPremium, minPricePremium, 2L);

        // WHEN
        var response = 차종_ID로_트림_목록_조회_요청(2L);

        // THEN
        차종_ID로_트림_목록_조회_응답_검증(
                response,
                new Long[]{2L, 3L},
                new String[]{trimNameCalligraphy, trimNamePremium},
                new String[]{imageUrlCalligraphy, imageUrlPremium},
                new Long[]{minPriceCalligraphy, minPricePremium},
                new Long[]{2L, 2L}
        );
    }

    @DisplayName("존재하지 않는 차종 ID로 트림 조회")
    @Test
    void 존재하지_않는_차종_ID로_트림_목록_조회() {
        // GIVEN
        차종_생성_요청(
                "palisade",
                "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg"
        );
        트림_생성_요청("Le Blanc", "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png", 48_000_000L, 1L);

        // WHEN
        var response = 존재하지_않는_차종_ID로_트림_목록_조회_요청(1341394823482340L);

        // THEN
        존재하지_않는_차종_ID로_트림_목록_조회_응답_검증(response);
    }

    @DisplayName("트림에 차량 색상 설정")
    @Test
    void 트림에_차량_색상_설정() {
        // GIVEN
        차종_생성_요청("sonata", "https://www.naver.com/image-url.jpg");
        트림_생성_요청(trimNamePremium, imageUrlPremium, minPricePremium, 1L);
        차량_색상_생성_요청("red", "https://www.naver.com/color/red.jpg", "INTERIOR");

        // WHEN
        var response = 트림에_차량_색상_설정_요청(
                1L,
                1L,
                "https://www.naver.com/color/exterior.jpg",
                "https://www.naver.com/color/interior.jpg",
                "https://www.naver.com/color/rotation"
        );

        // THEN
        트림에_차량_색상_설정_응답_검증(response, "/api/trim/1/color");
    }

    @DisplayName("존재하지 않는 트림에 차량 색상을 설정")
    @Test
    void 존재하지_않는_트림에_차량_색상_설정() {
        // GIVEN
        차량_색상_생성_요청("red", "https://www.naver.com/color/red.jpg", "INTERIOR");

        // WHEN
        var response = 존재하지_않는_트림에_차량_색상_설정_요청(1L, 29812312739123L);

        // THEN
        존재하지_않는_트림에_차량_색상_설정_응답_검증(response);
    }

    @DisplayName("트림에 존재하지 않는 차량 색상을 설정")
    @Test
    void 트림에_존재하지_않는_차량_색상_설정() {
        // GIVEN
        차종_생성_요청("sonata", "https://www.naver.com/image-url.jpg");
        트림_생성_요청(trimNamePremium, imageUrlPremium, minPricePremium, 1L);

        // WHEN
        var response = 트림에_존재하지_않는_차량_색상_설정_요청(2981231223739123L, 1L);

        // THEN
        트림에_존재하지_않는_차량_색상_설정_응답_검증(response);
    }

    @DisplayName("차종에 차량 색상을 조회한다.")
    @Test
    void 차종에_차량_색상_조회() {
        // GIVEN
        차종_생성_요청("sonata", "https://www.naver.com/image-url.jpg");
        트림_생성_요청(trimNamePremium, imageUrlPremium, minPricePremium, 1L);
        차량_색상_생성_요청(carColorNameRed, imageUrlRed, carColorTypeInterior);
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
        차량_색상_생성_요청(carColorNameBlue, imageUrlBlue, carColorTypeExterior);
        트림에_차량_색상_설정_요청(
                2L,
                1L,
                "https://www.naver.com/color/exterior.jpg",
                "https://www.naver.com/color/interior.jpg",
                "https://www.naver.com/color/rotation"
        );
        트림에_차량_색상_설정_요청(
                1L,
                2L,
                "https://www.naver.com/color/exterior.jpg",
                "https://www.naver.com/color/interior.jpg",
                "https://www.naver.com/color/rotation"
        );
        차량_색상_생성_요청("orange", "https://www.naver.com/color/orange.jpg", "INTERIOR");
        양립_불가능한_차량_색상_설정_요청(2L, 3L);
        차량_색상_생성_요청("green", "https://www.naver.com/color/green.jpg", "INTERIOR");
        양립_불가능한_차량_색상_설정_요청(2L, 4L);

        // WHEN
        var response = 차종에_차량_색상_조회_요청(1L);

        // THEN
        차종에_차량_색상_조회_응답_검증(
                response,
                List.of(1, 2),
                List.of(List.of(2), List.of(1)),
                List.of(List.of(carColorNameBlue), List.of(carColorNameRed)),
                List.of(List.of(imageUrlBlue), List.of(imageUrlRed)),
                List.of(List.of(carColorTypeExterior), List.of(carColorTypeInterior)),
                List.of(List.of(List.of(3, 4)), List.of(List.of()))
        );
    }

    @DisplayName("존재하지 않는 차종에 차량 색상을 조회.")
    @Test
    void 존재하지_않는_차종에_차량_색상_조회() {
        // GIVEN
        차종_생성_요청("sonata", "https://www.naver.com/image-url.jpg");
        트림_생성_요청(trimNamePremium, imageUrlPremium, minPricePremium, 1L);
        차량_색상_생성_요청(carColorNameRed, imageUrlRed, carColorTypeInterior);
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
        차량_색상_생성_요청(carColorNameBlue, imageUrlBlue, carColorTypeExterior);
        트림에_차량_색상_설정_요청(
                2L,
                1L,
                "https://www.naver.com/color/exterior.jpg",
                "https://www.naver.com/color/interior.jpg",
                "https://www.naver.com/color/rotation"
        );
        트림에_차량_색상_설정_요청(
                1L,
                2L,
                "https://www.naver.com/color/exterior.jpg",
                "https://www.naver.com/color/interior.jpg",
                "https://www.naver.com/color/rotation"
        );

        // WHEN
        var response = 존재하지_않는_차종에_차량_색상_조회_요청(129831823912387L);

        // THEN
        존재하지_않는_차종에_차량_색상_조회_응답_검증(response);
    }
}
