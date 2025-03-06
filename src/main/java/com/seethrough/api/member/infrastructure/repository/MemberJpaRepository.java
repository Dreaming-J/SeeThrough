package com.seethrough.api.member.infrastructure.repository;

import com.seethrough.api.member.infrastructure.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, String> {
}
