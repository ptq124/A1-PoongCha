package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_요청;

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
        차량_옵션_생성_요청(
                "후석 승객 알림",
                "www.naver.com/option/image.png",
                "HANDLE",
                "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다."
        );
        차량_옵션_생성_요청(
                "전방 추돌 방지 알림",
                "www.naver.com/option/image.png",
                "DEFAULT",
                "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션"
        );

        var response = 차량_옵션_그룹_생성_요청(
                compote2CarOptionGroupName,
                additionalPrice,
                summaryDescription,
                new long[]{1L, 2L}
        );

        // THEN
        차량_옵션_그룹_생성_응답_검증(response, "/api/option-group/1");
    }

    @DisplayName("차량 옵션 그룹 ID 조회")
    @Test
    void 차량_옵션_그룹_ID_조회() {
        // GIVEN
        차량_옵션_생성_요청(
                "후석 승객 알림",
                "www.naver.com/option/image.png",
                handleInstallationLocation,
                "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다."
        );
        차량_옵션_생성_요청(
                "전방 추돌 방지 알림",
                "www.naver.com/option/image.png",
                "DEFAULT",
                "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션"
        );

        // WHEN
        var response = 차량_옵션_그룹_생성_요청(
                compote2CarOptionGroupName,
                additionalPrice,
                summaryDescription,
                new long[]{1L, 2L}
        );

        // THEN
        차량_옵션_그룹_생성_응답_검증(response, "/api/option-group/1");
    }

    @DisplayName("존재하지 않는 차량 옵션 ID로 차량 옵션 그룹 생성")
    @Test
    void 존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성() {
        // WHEN
        var response = 존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_요청(
                compote2CarOptionGroupName,
                additionalPrice,
                summaryDescription,
                new long[]{1L, 2L}
        );

        // THEN
        존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_응답_검증(response);
    }
}
