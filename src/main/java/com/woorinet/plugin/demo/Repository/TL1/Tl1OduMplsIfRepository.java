package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1OduMplsIf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1OduMplsIfRepository extends JpaRepository<Tl1OduMplsIf, Integer> {
    List<Tl1OduMplsIf> findTl1OduMplsIfBySyncDate(String syncDate);
}
