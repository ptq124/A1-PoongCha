package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.customRequestFields;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarOptionGroupSteps {
    public static ExtractableResponse<Response> 차량_옵션_그룹_생성_요청(
            final String carOptionGroupName,
            final long additionalPrice,
            final String summaryDescription,
            final long[] ids
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carOptionGroupName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 그룹 이름"),
                                fieldWithPath("additionalPrice").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 그룹 가격"),
                                fieldWithPath("summaryDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 그룹 설명"),
                                fieldWithPath("carOptionIds").type(JsonFieldType.ARRAY)
                                        .description("차량 옵션 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carOptionGroupName", carOptionGroupName,
                        "additionalPrice", additionalPrice,
                        "summaryDescription", summaryDescription,
                        "carOptionIds", ids
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group")
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_그룹_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_요청(
            final String carOptionGroupName,
            final long additionalPrice,
            final String summaryDescription,
            final long[] ids
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carOptionGroupName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 그룹 이름"),
                                fieldWithPath("additionalPrice").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 그룹 가격"),
                                fieldWithPath("summaryDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 그룹 설명"),
                                fieldWithPath("carOptionIds").type(JsonFieldType.ARRAY)
                                        .description("차량 옵션 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carOptionGroupName", carOptionGroupName,
                        "additionalPrice", additionalPrice,
                        "summaryDescription", summaryDescription,
                        "carOptionIds", ids
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group")
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차량_옵션_ID로_차량_옵션_그룹_생성_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }
}
