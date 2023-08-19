package com.poongcha.car.application.caroptiontag;

import com.poongcha.car.application.dto.CarOptionTagResponse;
import com.poongcha.car.domain.caroptiontag.CarOptionTag;
import com.poongcha.car.domain.caroptiontag.CarOptionTagRepository;
import com.poongcha.car.exception.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CarOptionTagQueryService {
    private final CarOptionTagRepository carOptionTagRepository;
    private final CarOptionTagMapper carOptionTagMapper;

    public CarOptionTagResponse findById(final long id) {
        CarOptionTag carOptionTag = carOptionTagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("차량 옵션 태그를 찾을 수 없습니다."));

        return carOptionTagMapper.toCarOptionTagResponse(carOptionTag);
    }

    public List<CarOptionTagResponse> findAll() {
        List<CarOptionTag> carOptionTags = carOptionTagRepository.findAll();

        return carOptionTags.stream()
                .map(carOptionTagMapper::toCarOptionTagResponse)
                .collect(Collectors.toUnmodifiableList());
    }
}
