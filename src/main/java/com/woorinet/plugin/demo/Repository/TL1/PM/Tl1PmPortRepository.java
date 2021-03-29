package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmPortRepository extends JpaRepository<Tl1PmPort, Integer>{
    List<Tl1PmPort> findTl1PmPortBySyncDate(String syncDate);
}
