package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1StunnelExt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface Tl1StunnelExtRepository extends JpaRepository<Tl1StunnelExt, Integer> {
    List<Tl1StunnelExt> findTl1StunnelExtBySyncDate(String syncDate);
}