package com.ssafy.seethrough.refrigerator.presentation;

import com.ssafy.seethrough.common.pagination.SliceResponseDto;
import com.ssafy.seethrough.refrigerator.application.service.RefrigeratorService;
import com.ssafy.seethrough.refrigerator.presentation.dto.response.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/refrigerator")
public class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @GetMapping
    public ResponseEntity<SliceResponseDto<InventoryResponse>> getInventoryList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "inboundAt") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDirection
    ) {
        SliceResponseDto<InventoryResponse> responseList = refrigeratorService.getInventoryList(page, size, sortBy, sortDirection);

        return ResponseEntity.ok(responseList);
    }
}
