package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1OduNodeConnector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1OduNodeConnectorRepository extends JpaRepository<Tl1OduNodeConnector, Integer> {
    List<Tl1OduNodeConnector> findTl1OduNodeConnectorBySyncDate(String syncDate);
}
