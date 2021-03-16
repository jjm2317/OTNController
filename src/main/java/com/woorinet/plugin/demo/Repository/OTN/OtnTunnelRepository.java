package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnNode;
import com.woorinet.plugin.demo.DTO.OTN.OtnTunnel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtnTunnelRepository extends JpaRepository<OtnTunnel, String> {
    @Query("from OtnTunnel where tunnel_id= :tunnelId" )
    OtnNode findSdnTunnelByTunnelId(@Param("tunnelId") String tunnelId);
}
