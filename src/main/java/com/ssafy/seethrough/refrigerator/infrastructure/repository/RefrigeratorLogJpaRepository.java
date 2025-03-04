package com.ssafy.seethrough.refrigerator.infrastructure.repository;

import com.ssafy.seethrough.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefrigeratorLogJpaRepository extends JpaRepository<RefrigeratorLogEntity, String> {
}
