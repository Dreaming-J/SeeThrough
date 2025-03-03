package com.ssafy.seethrough.refrigerator.presentation.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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
