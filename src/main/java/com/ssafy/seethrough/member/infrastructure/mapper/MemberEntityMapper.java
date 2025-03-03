package com.ssafy.seethrough.member.infrastructure.mapper;

import com.ssafy.seethrough.member.domain.Member;
import com.ssafy.seethrough.common.value.UUID;
import com.ssafy.seethrough.member.infrastructure.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {

    public MemberEntity toEntity(Member member) {
        return MemberEntity.builder()
            .id(member.getId().value())
            .name(member.getName())
            .isIdentified(member.getIsIdentified())
            .createdAt(member.getCreatedAt())
            .recognitionTimes(member.getRecognitionTimes())
            .significants(member.getSignificants())
            .build();
    }

    public Member toDomain(MemberEntity entity) {
        return Member.builder()
            .id(new UUID(entity.getId()))
            .name(entity.getName())
            .isIdentified(entity.getIsIdentified())
            .createdAt(entity.getCreatedAt())
            .recognitionTimes(entity.getRecognitionTimes())
            .significants(entity.getSignificants())
            .build();
    }
}
