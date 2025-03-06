package com.seethrough.api.refrigerator.infrastructure.mapper;

import com.seethrough.api.common.value.UUID;
import com.seethrough.api.refrigerator.domain.RefrigeratorLog;
import com.seethrough.api.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
import org.springframework.stereotype.Component;

@Component
public class RefrigeratorLogEntityMapper {

    // TODO: Member 넣는거 해결해보기
    // TODO: FoodCategory 넣는거 해결해보기
    public RefrigeratorLogEntity toEntity(RefrigeratorLog refrigeratorLog) {
        return RefrigeratorLogEntity.builder()
            .id(refrigeratorLog.getId())
            .refrigeratorInventoryId(refrigeratorLog.getRefrigeratorInventoryId().value())
            .memberId(refrigeratorLog.getMemberId().value())
            .movementType(refrigeratorLog.getMovementType())
            .createdAt(refrigeratorLog.getCreatedAt())
            .build();
    }

    public RefrigeratorLog toDomain(RefrigeratorLogEntity entity) {
        return RefrigeratorLog.builder()
            .id(entity.getId())
            .refrigeratorInventoryId(new UUID(entity.getRefrigeratorInventoryId()))
            .memberId(new UUID(entity.getMemberId()))
            .movementType(entity.getMovementType())
            .createdAt(entity.getCreatedAt())
            .build();
    }
}
