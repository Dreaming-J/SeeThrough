package com.ssafy.seethrough.refrigerator.infrastructure.mapper;

import com.ssafy.seethrough.common.value.UUID;
import com.ssafy.seethrough.refrigerator.domain.RefrigeratorLog;
import com.ssafy.seethrough.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
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
