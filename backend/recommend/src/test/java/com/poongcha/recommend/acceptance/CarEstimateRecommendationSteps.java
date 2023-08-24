package com.poongcha.recommend.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
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

    public static ExtractableResponse<Response> 추가_질문_추천_견적_조회_요청(
            final Integer ageOptionId,
            final Integer personaId,
            final List<Integer> answerIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("age").type(JsonFieldType.NUMBER).description("나이 질문 ID"),
                                fieldWithPath("persona").type(JsonFieldType.NUMBER).description("페르소나 ID"),
                                fieldWithPath("answers").type(JsonFieldType.ARRAY).description("추가 질문 옵션 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "age", ageOptionId,
                        "persona", personaId,
                        "answers", answerIds
                ))
                .contentType(ContentType.JSON)
                .post("/recommend/estimate/question")
                .then().log().all()
                .extract();
    }

    public static void 추가_질문_추천_견적_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final String trimImageUrl,
            final int carTypeId,
            final String carTypeName,
            final int trimId,
            final String trimName,
            final int trimPrice,
            final List<Integer> componentIds,
            final List<String> componentNames,
            final List<Integer> componentPrices,
            final int exteriorId,
            final String exteriorName,
            final String exteriorImageUrl,
            final int interiorId,
            final String interiorName,
            final String interiorImageUrl,
            final List<Integer> optionIds,
            final List<String> optionName,
            final List<String> optionImageUrl,
            final List<Integer> optionPrice,
            final List<String> optionDescription
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            JsonPath jsonPath = response.jsonPath();
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(jsonPath.getLong("carType.id")).isEqualTo(carTypeId);
            assertions.assertThat(jsonPath.getString("carType.name")).isEqualTo(carTypeName);
            assertions.assertThat(jsonPath.getLong("trim.id")).isEqualTo(trimId);
            assertions.assertThat(jsonPath.getString("trim.imageUrl")).isEqualTo(trimImageUrl);
            assertions.assertThat(jsonPath.getString("trim.name")).isEqualTo(trimName);
            assertions.assertThat(jsonPath.getLong("trim.minPrice")).isEqualTo(trimPrice);
            assertions.assertThat(jsonPath.getList("components.id")).usingRecursiveComparison()
                    .isEqualTo(componentIds);
            assertions.assertThat(jsonPath.getList("components.name")).usingRecursiveComparison()
                    .isEqualTo(componentNames);
            assertions.assertThat(jsonPath.getList("components.additionalPrice")).usingRecursiveComparison()
                    .isEqualTo(componentPrices);
            assertions.assertThat(jsonPath.getLong("exteriorColor.id")).isEqualTo(exteriorId);
            assertions.assertThat(jsonPath.getString("exteriorColor.name")).isEqualTo(exteriorName);
            assertions.assertThat(jsonPath.getString("exteriorColor.imageUrl")).isEqualTo(exteriorImageUrl);
            assertions.assertThat(jsonPath.getLong("interiorColor.id")).isEqualTo(interiorId);
            assertions.assertThat(jsonPath.getString("interiorColor.name")).isEqualTo(interiorName);
            assertions.assertThat(jsonPath.getString("interiorColor.imageUrl")).isEqualTo(interiorImageUrl);
            assertions.assertThat(jsonPath.getList("optionGroups.id")).usingRecursiveComparison()
                    .isEqualTo(optionIds);
            assertions.assertThat(jsonPath.getList("optionGroups.name")).usingRecursiveComparison()
                    .isEqualTo(optionName);
            assertions.assertThat(jsonPath.getList("optionGroups.imageUrl")).usingRecursiveComparison()
                    .isEqualTo(optionImageUrl);
            assertions.assertThat(jsonPath.getList("optionGroups.price")).usingRecursiveComparison()
                    .isEqualTo(optionPrice);
            assertions.assertThat(jsonPath.getList("optionGroups.summaryDescription")).usingRecursiveComparison()
                    .isEqualTo(optionDescription);
        }
    }

    public static ExtractableResponse<Response> 퍼소나_추천_견적_조회_요청(
            final Integer ageOptionId,
            final Integer personaId,
            final List<Integer> answerIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("age").type(JsonFieldType.NUMBER).description("나이 질문 ID"),
                                fieldWithPath("persona").type(JsonFieldType.NUMBER).description("페르소나 ID"),
                                fieldWithPath("answers").type(JsonFieldType.ARRAY).description("추가 질문 옵션 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "age", ageOptionId,
                        "persona", personaId,
                        "answers", answerIds
                ))
                .contentType(ContentType.JSON)
                .post("/recommend/estimate/persona")
                .then().log().all()
                .extract();
    }

    public static void 퍼소나_추천_견적_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final String introduction,
            final String trimImageUrl,
            final int carTypeId,
            final String carTypeName,
            final int trimId,
            final String trimName,
            final int trimPrice,
            final List<Integer> componentIds,
            final List<String> componentNames,
            final List<Integer> componentPrices,
            final int exteriorId,
            final String exteriorName,
            final String exteriorImageUrl,
            final int interiorId,
            final String interiorName,
            final String interiorImageUrl,
            final List<Integer> optionIds,
            final List<String> optionName,
            final List<String> optionImageUrl,
            final List<Integer> optionPrice,
            final List<String> optionDescription
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            JsonPath jsonPath = response.jsonPath();
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(jsonPath.getString("introduction")).isEqualTo(introduction);
            assertions.assertThat(jsonPath.getLong("carType.id")).isEqualTo(carTypeId);
            assertions.assertThat(jsonPath.getString("carType.name")).isEqualTo(carTypeName);
            assertions.assertThat(jsonPath.getLong("trim.id")).isEqualTo(trimId);
            assertions.assertThat(jsonPath.getString("trim.imageUrl")).isEqualTo(trimImageUrl);
            assertions.assertThat(jsonPath.getString("trim.name")).isEqualTo(trimName);
            assertions.assertThat(jsonPath.getLong("trim.minPrice")).isEqualTo(trimPrice);
            assertions.assertThat(jsonPath.getList("components.id")).usingRecursiveComparison()
                    .isEqualTo(componentIds);
            assertions.assertThat(jsonPath.getList("components.name")).usingRecursiveComparison()
                    .isEqualTo(componentNames);
            assertions.assertThat(jsonPath.getList("components.additionalPrice")).usingRecursiveComparison()
                    .isEqualTo(componentPrices);
            assertions.assertThat(jsonPath.getLong("exteriorColor.id")).isEqualTo(exteriorId);
            assertions.assertThat(jsonPath.getString("exteriorColor.name")).isEqualTo(exteriorName);
            assertions.assertThat(jsonPath.getString("exteriorColor.imageUrl")).isEqualTo(exteriorImageUrl);
            assertions.assertThat(jsonPath.getLong("interiorColor.id")).isEqualTo(interiorId);
            assertions.assertThat(jsonPath.getString("interiorColor.name")).isEqualTo(interiorName);
            assertions.assertThat(jsonPath.getString("interiorColor.imageUrl")).isEqualTo(interiorImageUrl);
            assertions.assertThat(jsonPath.getList("optionGroups.id")).usingRecursiveComparison()
                    .isEqualTo(optionIds);
            assertions.assertThat(jsonPath.getList("optionGroups.name")).usingRecursiveComparison()
                    .isEqualTo(optionName);
            assertions.assertThat(jsonPath.getList("optionGroups.imageUrl")).usingRecursiveComparison()
                    .isEqualTo(optionImageUrl);
            assertions.assertThat(jsonPath.getList("optionGroups.price")).usingRecursiveComparison()
                    .isEqualTo(optionPrice);
            assertions.assertThat(jsonPath.getList("optionGroups.summaryDescription")).usingRecursiveComparison()
                    .isEqualTo(optionDescription);
        }
    }
}
