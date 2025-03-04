package com.ssafy.seethrough.refrigerator.presentation;

import com.ssafy.seethrough.common.pagination.SliceResponseDto;
import com.ssafy.seethrough.refrigerator.application.service.RefrigeratorService;
import com.ssafy.seethrough.refrigerator.presentation.dto.request.CreateInventoryRequest;
import com.ssafy.seethrough.refrigerator.presentation.dto.response.InventoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/refrigerator")
@Tag(name = "냉장고 관리", description = "냉장고 정보를 관리하는 API")
public class RefrigeratorController {

    private final RefrigeratorService refrigeratorService;

    @GetMapping
    @Operation(
        summary = "냉장고 식품 목록 조회",
        description = "시스템에 등록된 모든 냉장고 식품 목록을 페이지네이션을 적용하여 반환합니다."
    )
    public ResponseEntity<SliceResponseDto<InventoryResponse>> getInventoryList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(defaultValue = "inboundAt") String sortBy,
        @RequestParam(defaultValue = "DESC") String sortDirection
    ) {
        SliceResponseDto<InventoryResponse> responseList = refrigeratorService.getInventoryList(page, size, sortBy, sortDirection);

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    @Operation(
        summary = "냉장고 식품 입고",
        description = "시스템에 새로운 식품을 추가하여 성공 여부를 반환합니다."
    )
    public ResponseEntity<Boolean> createInventory(
        @RequestBody CreateInventoryRequest request
    ) {
        Boolean result = refrigeratorService.createInventory(request);

        return ResponseEntity.ok(result);
    }
}
