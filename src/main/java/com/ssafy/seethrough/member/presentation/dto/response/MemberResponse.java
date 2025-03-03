package com.ssafy.seethrough.member.presentation.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {
    private String name;
    private Boolean isIdentified;
    private LocalDateTime createdAt;
    private Integer recognitionTimes;
    private List<String> significants;
}
