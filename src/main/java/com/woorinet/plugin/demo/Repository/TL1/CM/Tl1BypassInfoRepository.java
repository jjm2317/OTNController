package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1BypassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1BypassInfoRepository extends JpaRepository<Tl1BypassInfo, Integer> {
    List<Tl1BypassInfo> findTl1BypassInfoBySyncDate(String syncDate);
}
