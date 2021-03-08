package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnNode;
import com.woorinet.plugin.demo.DTO.SDN.SdnTunnel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnTunnelRepository extends JpaRepository<SdnTunnel, String> {
    @Query("from SdnTunnel where tunnel_id= :tunnelId" )
    SdnNode findSdnTunnelByTunnelId(@Param("tunnelId") String tunnelId);
}
