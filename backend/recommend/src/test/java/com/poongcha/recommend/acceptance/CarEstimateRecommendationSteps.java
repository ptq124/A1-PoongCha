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
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarEstimateRecommendationSteps {
    public static ExtractableResponse<Response> 추천_견적_생성_요청(
            final String estimateId,
            final List<Integer> additionalQuestionOptionIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("estimateCode").type(JsonFieldType.STRING).description("견적 코드"),
                                fieldWithPath("additionalQuestionOptionIds").type(JsonFieldType.ARRAY)
                                        .description("추가 질문 옵션 아이디 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "estimateCode", estimateId,
                        "additionalQuestionOptionIds", additionalQuestionOptionIds
                ))
                .contentType(ContentType.JSON)
                .post("/recommend")
                .then().log().all()
                .extract();
    }

    public static void 추천_견적_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }
}
