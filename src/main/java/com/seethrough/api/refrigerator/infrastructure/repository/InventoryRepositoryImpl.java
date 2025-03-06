package com.seethrough.api.refrigerator.infrastructure.repository;

import com.seethrough.api.refrigerator.domain.Inventory;
import com.seethrough.api.refrigerator.domain.InventoryRepository;
import com.seethrough.api.refrigerator.domain.RefrigeratorLog;
import com.seethrough.api.refrigerator.infrastructure.entity.InventoryEntity;
import com.seethrough.api.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
import com.seethrough.api.refrigerator.infrastructure.mapper.InventoryEntityMapper;
import com.seethrough.api.refrigerator.infrastructure.mapper.RefrigeratorLogEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;
    private final InventoryEntityMapper inventoryEntityMapper;
    private final RefrigeratorLogJpaRepository refrigeratorLogJpaRepository;
    private final RefrigeratorLogEntityMapper refrigeratorLogEntityMapper;

    @Override
    public Slice<Inventory> findInventories(Pageable pageable) {
        Slice<InventoryEntity> entities = inventoryJpaRepository.findAll(pageable);

        return entities.map(inventoryEntityMapper::toDomain);
    }

    @Override
    public void save(Inventory inventory) {
        InventoryEntity entity = inventoryEntityMapper.toEntity(inventory);

        inventoryJpaRepository.save(entity);
    }

    @Override
    public void saveInBoundLog(RefrigeratorLog refrigeratorLog) {
        RefrigeratorLogEntity entity = refrigeratorLogEntityMapper.toEntity(refrigeratorLog);

        refrigeratorLogJpaRepository.save(entity);
    }
}
