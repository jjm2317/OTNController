package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmTemperatureRepository extends JpaRepository<Tl1PmTemperature, Integer> {
    List<Tl1PmTemperature> findTl1PmTemperatureBySyncDate(String syncDate);
}

