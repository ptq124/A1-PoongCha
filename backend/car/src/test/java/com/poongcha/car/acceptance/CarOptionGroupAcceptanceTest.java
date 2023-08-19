package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionGroupSteps.같은_ID로_양립_불가능한_차량_옵션_설정_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.같은_ID로_양립_불가능한_차량_옵션_설정_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.양립_불가능한_차량_옵션_설정_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.양립_불가능한_차량_옵션_설정_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_ID로_양립_불가능한_차량_옵션_설정_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_ID로_양립_불가능한_차량_옵션_설정_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_그룹_ID_조회_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.존재하지_않는_차량_옵션_그룹_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_ID_조회_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_응답_검증;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_태그_설정_요청;
import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_생성_요청;

import com.poongcha.car.util.DocumentationTest;
import java.util.List;
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
        String optionName1 = "후석 승객 알림";
        String imageUrl1 = "www.naver.com/option/image.png";
        String detailDescription1 = "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.";
        String installationLocation1 = handleInstallationLocation;
        차량_옵션_생성_요청(optionName1, imageUrl1, installationLocation1, detailDescription1);

        String optionName2 = "전방 추돌 방지 알림";
        String imageUrl2 = "www.naver.com/option/image.png";
        String installationLocation2 = "DEFAULT";
        String detailDescription2 = "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션";
        차량_옵션_생성_요청(optionName2, imageUrl2, installationLocation2, detailDescription2);

        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});
        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});
        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});

        양립_불가능한_차량_옵션_설정_요청(1, List.of(2L, 3L));

        차량_옵션_태그_생성_요청("태그1", "www.naver.com/situation/image1.png", "www.naver.com/icon/image1.png");
        차량_옵션_태그_생성_요청("태그2", "www.naver.com/situation/image2.png", "www.naver.com/icon/image2.png");
        차량_옵션_그룹_태그_설정_요청(1, List.of(1L, 2L));

        // WHEN
        var response = 차량_옵션_그룹_ID_조회_요청(1L);

        // THEN
        차량_옵션_그룹_ID_조회_응답_검증(
                response,
                1L,
                compote2CarOptionGroupName,
                additionalPrice,
                summaryDescription,
                List.of("태그1", "태그2"),
                List.of(2, 3),
                List.of(1, 2),
                List.of(optionName1, optionName2),
                List.of(imageUrl1, imageUrl2),
                List.of(detailDescription1, detailDescription2),
                List.of(installationLocation1, installationLocation2)
        );
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

    @DisplayName("존재하지 않는 차량 옵션 그룹 ID 조회")
    @Test
    void 존재하지_않는_차량_옵션_그룹_ID_조회() {
        // GIVEN
        String optionName1 = "후석 승객 알림";
        String imageUrl1 = "www.naver.com/option/image.png";
        String detailDescription1 = "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.";
        String installationLocation1 = handleInstallationLocation;
        차량_옵션_생성_요청(optionName1, imageUrl1, installationLocation1, detailDescription1);

        String optionName2 = "전방 추돌 방지 알림";
        String imageUrl2 = "www.naver.com/option/image.png";
        String installationLocation2 = "DEFAULT";
        String detailDescription2 = "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션";
        차량_옵션_생성_요청(optionName2, imageUrl2, installationLocation2, detailDescription2);

        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});

        // WHEN
        var response = 존재하지_않는_차량_옵션_그룹_ID_조회_요청(2873129379123L);

        // THEN
        존재하지_않는_차량_옵션_그룹_ID_조회_응답_검증(response);
    }

    @DisplayName("양립 불가능한 차량 옵션 설정")
    @Test
    void 양립_불가능한_차량_옵션_설정() {
        // GIVEN
        String optionName1 = "후석 승객 알림";
        String imageUrl1 = "www.naver.com/option/image.png";
        String detailDescription1 = "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.";
        String installationLocation1 = handleInstallationLocation;
        차량_옵션_생성_요청(optionName1, imageUrl1, installationLocation1, detailDescription1);

        String optionName2 = "전방 추돌 방지 알림";
        String imageUrl2 = "www.naver.com/option/image.png";
        String installationLocation2 = "DEFAULT";
        String detailDescription2 = "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션";
        차량_옵션_생성_요청(optionName2, imageUrl2, installationLocation2, detailDescription2);

        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});

        차량_옵션_그룹_생성_요청("전방 추돌 방지 알림", 1_000_000, "전방 추돌 방지 옵션", new long[]{2L});

        // WHEN
        var response = 양립_불가능한_차량_옵션_설정_요청(1L, List.of(2L));

        // THEN
        양립_불가능한_차량_옵션_설정_응답_검증(response, "/api/option-group/" + 1L);
    }

    @DisplayName("같은 ID로 양립 불가능한 차량 옵션 설정")
    @Test
    void 같은_ID로_양립_불가능한_차량_옵션_설정() {
        // GIVEN
        String optionName1 = "후석 승객 알림";
        String imageUrl1 = "www.naver.com/option/image.png";
        String detailDescription1 = "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.";
        String installationLocation1 = handleInstallationLocation;
        차량_옵션_생성_요청(optionName1, imageUrl1, installationLocation1, detailDescription1);

        String optionName2 = "전방 추돌 방지 알림";
        String imageUrl2 = "www.naver.com/option/image.png";
        String installationLocation2 = "DEFAULT";
        String detailDescription2 = "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션";
        차량_옵션_생성_요청(optionName2, imageUrl2, installationLocation2, detailDescription2);

        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});

        차량_옵션_그룹_생성_요청("전방 추돌 방지 알림", 1_000_000, "전방 추돌 방지 옵션", new long[]{2L});

        // WHEN
        var response = 같은_ID로_양립_불가능한_차량_옵션_설정_요청(1L, List.of(1L));

        // THEN
        같은_ID로_양립_불가능한_차량_옵션_설정_응답_검증(response);
    }

    @DisplayName("존재하지 않는 ID로 양립 불가능한 차량 옵션 설정")
    @Test
    void 존재하지_않는_ID로_양립_불가능한_차량_옵션_설정() {
        // GIVEN
        String optionName1 = "후석 승객 알림";
        String imageUrl1 = "www.naver.com/option/image.png";
        String detailDescription1 = "초음파 센서를 통해 뒷좌석에 남아있는 승객의 움직임을 감지하여 운전자에게 경고함으로써 부주의에 의한 유아 또는 반려 동물 등의 방치 사고를 예방하는 신기술입니다.";
        String installationLocation1 = handleInstallationLocation;
        차량_옵션_생성_요청(optionName1, imageUrl1, installationLocation1, detailDescription1);

        String optionName2 = "전방 추돌 방지 알림";
        String imageUrl2 = "www.naver.com/option/image.png";
        String installationLocation2 = "DEFAULT";
        String detailDescription2 = "카메라를를 통해 전방 차량을 감지해 추돌을 방지해주는 옵션";
        차량_옵션_생성_요청(optionName2, imageUrl2, installationLocation2, detailDescription2);

        차량_옵션_그룹_생성_요청(compote2CarOptionGroupName, additionalPrice, summaryDescription, new long[]{1L, 2L});

        차량_옵션_그룹_생성_요청("전방 추돌 방지 알림", 1_000_000, "전방 추돌 방지 옵션", new long[]{2L});

        // WHEN
        var response = 존재하지_않는_ID로_양립_불가능한_차량_옵션_설정_요청(1L, List.of(19283123492489L));

        // THEN
        존재하지_않는_ID로_양립_불가능한_차량_옵션_설정_응답_검증(response);
    }
}
