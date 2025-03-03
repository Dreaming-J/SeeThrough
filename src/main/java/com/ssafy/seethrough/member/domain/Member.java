package com.ssafy.seethrough.member.domain;

import com.ssafy.seethrough.member.domain.value.MemberId;
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
    private MemberId id;
    private String name;
    private Boolean isIdentified;
    private LocalDateTime createdAt;
    private Integer recognitionTimes;
    private List<String> significants;

    //TODO: 검증 로직
}
