package com.woorinet.plugin.demo.Repository.SDN;

import com.woorinet.plugin.demo.DTO.SDN.SdnLink;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SdnLinkRepository extends JpaRepository<SdnLink, String> {
    @Query("from SdnLink where link_id= :linkId")
    SdnLink findSdnLinkByLinkId(@Param("linkId") String linkId);


}
