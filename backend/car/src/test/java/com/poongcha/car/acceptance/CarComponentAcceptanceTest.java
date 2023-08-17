package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 컴포넌트 관련 기능")
public class CarComponentAcceptanceTest extends DocumentationTest {
    @DisplayName("차량 컴포넌트 그룹 생성")
    @Test
    void 차량_컴포넌트_그룹_생성() {
        // GIVEN
        var carComponentGroupName = "엔진";
        var selectionHelpTooltip = "디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요";

        // WHEN
        var response = 차량_컴포넌트_그룹_생성_요청(carComponentGroupName, selectionHelpTooltip);

        // THEN
        차량_컴포넌트_그룹_생성_응답_검증(response, "/api/component-group/1");
    }

    @DisplayName("차량 컴포넌트 생성")
    @Test
    void 차량_컴포넌트_생성() {
        // GIVEN
        var carComponentName = "4WD";
        var descriptionImageUrl = "www.naver.com/image/4wd.png";
        var additionalPrice = 2_000_000;

        // WHEN
        var response = 차량_컴포넌트_생성_요청(carComponentName, descriptionImageUrl, additionalPrice);

        // THEN
        차량_컴포넌트_생성_응답_검증(response, "/api/component/1");
    }
}
