package com.poongcha.car.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonInclude(Include.NON_NULL)
@RequiredArgsConstructor
public class CarColorDefaultResponse {
    private final long id;
    private final String name;
    private final String image;
    private final String type;
    private final String trimExteriorImageUrl;
    private final String trimInteriorImageUrl;
    private final String trimRotationImageBaseUrl;
    private final List<Long> incompatibleColorIds;
}
