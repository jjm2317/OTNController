package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1QkdInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1QkdInfoRepository extends JpaRepository<Tl1QkdInfo, Integer> {
    List<Tl1QkdInfo> findTl1QkdInfoBySyncDate(String syncDate);
}
