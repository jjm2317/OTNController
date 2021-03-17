package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtnNodeRepository extends JpaRepository<OtnNode, String> {
    OtnNode findOtnNodeByNeId(String neId);
}
