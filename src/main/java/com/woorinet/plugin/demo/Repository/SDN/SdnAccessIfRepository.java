package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnAccessIf;
import com.woorinet.plugin.demo.DTO.SDN.SdnNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnAccessIfRepository extends JpaRepository<SdnAccessIf, String> {
    @Query("from SdnAccessIf where accessif_id= :accessifId" )
    SdnAccessIf findSdnAccessIfByAccessifId(@Param("accessifId") String accessifId);
}
