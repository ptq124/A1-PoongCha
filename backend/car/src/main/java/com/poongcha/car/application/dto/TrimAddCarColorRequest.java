package com.poongcha.car.application.dto;

import lombok.Getter;

@Getter
public class TrimAddCarColorRequest {
    private long colorId;

    public TrimAddCarColorRequest() {
    }

    public TrimAddCarColorRequest(final long colorId) {
        this.colorId = colorId;
    }
}
