package com.poongcha.recommend.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class AdditionalQuestionAnswerSteps {
    public static ExtractableResponse<Response> 추가_질문_답변_생성_요청(
            final List<Integer> questionIds,
            final List<Integer> answerIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("answers").type(JsonFieldType.ARRAY).description("질문 답변 목록"),
                                fieldWithPath("answers[].questionId").type(JsonFieldType.NUMBER).description("질문 ID"),
                                fieldWithPath("answers[].answerId").type(JsonFieldType.NUMBER)
                                        .description("답변 순서 ID")
                        )
                )).log().all()
                .when()
                .body(createAnswers(questionIds, answerIds))
                .contentType(ContentType.JSON)
                .post("/answer")
                .then().log().all()
                .extract();
    }

    private static Map createAnswers(
            final List<Integer> questionIds,
            final List<Integer> answerIds
    ) {
        return Map.of("answers", IntStream.range(0, questionIds.size())
                .mapToObj(i -> Map.of(
                        "questionId", questionIds.get(i),
                        "answerId", answerIds.get(i)
                ))
                .collect(Collectors.toUnmodifiableList()));
    }


    public static void 추가_질문_답변_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }
}
