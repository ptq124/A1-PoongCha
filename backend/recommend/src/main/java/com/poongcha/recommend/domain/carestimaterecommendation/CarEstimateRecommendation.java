package com.poongcha.recommend.domain.carestimaterecommendation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "car_estimate_recommendations")
public class CarEstimateRecommendation {
    @Column("id")
    @Id
    private Long id;

    @Embedded.Nullable
    private CarEstimateCode carEstimateCode;

    @MappedCollection(idColumn = "car_estimate_recommendation_id")
    private Set<CarEstimateRecommendationQuestionOption> carEstimateRecommendationQuestionOptions = new HashSet<>();

    public CarEstimateRecommendation(
            final CarEstimateCode carEstimateCode,
            final List<Long> carEstimateRecommendationQuestionOptionIds
    ) {
        this.carEstimateCode = carEstimateCode;
        carEstimateRecommendationQuestionOptions.addAll(
                carEstimateRecommendationQuestionOptionIds.stream()
                        .map(CarEstimateRecommendationQuestionOption::new)
                        .collect(Collectors.toUnmodifiableList())
        );
    }
}
