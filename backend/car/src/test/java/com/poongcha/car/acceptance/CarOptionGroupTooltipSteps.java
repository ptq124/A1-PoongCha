package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.customRequestFields;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
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

public class CarOptionGroupTooltipSteps {
    public static ExtractableResponse<Response> 차량_옵션_툴팁_생성_요청(
            final String imageUrl,
            final String tooltipDescription,
            final long carOptionGroupId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 이미지"),
                                fieldWithPath("tooltipDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 설명"),
                                fieldWithPath("carOptionGroupId").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "imageUrl", imageUrl,
                        "tooltipDescription", tooltipDescription,
                        "carOptionGroupId", carOptionGroupId
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group/{id}/tooltip", 1L)
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_툴팁_생성_응답_검증(
            final ExtractableResponse<Response> response,
            final String location
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }


    public static ExtractableResponse<Response> 존재하지_않는_차량_옵션_툴팁_생성_요청(
            final String imageUrl,
            final String tooltipDescription,
            final long carOptionGroupId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 이미지"),
                                fieldWithPath("tooltipDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 설명"),
                                fieldWithPath("carOptionGroupId").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "imageUrl", imageUrl,
                        "tooltipDescription", tooltipDescription,
                        "carOptionGroupId", carOptionGroupId
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group/{id}/tooltip", 1231239183891283L)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차량_옵션_툴팁_생성_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static ExtractableResponse<Response> 차량_옵션_툴팁_ID_조회_요청(
            final long id,
            final long carOptionGroupTooltipId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 옵션 그룹 ID"),
                                parameterWithName("tooltip-id").description("차량 옵션 툴팁 ID")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 툴팁 ID"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 이미지"),
                                fieldWithPath("tooltipDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 툴팁 설명")
                        )
                )).log().all()
                .when()
                .pathParam("id", id)
                .pathParam("tooltip-id", carOptionGroupTooltipId)
                .get("/api/option-group/{id}/tooltip/{tooltip-id}", id, carOptionGroupTooltipId)
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_툴팁_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final long id,
            final String imageUrl,
            final String description
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getLong("id")).isEqualTo(id);
            assertions.assertThat(response.jsonPath().getString("imageUrl")).isEqualTo(imageUrl);
            assertions.assertThat(response.jsonPath().getString("tooltipDescription")).isEqualTo(description);
        }
    }
}
