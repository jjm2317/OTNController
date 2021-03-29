package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1SessState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1SessStateRepository extends JpaRepository<Tl1SessState, Integer> {
    List<Tl1SessState> findTl1SessStateBySyncDate(String syncDate);
}
