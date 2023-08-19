package com.poongcha.car.application.caroptiongroup;

import com.poongcha.car.application.dto.CarOptionGroupResponse;
import com.poongcha.car.domain.caroption.CarOption;
import com.poongcha.car.domain.caroption.CarOptionRepository;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroup;
import com.poongcha.car.domain.caroptiongroup.CarOptionGroupRepository;
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
public class CarOptionGroupQueryService {
    private final CarOptionGroupRepository carOptionGroupRepository;
    private final CarOptionRepository carOptionRepository;
    private final CarOptionTagRepository carOptionTagRepository;
    private final CarOptionGroupMapper carOptionGroupMapper;

    public CarOptionGroupResponse findById(final long carOptionGroupId) {
        CarOptionGroup carOptionGroup = carOptionGroupRepository.findById(carOptionGroupId)
                .orElseThrow(() -> new NotFoundException("옵션 그룹을 찾을 수 없습니다."));

        List<CarOption> options = carOptionRepository.findAllByIdIn(carOptionGroup.optionIds());

        List<CarOptionTag> optionTags = carOptionTagRepository.findAllByIdIn(carOptionGroup.optionTagIds());

        return carOptionGroupMapper.toCarOptionGroupResponse(
                carOptionGroup,
                optionTags.stream()
                        .map(option -> option.getCarOptionTagName().getValue())
                        .collect(Collectors.toUnmodifiableList()),
                options
        );
    }

    public List<CarOptionGroupResponse> findAll() {
        return carOptionGroupRepository.findAll().stream()
                .map(carOptionGroup -> {
                    List<CarOption> options = carOptionRepository.findAllByIdIn(carOptionGroup.optionIds());
                    List<CarOptionTag> optionTags = carOptionTagRepository.findAllByIdIn(carOptionGroup.optionTagIds());
                    return carOptionGroupMapper.toCarOptionGroupResponse(
                            carOptionGroup,
                            optionTags.stream()
                                    .map(option -> option.getCarOptionTagName().getValue())
                                    .collect(Collectors.toUnmodifiableList()),
                            options
                    );
                }).collect(Collectors.toUnmodifiableList());
    }
}
