package com.poongcha.recommend.domain.carestimaterecommendation;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface CarEstimateRecommendationRepository extends Repository<CarEstimateRecommendation, Long> {
    CarEstimateRecommendation save(final CarEstimateRecommendation carEstimateRecommendation);

    @Query(
            "select * "
                    + "from car_estimate_recommendations r join car_estimate_recommendation_question_options o "
                    + "where r.id = o.car_estimate_recommendation_id "
                    + "AND o.car_estimate_recommendation_id in (:questionOptionIds) limit 1"
    )
    Optional<CarEstimateRecommendation> findByCarEstimateRecommendationQuestionOptionIds(final List<Long> questionOptionIds);
}
