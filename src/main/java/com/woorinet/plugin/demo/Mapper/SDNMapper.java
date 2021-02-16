package com.woorinet.plugin.demo.Mapper;


import com.woorinet.plugin.demo.DTO.SDN.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SDNMapper {
    void initDatabase() throws Exception;
    void initNodeTable() throws Exception;
    void initConnector() throws Exception;
    void initLink() throws Exception;
    void initService() throws Exception;
    void initTunnel() throws Exception;
    void initAccessIf() throws Exception;
    void initConstraint() throws Exception;
    void initPath() throws Exception;
    void insertNode(NODE node) throws Exception;
    void insertConnector(CONNECTOR connector) throws Exception;
    void insertLink(LINK link) throws Exception;
    void insertService(SERVICE service) throws Exception;
    void insertTunnel(TUNNEL tunnel) throws Exception;
    void insertAccessIf(ACCESS_IF accessIf) throws Exception;
    void insertConstraint(CONSTRAINT constraint) throws Exception;
    void insertPath(PATH path) throws Exception;
}
