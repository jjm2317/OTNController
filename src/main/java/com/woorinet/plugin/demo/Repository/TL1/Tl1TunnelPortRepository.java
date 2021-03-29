package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1TunnelPort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1TunnelPortRepository extends JpaRepository<Tl1TunnelPort, Integer> {
    List<Tl1TunnelPort> findTl1TunnelPortBySyncDate(String syncDate);
}
