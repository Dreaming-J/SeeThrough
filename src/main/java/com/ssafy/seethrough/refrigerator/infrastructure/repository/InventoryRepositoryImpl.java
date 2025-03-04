package com.ssafy.seethrough.refrigerator.infrastructure.repository;

import com.ssafy.seethrough.refrigerator.domain.Inventory;
import com.ssafy.seethrough.refrigerator.domain.InventoryRepository;
import com.ssafy.seethrough.refrigerator.domain.RefrigeratorLog;
import com.ssafy.seethrough.refrigerator.infrastructure.entity.InventoryEntity;
import com.ssafy.seethrough.refrigerator.infrastructure.entity.RefrigeratorLogEntity;
import com.ssafy.seethrough.refrigerator.infrastructure.mapper.InventoryEntityMapper;
import com.ssafy.seethrough.refrigerator.infrastructure.mapper.RefrigeratorLogEntityMapper;
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
