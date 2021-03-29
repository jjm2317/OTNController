package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmTunnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmTunnelRepository extends JpaRepository<Tl1PmTunnel, Integer>{
    List<Tl1PmTunnel> findTl1PmTunnelBySyncDate(String syncDate);
}
