package com.poongcha.recommend.application.lifestylepersona;

import com.poongcha.recommend.application.dto.LifestylePersonaCreateRequest;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersona;
import com.poongcha.recommend.domain.lifestylepersona.LifestylePersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class LifestylePersonaCommandService {
    private final LifestylePersonaRepository lifestylePersonaRepository;
    private final LifestylePersonaMapper lifestylePersonaMapper;

    public long create(final LifestylePersonaCreateRequest lifestylePersonaCreateRequest) {
        LifestylePersona lifestylePersona = lifestylePersonaMapper.toEntity(lifestylePersonaCreateRequest);

        return lifestylePersonaRepository.save(lifestylePersona).getId();
    }
}
