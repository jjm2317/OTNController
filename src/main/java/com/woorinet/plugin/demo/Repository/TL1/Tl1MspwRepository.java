package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Mspw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1MspwRepository extends JpaRepository<Tl1Mspw, String> {
    List<Tl1Mspw> findTl1MspwBySyncDate(String syncDate);
}

