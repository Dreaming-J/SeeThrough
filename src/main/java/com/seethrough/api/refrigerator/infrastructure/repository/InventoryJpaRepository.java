package com.seethrough.api.refrigerator.infrastructure.repository;

import com.seethrough.api.refrigerator.infrastructure.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, String> {
}
