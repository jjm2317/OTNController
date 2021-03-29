package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1Pm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmRepository extends JpaRepository<Tl1Pm, Integer> {
    List<Tl1Pm> findTl1PmBySyncDate(String syncDate);
}
