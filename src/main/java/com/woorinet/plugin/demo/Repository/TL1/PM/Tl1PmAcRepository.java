package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmAc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmAcRepository extends JpaRepository<Tl1PmAc, Integer>{
    List<Tl1PmAc> findTl1PmAcBySyncDate(String syncDate);
}
