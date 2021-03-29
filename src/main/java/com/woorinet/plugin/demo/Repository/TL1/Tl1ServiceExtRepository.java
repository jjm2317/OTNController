package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1ServiceExt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1ServiceExtRepository extends JpaRepository<Tl1ServiceExt, Integer> {
    List<Tl1ServiceExt> findTl1ServiceExtBySyncDate(String syncDate);
}
