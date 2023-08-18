package com.poongcha.car.presentation;

import com.poongcha.car.application.caroptiongrouptooltip.CarOptionGroupTooltipCommandService;
import com.poongcha.car.application.caroptiongrouptooltip.dto.CarOptionGroupTooltipCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarOptionGroupTooltipController {
    private final CarOptionGroupTooltipCommandService carOptionGroupTooltipCommandService;

    @PostMapping("/api/option-group/{id}/tooltip")
    public ResponseEntity<Void> create(
            @PathVariable("id") final long optionGroupId,
            @RequestBody CarOptionGroupTooltipCreateRequest carOptionGroupTooltipCreateRequest
    ) {
        long createCarOptionGroupTooltipId = carOptionGroupTooltipCommandService
                .create(optionGroupId, carOptionGroupTooltipCreateRequest);

        return ResponseEntity.created(
                URI.create("/api/option-group/" + optionGroupId + "/tooltip/" + createCarOptionGroupTooltipId)
        ).build();
    }
}
