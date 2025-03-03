package com.ssafy.seethrough.member.infrastructure.repository;

import com.ssafy.seethrough.member.infrastructure.entity.MemberLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLogJpaRepository extends JpaRepository<MemberLogEntity, String> {
}
