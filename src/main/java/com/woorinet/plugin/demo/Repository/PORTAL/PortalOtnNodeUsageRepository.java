package com.woorinet.plugin.demo.Repository.PORTAL;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalStatsNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortalOtnNodeUsageRepository extends JpaRepository<PortalStatsNode, Integer> {
}
