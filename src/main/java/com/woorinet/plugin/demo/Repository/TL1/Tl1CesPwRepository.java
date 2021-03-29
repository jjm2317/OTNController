package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1CesPw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1CesPwRepository extends JpaRepository<Tl1CesPw, Integer> {
    List<Tl1CesPw> findTl1CesPwBySyncDate(String syncDate);
}

