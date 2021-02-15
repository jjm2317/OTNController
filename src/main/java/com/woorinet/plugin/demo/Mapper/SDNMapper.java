package com.woorinet.plugin.demo.Mapper;


import com.woorinet.plugin.demo.DTO.SDN.CONNECTOR;
import com.woorinet.plugin.demo.DTO.SDN.NODE;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SDNMapper {
    void initDatabase() throws Exception;
    void initNodeTable() throws Exception;
    void initConnector() throws Exception;

    void insertNode(NODE node) throws Exception;
    void insertConnector(CONNECTOR connector) throws Exception;
}
