package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1CryptoMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1CryptoModeRepository extends JpaRepository<Tl1CryptoMode, Integer> {
    List<Tl1CryptoMode> findTl1CryptoModeBySyncDate(String syncDate);
}
