package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입에_차량_컴포넌트_그룹_추가_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입에_차량_컴포넌트_그룹_추가_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입의_차량_컴포넌트_그룹_조회_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입의_차량_컴포넌트_그룹_조회_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_ID_조회_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_전체_조회_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_전체_조회_응답_검증;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차종 인수 테스트")
public class CarTypeAcceptanceTest extends CarAcceptanceTest {
    private final String palisadeCarTypeName = "palisade";
    private final String palisadeImageUrl = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
    private final String sonataCarTypeName = "sonata";
    private final String sonataImageUrl = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
    private final String carComponentName4WD = "4WD";
    private final String carComponentDescriptionImageUrl4WD = "www.naver.com/image/4wd.png";
    private final int carComponentAdditionalPrice4WD = 2_000_000;
    private final String carComponentGroupNameEngine = "엔진";
    private final String selectionHelpTooltipEngine = "디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요";

    @DisplayName("차종 생성")
    @Test
    void 차종_생성() {
        // WHEN
        var response = 차종_생성_요청(palisadeCarTypeName, palisadeImageUrl);

        // THEN
        차종_생성_응답_검증(response, "/api/car-type/1");
    }

    @DisplayName("차종 ID 조회")
    @Test
    void 차종_ID_조회() {
        // GIVEN
        차종_생성_요청(palisadeCarTypeName, palisadeImageUrl);

        // WHEN
        var response = 차종_ID_조회_요청(1L);

        // THEN
        차종_ID_조회_응답_검증(response, 1L, palisadeCarTypeName, palisadeImageUrl);
    }

    @DisplayName("차종 전체 조회")
    @Test
    void 차종_전체_조회() {
        // GIVEN
        차종_생성_요청(palisadeCarTypeName, palisadeImageUrl);
        차종_생성_요청(sonataCarTypeName, sonataImageUrl);

        // WHEN
        var response = 차종_전체_조회_요청();

        // THEN
        차종_전체_조회_응답_검증(
                response,
                new Long[]{1L, 2L},
                new String[]{palisadeCarTypeName, sonataCarTypeName},
                new String[]{palisadeImageUrl, sonataImageUrl}
        );
    }

    @DisplayName("차량 타입에 차량 컴포넌트 그룹 추가")
    @Test
    void 차량_타입에_차량_컴포넌트_그룹_추가() {
        // GIVEN
        차종_생성_요청(palisadeCarTypeName, palisadeImageUrl);
        차량_컴포넌트_생성_요청(carComponentName4WD, carComponentDescriptionImageUrl4WD, carComponentAdditionalPrice4WD);
        차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));

        // WHEN
        var response = 차량_타입에_차량_컴포넌트_그룹_추가_요청(1L, List.of(1L));

        // THEN
        차량_타입에_차량_컴포넌트_그룹_추가_응답_검증(response, "/api/car-type/1/component-group");
    }

    @DisplayName("차량 타입에 차량 컴포넌트 조회")
    @Test
    void 차량_타입에_차량_컴포넌트_조회() {
        // GIVEN
        차종_생성_요청(palisadeCarTypeName, palisadeImageUrl);
        차량_컴포넌트_생성_요청(carComponentName4WD, carComponentDescriptionImageUrl4WD, carComponentAdditionalPrice4WD);
        차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));
        차량_타입에_차량_컴포넌트_그룹_추가_요청(1L, List.of(1L));

        // WHEN
        var response = 차량_타입의_차량_컴포넌트_그룹_조회_요청(1L);

        // THEN
        차량_타입의_차량_컴포넌트_그룹_조회_응답_검증(response);
    }
}
