package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarOptionTagSteps {
    public static ExtractableResponse<Response> 차량_옵션_태그_생성_요청(
            final String tagName,
            final String situationImageUrl,
            final String iconImageUrl
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 설명"),
                                fieldWithPath("situationImageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 상황 이미지"),
                                fieldWithPath("iconImageUrl").type(JsonFieldType.STRING).description("아이콘 이미지 URL")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "name", tagName,
                        "situationImageUrl", situationImageUrl,
                        "iconImageUrl", iconImageUrl
                ))
                .contentType(ContentType.JSON)
                .post("/option-tag")
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_태그_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 차량_옵션_태그_ID_조회_요청(final long id) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 옵션 태그 ID")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 태그 ID"),
                                fieldWithPath("name").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 설명"),
                                fieldWithPath("situationImageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 상황 이미지"),
                                fieldWithPath("iconImageUrl").type(JsonFieldType.STRING).description("아이콘 이미지 URL")
                        )
                )).log().all()
                .when()
                .get("/option-tag/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_태그_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final long id,
            final String tagName,
            final String situationImageUrl,
            final String iconImageUrl
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getLong("id")).isEqualTo(id);
            assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(tagName);
            assertions.assertThat(response.jsonPath().getString("situationImageUrl")).isEqualTo(situationImageUrl);
            assertions.assertThat(response.jsonPath().getString("iconImageUrl")).isEqualTo(iconImageUrl);
        }
    }

    public static ExtractableResponse<Response> 차량_옵션_태그_목록_조회_요청() {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 태그 ID"),
                                fieldWithPath("[].name").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 설명"),
                                fieldWithPath("[].situationImageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 태그 상황 이미지"),
                                fieldWithPath("[].iconImageUrl").type(JsonFieldType.STRING).description("아이콘 이미지 URL")
                        )
                )).log().all()
                .when()
                .get("/option-tag")
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_태그_목록_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final List<Integer> ids,
            final List<String> tagNames,
            final List<String> situationImageUrls,
            final List<String> iconImageUrls
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getList("id")).usingRecursiveComparison()
                    .isEqualTo(ids);
            assertions.assertThat(response.jsonPath().getList("name")).usingRecursiveComparison()
                    .isEqualTo(tagNames);
            assertions.assertThat(response.jsonPath().getList("situationImageUrl")).usingRecursiveComparison()
                    .isEqualTo(situationImageUrls);
            assertions.assertThat(response.jsonPath().getList("iconImageUrl")).usingRecursiveComparison()
                    .isEqualTo(iconImageUrls);
        }
    }
}
