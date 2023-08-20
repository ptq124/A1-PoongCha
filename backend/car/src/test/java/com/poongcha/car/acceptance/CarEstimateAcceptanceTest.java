package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.acceptance.CarColorSteps.차량_색상_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청;
import static com.poongcha.car.acceptance.CarComponentSteps.차량_컴포넌트_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.양립_불가능한_차량_옵션_설정_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_생성_요청;
import static com.poongcha.car.acceptance.CarOptionGroupSteps.차량_옵션_그룹_태그_설정_요청;
import static com.poongcha.car.acceptance.CarOptionSteps.차량_옵션_생성_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_생성_요청;
import static com.poongcha.car.acceptance.CarTypeSteps.차종_생성_요청;
import static com.poongcha.car.acceptance.TrimSteps.트림_생성_요청;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.poongcha.car.util.DocumentationTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

@DisplayName("차량 견적 인수 테스트")
public class CarEstimateAcceptanceTest extends DocumentationTest {
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
        차종_생성_요청(
                carTypeName,
                carTypeImageUrl
        );
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

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);

        // THEN
        ExtractableResponse<Response> findByIdResponse = 차량_견적_생성_ID_조회_요청(1L);

        차량_견적_생성_ID_조회_검증(
                findByIdResponse,
                1L,
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

    private ExtractableResponse<Response> 차량_견적_생성_ID_조회_요청(final long id) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("견적 ID"),
                                fieldWithPath("carType.id").type(JsonFieldType.NUMBER).description("차종 ID"),
                                fieldWithPath("carType.name").type(JsonFieldType.STRING).description("차종 이름"),
                                fieldWithPath("carType.imageUrl").type(JsonFieldType.STRING).description("차종 이미지 URL"),
                                fieldWithPath("trim.id").type(JsonFieldType.NUMBER).description("트림 ID"),
                                fieldWithPath("trim.name").type(JsonFieldType.STRING).description("트림 이름"),
                                fieldWithPath("trim.imageUrl").type(JsonFieldType.STRING).description("트림 이미지 URL"),
                                fieldWithPath("trim.minPrice").type(JsonFieldType.NUMBER).description("트림 가격"),
                                fieldWithPath("components[].id").type(JsonFieldType.NUMBER).description("컴포넌트 ID"),
                                fieldWithPath("components[].name").type(JsonFieldType.STRING).description("컴포넌트 이름"),
                                fieldWithPath("components[].additionalPrice").type(JsonFieldType.NUMBER)
                                        .description("컴포넌트 추가 가격"),
                                fieldWithPath("exteriorColor.id").type(JsonFieldType.NUMBER).description("외장 색상 ID"),
                                fieldWithPath("exteriorColor.name").type(JsonFieldType.STRING).description("외장 색상 이름"),
                                fieldWithPath("exteriorColor.imageUrl").type(JsonFieldType.STRING)
                                        .description("외장 색상 이미지 URL"),
                                fieldWithPath("exteriorColor.type").type(JsonFieldType.STRING).description("외장 색상 타입"),
                                fieldWithPath("interiorColor.id").type(JsonFieldType.NUMBER).description("내장 색상 ID"),
                                fieldWithPath("interiorColor.name").type(JsonFieldType.STRING).description("내장 색상 이름"),
                                fieldWithPath("interiorColor.imageUrl").type(JsonFieldType.STRING)
                                        .description("내장 색상 이미지 URL"),
                                fieldWithPath("interiorColor.type").type(JsonFieldType.STRING).description("내장 색상 타입"),
                                fieldWithPath("optionGroups").type(JsonFieldType.ARRAY).description("옵션 그룹 목록"),
                                fieldWithPath("optionGroups[].id").type(JsonFieldType.NUMBER).description("옵션 그룹 ID"),
                                fieldWithPath("optionGroups[].name").type(JsonFieldType.STRING).description("옵션 그룹 이름"),
                                fieldWithPath("optionGroups[].additionalPrice").type(JsonFieldType.NUMBER)
                                        .description("옵션 그룹 추가 가격"),
                                fieldWithPath("optionGroups[].options[].id").type(JsonFieldType.NUMBER)
                                        .description("옵션 ID"),
                                fieldWithPath("optionGroups[].options[].name").type(JsonFieldType.STRING)
                                        .description("옵션 이름"),
                                fieldWithPath("optionGroups[].options[].imageUrl").type(JsonFieldType.STRING)
                                        .description("옵션 이미지 URL")
                        )
                ))
                .log().all()
                .when()
                .get("/api/estimate/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 차량_견적_생성_ID_조회_검증(
            final ExtractableResponse<Response> response,
            final long estimateId,
            final long carTypeId,
            final String carTypeName,
            final String carTypeImageUrl,
            final long trimId,
            final String trimName,
            final String trimImageUrl,
            final long trimMinPrice,
            final List<Integer> componentIds,
            final List<String> componentName,
            final List<Integer> componentAdditionalPrice,
            final int exteriorColorId,
            final String exteriorColorName,
            final String exteriorColorImageUrl,
            final String exteriorColorType,
            final int interiorColorId,
            final String interiorColorName,
            final String interiorColorImageUrl,
            final String interiorColorType,
            final List<Integer> carOptionGroupIds,
            final List<String> carOptionGroupName,
            final List<Integer> additionalPrice,
            final List<List<Integer>> optionIds,
            final List<List<String>> optionNames,
            final List<List<String>> optionImageUrls
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            JsonPath jsonPath = response.jsonPath();
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(jsonPath.getLong("id")).isEqualTo(estimateId);
            assertions.assertThat(jsonPath.getLong("carType.id")).isEqualTo(carTypeId);
            assertions.assertThat(jsonPath.getString("carType.name")).isEqualTo(carTypeName);
            assertions.assertThat(jsonPath.getString("carType.imageUrl")).isEqualTo(carTypeImageUrl);
            assertions.assertThat(jsonPath.getLong("trim.id")).isEqualTo(trimId);
            assertions.assertThat(jsonPath.getString("trim.name")).isEqualTo(trimName);
            assertions.assertThat(jsonPath.getString("trim.imageUrl")).isEqualTo(trimImageUrl);
            assertions.assertThat(jsonPath.getLong("trim.minPrice")).isEqualTo(trimMinPrice);
            assertions.assertThat(jsonPath.getList("components.id")).isEqualTo(componentIds);
            assertions.assertThat(jsonPath.getList("components.name")).isEqualTo(componentName);
            assertions.assertThat(jsonPath.getList("components.additionalPrice")).isEqualTo(componentAdditionalPrice);
            assertions.assertThat(jsonPath.getLong("exteriorColor.id")).isEqualTo(exteriorColorId);
            assertions.assertThat(jsonPath.getString("exteriorColor.name")).isEqualTo(exteriorColorName);
            assertions.assertThat(jsonPath.getString("exteriorColor.imageUrl")).isEqualTo(exteriorColorImageUrl);
            assertions.assertThat(jsonPath.getString("exteriorColor.type")).isEqualTo(exteriorColorType);
            assertions.assertThat(jsonPath.getLong("interiorColor.id")).isEqualTo(interiorColorId);
            assertions.assertThat(jsonPath.getString("interiorColor.name")).isEqualTo(interiorColorName);
            assertions.assertThat(jsonPath.getString("interiorColor.imageUrl")).isEqualTo(interiorColorImageUrl);
            assertions.assertThat(jsonPath.getString("interiorColor.type")).isEqualTo(interiorColorType);
            assertions.assertThat(response.jsonPath().getList("optionGroups.id")).usingRecursiveComparison()
                    .isEqualTo(carOptionGroupIds);
            assertions.assertThat(response.jsonPath().getList("optionGroups.name")).usingRecursiveComparison()
                    .isEqualTo(carOptionGroupName);
            assertions.assertThat(response.jsonPath().getList("optionGroups.additionalPrice"))
                    .usingRecursiveComparison()
                    .isEqualTo(additionalPrice);
            assertions.assertThat(response.jsonPath().getList("optionGroups.options.id")).usingRecursiveComparison()
                    .isEqualTo(optionIds);
            assertions.assertThat(response.jsonPath().getList("optionGroups.options.name")).usingRecursiveComparison()
                    .isEqualTo(optionNames);
            assertions.assertThat(response.jsonPath().getList("optionGroups.options.imageUrl"))
                    .usingRecursiveComparison()
                    .isEqualTo(optionImageUrls);
        }
    }

    public static ExtractableResponse<Response> 차량_견적_생성_요청(
            final long trimId,
            final List<Long> componentIds,
            final long exteriorId,
            final long interiorId,
            final List<Long> optionGroupIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("trimId").type(JsonFieldType.NUMBER).description("트림 ID"),
                                fieldWithPath("componentIds").type(JsonFieldType.ARRAY).description("차종 컴포넌트 ID 목록"),
                                fieldWithPath("exteriorId").type(JsonFieldType.NUMBER).description("차종 외장 색상 ID"),
                                fieldWithPath("interiorId").type(JsonFieldType.NUMBER).description("차종 내장 색상 ID"),
                                fieldWithPath("optionGroupIds").type(JsonFieldType.ARRAY).description("차종 옵션 그룹 ID 목록")
                        )
                ))
                .log().all()
                .when()
                .body(
                        Map.of(
                                "trimId", trimId,
                                "componentIds", componentIds,
                                "exteriorId", exteriorId,
                                "interiorId", interiorId,
                                "optionGroupIds", optionGroupIds
                        )
                )
                .contentType(ContentType.JSON)
                .post("/api/estimate")
                .then().log().all()
                .extract();
    }
}
