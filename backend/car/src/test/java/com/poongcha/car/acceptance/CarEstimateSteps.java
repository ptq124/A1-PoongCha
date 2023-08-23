package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarEstimateSteps {
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
                .post("/estimate")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 차량_견적_ID_조회_요청(final long id) {
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
                .get("/estimate/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 차량_견적_생성_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
        }
    }

    public static void 차량_견적_ID_조회_검증(
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
}
