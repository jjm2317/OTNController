package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmOpticTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmOpticTemperatureRepository extends JpaRepository<Tl1PmOpticTemperature, Integer> {
    List<Tl1PmOpticTemperature> findTl1PmOpticTemperatureBySyncDate(String syncDate);
}

