package com.ssafy.seethrough.member.infrastructure.repository;

import com.ssafy.seethrough.member.domain.Member;
import com.ssafy.seethrough.member.domain.MemberRepository;
import com.ssafy.seethrough.member.domain.value.MemberId;
import com.ssafy.seethrough.member.infrastructure.entity.MemberEntity;
import com.ssafy.seethrough.member.infrastructure.mapper.MemberEntityMapper;
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

    @Override
    public Slice<Member> findMembers(Pageable pageable) {
        Slice<MemberEntity> entities = memberJpaRepository.findAll(pageable);

        return entities.map(memberEntityMapper::toDomain);
    }

    @Override
    public Optional<Member> findByMemberId(MemberId memberId) {
        Optional<MemberEntity> entity = memberJpaRepository.findById(memberId.getValue());

        return entity.map(memberEntityMapper::toDomain);
    }
}
