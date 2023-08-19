package com.poongcha.car.application.carestimate;

import com.poongcha.car.application.dto.CarEstimateCreateRequest;
import com.poongcha.car.domain.carestimate.CarEstimate;
import java.util.HashSet;
import org.springframework.stereotype.Component;

@Component
public class CarEstimateMapper {
    public CarEstimate toEntity(final CarEstimateCreateRequest carEstimateCreateRequest) {
        return new CarEstimate(
                carEstimateCreateRequest.getTrimId(),
                new HashSet<>(carEstimateCreateRequest.getComponentIds()),
                carEstimateCreateRequest.getExteriorId(),
                carEstimateCreateRequest.getInteriorId(),
                new HashSet<>(carEstimateCreateRequest.getOptionGroupIds())
        );
    }
}
