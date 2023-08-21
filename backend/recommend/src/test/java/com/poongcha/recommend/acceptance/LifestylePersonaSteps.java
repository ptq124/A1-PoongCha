package com.poongcha.recommend.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
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

public class LifestylePersonaSteps {
    public static ExtractableResponse<Response> 라이프스타일_퍼소나_생성_요청(
            final String representativePhrase,
            final String profileImageUrl,
            final String profileName,
            final String profileIntroduction,
            final String coverImageUrl,
            final List<Map> interviews,
            final List<Integer> additionalQuestionOptionIds,
            final List<Integer> lifestylePersonaSituationTagIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        requestFields(
                                fieldWithPath("representativePhrase").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 대표 문구"),
                                fieldWithPath("profileImageUrl").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 프로필 이미지 URL"),
                                fieldWithPath("profileName").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 프로필 이름"),
                                fieldWithPath("profileIntroduction").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 소개 문구"),
                                fieldWithPath("coverImageUrl").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 표지 이미지 URL"),
                                fieldWithPath("interviews").type(JsonFieldType.ARRAY)
                                        .description("라이프스타일 퍼소나 인터뷰 목록"),
                                fieldWithPath("interviews[].question").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 인터뷰 질문"),
                                fieldWithPath("interviews[].answer").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 인터뷰 답변"),
                                fieldWithPath("additionalQuestionOptionIds").type(JsonFieldType.ARRAY)
                                        .description("라이프스타일 퍼소나 추가 질문 옵션 ID 목록"),
                                fieldWithPath("lifestylePersonaSituationTagIds").type(JsonFieldType.ARRAY)
                                        .description("라이프스타일 퍼소나 상황 태그 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "representativePhrase", representativePhrase,
                        "profileImageUrl", profileImageUrl,
                        "profileName", profileName,
                        "profileIntroduction", profileIntroduction,
                        "coverImageUrl", coverImageUrl,
                        "interviews", interviews,
                        "additionalQuestionOptionIds", additionalQuestionOptionIds,
                        "lifestylePersonaSituationTagIds", lifestylePersonaSituationTagIds
                ))
                .contentType(ContentType.JSON)
                .post("/lifestyle-persona")
                .then().log().all()
                .extract();
    }

    public static void 라이프스타일_퍼소나_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }

    public static ExtractableResponse<Response> 라이프스타일_퍼소나_전체_조회_요청() {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER)
                                        .description("라이프스타일 퍼소나 ID"),
                                fieldWithPath("[].representativePhrase").type(JsonFieldType.STRING)
                                        .description("라이프스타일 대표 문구"),
                                fieldWithPath("[].profile").type(JsonFieldType.OBJECT)
                                        .description("라이프스타일 퍼소나 프로필"),
                                fieldWithPath("[].profile.name").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 프로필 이름"),
                                fieldWithPath("[].profile.imageUrl").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 프로필 이미지 URL"),
                                fieldWithPath("[].profile.introduction").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 소개 문구"),
                                fieldWithPath("[].coverImageUrl").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 표지 이미지 URL"),
                                fieldWithPath("[].interviews").type(JsonFieldType.ARRAY)
                                        .description("라이프스타일 퍼소나 인터뷰 목록"),
                                fieldWithPath("[].interviews[].question").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 인터뷰 질문"),
                                fieldWithPath("[].interviews[].answer").type(JsonFieldType.STRING)
                                        .description("라이프스타일 퍼소나 인터뷰 답변"),
                                fieldWithPath("[].situationTags").type(JsonFieldType.ARRAY)
                                        .description("라이프스타일 퍼소나 상황 태그 이름 목록")
                        )
                )).log().all()
                .when()
                .get("/lifestyle-persona")
                .then().log().all()
                .extract();
    }

    public static void 라이프스타일_퍼소나_전체_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final List<String> representativePhrase,
            final List<String> profileImageUrl,
            final List<String> profileName,
            final List<String> profileIntroduction,
            final List<String> coverImageUrl,
            final List<String[]> lifestylePersonaSituationTagNames
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getList("representativePhrase")).usingRecursiveComparison()
                    .isEqualTo(representativePhrase);
            assertions.assertThat(response.jsonPath().getList("profile.name")).usingRecursiveComparison()
                    .isEqualTo(profileName);
            assertions.assertThat(response.jsonPath().getList("profile.imageUrl")).usingRecursiveComparison()
                    .isEqualTo(profileImageUrl);
            assertions.assertThat(response.jsonPath().getList("profile.introduction")).usingRecursiveComparison()
                    .isEqualTo(profileIntroduction);
            assertions.assertThat(response.jsonPath().getList("coverImageUrl")).usingRecursiveComparison()
                    .isEqualTo(coverImageUrl);
            assertions.assertThat(response.jsonPath().getList("situationTags[0]"))
                    .contains(lifestylePersonaSituationTagNames.get(0));
            assertions.assertThat(response.jsonPath().getList("situationTags[1]"))
                    .contains(lifestylePersonaSituationTagNames.get(1));
        }
    }
}
