package com.ssafy.seethrough.member.infrastructure.mapper;

import com.ssafy.seethrough.member.domain.MemberLog;
import com.ssafy.seethrough.common.value.UUID;
import com.ssafy.seethrough.member.infrastructure.entity.MemberLogEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberLogEntityMapper {

    // TODO: Member 넣는거 해결해보기
    public MemberLogEntity toEntity(MemberLog memberLog) {
        return MemberLogEntity.builder()
            .id(memberLog.getId())
            .memberId(memberLog.getMemberId().value())
            .imageUrl(memberLog.getImageUrl())
            .createdAt(memberLog.getCreatedAt())
            .build();
    }

    public MemberLog toDomain(MemberLogEntity entity) {
        return MemberLog.builder()
            .id(entity.getId())
            .memberId(new UUID(entity.getMemberId()))
            .name(entity.getMember().getName())
            .imageUrl(entity.getImageUrl())
            .createdAt(entity.getCreatedAt())
            .build();
    }
}
