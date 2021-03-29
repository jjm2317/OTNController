package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1ModuleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Tl1ModuleInfoRepository extends JpaRepository<Tl1ModuleInfo, Integer> {
    List<Tl1ModuleInfo> findTl1ModuleInfoBySyncDate(String syncDate);
}
