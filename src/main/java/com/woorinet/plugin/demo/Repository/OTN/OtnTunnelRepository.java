package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnTunnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtnTunnelRepository extends JpaRepository<OtnTunnel, String> {
    OtnTunnel findOtnTunnelByTunnelId(String tunnelId);
}
