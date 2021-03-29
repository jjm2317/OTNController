package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1NodeConnector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1NodeConnectorRepository extends JpaRepository<Tl1NodeConnector, Integer> {
    List<Tl1NodeConnector> findTl1NodeConnectorBySyncDate(String syncDate);
}