package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1NodeRepository extends JpaRepository<Tl1Node, Integer> {
    List<Tl1Node> findTl1NodeBySyncDate(String syncDate);
}

