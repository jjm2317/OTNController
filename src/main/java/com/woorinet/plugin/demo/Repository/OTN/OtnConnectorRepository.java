package com.woorinet.plugin.demo.Repository.OTN;

import com.woorinet.plugin.demo.DTO.OTN.OtnConnector;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtnConnectorRepository extends JpaRepository<OtnConnector, String> {
    OtnConnector findOtnConnectorByConnectId( String connectId);

    @Query(value = "select c.unit_type from SdnConnector c where c.unit_type != '' group by c.unit_type ",
            nativeQuery = true)
    List<String> findAllUnitTypesNative();

//    @Query(value = "select count(*) from SdnConnector c where c.ne_name = ")
//    int findCountOf

}
