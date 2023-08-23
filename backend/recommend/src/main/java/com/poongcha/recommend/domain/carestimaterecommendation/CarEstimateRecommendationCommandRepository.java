package com.poongcha.recommend.domain.carestimaterecommendation;


import org.springframework.data.repository.Repository;

public interface CarEstimateRecommendationCommandRepository extends Repository<CarEstimateRecommendation, Long> {
    CarEstimateRecommendation save(final CarEstimateRecommendation carEstimateRecommendation);
}
