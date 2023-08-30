package com.poongcha.car.presentation;

import com.poongcha.car.application.caroptiongroup.CarOptionGroupCommandService;
import com.poongcha.car.application.caroptiongroup.CarOptionGroupQueryService;
import com.poongcha.car.application.dto.CarOptionGroupCreateRequest;
import com.poongcha.car.application.dto.CarOptionGroupResponse;
import com.poongcha.car.application.dto.OptionGroupAddIncompatibleOptionGroupRequest;
import com.poongcha.car.application.dto.OptionGroupAddOptionTagRequest;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionGroupController {
    private final CarOptionGroupCommandService carOptionGroupCommandService;
    private final CarOptionGroupQueryService carOptionGroupQueryService;

    @PostMapping("/option-group")
    public ResponseEntity<Void> createCarOptionGroup(
            @RequestBody final CarOptionGroupCreateRequest carOptionGroupCreateRequest
    ) {
        long createCarOptionGroupId = carOptionGroupCommandService.create(carOptionGroupCreateRequest);

        return ResponseEntity.created(URI.create("/option-group/" + createCarOptionGroupId)).build();
    }

    @GetMapping("/option-group")
    public ResponseEntity<List<CarOptionGroupResponse>> findAll() {
        return ResponseEntity.ok().body(carOptionGroupQueryService.findAll());
    }

    @GetMapping("/option-group/{id}")
    public ResponseEntity<CarOptionGroupResponse> findById(@PathVariable("id") final long carOptionGroupId) {
        return ResponseEntity.ok().body(carOptionGroupQueryService.findById(carOptionGroupId));
    }

    @PostMapping("/option-group/{id}/incompatible")
    public ResponseEntity<Void> createCarOptionGroup(
            @PathVariable("id") final long carOptionGroupId,
            @RequestBody final OptionGroupAddIncompatibleOptionGroupRequest optionGroupAddIncompatibleOptionGroupRequest
    ) {
        long createCarOptionGroupId = carOptionGroupCommandService.add(
                carOptionGroupId,
                optionGroupAddIncompatibleOptionGroupRequest
        );

        return ResponseEntity.created(URI.create("/option-group/" + createCarOptionGroupId)).build();
    }

    @PostMapping("/option-group/{id}/option-tag")
    public ResponseEntity<Void> createCarOptionGroup(
            @PathVariable("id") final long carOptionGroupId,
            @RequestBody final OptionGroupAddOptionTagRequest optionGroupAddOptionTagRequest
    ) {
        long createCarOptionGroupId = carOptionGroupCommandService.add(
                carOptionGroupId,
                optionGroupAddOptionTagRequest
        );

        return ResponseEntity.created(URI.create("/option-group/" + createCarOptionGroupId)).build();
    }
}
