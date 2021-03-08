package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnConnector;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnConnectorRepository extends JpaRepository<SdnConnector, String> {
    @Query("from SdnConnector where connect_id= :connectId" )
    SdnConnector findSdnConnectorByConnectId(@Param("connectId") String connectId);
}
