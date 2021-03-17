package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtnServiceRepository extends JpaRepository<OtnService, String> {
    OtnService findOtnServiceByServiceId(String serviceId);
}
