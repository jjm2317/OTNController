package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnNode;
import com.woorinet.plugin.demo.DTO.SDN.SdnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnServiceRepository extends JpaRepository<SdnService, String> {

    @Query("from SdnService where service_id = :serviceId" )
    SdnService findSdnServiceByServiceId(@Param("serviceId") String serviceId);
}
