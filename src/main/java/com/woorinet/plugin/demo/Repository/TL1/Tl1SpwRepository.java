package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Spw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1SpwRepository extends JpaRepository<Tl1Spw, Integer> {
    List<Tl1Spw> findTl1SpwBySyncDate(String syncDate);
}
