package com.poongcha.car.application.caroption.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarOptionResponse {
    private long id;
    private String name;
    private String imageUrl;
    private String detailDescription;
    private String installationLocation;
}
