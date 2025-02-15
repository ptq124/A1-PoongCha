package com.poongcha.car.presentation;

import com.poongcha.car.application.caroptiongrouptooltip.CarOptionGroupTooltipCommandService;
import com.poongcha.car.application.caroptiongrouptooltip.CarOptionGroupTooltipQueryService;
import com.poongcha.car.application.dto.CarOptionGroupTooltipCreateRequest;
import com.poongcha.car.application.dto.CarOptionGroupTooltipResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionGroupTooltipController {
    private final CarOptionGroupTooltipCommandService carOptionGroupTooltipCommandService;
    private final CarOptionGroupTooltipQueryService carOptionGroupTooltipQueryService;

    @PostMapping("/option-group/{id}/tooltip")
    public ResponseEntity<Void> create(
            @PathVariable("id") final long optionGroupId,
            @RequestBody CarOptionGroupTooltipCreateRequest carOptionGroupTooltipCreateRequest
    ) {
        long createCarOptionGroupTooltipId = carOptionGroupTooltipCommandService
                .create(optionGroupId, carOptionGroupTooltipCreateRequest);

        return ResponseEntity.created(
                URI.create("/option-group/" + optionGroupId + "/tooltip/" + createCarOptionGroupTooltipId)
        ).build();
    }

    @GetMapping("/option-group/{id}/tooltip")
    public ResponseEntity<CarOptionGroupTooltipResponse> findById(@PathVariable("id") final long optionGroupId) {
        return ResponseEntity.ok().body(carOptionGroupTooltipQueryService.findById(optionGroupId));
    }
}
