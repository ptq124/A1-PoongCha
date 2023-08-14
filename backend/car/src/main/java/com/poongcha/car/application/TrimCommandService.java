package com.poongcha.car.application;

import com.poongcha.car.application.dto.TrimCreateRequest;
import com.poongcha.car.application.mapper.TrimMapper;
import com.poongcha.car.domain.Trim;
import com.poongcha.car.domain.TrimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TrimCommandService {
    private final TrimRepository trimRepository;
    private final TrimMapper trimMapper;

    public long create(final TrimCreateRequest trimCreateRequest) {
        Trim trim = trimMapper.toEntity(trimCreateRequest);
        return trimRepository.save(trim).getId();
    }
}
