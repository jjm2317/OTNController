package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1KeyState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1KeyStateRepository extends JpaRepository<Tl1KeyState, Integer> {
    List<Tl1KeyState> findTl1KeyStateBySyncDate(String syncDate);
}
