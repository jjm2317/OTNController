package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnConstraint;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtnConstraintRepository extends JpaRepository<OtnConstraint, Integer> {
    OtnConstraint findOtnConstraintById( int id);


    List<OtnConstraint> findSdnConstraintByServiceId( String serviceId);
}
