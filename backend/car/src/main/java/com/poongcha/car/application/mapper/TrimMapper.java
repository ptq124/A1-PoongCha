package com.poongcha.car.application.mapper;

import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.dto.TrimDefaultResponse;
import com.poongcha.car.domain.Trim;
import org.springframework.stereotype.Component;

@Component
public class TrimMapper {
    public Trim toEntity(final TrimCreateRequest trimCreateRequest) {
        return new Trim(
                trimCreateRequest.getTrimName(),
                trimCreateRequest.getImageUrl(),
                trimCreateRequest.getMinPrice(),
                trimCreateRequest.getCarTypeId()
        );
    }

    public TrimDefaultResponse toDefaultResponse(final Trim trim) {
        return new TrimDefaultResponse(
                trim.getId(),
                trim.getTrimName().getValue(),
                trim.getImageUrl().getValue(),
                trim.getMinPrice().getValue(),
                trim.getCarType().getId()
        );
    }
}
