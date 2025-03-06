package com.seethrough.api.refrigerator.presentation.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InventoryResponse {
    private String id;
    private String memberId;
    private String memberName;
    private Integer foodCategoriesId;
    private String foodCategoriesName;
    private LocalDateTime inboudAt;
    private LocalDateTime expirationAt;
}
