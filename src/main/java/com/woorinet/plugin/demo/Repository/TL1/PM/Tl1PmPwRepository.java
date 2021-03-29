package com.woorinet.plugin.demo.Repository.TL1.PM;

import com.woorinet.plugin.demo.DTO.TL1.PM.Tl1PmPw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1PmPwRepository extends JpaRepository<Tl1PmPw, Integer> {
    List<Tl1PmPw> findTl1PmPwBySyncDate(String syncDate);
}
