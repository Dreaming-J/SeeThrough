package com.seethrough.api.member.domain;

import com.seethrough.api.common.value.UUID;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    private UUID id;
    private String name;
    private Boolean isIdentified;
    private LocalDateTime createdAt;
    private Integer recognitionTimes;
    private List<String> significants;

    //TODO: 검증 로직
}
