package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtnServiceRepository extends JpaRepository<OtnService, String> {

    @Query("from OtnService where service_id = :serviceId" )
    OtnService findSdnServiceByServiceId(@Param("serviceId") String serviceId);
}
