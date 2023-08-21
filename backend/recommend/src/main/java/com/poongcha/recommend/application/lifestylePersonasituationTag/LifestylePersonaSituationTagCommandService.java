package com.poongcha.recommend.application.lifestylePersonasituationTag;

import com.poongcha.recommend.application.dto.LifestylePersonaSituationTagCreateRequest;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTag;
import com.poongcha.recommend.domain.lifestylepersonasituationtag.LifestylePersonaSituationTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class LifestylePersonaSituationTagCommandService {
    private final LifestylePersonaSituationTagRepository lifestylePersonaSituationTagRepository;
    private final LifestylePersonaSituationTagMapper lifestylePersonaSituationTagMapper;

    public long create(final LifestylePersonaSituationTagCreateRequest lifestylePersonaSituationTagCreateRequest) {
        LifestylePersonaSituationTag lifestylePersonaSituationTag = lifestylePersonaSituationTagMapper.toEntity(
                lifestylePersonaSituationTagCreateRequest
        );

        return lifestylePersonaSituationTagRepository.save(lifestylePersonaSituationTag).getId();
    }
}
