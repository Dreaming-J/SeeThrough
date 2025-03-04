package com.ssafy.seethrough.refrigerator.infrastructure.repository;

import com.ssafy.seethrough.refrigerator.domain.Inventory;
import com.ssafy.seethrough.refrigerator.domain.InventoryRepository;
import com.ssafy.seethrough.refrigerator.infrastructure.entity.InventoryEntity;
import com.ssafy.seethrough.refrigerator.infrastructure.mapper.InventoryEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Slice<Inventory> findInventories(Pageable pageable) {
        Slice<InventoryEntity> entities = inventoryJpaRepository.findAll(pageable);

        return entities.map(inventoryEntityMapper::toDomain);
    }

    @Override
    public Boolean save(Inventory inventory) {
        InventoryEntity entity = inventoryEntityMapper.toEntity(inventory);
        System.out.println(entity);
        inventoryJpaRepository.save(entity);

        return true;
    }
}
