package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_요청;
import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_응답_검증;

import com.poongcha.car.util.CarAcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 옵션 관련 기능")
public class CarOptionAcceptanceTest extends CarAcceptanceTest {
    @DisplayName("차량 옵션 생성")
    @Test
    void 차량_옵션_생성() {
        // WHEN
        var response = 차량_옵션_생성_요청(
                "후석 승객 알림",
                "www.naver.com/option/image.png",
                "HANDLE",
                "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다."
        );

        // THEN
        차량_옵션_생성_응답_검증(response, "/option/1");
    }
}
