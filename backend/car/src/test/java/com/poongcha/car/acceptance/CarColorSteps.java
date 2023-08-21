package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarColorSteps {
    public static ExtractableResponse<Response> 차량_색상_생성_요청(
            final String carColorName,
            final String imageUrl,
            final String carColorType
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carColorName").type(JsonFieldType.STRING).description("차량 색상 이름"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("차량 색상 이미지 URL"),
                                fieldWithPath("carColorType").type(JsonFieldType.STRING).description("차량 색상 타입")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carColorName", carColorName,
                        "imageUrl", imageUrl,
                        "carColorType", carColorType
                ))
                .contentType(ContentType.JSON)
                .post("/color")
                .then().log().all()
                .extract();
    }

    public static void 차량_색상_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 양립_불가능한_차량_색상_설정_요청(
            final long carColorId,
            final long... incompatibleCarColor
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 색상 ID")
                        ),
                        customRequestFields(
                                fieldWithPath("ids").type(JsonFieldType.ARRAY).description("양립 불가능한 차량 색상 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "ids", incompatibleCarColor
                ))
                .contentType(ContentType.JSON)
                .post("/color/{id}/incompatible", carColorId)
                .then().log().all()
                .extract();
    }

    public static void 양립_불가능한_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_차량_색상에_양립_불가능한_차량_색상_설정_요청(
            final long carColorId,
            final Long... incompatibleIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 색상 ID")
                        ),
                        customRequestFields(
                                fieldWithPath("ids").type(JsonFieldType.ARRAY).description("양립 불가능한 차량 색상 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "ids", incompatibleIds
                ))
                .contentType(ContentType.JSON)
                .post("/color/{id}/incompatible", carColorId)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차량_색상에_양립_불가능한_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static ExtractableResponse<Response> 같은_ID로_양립_불가능한_차량_색상_설정_요청(
            final long carColorId,
            final long... sameColorId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 색상 ID")
                        ),
                        customRequestFields(
                                fieldWithPath("ids").type(JsonFieldType.ARRAY).description("양립 불가능한 차량 색상 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "ids", sameColorId
                ))
                .contentType(ContentType.JSON)
                .post("/color/{id}/incompatible", carColorId)
                .then().log().all()
                .extract();
    }

    public static void 같은_ID로_양립_불가능한_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static ExtractableResponse<Response> 같은_차량_색상_타입으로_양립_불가능한_차량_색상_설정_요청(
            final long carColorId,
            final long... sameColorId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 색상 ID")
                        ),
                        customRequestFields(
                                fieldWithPath("ids").type(JsonFieldType.ARRAY).description("양립 불가능한 차량 색상 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "ids", sameColorId
                ))
                .contentType(ContentType.JSON)
                .post("/color/{id}/incompatible", carColorId)
                .then().log().all()
                .extract();
    }

    public static void 같은_차량_색상_타입으로_양립_불가능한_차량_색상_설정_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }
}
