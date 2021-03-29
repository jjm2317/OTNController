package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Stunnel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1StunnelRepository extends JpaRepository<Tl1Stunnel, Integer> {
    List<Tl1Stunnel> findTl1StunnelBySyncDate(String syncDate);
}