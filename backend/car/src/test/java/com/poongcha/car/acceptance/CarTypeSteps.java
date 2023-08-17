package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.customRequestFields;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
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

public class CarTypeSteps {
    public static ExtractableResponse<Response> 차종_생성_요청(final String car_type_name, final String image_url) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carTypeName").type(JsonFieldType.STRING).description("차종명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("차종 이미지 url")
                        )
                ))
                .log().all()
                .when()
                .body(
                        Map.of(
                                "carTypeName", car_type_name,
                                "imageUrl", image_url
                        )
                )
                .contentType(ContentType.JSON)
                .post("/api/car-type")
                .then().log().all()
                .extract();
    }

    public static void 차종_생성_응답_검증(final ExtractableResponse<Response> response, final String expectedLocation) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.headers().get(HttpHeaders.LOCATION).getValue()).isEqualTo(expectedLocation);
        }
    }

    public static ExtractableResponse<Response> 차종_ID_조회_요청(final long id) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("차종 ID"),
                                fieldWithPath("carTypeName").type(JsonFieldType.STRING).description("차종명"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("차종 이미지 url")
                        )
                ))
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("/api/car-type/{id}", id)
                .then().log().all()
                .extract();
    }

    public static void 차종_ID_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final long id,
            final String carTypeName,
            final String imageUrl
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getLong("id")).isEqualTo(id);
            assertions.assertThat(response.jsonPath().getString("carTypeName")).isEqualTo(carTypeName);
            assertions.assertThat(response.jsonPath().getString("imageUrl")).isEqualTo(imageUrl);
        }
    }

    public static ExtractableResponse<Response> 차종_전체_조회_요청() {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        responseFields(
                                fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("차종 ID"),
                                fieldWithPath("[].carTypeName").type(JsonFieldType.STRING).description("차종명"),
                                fieldWithPath("[].imageUrl").type(JsonFieldType.STRING).description("차종 이미지 url")
                        )
                ))
                .log().all()
                .when()
                .get("/api/car-type")
                .then().log().all()
                .extract();
    }

    public static void 차종_전체_조회_응답_검증(
            final ExtractableResponse<Response> response,
            final Long[] ids,
            final String[] carTypeNames,
            final String[] imageUrls
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
            assertions.assertThat(response.jsonPath().getList("id", Long.class))
                    .containsExactly(ids);
            assertions.assertThat(response.jsonPath().getList("carTypeName", String.class))
                    .containsExactly(carTypeNames);
            assertions.assertThat(response.jsonPath().getList("imageUrl", String.class))
                    .containsExactly(imageUrls);
        }
    }

    public static ExtractableResponse<Response> 차량_타입에_차량_컴포넌트_그룹_추가_요청(
            final long carTypeId,
            final List<Long> carComponentGroupIds
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        pathParameters(
                                parameterWithName("id").description("차종 ID")
                        ),
                        requestFields(
                                fieldWithPath("carComponentGroupIds").type(JsonFieldType.ARRAY)
                                        .description("차량 컴포넌트 그룹 ID 목록")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carComponentGroupIds", carComponentGroupIds
                ))
                .contentType(ContentType.JSON)
                .post("/api/car-type/{id}/component-group", carTypeId)
                .then().log().all()
                .extract();
    }

    public static void 차량_타입에_차량_컴포넌트_그룹_추가_응답_검증(
            final ExtractableResponse<Response> response,
            final String location
    ) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.headers().get(HttpHeaders.LOCATION).getValue()).isEqualTo(location);
        }
    }
}
