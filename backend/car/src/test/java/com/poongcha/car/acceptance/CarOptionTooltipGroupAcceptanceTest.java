package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.존재하지_않는_차량_옵션_툴팁_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.존재하지_않는_차량_옵션_툴팁_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.차량_옵션_툴팁_ID_조회_요청;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.차량_옵션_툴팁_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.차량_옵션_툴팁_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupTooltipSteps.차량_옵션_툴팁_생성_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 옵션 툴팁 관련 기능")
public class CarOptionTooltipGroupAcceptanceTest extends DocumentationTest {
    @DisplayName("차량 옵션 툴팁 생성")
    @Test
    void 차량_옵션_툴팁_생성() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );

        // WHEN
        var response = 차량_옵션_툴팁_생성_요청(
                "www.naver.com/tooltip/image.png",
                "툴팁 설명입니다.",
                1L
        );

        // THEN
        차량_옵션_툴팁_생성_응답_검증(response, "/api/option-group/1/tooltip/1");
    }

    @DisplayName("존재하지 않는 차량 옵션 그룹의 ID로 차량 옵션 툴팁 생성")
    @Test
    void 존재하지_않는_차량_옵션_그룹_ID로_차량_옵션_툴팁_생성() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );

        // WHEN
        var response = 존재하지_않는_차량_옵션_툴팁_생성_요청(
                "www.naver.com/tooltip/image.png",
                "툴팁 설명입니다.",
                120931283918239L
        );

        // THEN
        존재하지_않는_차량_옵션_툴팁_생성_응답_검증(response);
    }

    @DisplayName("차량 옵션 툴팁 ID 조회")
    @Test
    void create() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );
        차량_옵션_툴팁_생성_요청(
                "www.naver.com/tooltip/image.png",
                "툴팁 설명입니다.",
                1L
        );

        var response = 차량_옵션_툴팁_ID_조회_요청(1L, 1L);

        // THEN
        차량_옵션_툴팁_ID_조회_응답_검증(
                response,
                1L,
                "www.naver.com/tooltip/image.png",
                "툴팁 설명입니다."
        );
    }
}
