package com.seethrough.api.member.infrastructure.repository;

import com.seethrough.api.member.domain.Member;
import com.seethrough.api.member.domain.MemberLog;
import com.seethrough.api.member.domain.MemberRepository;
import com.seethrough.api.common.value.UUID;
import com.seethrough.api.member.infrastructure.entity.MemberEntity;
import com.seethrough.api.member.infrastructure.entity.MemberLogEntity;
import com.seethrough.api.member.infrastructure.mapper.MemberEntityMapper;
import com.seethrough.api.member.infrastructure.mapper.MemberLogEntityMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberEntityMapper memberEntityMapper;
    private final MemberLogJpaRepository memberLogJpaRepository;
    private final MemberLogEntityMapper memberLogEntityMapper;

    @Override
    public Slice<Member> findMembers(Pageable pageable) {
        Slice<MemberEntity> entities = memberJpaRepository.findAll(pageable);

        return entities.map(memberEntityMapper::toDomain);
    }

    @Override
    public Optional<Member> findByMemberId(UUID memberId) {
        Optional<MemberEntity> entity = memberJpaRepository.findById(memberId.value());

        return entity.map(memberEntityMapper::toDomain);
    }

    @Override
    public Slice<MemberLog> findMemberLogs(Pageable pageable) {
        Slice<MemberLogEntity> entities = memberLogJpaRepository.findAll(pageable);

        return entities.map(memberLogEntityMapper::toDomain);
    }
}
