package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1EthPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1EthPortRepository extends JpaRepository<Tl1EthPort, Integer> {
    List<Tl1EthPort> findTl1EthPortBySyncDate(String syncDate);
}
