package com.poongcha.recommend.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LifestylePersonaProfileResponse {
    private String name;
    private String imageUrl;
    private String introduction;
}
