package com.woorinet.plugin.demo.Repository.TL1.CM;

import com.woorinet.plugin.demo.DTO.TL1.CM.Tl1CmProgramInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Tl1CmProgramInfoRepository extends JpaRepository<Tl1CmProgramInfo, String>{
    List<Tl1CmProgramInfo> findTl1CmProgramInfoBySyncDate(String syncDate);
}
