package com.woorinet.plugin.demo.Mapper;

import com.woorinet.plugin.demo.DTO.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TL1Mapper {
    void initDatabase() throws Exception;
    void initNodeTable() throws Exception;
    void initSystemInfoTable() throws Exception;
    void initSlotTable() throws Exception;
    void initEthPortTable() throws Exception;
    void initNodeConnectorTable() throws Exception;
    void initCesNodeConnectorTable() throws Exception;
    void initOduNodeConnectorTable() throws Exception;
    void initMplsIfTable() throws Exception;
    void initOduMplsIfTable() throws Exception;


    List<NODE> selectNode() throws Exception;
    List<SYSTEM_INFO> selectSystemInfo() throws Exception;
    List<SLOT> selectSlot() throws Exception;
    List<ETH_PORT> selectEthPort() throws Exception;
    List<NODECONNECTOR> selectNodeConnector() throws Exception;
    List<CES_NODE_CONNECTOR> selectCesNodeConnector() throws Exception;
    List<ODU_NODE_CONNECTOR> selectOduNodeConnector() throws Exception;
    List<MPLS_IF> selectMplsIf() throws Exception;
    List<ODU_MPLS_IF> selectOduMplsIf() throws Exception;

    void insertNode(NODE node) throws Exception;
    void insertSystemInfo(SYSTEM_INFO systemInfo) throws Exception;
    void insertSlot(SLOT slot) throws Exception;
    void insertEthPort(ETH_PORT ethPort) throws Exception;
    void insertNodeConnector(NODECONNECTOR nodeConnector) throws Exception;
    void insertCesNodeConnector(CES_NODE_CONNECTOR cesNodeConnector) throws Exception;
    void insertOduNodeConnector(ODU_NODE_CONNECTOR oduNodeConnector) throws Exception;
    void insertMplsIf(MPLS_IF mplsIf) throws Exception;
    void insertOduMplsIf(ODU_MPLS_IF oduMplsIf) throws Exception;
}