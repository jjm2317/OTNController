package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnPath;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtnPathRepository extends JpaRepository<OtnPath, String> {
    @Query("from OtnPath where id= :id" )
    OtnPath findSdnPathById(@Param("id") int id);

    @Query("from OtnPath where service_id= :serviceId")
    List<OtnPath> findSdnPathByServiceId(@Param("serviceId") String serviceId);
}
