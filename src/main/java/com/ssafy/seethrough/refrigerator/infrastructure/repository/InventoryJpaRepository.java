package com.ssafy.seethrough.refrigerator.infrastructure.repository;

import com.ssafy.seethrough.refrigerator.infrastructure.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, String> {
}
