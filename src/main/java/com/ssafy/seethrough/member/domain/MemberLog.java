package com.ssafy.seethrough.member.domain;

import com.ssafy.seethrough.member.domain.value.MemberId;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberLog {
    private Integer id;
    private MemberId memberId;
    private String name;
    private String imageUrl;
    private LocalDateTime createdAt;

    //TODO: 검증 로직
}
