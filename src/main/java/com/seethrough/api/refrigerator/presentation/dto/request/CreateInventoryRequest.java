package com.seethrough.api.refrigerator.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateInventoryRequest {
    String memberId;
    Integer foodCategoryId;
}
