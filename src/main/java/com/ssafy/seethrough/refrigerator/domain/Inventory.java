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
public class Inventory {
    private UUID id;
    private UUID memberId;
    private String memberName;
    private Integer foodCategoriesId;
    private String foodCategoriesName;
    private LocalDateTime inboudAt;
    private LocalDateTime expirationAt;

    //TODO: 검증 로직
}
