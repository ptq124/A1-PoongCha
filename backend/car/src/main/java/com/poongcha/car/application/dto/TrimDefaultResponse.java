package com.poongcha.car.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TrimDefaultResponse {
    private final long id;
    private final String trimName;
    private final String imageUrl;
    private final long minPrice;
    private final long carTypeId;
    private final List<TrimRepresentativeOptionGroupResponse> optionGroups;
}
