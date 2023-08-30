package com.poongcha.recommend.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import com.poongcha.recommend.domain.recommendationfeedback.FeedbackScore;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class RecommendationFeedbackSteps {

    public static ExtractableResponse<Response> 추천_피드백_생성_요청(
            final FeedbackScore feedbackScore,
            final long estimateId,
            final long additionalQuestionAnswerGroupId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("feedbackScore").type(JsonFieldType.STRING).description("피드백 점수"),
                                fieldWithPath("estimateId").type(JsonFieldType.NUMBER).description("견적 ID"),
                                fieldWithPath("additionalQuestionAnswerGroupId").type(JsonFieldType.NUMBER)
                                        .description("질문 응답 그룹 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "feedbackScore", feedbackScore,
                        "estimateId", estimateId,
                        "additionalQuestionAnswerGroupId", additionalQuestionAnswerGroupId
                ))
                .contentType(ContentType.JSON)
                .post("/feedback")
                .then().log().all()
                .extract();
    }

    public static void 추천_피드백_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 추천_피드백_ID_조회_요청(final long recommendationFeedbackId) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("추천 피드백 ID"),
                                fieldWithPath("feedbackScore").type(JsonFieldType.STRING).description("피드백 점수"),
                                fieldWithPath("estimateId").type(JsonFieldType.NUMBER).description("견적 ID"),
                                fieldWithPath("additionalQuestionAnswerGroupId").type(JsonFieldType.NUMBER)
                                        .description("질문 응답 그룹 ID")
                        )
                )).log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("/feedback/{id}", recommendationFeedbackId)
                .then().log().all()
                .extract();
    }

    public static void 추천_피드백_조회_검증(
            final ExtractableResponse<Response> response,
            final FeedbackScore feedbackScore,
            final Long estimateId,
            final Long additionalQuestionAnswerGroupId
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getString("feedbackScore")).isEqualTo(feedbackScore.name());
            assertions.assertThat(response.jsonPath().getLong("estimateId")).isEqualTo(estimateId);
            assertions.assertThat(response.jsonPath().getLong("additionalQuestionAnswerGroupId"))
                    .isEqualTo(additionalQuestionAnswerGroupId);
        }
    }
}
