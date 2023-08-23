package com.poongcha.recommend.domain.carestimaterecommendation;

import com.poongcha.recommend.domain.additionalquestion.AdditionalQuestionOption;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.core.mapping.AggregateReference.IdOnlyAggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table("car_estimate_recommendation_question_options")
public class CarEstimateRecommendationQuestionOption {
    @Column("id")
    @Id
    private Long id;

    @Column("additional_question_option_id")
    private AggregateReference<AdditionalQuestionOption, Long> additionalQuestionOption;

    public CarEstimateRecommendationQuestionOption(final Long additionalQuestionOptionId) {
        this.additionalQuestionOption = new IdOnlyAggregateReference<>(additionalQuestionOptionId);
    }
}
