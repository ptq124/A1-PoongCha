package com.poongcha.car.acceptance;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static util.DocumentationTest.DEFAULT_RESTDOCS_PATH;
import static util.DocumentationTest.customRequestFields;
import static util.DocumentationTest.given;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.springframework.restdocs.payload.JsonFieldType;

public class CarOptionSteps {
    public static ExtractableResponse<Response> 차량_옵션_생성_요청(
            final String carOptionName,
            final String imageUrl,
            final String installationLocation,
            final String detailDescription
    ) {
        return given()
                .filter(document(
                        DEFAULT_RESTDOCS_PATH,
                        customRequestFields(
                                fieldWithPath("carOptionName").type(JsonFieldType.STRING)
                                        .description("차량 옵션 이름"),
                                fieldWithPath("imageUrl").type(JsonFieldType.STRING)
                                        .description("차량 옵션 이미지 URL"),
                                fieldWithPath("installationLocation").type(JsonFieldType.STRING)
                                        .description("설치 위치"),
                                fieldWithPath("detailDescription").type(JsonFieldType.STRING)
                                        .description("차량 옵션 자세한 설명")
                        )
                )).log().all()
                .when()
                .body(Map.of(
                        "carOptionName", carOptionName,
                        "imageUrl", imageUrl,
                        "installationLocation", installationLocation,
                        "detailDescription", detailDescription
                ))
                .contentType(ContentType.JSON)
                .post("/api/option")
                .then().log().all()
                .extract();
    }

    public static void 차량_옵션_생성_응답_검증(final ExtractableResponse<Response> response, final String location) {
        try (AutoCloseableSoftAssertions assertions = new AutoCloseableSoftAssertions()) {
            assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
            assertions.assertThat(response.header(HttpHeaders.LOCATION)).isEqualTo(location);
        }
    }
}
