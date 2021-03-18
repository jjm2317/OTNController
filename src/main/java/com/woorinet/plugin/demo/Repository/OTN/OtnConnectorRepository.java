package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnConnector;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtnConnectorRepository extends JpaRepository<OtnConnector, String> {
    OtnConnector findOtnConnectorByConnectId( String connectId);

    @Query(value = "select unit_type from otn_connector where unit_type != '' group by unit_type",nativeQuery = true)
    List<String> findUnitTypes();

//    @Query(value = "select count(*) from SdnConnector c where c.ne_name = ")
//    int findCountOf

}
