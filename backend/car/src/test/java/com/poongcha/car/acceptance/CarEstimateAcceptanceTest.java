package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarEstimateSteps.차량_견적_생성_요청;
import static com.poongcha.car.acceptance.CarEstimateSteps.차량_견적_생성_응답_검증;
import static com.poongcha.car.acceptance.CarEstimateSteps.차량_견적_코드_조회_검증;
import static com.poongcha.car.acceptance.CarEstimateSteps.차량_견적_코드_조회_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.양립_불가능한_차량_옵션_설정_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_태그_설정_요청;
import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_요청;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 견적 인수 테스트")
public class CarEstimateAcceptanceTest extends CarAcceptanceTest {
    private final String compote2CarOptionGroupName = "컴포트 2";
    private final String handleInstallationLocation = "HANDLE";
    private final int additionalPrice = 1_000_000;
    private final String summaryDescription = "요약 설명";
    private final String carComponentName4WD = "4WD";
    private final String carComponentDescriptionImageUrl4WD = "www.naver.com/image/4wd.png";
    private final int carComponentAdditionalPrice4WD = 2_000_000;
    private final String carComponentGroupNameEngine = "엔진";
    private final String selectionHelpTooltipEngine = "디젤은 연비가 좋고 가솔린은 승차감이 더 부드럽고 조용해요";
    private final String trimNameLeBlanc = "Le Blanc";
    private final String imageUrlLeBlanc = "https://www.hyundai.com/contents/vr360/LX06/trim/DS.png";
    private final long minPriceLeBlanc = 48_000_000;

    @DisplayName("차량 견적 생성 테스트")
    @Test
    void 차량_견적_생성() {
        // GIVEN
        String carTypeName = "palisade";
        String carTypeImageUrl = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        차종_생성_요청(carTypeName, carTypeImageUrl);
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
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
        차량_컴포넌트_생성_요청(carComponentName4WD, carComponentDescriptionImageUrl4WD, carComponentAdditionalPrice4WD);
        차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));
        String exteriorColorName = "green";
        String exteriorColorImageUrl = "www.naver.com/color/green.png";
        String exteriorColorType = "EXTERIOR";
        차량_색상_생성_요청(exteriorColorName, exteriorColorImageUrl, exteriorColorType);
        String interiorColorName = "red";
        String interiorColorImageUrl = "www.naver.com/color/red.png";
        String interiorColorType = "INTERIOR";
        차량_색상_생성_요청(interiorColorName, interiorColorImageUrl, interiorColorType);

        // WHEN
        var response = 차량_견적_생성_요청(
                1L,
                List.of(1L),
                1L,
                2L,
                List.of(1L)
        );

        // THEN
        차량_견적_생성_응답_검증(response);
    }

    @DisplayName("차량 견적 조회 테스트")
    @Test
    void 차량_견적_코드_조회() {
        // GIVEN
        String carTypeName = "palisade";
        String carTypeImageUrl = "https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg";
        차종_생성_요청(carTypeName, carTypeImageUrl);
        트림_생성_요청(trimNameLeBlanc, imageUrlLeBlanc, minPriceLeBlanc, 1L);
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
        차량_컴포넌트_생성_요청(carComponentName4WD, carComponentDescriptionImageUrl4WD, carComponentAdditionalPrice4WD);
        차량_컴포넌트_그룹_생성_요청(carComponentGroupNameEngine, selectionHelpTooltipEngine);
        차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(1L, List.of(1L));
        String exteriorColorName = "green";
        String exteriorColorImageUrl = "www.naver.com/color/green.png";
        String exteriorColorType = "EXTERIOR";
        차량_색상_생성_요청(exteriorColorName, exteriorColorImageUrl, exteriorColorType);
        String interiorColorName = "red";
        String interiorColorImageUrl = "www.naver.com/color/red.png";
        String interiorColorType = "INTERIOR";
        차량_색상_생성_요청(interiorColorName, interiorColorImageUrl, interiorColorType);
        String location = 차량_견적_생성_요청(
                1L,
                List.of(1L),
                1L,
                2L,
                List.of(1L)
        ).header(HttpHeaders.LOCATION);

        String estimateCode = location.substring(location.lastIndexOf("/") + 1);

        // WHEN
        var response = 차량_견적_코드_조회_요청(estimateCode);

        // THEN
        차량_견적_코드_조회_검증(
                response,
                1L,
                estimateCode,
                1L,
                carTypeName,
                carTypeImageUrl,
                1L,
                trimNameLeBlanc,
                imageUrlLeBlanc,
                minPriceLeBlanc,
                List.of(1),
                List.of(carComponentName4WD),
                List.of(carComponentAdditionalPrice4WD),
                1,
                exteriorColorName,
                exteriorColorImageUrl,
                exteriorColorType,
                2,
                interiorColorName,
                interiorColorImageUrl,
                interiorColorType,
                List.of(1),
                List.of(compote2CarOptionGroupName),
                List.of(additionalPrice),
                List.of(List.of(1, 2)),
                List.of(List.of(optionName1, optionName2)),
                List.of(List.of(imageUrl1, imageUrl2))
        );
    }
}
