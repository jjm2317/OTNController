package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SdnServiceRepository extends JpaRepository<SdnService, String> {
    @Query("select s from SERVICE s where s.service_name = :service_name")
    SdnService findByService_name (@Param("service_name") String service_name);
}
