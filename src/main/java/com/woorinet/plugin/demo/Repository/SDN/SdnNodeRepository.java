package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnNodeRepository extends JpaRepository<SdnNode, String> {
    @Query("from SdnNode where ne_id= :neId" )
    SdnNode findSdnNodeByNeId(@Param("neId") String neId);
}
