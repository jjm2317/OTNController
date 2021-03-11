package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnPath;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SdnPathRepository extends JpaRepository<SdnPath, String> {
    @Query("from SdnPath where id= :id" )
    SdnPath findSdnPathById(@Param("id") int id);

    @Query("from SdnPath where service_id= :serviceId")
    List<SdnPath> findSdnPathByServiceId(@Param("serviceId") String serviceId);
}
