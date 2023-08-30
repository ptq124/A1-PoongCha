package com.poongcha.recommend.util;

import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateCode;
import com.poongcha.recommend.infra.client.CarContextClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Primary
@Component
public class TestCarContextClient implements CarContextClient {
    @Override
    public ResponseEntity<String> findEstimate(final CarEstimateCode carEstimateCode) {
        return new ResponseEntity<>("{\n"
                + "    \"id\": 1,\n"
                + "    \"code\": \"" + carEstimateCode.getValue() + "\",\n"
                + "    \"carType\": {\n"
                + "        \"id\": 1,\n"
                + "        \"name\": \"palisade\",\n"
                + "        \"imageUrl\": \"https://www.hyundai.com/static/images/model/palisade/24my/mo/palisade_highlights_design_m.jpg\"\n"
                + "    },\n"
                + "    \"trim\": {\n"
                + "        \"id\": 1,\n"
                + "        \"name\": \"Le Blanc\",\n"
                + "        \"imageUrl\": \"https://www.hyundai.com/contents/vr360/LX06/trim/DS.png\",\n"
                + "        \"minPrice\": 48000000\n"
                + "    },\n"
                + "    \"components\": [\n"
                + "        {\n"
                + "            \"id\": 1,\n"
                + "            \"name\": \"4WD\",\n"
                + "            \"additionalPrice\": 2000000\n"
                + "        }\n"
                + "    ],\n"
                + "    \"exteriorColor\": {\n"
                + "        \"id\": 1,\n"
                + "        \"name\": \"green\",\n"
                + "        \"imageUrl\": \"www.naver.com/color/green.png\",\n"
                + "        \"type\": \"EXTERIOR\"\n"
                + "    },\n"
                + "    \"interiorColor\": {\n"
                + "        \"id\": 2,\n"
                + "        \"name\": \"red\",\n"
                + "        \"imageUrl\": \"www.naver.com/color/red.png\",\n"
                + "        \"type\": \"INTERIOR\"\n"
                + "    },\n"
                + "    \"optionGroups\": [\n"
                + "        {\n"
                + "            \"id\": 1,\n"
                + "            \"name\": \"컴포트 2\",\n"
                + "            \"additionalPrice\": 1000000,\n"
                + "            \"summaryDescription\": \"옵션 그룹 요약 문구\",\n"
                + "            \"options\": [\n"
                + "                {\n"
                + "                    \"id\": 1,\n"
                + "                    \"name\": \"후석 승객 알림\",\n"
                + "                    \"imageUrl\": \"www.naver.com/option/image.png\"\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 2,\n"
                + "                    \"name\": \"전방 추돌 방지 알림\",\n"
                + "                    \"imageUrl\": \"www.naver.com/option/image.png\"\n"
                + "                }\n"
                + "            ]\n"
                + "        }\n"
                + "    ]\n"
                + "}", HttpStatus.OK);
    }
}
