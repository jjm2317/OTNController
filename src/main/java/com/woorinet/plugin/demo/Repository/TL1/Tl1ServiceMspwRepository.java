package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1ServiceMspw;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1ServiceMspwRepository extends JpaRepository<Tl1ServiceMspw, Integer> {
    List<Tl1ServiceMspw> findTl1ServiceMspwBySyncDate(String syncDate);
}
