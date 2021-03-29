package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1SystemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1SystemInfoRepository extends JpaRepository<Tl1SystemInfo, String> {
    List<Tl1SystemInfo> findTl1SystemInfoBySyncDate(String syncDate);
}

