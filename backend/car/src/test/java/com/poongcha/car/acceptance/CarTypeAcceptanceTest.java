package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입에_차량_컴포넌트_그룹_추가_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차량_타입에_차량_컴포넌트_그룹_추가_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_ID_조회_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_응답_검증;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_전체_조회_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_전체_조회_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차종 인수 테스트")
public class CarTypeAcceptanceTest extends DocumentationTest {
    @DisplayName("차종 생성")
    @Test
    void 차종_생성() {
        // GIVEN
        var car_type_name = "palisade";
        var image_url = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";

        // WHEN
        var response = 차종_생성_요청(car_type_name, image_url);

        // THEN
        차종_생성_응답_검증(response, "/api/car-type/1");
    }

    @DisplayName("차종 ID 조회")
    @Test
    void 차종_ID_조회() {
        // GIVEN
        var car_type_name = "palisade";
        var image_url = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        차종_생성_요청(car_type_name, image_url);

        // WHEN
        var response = 차종_ID_조회_요청(1L);

        // THEN
        차종_ID_조회_응답_검증(response, 1L, car_type_name, image_url);
    }

    @DisplayName("차종 전체 조회")
    @Test
    void 차종_전체_조회() {
        // GIVEN
        var carTypeName1 = "palisade";
        var imageUrl1 = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        차종_생성_요청(carTypeName1, imageUrl1);
        var carTypeName2 = "sonata";
        var imageUrl2 = "https://www.hyundai.com/static/images/model/sonata-hybrid/23fl/mo/sonata_the_edge_hybrid_highlights_hybrid_m.jpg";
        차종_생성_요청(carTypeName2, imageUrl2);

        // WHEN
        var response = 차종_전체_조회_요청();

        // THEN
        차종_전체_조회_응답_검증(
                response,
                new Long[]{1L, 2L},
                new String[]{carTypeName1, carTypeName2},
                new String[]{imageUrl1, imageUrl2}
        );
    }

    @DisplayName("차량 타입에 차량 컴포넌트 그룹 추가")
    @Test
    void 차량_타입에_차량_컴포넌트_그룹_추가() {
        // GIVEN
        var carTypeName1 = "palisade";
        var imageUrl1 = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        차종_생성_요청(carTypeName1, imageUrl1);
        var carComponentName = "4WD";
        var descriptionImageUrl = "www.naver.com/image/4wd.png";
        var additionalPrice = 2_000_000;
        차량_컴포넌트_생성_요청(carComponentName, descriptionImageUrl, additionalPrice);
        var carComponentGroupName = "엔진";
        var selectionHelpTooltip = "디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요";
        차량_컴포넌트_그룹_생성_요청(carComponentGroupName, selectionHelpTooltip);
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));

        // WHEN
        var response = 차량_타입에_차량_컴포넌트_그룹_추가_요청(1L, List.of(1L));

        // THEN
        차량_타입에_차량_컴포넌트_그룹_추가_응답_검증(response, "/api/car-type/1/component-group");
    }
}
