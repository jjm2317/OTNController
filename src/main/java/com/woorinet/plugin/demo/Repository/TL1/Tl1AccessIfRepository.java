package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1AccessIf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1AccessIfRepository extends JpaRepository<Tl1AccessIf, String> {
    List<Tl1AccessIf> findTl1AccessIfBySyncDate(String syncDate);
}
