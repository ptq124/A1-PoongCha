package com.poongcha.recommend.application.carestimaterecommandation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poongcha.recommend.application.dto.CarEstimateRecommendationCreateRequest;
import com.poongcha.recommend.application.dto.CarRecommendEstimateColorResponse;
import com.poongcha.recommend.application.dto.CarRecommendEstimateOptionResponse;
import com.poongcha.recommend.application.dto.CarRecommendPersonaEstimateResponse;
import com.poongcha.recommend.application.dto.CarRecommendQuestionEstimateResponse;
import com.poongcha.recommend.application.dto.CarRecommendEstimateTrimResponse;
import com.poongcha.recommend.application.dto.CarRecommendationEstimateCarTypeResponse;
import com.poongcha.recommend.application.dto.CarRecommendationEstimateComponentResponse;
import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateCode;
import com.poongcha.recommend.domain.carestimaterecommendation.CarEstimateRecommendation;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CarEstimateRecommendationMapper {
    public CarEstimateRecommendation toEntity(
            final CarEstimateRecommendationCreateRequest carEstimateRecommendationCreateRequest
    ) {
        return new CarEstimateRecommendation(
                new CarEstimateCode(carEstimateRecommendationCreateRequest.getEstimateCode()),
                carEstimateRecommendationCreateRequest.getAdditionalQuestionOptionIds()
        );
    }

    public CarRecommendQuestionEstimateResponse toCarRecommendQuestionEstimateResponse(
            final ResponseEntity<String> carEstimateResponse,
            final List<AdditionalQuestionOption> additionalQuestionOptions
    ) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(carEstimateResponse.getBody());
            return new CarRecommendQuestionEstimateResponse(
                    getTags(additionalQuestionOptions),
                    new CarRecommendationEstimateCarTypeResponse(
                            jsonNode.path("carType").get("id").longValue(),
                            jsonNode.path("carType").get("name").textValue()
                    ),
                    getTrim(jsonNode),
                    getComponentResponses(jsonNode),
                    getExteriorColor(jsonNode),
                    getInteriorColor(jsonNode),
                    getOptionResponses(jsonNode)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("추천 견적 조회에 실패했습니다.");
        }
    }

    public CarRecommendPersonaEstimateResponse toCarRecommendPersonaEstimateResponse(
            final LifestylePersona lifestylePersona,
            final ResponseEntity<String> carEstimateResponse
    ) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(carEstimateResponse.getBody());
            return new CarRecommendPersonaEstimateResponse(
                    lifestylePersona.getLifestylePersonaProfile().getIntroduction(),
                    new CarRecommendationEstimateCarTypeResponse(
                            jsonNode.path("carType").get("id").longValue(),
                            jsonNode.path("carType").get("name").textValue()
                    ),
                    getTrim(jsonNode),
                    getComponentResponses(jsonNode),
                    getExteriorColor(jsonNode),
                    getInteriorColor(jsonNode),
                    getOptionResponses(jsonNode)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("추천 견적 조회에 실패했습니다.");
        }
    }

    private List<String> getTags(final List<AdditionalQuestionOption> additionalQuestionOptions) {
        return additionalQuestionOptions.stream()
                .map(
                        additionalQuestionOption -> additionalQuestionOption.getAdditionalQuestionOptionName()
                                .getValue()
                )
                .collect(Collectors.toUnmodifiableList());
    }

    private List<CarRecommendationEstimateComponentResponse> getComponentResponses(
            final JsonNode jsonNode) {
        List<CarRecommendationEstimateComponentResponse> componentResponses = new ArrayList<>();
        for (JsonNode componentNode : jsonNode.path("components")) {
            componentResponses.add(new CarRecommendationEstimateComponentResponse(
                    componentNode.get("id").longValue(),
                    componentNode.get("name").textValue(),
                    componentNode.get("additionalPrice").longValue()
            ));
        }
        return componentResponses;
    }

    private List<CarRecommendEstimateOptionResponse> getOptionResponses(
            final JsonNode jsonNode) {
        List<CarRecommendEstimateOptionResponse> optionResponses = new ArrayList<>();
        for (JsonNode componentNode : jsonNode.path("optionGroups")) {
            optionResponses.add(new CarRecommendEstimateOptionResponse(
                    componentNode.get("id").longValue(),
                    componentNode.get("name").textValue(),
                    componentNode.get("options").get(0).path("imageUrl").textValue(),
                    componentNode.get("additionalPrice").longValue(),
                    componentNode.get("summaryDescription").textValue()
            ));
        }
        return optionResponses;
    }

    private CarRecommendEstimateTrimResponse getTrim(final JsonNode jsonNode) {
        return new CarRecommendEstimateTrimResponse(
                jsonNode.path("trim").get("id").longValue(),
                jsonNode.path("trim").get("name").textValue(),
                jsonNode.path("trim").get("imageUrl").textValue(),
                jsonNode.path("trim").get("minPrice").longValue()
        );
    }

    private CarRecommendEstimateColorResponse getInteriorColor(final JsonNode jsonNode) {
        return new CarRecommendEstimateColorResponse(
                jsonNode.path("interiorColor").get("id").longValue(),
                jsonNode.path("interiorColor").get("name").textValue(),
                jsonNode.path("interiorColor").get("imageUrl").textValue()
        );
    }

    private CarRecommendEstimateColorResponse getExteriorColor(final JsonNode jsonNode) {
        return new CarRecommendEstimateColorResponse(
                jsonNode.path("exteriorColor").get("id").longValue(),
                jsonNode.path("exteriorColor").get("name").textValue(),
                jsonNode.path("exteriorColor").get("imageUrl").textValue()
        );
    }
}
