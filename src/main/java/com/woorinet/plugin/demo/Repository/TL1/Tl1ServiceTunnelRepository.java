package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1ServiceTunnel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1ServiceTunnelRepository extends JpaRepository<Tl1ServiceTunnel, Integer> {
    List<Tl1ServiceTunnel> findTl1ServiceTunnelBySyncDate(String syncDate);
}
