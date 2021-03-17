package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnAccessIf;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtnAccessIfRepository extends JpaRepository<OtnAccessIf, String> {
    OtnAccessIf findOtnAccessIfByAccessifId(String accessifId);
}
