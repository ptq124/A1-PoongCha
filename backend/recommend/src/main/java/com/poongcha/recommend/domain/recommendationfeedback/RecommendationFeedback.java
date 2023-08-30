package com.poongcha.recommend.domain.recommendationfeedback;

import com.poongcha.recommend.domain.additionalquestionanswer.AdditionalQuestionAnswerGroup;
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
@Table(name = "recommendation_feedbacks")
public class RecommendationFeedback {
    @Column("id")
    @Id
    private Long id;

    @Column("feedback_score")
    private FeedbackScore feedbackScore;

    @Column("estimate_id")
    private Long estimateId;

    @Column("additional_question_answer_group_id")
    private AggregateReference<AdditionalQuestionAnswerGroup, Long> additionalQuestionAnswerGroup;

    public RecommendationFeedback(
            final FeedbackScore feedbackScore,
            final Long estimateId,
            final Long additionalQuestionAnswerGroupId
    ) {
        this.feedbackScore = feedbackScore;
        this.estimateId = estimateId;
        this.additionalQuestionAnswerGroup = new IdOnlyAggregateReference<>(additionalQuestionAnswerGroupId);
    }
}
