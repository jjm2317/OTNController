package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnConstraint;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SdnConstraintRepository extends JpaRepository<SdnConstraint, Integer> {
    @Query("from SdnConstraint where id= :id" )
    SdnConstraint findSdnConstraintById(@Param("id") int id);

    @Query("from SdnConstraint where service_id= :serviceId")
    List<SdnConstraint> findSdnConstraintByServiceId(@Param("serviceId") String serviceId);
}
