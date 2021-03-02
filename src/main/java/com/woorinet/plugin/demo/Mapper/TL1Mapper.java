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
    List<Tl1EthPort> selectEthPort() throws Exception;
    List<Tl1NodeConnector> selectNodeConnector() throws Exception;
    List<Tl1CesNodeConnector> selectCesNodeConnector() throws Exception;
    List<Tl1OduNodeConnector> selectOduNodeConnector() throws Exception;
    List<Tl1MplsIf> selectMplsIf() throws Exception;
    List<Tl1OduMplsIf> selectOduMplsIf() throws Exception;
    List<Tl1Stunnel> selectSTunnel() throws Exception;
    List<Tl1StunnelExt> selectSTunnelExt() throws Exception;
    List<Tl1StunnelTransit> selectSTunnelTransit() throws Exception;
    List<Tl1TunnelPort> selectTunnelProt() throws Exception;
    List<Tl1Spw> selectSpw() throws Exception;
    List<Tl1Mspw> selectMSpw() throws Exception;
    List<Tl1MplsAc> selectMplsAc() throws Exception;
    List<Tl1AccessIf> selectAccessIf() throws Exception;
    List<Tl1Service> selectService() throws Exception;
    List<Tl1ServiceExt> selectServiceExt() throws Exception;
    List<Tl1ServiceTunnel> selectServiceTunnel() throws Exception;
    List<Tl1ServiceMspw> selectServiceMspw() throws Exception;
    List<Tl1Odu> selectOdu() throws Exception;
    List<CES_PORT> selectCesPort() throws Exception;
    List<CES_PW> selectCesPw() throws Exception;
    List<L2_LACP> selectL2Lacp() throws Exception;
    List<OPTIC_POWER> selectOpticPower() throws Exception;

    void insertNode(NODE node) throws Exception;
    void insertSystemInfo(Tl1SystemInfo systemInfo) throws Exception;
    void insertSlot(Tl1Slot tl1Slot) throws Exception;
    void insertEthPort(Tl1EthPort ethPort) throws Exception;
    void insertNodeConnector(Tl1NodeConnector nodeConnector) throws Exception;
    void insertCesNodeConnector(Tl1CesNodeConnector cesNodeConnector) throws Exception;
    void insertOduNodeConnector(Tl1OduNodeConnector oduNodeConnector) throws Exception;
    void insertMplsIf(Tl1MplsIf mplsIf) throws Exception;
    void insertOduMplsIf(Tl1OduMplsIf oduMplsIf) throws Exception;
    void insertSTunnel(Tl1Stunnel tl1Stunnel) throws Exception;
    void insertSTunnelExt(Tl1StunnelExt stunnelExt) throws Exception;
    void insertSTunnelTransit(Tl1StunnelTransit stunnelTransit) throws Exception;
    void insertTunnelProt(Tl1TunnelPort tunnelProt) throws Exception;
    void insertSpw(Tl1Spw tl1Spw) throws Exception;
    void insertMSpw(Tl1Mspw spw) throws Exception;
    void insertMplsAc(Tl1MplsAc mplsAc) throws Exception;
    void insertAccessIf(Tl1AccessIf accessIf) throws Exception;
    void insertService(Tl1Service tl1Service) throws Exception;
    void insertServiceExt(Tl1ServiceExt serviceExt) throws Exception;
    void insertServiceTunnel(Tl1ServiceTunnel serviceTunnel) throws Exception;
    void insertServiceMspw(Tl1ServiceMspw serviceMspw) throws Exception;
    void insertOdu(Tl1Odu tl1Odu) throws Exception;
    void insertCesPort(CES_PORT cesPort) throws Exception;
    void insertCesPw(CES_PW cesPw) throws Exception;
    void insertL2Lacp(L2_LACP l2Lacp) throws Exception;
    void insertOpticPower(OPTIC_POWER optic_power) throws Exception;
}