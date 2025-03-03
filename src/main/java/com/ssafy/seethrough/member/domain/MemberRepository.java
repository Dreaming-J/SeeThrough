package com.ssafy.seethrough.member.domain;

import com.ssafy.seethrough.member.domain.value.MemberId;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface MemberRepository {
    Slice<Member> findMembers(Pageable pageable);

    Optional<Member> findByMemberId(MemberId memberId);
}
