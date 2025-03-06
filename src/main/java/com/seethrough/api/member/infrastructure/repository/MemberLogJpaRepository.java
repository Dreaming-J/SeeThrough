package com.seethrough.api.member.infrastructure.repository;

import com.seethrough.api.member.infrastructure.entity.MemberLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLogJpaRepository extends JpaRepository<MemberLogEntity, String> {
}
