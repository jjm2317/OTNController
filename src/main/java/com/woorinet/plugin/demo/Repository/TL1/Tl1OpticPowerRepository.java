package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1OpticPower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1OpticPowerRepository extends JpaRepository<Tl1OpticPower, Integer> {
    List<Tl1OpticPower> findTl1OpticPowerBySyncDate(String syncDate);
}
