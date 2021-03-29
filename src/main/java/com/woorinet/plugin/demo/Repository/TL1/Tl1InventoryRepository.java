package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1InventoryRepository extends JpaRepository<Tl1Inventory, String>{
    List<Tl1Inventory> findTl1InventoryBySyncDate(String syncDate);
}
