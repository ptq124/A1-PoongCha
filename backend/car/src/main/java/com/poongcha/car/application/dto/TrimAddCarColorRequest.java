package com.poongcha.car.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TrimAddCarColorRequest {
    private long colorId;
    private String trimExteriorImageUrl;
    private String trimInteriorImageUrl;
    private String trimRotationImageBaseUrl;
}
