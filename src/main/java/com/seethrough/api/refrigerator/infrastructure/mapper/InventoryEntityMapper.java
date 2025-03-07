package com.seethrough.api.refrigerator.infrastructure.mapper;

import com.seethrough.api.common.value.UUID;
import com.seethrough.api.refrigerator.domain.Inventory;
import com.seethrough.api.refrigerator.infrastructure.entity.InventoryEntity;
import org.springframework.stereotype.Component;

@Component
public class InventoryEntityMapper {

    // TODO: Member 넣는거 해결해보기
    // TODO: FoodCategory 넣는거 해결해보기
    public InventoryEntity toEntity(Inventory inventory) {
        return InventoryEntity.builder()
            .id(inventory.getId().value())
            .memberId(inventory.getMemberId().value())
            .foodCategoryId(inventory.getFoodCategoriesId())
            .inboundAt(inventory.getInboudAt())
            .expirationAt(inventory.getExpirationAt())
            .build();
    }

    public Inventory toDomain(InventoryEntity entity) {
        return Inventory.builder()
            .id(new UUID(entity.getId()))
            .memberId(new UUID(entity.getMemberId()))
            .memberName(entity.getMember().getName())
            .foodCategoriesId(entity.getFoodCategoryId())
            .foodCategoriesName(entity.getFoodCategory().getName())
            .inboudAt(entity.getInboundAt())
            .expirationAt(entity.getExpirationAt())
            .build();
    }
}
