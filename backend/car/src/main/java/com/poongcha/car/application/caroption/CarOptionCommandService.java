package com.poongcha.car.application.caroption;

import com.poongcha.car.application.caroption.dto.CarOptionCreateRequest;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroption.CarOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CarOptionCommandService {
    private final CarOptionRepository carOptionRepository;
    private final CarOptionMapper carOptionMapper;

    public long create(final CarOptionCreateRequest carOptionCreateRequest) {
        CarOption carOption = carOptionMapper.toEntity(carOptionCreateRequest);

        return carOptionRepository.save(carOption).getId();
    }
}
