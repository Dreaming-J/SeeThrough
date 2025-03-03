package com.ssafy.seethrough.member.infrastructure.repository;

import com.ssafy.seethrough.member.domain.Member;
import com.ssafy.seethrough.member.domain.MemberLog;
import com.ssafy.seethrough.member.domain.MemberRepository;
import com.ssafy.seethrough.common.value.UUID;
import com.ssafy.seethrough.member.infrastructure.entity.MemberEntity;
import com.ssafy.seethrough.member.infrastructure.entity.MemberLogEntity;
import com.ssafy.seethrough.member.infrastructure.mapper.MemberEntityMapper;
import com.ssafy.seethrough.member.infrastructure.mapper.MemberLogEntityMapper;
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
