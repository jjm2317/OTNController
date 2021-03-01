package com.woorinet.plugin.demo.Mapper;

import com.woorinet.plugin.demo.DTO.TL1.*;
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
    void initSTunnelTable() throws Exception;
    void initSTunnelExtTable() throws Exception;
    void initSTunnelTransitTable() throws Exception;
    void initTunnelProtTable() throws Exception;
    void initSpwTable() throws Exception;
    void initMSpwTable() throws Exception;
    void initMplsAcTable() throws Exception;
    void initAccessIfTable() throws Exception;
    void initServiceTable() throws Exception;
    void initServiceExtTable() throws Exception;
    void initServiceTunnelTable() throws Exception;
    void initServiceMspwTable() throws Exception;
    void initOduTable() throws Exception;
    void initCesPortTable() throws Exception;
    void initCesPwTable() throws Exception;
    void initL2LacpTable() throws Exception;
    void initOpticPowerTable() throws Exception;


    List<NODE> selectNode() throws Exception;
    List<Tl1SystemInfo> selectSystemInfo() throws Exception;
    List<Tl1Slot> selectSlot() throws Exception;
    List<ETH_PORT> selectEthPort() throws Exception;
    List<NODECONNECTOR> selectNodeConnector() throws Exception;
    List<CES_NODE_CONNECTOR> selectCesNodeConnector() throws Exception;
    List<ODU_NODE_CONNECTOR> selectOduNodeConnector() throws Exception;
    List<MPLS_IF> selectMplsIf() throws Exception;
    List<ODU_MPLS_IF> selectOduMplsIf() throws Exception;
    List<STUNNEL> selectSTunnel() throws Exception;
    List<STUNNEL_EXT> selectSTunnelExt() throws Exception;
    List<STUNNEL_TRANSIT> selectSTunnelTransit() throws Exception;
    List<TUNNEL_PROT> selectTunnelProt() throws Exception;
    List<SPW> selectSpw() throws Exception;
    List<MSPW> selectMSpw() throws Exception;
    List<MPLS_AC> selectMplsAc() throws Exception;
    List<Tl1AccessIf> selectAccessIf() throws Exception;
    List<SERVICE> selectService() throws Exception;
    List<SERVICE_EXT> selectServiceExt() throws Exception;
    List<SERVICE_TUNNEL> selectServiceTunnel() throws Exception;
    List<SERVICE_MSPW> selectServiceMspw() throws Exception;
    List<ODU> selectOdu() throws Exception;
    List<CES_PORT> selectCesPort() throws Exception;
    List<CES_PW> selectCesPw() throws Exception;
    List<L2_LACP> selectL2Lacp() throws Exception;
    List<OPTIC_POWER> selectOpticPower() throws Exception;

    void insertNode(NODE node) throws Exception;
    void insertSystemInfo(Tl1SystemInfo systemInfo) throws Exception;
    void insertSlot(Tl1Slot tl1Slot) throws Exception;
    void insertEthPort(ETH_PORT ethPort) throws Exception;
    void insertNodeConnector(NODECONNECTOR nodeConnector) throws Exception;
    void insertCesNodeConnector(CES_NODE_CONNECTOR cesNodeConnector) throws Exception;
    void insertOduNodeConnector(ODU_NODE_CONNECTOR oduNodeConnector) throws Exception;
    void insertMplsIf(MPLS_IF mplsIf) throws Exception;
    void insertOduMplsIf(ODU_MPLS_IF oduMplsIf) throws Exception;
    void insertSTunnel(STUNNEL stunnel) throws Exception;
    void insertSTunnelExt(STUNNEL_EXT stunnelExt) throws Exception;
    void insertSTunnelTransit(STUNNEL_TRANSIT stunnelTransit) throws Exception;
    void insertTunnelProt(TUNNEL_PROT tunnelProt) throws Exception;
    void insertSpw(SPW spw) throws Exception;
    void insertMSpw(MSPW spw) throws Exception;
    void insertMplsAc(MPLS_AC mplsAc) throws Exception;
    void insertAccessIf(Tl1AccessIf accessIf) throws Exception;
    void insertService(SERVICE service) throws Exception;
    void insertServiceExt(SERVICE_EXT serviceExt) throws Exception;
    void insertServiceTunnel(SERVICE_TUNNEL serviceTunnel) throws Exception;
    void insertServiceMspw(SERVICE_MSPW serviceMspw) throws Exception;
    void insertOdu(ODU odu) throws Exception;
    void insertCesPort(CES_PORT cesPort) throws Exception;
    void insertCesPw(CES_PW cesPw) throws Exception;
    void insertL2Lacp(L2_LACP l2Lacp) throws Exception;
    void insertOpticPower(OPTIC_POWER optic_power) throws Exception;
}