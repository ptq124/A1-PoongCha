package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarComponentSteps {
    public static ExtractableResponse<Response> 차량_컴포넌트_그룹_생성_요청(
            final String carComponentGroupName,
            final String selectionHelpTooltip
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        requestFields(
                                fieldWithPath("carComponentGroupName").type(JsonFieldType.STRING)
                                        .description("차량 컴포넌트 그룹 이름"),
                                fieldWithPath("selectionHelpTooltip").type(JsonFieldType.STRING)
                                        .description("선택 도움말")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carComponentGroupName", carComponentGroupName,
                        "selectionHelpTooltip", selectionHelpTooltip
                ))
                .contentType(ContentType.JSON)
                .post("/api/component-group")
                .then().log().all()
                .extract();
    }

    public static void 차량_컴포넌트_그룹_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 차량_컴포넌트_생성_요청(
            final String carComponentName,
            final String descriptionImageUrl,
            final int additionalPrice
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        requestFields(
                                fieldWithPath("carComponentName").type(JsonFieldType.STRING)
                                        .description("차량 컴포넌트 이름"),
                                fieldWithPath("descriptionImageUrl").type(JsonFieldType.STRING)
                                        .description("설명 이미지 URL"),
                                fieldWithPath("additionalPrice").type(JsonFieldType.NUMBER)
                                        .description("컴포넌트 추가금")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carComponentName", carComponentName,
                        "descriptionImageUrl", descriptionImageUrl,
                        "additionalPrice", additionalPrice
                ))
                .contentType(ContentType.JSON)
                .post("/api/component")
                .then().log().all()
                .extract();
    }

    public static void 차량_컴포넌트_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 차량_컴포넌트_그룹에_차량_컴포넌트_추가_요청(
            final long carComponentGroupId,
            final List<Long> carComponentIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 컴포넌트 그룹 ID")
                        ),
                        requestFields(
                                fieldWithPath("carComponentIds").type(JsonFieldType.ARRAY).description("차량 컴포넌트 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carComponentIds", carComponentIds
                ))
                .contentType(ContentType.JSON)
                .post("/api/component-group/{id}", carComponentGroupId)
                .then().log().all()
                .extract();
    }

    public static void 차량_컴포넌트_그룹에_차량_컴포넌트_추가_응답_검증(
            final ExtractableResponse<Response> response,
            final String location
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }
}
