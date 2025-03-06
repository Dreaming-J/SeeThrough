package com.seethrough.api.member.application.mapper;

import com.seethrough.api.member.domain.Member;
import com.seethrough.api.member.domain.MemberLog;
import com.seethrough.api.member.presentation.dto.response.MemberLogResponse;
import com.seethrough.api.member.presentation.dto.response.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoMapper {

    public MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
            .memberId(member.getId().value())
            .name(member.getName())
            .isIdentified(member.getIsIdentified())
            .createdAt(member.getCreatedAt())
            .recognitionTimes(member.getRecognitionTimes())
            .significants(member.getSignificants())
            .build();
    }

    public MemberLogResponse toResponse(MemberLog memberLog) {
        return MemberLogResponse.builder()
            .memberId(memberLog.getMemberId().value())
            .name(memberLog.getName())
            .image_url(memberLog.getImageUrl())
            .createdAt(memberLog.getCreatedAt())
            .build();
    }
}
