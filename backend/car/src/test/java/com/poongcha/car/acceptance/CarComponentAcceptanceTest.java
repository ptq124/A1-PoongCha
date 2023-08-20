package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_응답_검증;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_응답_검증;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 컴포넌트 관련 기능")
public class CarComponentAcceptanceTest extends CarAcceptanceTest {
    private final String carComponentName4WD = "4WD";
    private final String carComponentDescriptionImageUrl4WD = "www.naver.com/image/4wd.png";
    private final int carComponentAdditionalPrice4WD = 2_000_000;
    private final String carComponentGroupNameEngine = "엔진";
    private final String selectionHelpTooltipEngine = "디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요";

    @DisplayName("차량 컴포넌트 그룹 생성")
    @Test
    void 차량_컴포넌트_그룹_생성() {
        // WHEN
        var response = 차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);

        // THEN
        차량_컴포넌트_그룹_생성_응답_검증(response, "/api/component-group/1");
    }

    @DisplayName("차량 컴포넌트 생성")
    @Test
    void 차량_컴포넌트_생성() {
        // WHEN
        var response = 차량_컴포넌트_생성_요청(
                carComponentName4WD,
                carComponentDescriptionImageUrl4WD,
                carComponentAdditionalPrice4WD
        );

        // THEN
        차량_컴포넌트_생성_응답_검증(response, "/api/component/1");
    }

    @DisplayName("차량 컴포넌트 그룹에 차량 컴포넌트 추가")
    @Test
    void 차량_컴포넌트_그룹에_차량_컴포넌트_추가() {
        // GIVEN
        차량_컴포넌트_생성_요청(carComponentName4WD, carComponentDescriptionImageUrl4WD, carComponentAdditionalPrice4WD);
        차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);

        // WHEN
        var response = 차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));

        // THEN
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_응답_검증(response, "/api/component-group/1");
    }
}
