package com.woorinet.plugin.demo.Repository.TL1;

import com.woorinet.plugin.demo.DTO.TL1.Tl1Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Tl1ServiceRepository extends JpaRepository<Tl1Service, Integer> {
    List<Tl1Service> findTl1ServiceBySyncDate(String syncDate);
}
