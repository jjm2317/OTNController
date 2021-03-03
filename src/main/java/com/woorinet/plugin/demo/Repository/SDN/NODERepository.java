package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NODERepository extends JpaRepository<SdnNode, String> {
}
