package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1CesPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1CesPortRepository extends JpaRepository<Tl1CesPort, Integer> {
    List<Tl1CesPort> findTl1CesPortBySyncDate(String syncDate);
}

