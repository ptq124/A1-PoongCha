package com.poongcha.recommend.application.lifestylepersona;

import com.poongcha.recommend.application.dto.LifestylePersonaResponse;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaRepository;
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
public class LifestylePersonaQueryService {
    private final LifestylePersonaRepository lifestylePersonaRepository;
    private final LifestylePersonaSituationTagRepository lifestylePersonaSituationTagRepository;
    private final LifestylePersonaMapper lifestylePersonaMapper;

    public List<LifestylePersonaResponse> findAll() {
        return lifestylePersonaRepository.findAll().stream()
                .map(lifestylePersona -> {
                    List<LifestylePersonaSituationTag> tags = lifestylePersonaSituationTagRepository.findAllByIdIn(
                            lifestylePersona.lifestylePersonaSituationTagIds()
                    );
                    return lifestylePersonaMapper.toLifeStylePersonResponse(
                            lifestylePersona,
                            tags
                    );
                }).collect(Collectors.toUnmodifiableList());
    }
}
