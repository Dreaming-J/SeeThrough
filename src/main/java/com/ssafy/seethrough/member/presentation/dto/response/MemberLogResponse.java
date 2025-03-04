package com.ssafy.seethrough.member.presentation.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLogResponse {
    private String memberId;
    private String name;
    private String image_url;
    private LocalDateTime createdAt;
}
