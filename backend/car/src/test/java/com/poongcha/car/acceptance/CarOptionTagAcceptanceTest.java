package com.poongcha.car.acceptance;

import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_ID_조회_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_ID_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_목록_조회_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_목록_조회_응답_검증;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_생성_요청;
import static com.poongcha.car.acceptance.CarOptionTagSteps.차량_옵션_태그_생성_응답_검증;

import com.poongcha.car.util.CarAcceptanceTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 옵션 태그 관련 기능")
public class CarOptionTagAcceptanceTest extends CarAcceptanceTest {
    @DisplayName("차량 옵션 태그 생성 관련 기능")
    @Test
    void 차량_옵션_태그_생성() {
        // WHEN
        var response = 차량_옵션_태그_생성_요청(
                "차량 옵션 태그 이름",
                "www.naver.com/image/situation-tag.png",
                "www.naver.com/image/icon-image.png"
        );

        // THEN
        차량_옵션_태그_생성_응답_검증(response, "/api/option-tag/1");
    }

    @DisplayName("차량 옵션 태그 ID 조회")
    @Test
    void 차량_옵션_태그_ID_조회() {
        // GIVEN
        String tagName = "차량 옵션 태그 이름";
        String situationImageUrl = "www.naver.com/image/situation-tag.png";
        String iconImageUrl = "www.naver.com/image/icon-image.png";

        차량_옵션_태그_생성_요청(tagName, situationImageUrl, iconImageUrl);

        // WHEN
        var response = 차량_옵션_태그_ID_조회_요청(1L);

        // THEN
        차량_옵션_태그_ID_조회_응답_검증(response, 1L, tagName, situationImageUrl, iconImageUrl);
    }

    @DisplayName("차량 옵션 태그 전체 조회")
    @Test
    void 차량_옵션_태그_전체_조회() {
        // GIVEN
        String tagName = "차량 옵션 태그 이름";
        String situationImageUrl = "www.naver.com/image/situation-tag.png";
        String iconImageUrl = "www.naver.com/image/icon-image.png";
        차량_옵션_태그_생성_요청(tagName, situationImageUrl, iconImageUrl);
        String tagName2 = "차량 옵션 태그 이름2";
        String situationImageUrl2 = "www.naver.com/image/situation-tag2.png";
        String iconImageUrl2 = "www.naver.com/image/icon-image2.png";
        차량_옵션_태그_생성_요청(tagName2, situationImageUrl2, iconImageUrl2);

        // WHEN
        var response = 차량_옵션_태그_목록_조회_요청();

        // THEN
        차량_옵션_태그_목록_조회_응답_검증(
                response,
                List.of(1, 2),
                List.of(tagName, tagName2),
                List.of(situationImageUrl, situationImageUrl2),
                List.of(iconImageUrl, iconImageUrl2)
        );
    }
}
