package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1CmPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1CmPortRepository extends JpaRepository<Tl1CmPort, Integer> {
    List<Tl1CmPort> findTl1CmPortBySyncDate(String syncDate);
}
