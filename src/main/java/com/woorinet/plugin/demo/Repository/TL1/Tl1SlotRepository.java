package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1SlotRepository  extends JpaRepository<Tl1Slot, Integer> {
    List<Tl1Slot> findTl1SlotBySyncDate(String syncDate);
}
