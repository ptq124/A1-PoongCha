package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static com.poongcha.car.util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static com.poongcha.car.util.DocumentationTest.customRequestFields;
import static com.poongcha.car.util.DocumentationTest.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
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
}
