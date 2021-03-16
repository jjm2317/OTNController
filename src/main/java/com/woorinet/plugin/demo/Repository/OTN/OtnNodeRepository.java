package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtnNodeRepository extends JpaRepository<OtnNode, String> {
    @Query("from OtnNode where ne_id= :neId" )
    OtnNode findSdnNodeByNeId(@Param("neId") String neId);
}
