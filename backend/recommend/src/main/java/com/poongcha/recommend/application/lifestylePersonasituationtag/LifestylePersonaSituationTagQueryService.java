package com.poongcha.recommend.application.lifestylePersonasituationtag;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagResponse;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTagRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LifestylePersonaSituationTagQueryService {
    private final LifestylePersonaSituationTagRepository lifestylePersonaSituationTagRepository;
    private final LifestylePersonaSituationTagMapper lifestylePersonaSituationTagMapper;

    public List<LifestylePersonaSituationTagResponse> findAll() {
        List<LifestylePersonaSituationTag> lifestylePersonaSituationTags = lifestylePersonaSituationTagRepository.findAll();

        return lifestylePersonaSituationTags.stream()
                .map(lifestylePersonaSituationTagMapper::toLifeStylePersonaSituationTagResponse)
                .collect(Collectors.toUnmodifiableList());
    }
}
