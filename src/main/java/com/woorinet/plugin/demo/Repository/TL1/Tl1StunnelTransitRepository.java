package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1StunnelTransit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1StunnelTransitRepository extends JpaRepository<Tl1StunnelTransit, Integer> {
    List<Tl1StunnelTransit> findTl1StunnelTransitBySyncDate(String syncDate);
}