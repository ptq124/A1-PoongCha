package com.poongcha.car.config;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebConfigTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DisplayName("cors 설정 통과 테스트")
    @ParameterizedTest(name = "HOST : {0}")
    @ValueSource(strings = {"http://localhost:3000", "http://my-car.store"})
    void cors(String host) {
        RestAssured.given().log().all()
                .when()
                .header("Origin", host)
                .header("Access-Control-Request-Method", "POST")
                .options("/api/car-type")
                .then().log().all()
                .statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("cors 설정 실패 테스트")
    @ParameterizedTest(name = "HOST : {0}")
    @ValueSource(strings = {"http://localhost:9999", "http://naver.com"})
    void corsFail(String host) {
        RestAssured.given().log().all()
                .when()
                .header("Origin", host)
                .header("Access-Control-Request-Method", "POST")
                .options("/api/car-type")
                .then().log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
