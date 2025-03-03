package com.ssafy.seethrough.member.presentation.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLogResponse {
    private String memberId;
    private String name;
    private String image_url;
    private LocalDateTime createdAt;
}
