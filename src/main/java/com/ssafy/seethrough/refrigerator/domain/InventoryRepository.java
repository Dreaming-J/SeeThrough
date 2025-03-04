package com.ssafy.seethrough.refrigerator.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface InventoryRepository {
    Slice<Inventory> findInventories(Pageable pageable);

    void save(Inventory inventory);

    void saveInBoundLog(RefrigeratorLog refrigeratorLog);
}
