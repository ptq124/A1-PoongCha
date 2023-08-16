package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_요청;
import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 색상 관련 기능")
public class CarColorAcceptanceTest extends DocumentationTest {
    @DisplayName("차량 색상 생성")
    @Test
    void 차량_색상_생성() {
        // GIVEN
        var carColorName = "palisade";
        var imageUrl = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        var carColorType = "INTERIOR";

        // WHEN
        var response = 차량_색상_생성_요청(carColorName, imageUrl, carColorType);

        // THEN
        차량_색상_생성_응답_검증(response, "/api/color/1");
    }
}
