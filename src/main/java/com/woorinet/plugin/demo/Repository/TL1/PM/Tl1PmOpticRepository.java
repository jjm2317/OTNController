package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmOptic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmOpticRepository extends JpaRepository<Tl1PmOptic, Integer> {
    List<Tl1PmOptic> findTl1PmOpticBySyncDate(String syncDate);
}
