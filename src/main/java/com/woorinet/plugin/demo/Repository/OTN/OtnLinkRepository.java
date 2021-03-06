package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnLink;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtnLinkRepository extends JpaRepository<OtnLink, String> {
    OtnLink findOtnLinkByLinkId(String linkId);


}
