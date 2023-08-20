package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionBrandSteps.존재하지_않는_차량_옵션_브랜드_생성_요청;
import static com.poongcha.car.acceptance.CarOptionBrandSteps.존재하지_않는_차량_옵션_브랜드_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionBrandSteps.차량_옵션_브랜드_ID_조회_요청;
import static com.poongcha.car.acceptance.CarOptionBrandSteps.차량_옵션_브랜드_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionBrandSteps.차량_옵션_브랜드_생성_요청;
import static com.poongcha.car.acceptance.CarOptionBrandSteps.차량_옵션_브랜드_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 브랜드")
public class CarOptionBrandAcceptanceTest extends CarAcceptanceTest {
    @DisplayName("차량 옵션 브랜드 생성")
    @Test
    void 차량_옵션_브랜드_생성() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );

        // WHEN
        var response = 차량_옵션_브랜드_생성_요청(
                "N Performance",
                "www.naver.com/brand/n-performance.png",
                1L
        );

        // THEN
        차량_옵션_브랜드_생성_응답_검증(response, "/api/option-group/1/brand");
    }

    @DisplayName("존재하지 않는 차량 옵션 그룹의 ID로 차량 옵션 브랜드 생성")
    @Test
    void 존재하지_않는_차량_옵션_그룹_ID로_차량_옵션_브랜드_생성() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );

        // WHEN
        var response = 존재하지_않는_차량_옵션_브랜드_생성_요청(
                "www.naver.com/brand/image.png",
                "브랜드 설명입니다.",
                120931283918239L
        );

        // THEN
        존재하지_않는_차량_옵션_브랜드_생성_응답_검증(response);
    }

    @DisplayName("차량 옵션 브랜드 ID 조회")
    @Test
    void 차량_옵션_브랜드_ID_조() {
        // GIVEN
        차량_옵션_그룹_생성_요청(
                "차량 옵션 그룹 이름",
                10_000_000,
                "차량 옵션 그룹 간단한 설명",
                new long[]{}
        );
        차량_옵션_브랜드_생성_요청(
                "브랜드 설명입니다.",
                "www.naver.com/brand/image.png",
                1L
        );

        var response = 차량_옵션_브랜드_ID_조회_요청(1L);

        // THEN
        차량_옵션_브랜드_ID_조회_응답_검증(
                response,
                List.of(1),
                List.of("www.naver.com/brand/image.png"),
                List.of("브랜드 설명입니다.")
        );
    }
}
