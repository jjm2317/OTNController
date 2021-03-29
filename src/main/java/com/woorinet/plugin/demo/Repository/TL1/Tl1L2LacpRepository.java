package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1L2Lacp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1L2LacpRepository extends JpaRepository<Tl1L2Lacp, Integer> {
    List<Tl1L2Lacp> findTl1L2LacpBySyncDate(String syncDate);
}
