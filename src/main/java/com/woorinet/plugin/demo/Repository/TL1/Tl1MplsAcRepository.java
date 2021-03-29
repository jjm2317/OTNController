package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1MplsAc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1MplsAcRepository extends JpaRepository<Tl1MplsAc, Integer> {
    List<Tl1MplsAc> findTl1MplsAcBySyncDate(String syncDate);
}
