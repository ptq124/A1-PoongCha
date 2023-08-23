package com.poongcha.recommend.infra.client;

import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateClient implements CarContextClient {
    @Value("${module.car.protocol}")
    private String carModuleProtocol;
    @Value("${module.car.host}")
    private String carModuleHost;
    @Value("${module.car.port}")
    private int port;

    @Override
    public ResponseEntity<String> findEstimate(final CarEstimateCode carEstimateCode) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(
                carModuleProtocol + "://" + carModuleHost + ":" + port + "/estimate/" + carEstimateCode.getValue(),
                String.class
        );
    }
}
