package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.customRequestFields;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class TrimSteps {
    public static ExtractableResponse<Response> 트림_생성_요청(
            final String trimName,
            final String imageUrl,
            final long minPrice,
            final long carTypeId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("trimName").type(JsonFieldType.STRING).description("트림명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("트림 이미지 URL"),
                                fieldWithPath("minPrice").type(JsonFieldType.NUMBER).description("트림 최소 가격"),
                                fieldWithPath("carTypeId").type(JsonFieldType.NUMBER).description("차종 ID")
                        )
                ))
                .log().all()
                .when()
                .body(
                        Map.of(
                                "trimName", trimName,
                                "imageUrl", imageUrl,
                                "minPrice", minPrice,
                                "carTypeId", carTypeId
                        )
                )
                .contentType(ContentType.JSON)
                .post("/api/trim")
                .then().log().all()
                .extract();
    }

    public static void 트림_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_차종으로_트림_생성_요청(
            final String trimName,
            final String imageUrl,
            final int minPrice,
            final long carTypeId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("trimName").type(JsonFieldType.STRING).description("트림명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("트림 이미지 URL"),
                                fieldWithPath("minPrice").type(JsonFieldType.NUMBER).description("트림 최소 가격"),
                                fieldWithPath("carTypeId").type(JsonFieldType.NUMBER).description("차종 ID")
                        )
                ))
                .log().all()
                .when()
                .body(
                        Map.of(
                                "trimName", trimName,
                                "imageUrl", imageUrl,
                                "minPrice", minPrice,
                                "carTypeId", carTypeId
                        )
                )
                .contentType(ContentType.JSON)
                .post("/api/trim")
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차종으로_트림_생성_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static ExtractableResponse<Response> 트림_ID_조회_요청(final long id) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("트림 ID"),
                                fieldWithPath("trimName").type(JsonFieldType.STRING).description("트림명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("트림 이미지 URL"),
                                fieldWithPath("minPrice").type(JsonFieldType.NUMBER).description("트림 최소 가격"),
                                fieldWithPath("carTypeId").type(JsonFieldType.NUMBER).description("차종 ID")
                        )
                ))
                .log().all()
                .when()
                .get("/api/trim/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 트림_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final long trimId,
            final String trimName,
            final String imageUrl,
            final long minPrice,
            final long carTypeId
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getLong("id")).isEqualTo(trimId);
            assertions.assertThat(response.jsonPath().getString("trimName")).isEqualTo(trimName);
            assertions.assertThat(response.jsonPath().getString("imageUrl")).isEqualTo(imageUrl);
            assertions.assertThat(response.jsonPath().getLong("minPrice")).isEqualTo(minPrice);
            assertions.assertThat(response.jsonPath().getLong("carTypeId")).isEqualTo(carTypeId);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_트림_ID_조회_요청(final long id) {
        return given()
                .filter(document(DEFAULT_RESTDOCS_PATH))
                .log().all()
                .when()
                .get("/api/trim/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_트림_ID_조회_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ExtractableResponse<Response> 차종_ID로_트림_목록_조회_요청(final long carTypeId) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("car-type-id").description("차종 ID")
                        ),
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("트림 ID"),
                                fieldWithPath("[].trimName").type(JsonFieldType.STRING).description("트림명"),
                                fieldWithPath("[].imageUrl").type(JsonFieldType.STRING).description("트림 이미지 URL"),
                                fieldWithPath("[].minPrice").type(JsonFieldType.NUMBER).description("트림 최소 가격"),
                                fieldWithPath("[].carTypeId").type(JsonFieldType.NUMBER).description("차종 ID")
                        )
                ))
                .log().all()
                .when()
                .get("/api/car-type/{car-type-id}/trim", carTypeId)
                .then().log().all()
                .extract();
    }

    public static void 차종_ID로_트림_목록_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final Long[] ids,
            final String[] trimNames,
            final String[] imageUrls,
            final Long[] minPrices,
            final Long[] carTypeIds
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getList("id", Long.class)).containsExactly(ids);
            assertions.assertThat(response.jsonPath().getList("trimName", String.class)).containsExactly(trimNames);
            assertions.assertThat(response.jsonPath().getList("imageUrl", String.class)).containsExactly(imageUrls);
            assertions.assertThat(response.jsonPath().getList("minPrice", Long.class)).containsExactly(minPrices);
            assertions.assertThat(response.jsonPath().getList("carTypeId", Long.class)).containsExactly(carTypeIds);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_차종_ID로_트림_목록_조회_요청(final long carTypeId) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("car-type-id").description("차종 ID")
                        )
                ))
                .log().all()
                .when()
                .get("/api/car-type/{car-type-id}/trim", carTypeId)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차종_ID로_트림_목록_조회_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ExtractableResponse<Response> 트림에_차량_색상_설정_요청(final long carColorId, final long trimId) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        requestFields(
                                fieldWithPath("colorId").type(JsonFieldType.NUMBER).description("차량 색상 ID")
                        )
                )).log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(Map.of(
                        "colorId", carColorId
                ))
                .post("/api/trim/{id}/color", trimId)
                .then().log().all()
                .extract();
    }

    public static void 트림에_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_트림에_차량_색상_설정_요청(final long carColorId, final long trimId) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        requestFields(
                                fieldWithPath("colorId").type(JsonFieldType.NUMBER).description("차량 색상 ID")
                        )
                )).log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(Map.of(
                        "colorId", carColorId
                ))
                .post("/api/trim/{id}/color", trimId)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_트림에_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }
}
