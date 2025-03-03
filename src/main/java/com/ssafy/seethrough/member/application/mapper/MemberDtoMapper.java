package com.ssafy.seethrough.member.application.mapper;

import com.ssafy.seethrough.member.domain.Member;
import com.ssafy.seethrough.member.domain.MemberLog;
import com.ssafy.seethrough.member.presentation.dto.response.MemberLogResponse;
import com.ssafy.seethrough.member.presentation.dto.response.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoMapper {

    public MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
            .memberId(member.getId().getValue())
            .name(member.getName())
            .isIdentified(member.getIsIdentified())
            .createdAt(member.getCreatedAt())
            .recognitionTimes(member.getRecognitionTimes())
            .significants(member.getSignificants())
            .build();
    }

    public MemberLogResponse toResponse(MemberLog memberLog) {
        return MemberLogResponse.builder()
            .name(memberLog.getName())
            .image_url(memberLog.getImageUrl())
            .createdAt(memberLog.getCreatedAt())
            .build();
    }
}
