package com.ssafy.seethrough.refrigerator.application.service;

import com.ssafy.seethrough.common.pagination.SliceRequestDto;
import com.ssafy.seethrough.common.pagination.SliceResponseDto;
import com.ssafy.seethrough.common.value.UUID;
import com.ssafy.seethrough.refrigerator.application.mapper.InventoryRepositoryDtoMapper;
import com.ssafy.seethrough.refrigerator.domain.Inventory;
import com.ssafy.seethrough.refrigerator.domain.InventoryRepository;
import com.ssafy.seethrough.refrigerator.presentation.dto.request.CreateInventoryRequest;
import com.ssafy.seethrough.refrigerator.presentation.dto.response.InventoryResponse;
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
     * @return
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

        return inventoryRepository.save(inventory);
    }
}
