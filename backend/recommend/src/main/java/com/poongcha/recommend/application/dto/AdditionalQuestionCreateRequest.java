package com.poongcha.recommend.application.dto;


import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AdditionalQuestionCreateRequest {
    private String topic;
    private String description;
    private List<String> options;
}
