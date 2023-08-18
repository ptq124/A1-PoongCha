package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_응답_검증;

import com.poongcha.car.util.DocumentationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 옵션 그룹 관련 기능")
public class CarOptionGroupAcceptanceTest extends DocumentationTest {
    private final String compote2CarOptionGroupName = "컴포트 2";
    private final String handleInstallationLocation = "HANDLE";
    private final long additionalPrice = 10_000_000;
    private final String summaryDescription = "요약 설명";

    @DisplayName("차량 옵션 그룹 생성")
    @Test
    void 차량_옵션_그룹_생성() {
        // WHEN
        var response = 차량_옵션_그룹_생성_요청(
                compote2CarOptionGroupName,
                handleInstallationLocation,
                additionalPrice,
                summaryDescription
        );

        // THEN
        차량_옵션_그룹_생성_응답_검증(response, "/api/option-group/1");
    }
}
