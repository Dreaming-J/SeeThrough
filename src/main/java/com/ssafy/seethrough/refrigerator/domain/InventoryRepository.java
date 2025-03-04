package com.ssafy.seethrough.refrigerator.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface InventoryRepository {
    Slice<Inventory> findInventories(Pageable pageable);

    Boolean save(Inventory inventory);
}
