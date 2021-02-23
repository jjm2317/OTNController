package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SERVICE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SERVICERepository extends JpaRepository<SERVICE, String> {
    @Query("select s from SERVICE s where s.service_name = :service_name")
    SERVICE findByService_name (@Param("service_name") String service_name);
}
