package com.poongcha.car.application;

import com.poongcha.car.application.dto.TrimDefaultResponse;
import com.poongcha.car.application.mapper.TrimMapper;
import com.poongcha.car.domain.Trim;
import com.poongcha.car.domain.TrimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TrimQueryService {
    private final TrimRepository trimRepository;
    private final TrimMapper trimMapper;

    public TrimDefaultResponse findById(final long id) {
        Trim trim = trimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Trim ID" + id + "가 존재하지 않습니다."));
        return trimMapper.toDefaultResponse(trim);
    }
}
