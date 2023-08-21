package com.poongcha.recommend.acceptance;

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

public class AdditionalQuestionSteps {
    public static void 추가_질문_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 추가_질문_생성_요청(
            final String topic,
            final String description,
            final List<String> additionalQuestionOptionNames
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("topic").type(JsonFieldType.STRING).description("질문 제목"),
                                fieldWithPath("description").type(JsonFieldType.STRING).description("질문 설명"),
                                fieldWithPath("options").type(JsonFieldType.ARRAY).description("질문 선택지 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "topic", topic,
                        "description", description,
                        "options", additionalQuestionOptionNames
                ))
                .contentType(ContentType.JSON)
                .post("/question")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 추가_질문_ID_조회_요청(final long id) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("추가 질문 ID")
                        ),
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("추가 질문 ID"),
                                fieldWithPath("topic").type(JsonFieldType.STRING).description("질문 제목"),
                                fieldWithPath("description").type(JsonFieldType.STRING).description("질문 설명"),
                                fieldWithPath("options").type(JsonFieldType.ARRAY).description("질문 선택지 목록"),
                                fieldWithPath("options[].id").type(JsonFieldType.NUMBER).description("질문 선택지 ID"),
                                fieldWithPath("options[].name").type(JsonFieldType.STRING).description("질문 선택지 이름")
                        )
                )).log().all()
                .when()
                .get("/question/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 추가_질문_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final long id,
            final String topic,
            final String description,
            final Integer[] optionIds,
            final String[] optionNames
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getLong("id")).isEqualTo(id);
            assertions.assertThat(response.jsonPath().getString("topic")).isEqualTo(topic);
            assertions.assertThat(response.jsonPath().getString("description")).isEqualTo(description);
            assertions.assertThat(response.jsonPath().getList("options.id")).contains(optionIds);
            assertions.assertThat(response.jsonPath().getList("options.name")).contains(optionNames);
        }
    }
}
