package com.poongcha.car.application.mapper;

import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.domain.ImageUrl;
import com.poongcha.car.domain.Trim;
import com.poongcha.car.domain.TrimName;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.stereotype.Component;

@Component
public class TrimMapper {
    public Trim toEntity(final TrimCreateRequest trimCreateRequest) {
        return new Trim(
                new TrimName(trimCreateRequest.getTrimName()),
                new ImageUrl(trimCreateRequest.getImageUrl()),
                new IdOnlyAggregateReference<>(trimCreateRequest.getCarTypeId())
        );
    }
}
