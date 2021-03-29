package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Odu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1OduRepository extends JpaRepository<Tl1Odu, Integer> {
    List<Tl1Odu> findTl1OduBySyncDate(String syncDate);
}
