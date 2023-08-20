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

public class CarOptionBrandSteps {
    public static ExtractableResponse<Response> 차량_옵션_브랜드_생성_요청(
            final String brandName,
            final String imageUrl,
            final long carOptionGroupId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("brandName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 설명"),
                                fieldWithPath("carOptionGroupId").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 ID"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 이미지")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "brandName", brandName,
                        "imageUrl", imageUrl,
                        "carOptionGroupId", carOptionGroupId
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group/{id}/brand", 1L)
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_브랜드_생성_응답_검증(
            final ExtractableResponse<Response> response,
            final String location
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }


    public static ExtractableResponse<Response> 존재하지_않는_차량_옵션_브랜드_생성_요청(
            final String imageUrl,
            final String brandName,
            final long carOptionGroupId
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("brandName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 설명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 이미지"),
                                fieldWithPath("carOptionGroupId").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 ID")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "brandName", brandName,
                        "imageUrl", imageUrl,
                        "carOptionGroupId", carOptionGroupId
                ))
                .contentType(ContentType.JSON)
                .post("/api/option-group/{id}/brand", 1231239183891283L)
                .then().log().all()
                .extract();
    }

    public static void 존재하지_않는_차량_옵션_브랜드_생성_응답_검증(final ExtractableResponse<Response> response) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static ExtractableResponse<Response> 차량_옵션_브랜드_ID_조회_요청(
            final long id
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차량 옵션 그룹 ID")
                        ),
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER)
                                        .description("차량 옵션 브랜드 ID"),
                                fieldWithPath("[].imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 이미지"),
                                fieldWithPath("[].brandName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 브랜드 설명")
                        )
                )).log().all()
                .when()
                .get("/api/option-group/{id}/brand", id)
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_브랜드_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final List<Integer> id,
            final List<String> imageUrl,
            final List<String> brandName
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getList("id")).usingRecursiveComparison()
                    .isEqualTo(id);
            assertions.assertThat(response.jsonPath().getList("imageUrl")).usingRecursiveComparison()
                    .isEqualTo(imageUrl);
            assertions.assertThat(response.jsonPath().getList("brandName")).usingDefaultComparator()
                    .isEqualTo(brandName);
        }
    }
}
