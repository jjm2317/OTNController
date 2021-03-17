package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnPath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OtnPathRepository extends JpaRepository<OtnPath, String> {
    OtnPath findOtnPathById(int id);

    List<OtnPath> findOtnPathByServiceId(String serviceId);
}
