package com.poongcha.recommend.application.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AdditionalQuestionResponse {
    private Long id;
    private String topic;
    private String description;
    private List<AdditionalQuestionOptionNameResponse> options = new ArrayList<>();
}
