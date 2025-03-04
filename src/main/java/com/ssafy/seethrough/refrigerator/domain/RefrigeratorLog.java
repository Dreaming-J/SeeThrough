package com.ssafy.seethrough.refrigerator.domain;

import com.ssafy.seethrough.common.value.UUID;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RefrigeratorLog {
    private Integer id;
    private UUID refrigeratorInventoryId;
    private UUID memberId;
    private MovementType movementType;
    private LocalDateTime createdAt;

    //TODO: 검증 로직
}
