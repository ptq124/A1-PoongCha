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

public class CarColorSteps {
    public static ExtractableResponse<Response> 차량_색상_생성_요청(
            final String carColorName,
            final String imageUrl,
            final String carColorType
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carColorName").type(JsonFieldType.STRING).description("차량 색상 이름"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING).description("차량 색상 이미지 URL"),
                                fieldWithPath("carColorType").type(JsonFieldType.STRING).description("차량 색상 타입")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carColorName", carColorName,
                        "imageUrl", imageUrl,
                        "carColorType", carColorType
                ))
                .contentType(ContentType.JSON)
                .post("/api/color")
                .then().log().all()
                .extract();
    }

    public static void 차량_색상_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }
}
