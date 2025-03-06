package com.seethrough.api.refrigerator.infrastructure.repository;

import com.seethrough.api.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefrigeratorLogJpaRepository extends JpaRepository<RefrigeratorLogEntity, String> {
}
