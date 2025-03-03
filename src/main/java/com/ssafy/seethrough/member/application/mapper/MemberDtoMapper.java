package com.ssafy.seethrough.member.application.mapper;

import com.ssafy.seethrough.member.domain.Member;
import com.ssafy.seethrough.member.presentation.dto.response.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoMapper {

    public MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
            .name(member.getName())
            .isIdentified(member.getIsIdentified())
            .createdAt(member.getCreatedAt())
            .recognitionTimes(member.getRecognitionTimes())
            .significants(member.getSignificants())
            .build();
    }
}
