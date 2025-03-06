package com.seethrough.api.refrigerator.application.service;

import com.seethrough.api.common.pagination.SliceRequestDto;
import com.seethrough.api.common.pagination.SliceResponseDto;
import com.seethrough.api.common.value.UUID;
import com.seethrough.api.refrigerator.application.mapper.InventoryRepositoryDtoMapper;
import com.seethrough.api.refrigerator.domain.Inventory;
import com.seethrough.api.refrigerator.domain.InventoryRepository;
import com.seethrough.api.refrigerator.domain.MovementType;
import com.seethrough.api.refrigerator.domain.RefrigeratorLog;
import com.seethrough.api.refrigerator.presentation.dto.request.CreateInventoryRequest;
import com.seethrough.api.refrigerator.presentation.dto.response.InventoryResponse;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RefrigeratorService {

    private final InventoryRepository inventoryRepository;
    private final InventoryRepositoryDtoMapper inventoryRepositoryDtoMapper;

    /**
     * 페이지네이션에 맞게 냉장고 재고의 리스트 반환합니다.
     *
     * 최대 10명의 재고을 반환하며 Slice 형식으로 다음 값이 있는지를 SliceInfo에 함께 반환
     * @param page
     * @param size
     * @param sortBy
     * @param sortDirection
     * @return
     */
    public SliceResponseDto<InventoryResponse> getInventoryList(
        Integer page, Integer size, String sortBy, String sortDirection
    ) {
        // Slice 값 생성
        SliceRequestDto sliceRequestDto = SliceRequestDto.builder()
            .page(page)
            .size(size)
            .sortBy(sortBy)
            .sortDirection(sortDirection)
            .build();

        // Slice의 조건에 맞는 재고를 가져옵니다.
        Slice<Inventory> inventories = inventoryRepository.findInventories(sliceRequestDto.toPageable());

        // 페이지네이션 메타 데이터와 함께 반환합니다.
        return SliceResponseDto.of(inventories.map(inventoryRepositoryDtoMapper::toResponse));
    }

    /**
     * 새로운 재고를 추가하고 성공 여부를 반환합니다.
     *
     * @param request
     */
    @Transactional
    public Boolean createInventory(CreateInventoryRequest request) {
        // TODO: memberId가 members 테이블에 존재하는지 검증

        // TODO: foodCategoryId가 food_category 테이블에 존재하는지 검증

        Inventory inventory = Inventory.builder()
            .id(UUID.generateUUID())
            .memberId(new UUID(request.getMemberId()))
            .foodCategoriesId(request.getFoodCategoryId())
            .inboudAt(LocalDateTime.now())
            .build();

        //식품 입고
        inventoryRepository.save(inventory);

        //입고 로그 추가
        createLog(inventory.getId(), request);

        return true;
    }

    /**
     * 입고 로그를 추가합니다.
     *
     * @param request
     */
    private void createLog(UUID inventoryId, CreateInventoryRequest request) {
        RefrigeratorLog refrigeratorLog = RefrigeratorLog.builder()
            .refrigeratorInventoryId(inventoryId)
            .memberId(new UUID(request.getMemberId()))
            .movementType(MovementType.INBOUND)
            .createdAt(LocalDateTime.now())
            .build();

        inventoryRepository.saveInBoundLog(refrigeratorLog);
    }
}
