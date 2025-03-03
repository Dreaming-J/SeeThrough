package com.ssafy.seethrough.member.infrastructure.repository;

import com.ssafy.seethrough.member.infrastructure.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, String> {
}
