package com.seethrough.api.refrigerator.application.mapper;

import com.seethrough.api.refrigerator.domain.Inventory;
import com.seethrough.api.refrigerator.presentation.dto.response.InventoryResponse;
import org.springframework.stereotype.Component;

@Component
public class InventoryRepositoryDtoMapper {

    public InventoryResponse toResponse(Inventory inventory) {
        return InventoryResponse.builder()
            .id(inventory.getId().value())
            .memberId(inventory.getMemberId().value())
            .memberName(inventory.getMemberName())
            .foodCategoriesId(inventory.getFoodCategoriesId())
            .foodCategoriesName(inventory.getFoodCategoriesName())
            .inboudAt(inventory.getInboudAt())
            .expirationAt(inventory.getExpirationAt())
            .build();
    }
}
