package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.DTO.OTN.PM.*;
import com.woorinet.plugin.demo.DTO.TL1.PM.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Repository.OTN.*;
import com.woorinet.plugin.demo.Repository.OTN.PM.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OtnManager {
    OtnNodeRepository otnNodeRepository;
    OtnConnectorRepository otnConnectorRepository;
    OtnLinkRepository otnLinkRepository;
    OtnServiceRepository otnServiceRepository;
    OtnTunnelRepository otnTunnelRepository;
    OtnPathRepository otnPathRepository;
    OtnConstraintRepository otnConstraintRepository;
    OtnAccessIfRepository otnAccessIfRepository;
    OtnCryptoModuleRepository otnCryptoModuleRepository;
    OtnCryptoSessionRepository otnCryptoSessionRepository;
    OtnPmPwRepository otnPmPwRepository;
    OtnPmTunnelRepository otnPmTunnelRepository;
    OtnPmTemperatureRepository otnPmTemperatureRepository;
    OtnPmAcRepository otnPmAcRepository;
    OtnPmOpticRepository otnPmOpticRepository;
    OtnPmRepository otnPmRepository;
    OtnPmPortRepository otnPmPortRepository;
    OtnPmOpticTemperatureRepository otnPmOpticTemperatureRepository;

    String separator;

    List<Tl1Node> tl1NodeList;
    List<Tl1SystemInfo> tl1SystemInfoList;
    List<Tl1OduNodeConnector> tl1OduNodeConnectorList;
    List<Tl1OpticPower> tl1OpticPowerList;
    List<Tl1Odu> tl1OduList;
    List<Tl1OduMplsIf> tl1OduMplsIfList;
    List<Tl1Service> tl1ServiceList;
    List<Tl1AccessIf> tl1AccessIfList;
    List<Tl1ServiceExt> tl1ServiceExtList;
    List<Tl1MplsIf> tl1MplsIfList;
    List<List<Tl1Odu>> tl1OduListForService = new ArrayList<>();
    List<Tl1Inventory> tl1InventoryList;
    List<Tl1CmPort> tl1CmPortList;
    List<Tl1ModuleInfo> tl1ModuleInfoList;
    List<Tl1BypassInfo> tl1BypassInfoList;
    List<Tl1CmProgramInfo> tl1CmProgramInfoList;
    List<Tl1SessState> tl1SessStateList;
    List<Tl1KeyState> tl1KeyStateList;
    List<Tl1PmPw> tl1PmPwList;
    List<Tl1PmTunnel> tl1PmTunnelList;
    List<Tl1PmTemperature> tl1PmTemperatureList;
    List<Tl1PmAc> tl1PmAcList;
    List<Tl1PmOptic> tl1PmOpticList;
    List<Tl1Pm> tl1PmList;
    List<Tl1PmPort> tl1PmPortList;
    List<Tl1PmOpticTemperature> tl1PmOpticTemperatureList;

    HashMap<String, Tl1Node> tl1NodeHashMap = new HashMap<>();
    HashMap<String, Tl1SystemInfo> tl1SystemInfoHashMap = new HashMap<>();
    HashMap<String, Tl1Inventory> tl1InventoryHashMap = new HashMap<>();
    HashMap<String, Tl1OpticPower> tl1OpticPowerHashMap = new HashMap<>();
    HashMap<String, Tl1OduNodeConnector> tl1OduNodeConnectorHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduHashMapForMplsTp = new HashMap<>();
    HashMap<String, Tl1AccessIf> tl1AccessIfHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduNameTailHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduNameHeadHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduMapInMplsTpByLocalId = new HashMap<>();
    HashMap<String, Tl1OduMplsIf> tl1OduMplsIfHashMap = new HashMap<>();
    HashMap<String, List<Tl1Odu>> tl1OduHashMapForPath = new HashMap<>();
    HashMap<String, Tl1CmPort> tl1CmPortHashMap = new HashMap<>();
    HashMap<String, Tl1BypassInfo> tl1BypassInfoHashMap = new HashMap<>();
    HashMap<String, Tl1CmProgramInfo> tl1CmProgramInfoHashMap = new HashMap<>();
    HashMap<String, Tl1KeyState> tl1KeyStateHashMap = new HashMap<>();

    HashMap<String, OtnNode> sdnNodeHashMap = new HashMap<>();
    HashMap<String, OtnConnector> sdnConnectorHashMap = new HashMap<>();
    HashMap<String, OtnLink> sdnLinkHashMap = new HashMap<>();
    HashMap<String, OtnService> sdnServiceHashMapForPath = new HashMap<>();

    public OtnManager(OtnNodeRepository otnNodeRepository,
                      OtnConnectorRepository otnConnectorRepository,
                      OtnLinkRepository otnLinkRepository,
                      OtnServiceRepository otnServiceRepository,
                      OtnTunnelRepository otnTunnelRepository,
                      OtnPathRepository otnPathRepository,
                      OtnConstraintRepository otnConstraintRepository,
                      OtnAccessIfRepository otnAccessIfRepository,
                      OtnCryptoModuleRepository otnCryptoModuleRepository,
                      OtnCryptoSessionRepository otnCryptoSessionRepository,
                      OtnPmPwRepository otnPmPwRepository,
                      OtnPmTunnelRepository otnPmTunnelRepository,
                      OtnPmTemperatureRepository otnPmTemperatureRepository,
                      OtnPmAcRepository otnPmAcRepository,
                      OtnPmOpticRepository otnPmOpticRepository,
                      OtnPmRepository otnPmRepository,
                      OtnPmPortRepository otnPmPortRepository,
                      OtnPmOpticTemperatureRepository otnPmOpticTemperatureRepository,
                      List<Tl1Node> tl1NodeList,
                      List<Tl1SystemInfo> tl1SystemInfoList,
                      List<Tl1OduNodeConnector> tl1OduNodeConnectorList,
                      List<Tl1OpticPower> tl1OpticPowerList,
                      List<Tl1Odu> tl1OduList,
                      List<Tl1OduMplsIf> tl1OduMplsIfList,
                      List<Tl1Service> tl1ServiceList,
                      List<Tl1AccessIf> tl1AccessIfList,
                      List<Tl1ServiceExt> tl1ServiceExtList,
                      List<Tl1MplsIf> tl1MplsIfList,
                      List<Tl1Inventory> tl1InventoryList,
                      List<Tl1CmPort> tl1CmPortList,
                      List<Tl1ModuleInfo> tl1ModuleInfoList,
                      List<Tl1BypassInfo> tl1BypassInfoList,
                      List<Tl1CmProgramInfo> tl1CmProgramInfoList,
                      List<Tl1SessState> tl1SessStateList,
                      List<Tl1KeyState> tl1KeyStateList,
                      List<Tl1PmPw> tl1PmPwList,
                      List<Tl1PmTunnel> tl1PmTunnelList,
                      List<Tl1PmTemperature> tl1PmTemperatureList,
                      List<Tl1PmAc> tl1PmAcList,
                      List<Tl1PmOptic> tl1PmOpticList,
                      List<Tl1Pm> tl1PmList,
                      List<Tl1PmPort> tl1PmPortList,
                      List<Tl1PmOpticTemperature> tl1PmOpticTemperatureList
    ) throws Exception{
        this.otnNodeRepository = otnNodeRepository;
        this.otnConnectorRepository = otnConnectorRepository;
        this.otnLinkRepository = otnLinkRepository;
        this.otnServiceRepository = otnServiceRepository;
        this.otnTunnelRepository = otnTunnelRepository;
        this.otnPathRepository = otnPathRepository;
        this.otnConstraintRepository = otnConstraintRepository;
        this.otnAccessIfRepository = otnAccessIfRepository;
        this.otnCryptoModuleRepository = otnCryptoModuleRepository;
        this.otnCryptoSessionRepository = otnCryptoSessionRepository;
        this.otnPmPwRepository = otnPmPwRepository;
        this.otnPmTunnelRepository = otnPmTunnelRepository;
        this.otnPmTemperatureRepository = otnPmTemperatureRepository;
        this.otnPmAcRepository = otnPmAcRepository;
        this.otnPmOpticRepository = otnPmOpticRepository;
        this.otnPmRepository = otnPmRepository;
        this.otnPmPortRepository = otnPmPortRepository;
        this.otnPmOpticTemperatureRepository = otnPmOpticTemperatureRepository;

        this.separator = ".";
        this.tl1NodeList = tl1NodeList;
        this.tl1SystemInfoList = tl1SystemInfoList;
        this.tl1OduNodeConnectorList = tl1OduNodeConnectorList;
        this.tl1OpticPowerList = tl1OpticPowerList;
        this.tl1OduList = tl1OduList;
        this.tl1OduMplsIfList = tl1OduMplsIfList;
        this.tl1ServiceList = tl1ServiceList;
        this.tl1AccessIfList = tl1AccessIfList;
        this.tl1ServiceExtList = tl1ServiceExtList;
        this.tl1MplsIfList = tl1MplsIfList;
        this.tl1InventoryList = tl1InventoryList;
        this.tl1CmPortList = tl1CmPortList;
        this.tl1ModuleInfoList = tl1ModuleInfoList;
        this.tl1BypassInfoList = tl1BypassInfoList;
        this.tl1CmProgramInfoList = tl1CmProgramInfoList;
        this.tl1SessStateList = tl1SessStateList;
        this.tl1KeyStateList = tl1KeyStateList;
        this.tl1PmPwList = tl1PmPwList;
        this.tl1PmTunnelList = tl1PmTunnelList;
        this.tl1PmTemperatureList = tl1PmTemperatureList;
        this.tl1PmAcList = tl1PmAcList;
        this.tl1PmOpticList = tl1PmOpticList;
        this.tl1PmList = tl1PmList;
        this.tl1PmPortList = tl1PmPortList;
        this.tl1PmOpticTemperatureList = tl1PmOpticTemperatureList;

        makeHashMap();
    }

    private void makeHashMap() {
        for(Tl1Node tl1Node : tl1NodeList) {
            tl1NodeHashMap.put(tl1Node.getTID(), tl1Node);
        }
        for(Tl1SystemInfo tl1SystemInfo : tl1SystemInfoList) {
            tl1SystemInfoHashMap.put(tl1SystemInfo.getTID(), tl1SystemInfo);
        }
        for(Tl1Inventory tl1Inventory : tl1InventoryList) {
            tl1InventoryHashMap.put(tl1Inventory.getTID(), tl1Inventory);
        }
        for(Tl1OpticPower tl1OpticPower : tl1OpticPowerList) {
            tl1OpticPowerHashMap.put(tl1OpticPower.getTID()+"/"+ tl1OpticPower.getAID(), tl1OpticPower);
        }
        for(Tl1Odu tl1Odu : tl1OduList) {
            if(tl1OduHashMapForPath.get(tl1Odu.getNAME()) == null ) {
                List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                tl1Odu_list.add(tl1Odu);
                tl1OduHashMapForPath.put(tl1Odu.getNAME(), tl1Odu_list);
            } else {
                List<Tl1Odu> tl1Odu_list = tl1OduHashMapForPath.get(tl1Odu.getNAME());
                tl1Odu_list.add(tl1Odu);
                tl1OduHashMapForPath.put(tl1Odu.getNAME(), tl1Odu_list);
            }

            if(tl1Odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                tl1OduHashMapForOduTunnel.put(tl1Odu.getTID() + '/' + tl1Odu.getLOCAL_ID().split("-")[0] +'-'+ tl1Odu.getLOCAL_ID().split("-")[1], tl1Odu);
                if (tl1Odu.getROLE().equals("TAIL")) {
                    tl1OduNameTailHashMapForOduTunnel.put(tl1Odu.getNAME(), tl1Odu);

                    if (tl1OduNameHeadHashMapForOduTunnel.get(tl1Odu.getNAME()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(tl1OduNameHeadHashMapForOduTunnel.get(tl1Odu.getNAME()));
                        tl1Odu_list.add(tl1Odu);
                        tl1OduListForService.add(tl1Odu_list);
                    }
                } else {
                    tl1OduNameHeadHashMapForOduTunnel.put(tl1Odu.getNAME(), tl1Odu);

                    if (tl1OduNameTailHashMapForOduTunnel.get(tl1Odu.getNAME()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(tl1Odu);
                        tl1Odu_list.add(tl1OduNameTailHashMapForOduTunnel.get(tl1Odu.getNAME()));
                        tl1OduListForService.add(tl1Odu_list);
                    }
                }
            } else if (tl1Odu.getEMS_SERVICE().equals("MPLS_TP")) {
                tl1OduMapInMplsTpByLocalId.put(tl1Odu.getTID()+'/'+ tl1Odu.getLOCAL_ID(), tl1Odu);
                tl1OduHashMapForMplsTp.put(tl1Odu.getTID()+ '/' + tl1Odu.getLOCAL_ID().split("-")[0] +'-'+ tl1Odu.getLOCAL_ID().split("-")[1], tl1Odu);
            }



        }
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            tl1OduNodeConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), tl1OduNodeConnector);
        }
        for(Tl1AccessIf Tl1AccessIf : tl1AccessIfList) {
            tl1AccessIfHashMap.put(Tl1AccessIf.getTID(), Tl1AccessIf);
        }
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfList) {
            tl1OduMplsIfHashMap.put(tl1OduMplsIf.getTID()+'/'+ tl1OduMplsIf.getMPLS_TP_ID(), tl1OduMplsIf);
        }
        for(Tl1CmPort tl1CmPort : tl1CmPortList) {
            tl1CmPortHashMap.put(tl1CmPort.getAID(), tl1CmPort);
        }
        for(Tl1BypassInfo tl1BypassInfo :tl1BypassInfoList) {
            tl1BypassInfoHashMap.put(tl1BypassInfo.getAID(), tl1BypassInfo);
        }
        for(Tl1CmProgramInfo tl1CmProgramInfo : tl1CmProgramInfoList) {
            tl1CmProgramInfoHashMap.put(tl1CmProgramInfo.getAID(), tl1CmProgramInfo);
        }

        Stream<Tl1KeyState> tl1KeyStateStream = tl1KeyStateList.stream();
        tl1KeyStateStream.forEach(keystate -> tl1KeyStateHashMap.put(keystate.getAID(), keystate));
        for (Map.Entry<String, Tl1KeyState> entry : tl1KeyStateHashMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public void SDNSyncStart() throws Exception {
        OTNSyncPmPw();
        OTNSyncPmTunnel();
        OTNSyncPmTemperature();
        OTNSyncPmAc();
        OTNSyncPmOptic();
        OTNSyncPm();
        OTNSyncPmPort();
        OTNSyncPmOpticTemperature();
        // Node 데이터 업데이트
        SDNSyncNodeList();
        // Connector 데이터 업데이트
        SDNSyncConnectorList();
        // Link 데이터 업데이트
        SDNSyncLinkList();
        // Tunnel 데이터 업데이트
        SDNSyncTunnelList();
        // Service 데이터 업데이트
        SDNSyncServiceList();
        // Path 데이터 업데이트
        SDNSyncPathList();
        // Constraint 데이터 업데이트
        SDNSyncConstraint();
        // AccessIf 데이터 업데이트
        SDNSyncAccess_if();
        // CryptoModule 데이터 업데이트
        SDNSyncCryptoModule();
        // CryptoSession 데이터 업데이트
        SDNSyncCryptoSession();
    }

    private void SDNSyncNodeList() throws Exception {
        Stream<OtnNode> sdnNodeStream = tl1NodeList
            .stream()
            .filter(tl1NodeState -> tl1NodeState.getNODE_TYPE().equals("otn"))
            .map(tl1NodeState -> {
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1NodeState.getTID());
                Tl1Inventory tl1Inventory = tl1InventoryHashMap.get(tl1NodeState.getTID());

                OtnNode otnNode = new OtnNode(
                        200009, // ems_id
                        tl1SystemInfo==null? tl1NodeState.getNODE_TYPE() + separator + tl1NodeState.getTID(): tl1SystemInfo.getVENDOR() + separator + tl1NodeState.getNODE_TYPE() + separator + tl1NodeState.getTID(), // ne_id
                        tl1NodeState.getTID(), // ne_name
                        "", //ne_type
                        tl1NodeState.getSYSTEM_TYPE(), // ne_model
                        tl1NodeState.getNODE_STATUS().equals("normal") ? tl1NodeState.getNODE_STATUS() : "broken", // ne_status
                        tl1NodeState.getSOFTWARE(), // sw_ver
                        tl1NodeState.getIP_ADDR(), // ip_addr
                        tl1SystemInfo==null? "":tl1SystemInfo.getVENDOR(), // vendor
                        tl1Inventory==null||tl1Inventory.getSERIAL_NUM().equals("---") ? "" : tl1Inventory.getSERIAL_NUM(), // serial_num
                        tl1NodeState.getNODE_TYPE() // sys_type
                );

                sdnNodeHashMap.put(tl1NodeState.getTID(), otnNode);
                return otnNode;
            });
        sdnNodeStream.forEach(otnNodeRepository::save);
    }

    public void SDNSyncConnectorList( ) throws Exception {
        Stream<OtnConnector> sdnConnectorStream = tl1OduNodeConnectorList
            .stream()
            .map(tl1OduNodeConnector -> {
                Tl1Node tl1Node = tl1NodeHashMap.get(tl1OduNodeConnector.getTID());
                OtnNode otnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTID());
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduNodeConnector.getTID()+"/"+ tl1OduNodeConnector.getAID());
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1Node.getTID());

                String connectId = tl1SystemInfo.getVENDOR() +
                        separator +
                        otnNode.getSysType() +
                        separator +
                        otnNode.getNeName() +
                        separator +
                        tl1OduNodeConnector.getSHELF_INDEX() +
                        separator +
                        tl1OduNodeConnector.getSLOT_INDEX() +
                        separator +
                        tl1OduNodeConnector.getPORT_INDEX();
                String connectType = "";
                if (tl1OpticPower != null) {
                    if (tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2")) connectType = "sfp+";
                    else if (tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2") || tl1OpticPower.getPART_NUMBER().equals("EOLP-1396-10") || tl1OpticPower.getPART_NUMBER().equals("FTLX1471D3BNL"))
                        connectType = "sfp";
                    else connectType = tl1OpticPower.getPART_NUMBER(); // 구글링 해야됨
                }

                OtnConnector otnConnector = new OtnConnector(
                        200009, // ems_id
                        connectId, // connect_id
                        "", // connect_name
                        tl1OpticPower == null ? "" : connectType, // connect_type
                        otnNode.getNeId(), // ne_id
                        otnNode.getNeName(), // ne_name
                        "", // rack_id
                        tl1OduNodeConnector.getSHELF_INDEX(), // shelf_id
                        tl1OduNodeConnector.getSLOT_INDEX(), // slot_id
                        "", // subslot_id
                        tl1OduNodeConnector.getPORT_INDEX(), // port_id
                        tl1OduNodeConnector.getPORT_STATUS().equals("ACT") ? "up" : "down", // connect_status
                        tl1OduNodeConnector.getPORT_ROLE(), // connect_role
                        tl1OpticPower == null ? "idle" : "occupied", // connect_idle
                        tl1OpticPower == null ? "" : "", // connect_llcf
                        tl1OpticPower == null ? "" : tl1OpticPower.getTX_WAVELENGTH(), // connect_lambda
                        tl1OpticPower == null ? "" : tl1OpticPower.getPART_NUMBER(), // module_name
                        tl1OpticPower == null ? "" : "", // connect_pec
                        tl1OpticPower == null ? "" : tl1OpticPower.getSERIAL(), // connect_serial
                        tl1OpticPower == null ? "" : tl1OpticPower.getUNIT_TYPE() // unit_type
                );
                sdnConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), otnConnector);
                return otnConnector;
            });
        sdnConnectorStream.forEach(otnConnectorRepository::save);
    }

    public void SDNSyncLinkList ( ) throws Exception {
        Stream<OtnLink> sdnLinkStream = tl1OduMplsIfList
            .stream()
            .map(tl1OduMplsIf -> {
                Tl1SystemInfo srcTl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getSRC_TID());
                Tl1SystemInfo dstTl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getDST_TID());
                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1OduMplsIf.getSRC_TID());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1OduMplsIf.getDST_TID());
                OtnConnector srcOtnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());
                OtnConnector dstOtnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getDST_TID()+ '/' + tl1OduMplsIf.getDST_PORT());
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduMplsIf.getTID() + '/' + tl1OduMplsIf.getMPLS_TP_ID());
                Tl1Odu tl1Odu = tl1OduHashMapForOduTunnel.get(tl1OduMplsIf.getTID()+ '/' + tl1OduMplsIf.getMPLS_TP_ID());
                Tl1OduNodeConnector tl1OduNodeConnector = tl1OduNodeConnectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());

                int maximumBandwidth = Integer.parseInt(tl1OduMplsIf.getMAXIMUM_BANDWIDTH());
                int availableBandwidth = Integer.parseInt(tl1OduMplsIf.getAVAILABLE_BANDWIDTH());

                String linkId = srcTl1SystemInfo.getVENDOR() + separator + srcOtnNode.getSysType() + separator + srcOtnNode.getNeName() + separator +
                        srcOtnConnector.getShelfId() + separator + srcOtnConnector.getSlotId() + separator + srcOtnConnector.getPortId()
                        + ":" + dstTl1SystemInfo.getVENDOR() + separator + dstOtnNode.getSysType() + separator + dstOtnNode.getNeName() + separator +
                        dstOtnConnector.getShelfId() + separator + dstOtnConnector.getSlotId() + separator + dstOtnConnector.getPortId();

                OtnLink otnLink = new OtnLink(
                        200009, // ems_id
                        200009, // dst_ems_id
                        linkId, // link_id
                        tl1OduMplsIf.getNAME(), // link_nm
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        srcOtnConnector.getConnectId(), // src_node_connector_id
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        dstOtnConnector.getConnectId(), // dst_node_connector_id
                        tl1OduMplsIf.getLINK_TYPE(), // link_type
                        tl1OduNodeConnector.getPORT_STATUS(), // link_status
                        "", // link_category
                        "", // high_order_tunnel
                        "", // latency
                        tl1OpticPower.getDISTANCE(), // distance
                        "", // srlg
                        "", // ovpn
                        tl1Odu==null? "": tl1Odu.getTSMAP(), // timeslot
                        tl1OpticPower.getTX_WAVELENGTH(), // lambda
                        maximumBandwidth, // maximum_odu0s
                        maximumBandwidth/2, // maximum_odu1s
                        maximumBandwidth/8, // maximum_odu2s
                        maximumBandwidth/8, // maximum_odu2es
                        maximumBandwidth/32, // maximum_odu3s
                        maximumBandwidth/80, // maximum_odu4s
                        maximumBandwidth/160, // maximum_odu4cns
                        -1, // maximum_oduflexs
                        availableBandwidth, // available_odu0s
                        availableBandwidth/2, // available_odu1s
                        availableBandwidth/8, // available_odu2s
                        availableBandwidth/8, // available_odu2es
                        availableBandwidth/32, // available_odu3s
                        availableBandwidth/80, // available_odu4s
                        availableBandwidth/160, // available_odu4cns
                        -1 // available_oduflexs
                );

                sdnLinkHashMap.put(tl1OduMplsIf.getSRC_TID() + '/' + tl1OduMplsIf.getSRC_PORT() + '-' + tl1OduMplsIf.getDST_TID() + '/' + tl1OduMplsIf.getDST_PORT(), otnLink);

                return otnLink;
            });
        sdnLinkStream.forEach(otnLinkRepository::save);
    }

    public void SDNSyncServiceList( ) throws Exception {

        Stream<OtnService> sdnServiceStream = tl1OduListForService
            .stream()
            .map(tl1OduList -> {
                Tl1Odu tl1OduHead = tl1OduList.get(0);
                Tl1Odu tl1OduTail = tl1OduList.get(1);

                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1OduHead.getTID());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1OduTail.getTID());
                OtnConnector srcOtnConnector = sdnConnectorHashMap.get(tl1OduHead.getTID()+ '/' + tl1OduHead.getLOCAL_ID().split("-")[0] + "-" + tl1OduHead.getLOCAL_ID().split("-")[1]);
                OtnConnector dstOtnConnector = sdnConnectorHashMap.get(tl1OduTail.getTID()+ '/' + tl1OduTail.getLOCAL_ID().split("-")[0] + "-" + tl1OduTail.getLOCAL_ID().split("-")[1]);
                Tl1OduMplsIf tl1OduMplsIf = tl1OduMplsIfHashMap.get(tl1OduHead.getTID() + '/' + tl1OduHead.getLOCAL_ID().split("-")[0] + "-" + tl1OduHead.getLOCAL_ID().split("-")[1]);
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduHead.getTID() + '/' + tl1OduHead.getLOCAL_ID().split("-")[0] + "-" + tl1OduHead.getLOCAL_ID().split("-")[1]);

                OtnService otnService = new OtnService(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1OduHead.getNAME(), // service_id
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        srcOtnConnector.getConnectId(), // src_connect_id
                        tl1OduHead.getEMS_SERVICE() + "," + tl1OduHead.getEMS_SERVICE_SIG(), // src_accessif_type
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        dstOtnConnector.getConnectId(), // dst_connect_id
                        tl1OduTail.getEMS_SERVICE() + "," + tl1OduTail.getEMS_SERVICE_SIG(), // dst_accessif_type
                        tl1OduHead.getTYPE(), // service_type
                        tl1OduHead.getNAME(), // service_name
                        "", // network_type
                        "", // service_status
                        tl1OduHead.getTYPE(), // rate_type
                        tl1OduMplsIf.getLINK_TYPE(), // service_rate
                        "", // latency
                        tl1OpticPower == null ? "" : tl1OpticPower.getTX_WAVELENGTH(), // wavelength
                        tl1OduHead.getACTIVE_PATH_STATUS(), // active_path
                        tl1OduHead.getCREATION_DATE() // creation_date
                );
                sdnServiceHashMapForPath.put(otnService.getServiceName(), otnService);
                return otnService;
            });
        sdnServiceStream.forEach(otnServiceRepository::save);
    }

    public void SDNSyncTunnelList( ) throws  Exception {
        Stream<OtnTunnel> sdnTunnelStream = tl1OduList
            .stream()
            .map(tl1Odu -> {
                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1Odu.getEMS_SRC_LSR());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1Odu.getEMS_DST_LSR());

                OtnTunnel otnTunnel = new OtnTunnel(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1Odu.getNAME(), // tunnel_id
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        tl1Odu.getTYPE(), // rate_type
                        "1", // multiple_rate
                        "", // local_id
                        "", // request_id
                        tl1Odu.getNAME(), // tunnel_name
                        tl1Odu.getEMS_SERVICE().equals("ODU_TUNNEL")?"otn":tl1Odu.getEMS_SERVICE(), // tunnel_type
                        "", // tunnel_status
                        "", // configuration_action
                        "", // configuration_result_type
                        "", // tunnel_oam_enabler
                        "", // deployment_enabler
                        "", // deployment_status
                        tl1Odu.getACTIVE_PATH_STATUS(), // active_path
                        "", // src_node_ref
                        "", // dst_node_ref
                        "", // service_ref
                        "", // accessif_ref
                        tl1Odu.getPROT_TYPE(), // protection_type
                        "", // working_path
                        "", // protection_path
                        "", // service_mapping
                        tl1Odu.getCREATION_DATE() // creation_date
                );

                return otnTunnel;
            });
        sdnTunnelStream.forEach(otnTunnelRepository::save);
    }

    public void SDNSyncPathList() throws  Exception {
        for (Map.Entry<String, List<Tl1Odu>> entry : tl1OduHashMapForPath.entrySet() ) {
            List<Tl1Odu> tl1Odu_list = entry.getValue();
            if(tl1Odu_list.size() != 4) continue;

            Tl1Odu tl1Odu_head = null;
            Tl1Odu tl1Odu_tail = null;
            Tl1Odu tl1Odu_transit_from = null;
            Tl1Odu tl1Odu_transit_to = null;
            for(Tl1Odu tl1Odu : tl1Odu_list) {
                if (tl1Odu.getROLE().equals("TRANSIT_FROM")) tl1Odu_transit_from = tl1Odu;
                else if(tl1Odu.getROLE().equals("TRANSIT_TO")) tl1Odu_transit_to = tl1Odu;
                else if(tl1Odu.getROLE().equals("HEAD")) tl1Odu_head = tl1Odu;
                else tl1Odu_tail = tl1Odu;
            }

            tl1Odu_list.set(0, tl1Odu_head);
            tl1Odu_list.set(1, tl1Odu_transit_from);
            tl1Odu_list.set(2, tl1Odu_transit_to);
            tl1Odu_list.set(3, tl1Odu_tail);


            { // HEAD <--> TRANSIT_FROM
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] );
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_head.getACTIVE_PATH_STATUS());
                otnPath.setConnectionIdx("1");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("ingress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] );
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                otnPath.setConnectionIdx("2");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("ingress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPathRepository.save(otnPath);
            }
        }

        for (Map.Entry<String, List<Tl1Odu>> entry : tl1OduHashMapForPath.entrySet() ) {
            List<Tl1Odu> tl1Odu_list = entry.getValue();
            if(tl1Odu_list.size() != 4) continue;

            Tl1Odu tl1Odu_head = null;
            Tl1Odu tl1Odu_tail = null;
            Tl1Odu tl1Odu_transit_from = null;
            Tl1Odu tl1Odu_transit_to = null;
            for(Tl1Odu tl1Odu : tl1Odu_list) {
                if (tl1Odu.getROLE().equals("TRANSIT_FROM")) tl1Odu_transit_from = tl1Odu;
                else if(tl1Odu.getROLE().equals("TRANSIT_TO")) tl1Odu_transit_to = tl1Odu;
                else if(tl1Odu.getROLE().equals("HEAD")) tl1Odu_head = tl1Odu;
                else tl1Odu_tail = tl1Odu;
            }

            tl1Odu_list.set(0, tl1Odu_head);
            tl1Odu_list.set(1, tl1Odu_transit_from);
            tl1Odu_list.set(2, tl1Odu_transit_to);
            tl1Odu_list.set(3, tl1Odu_tail);


            { // HEAD <--> TRANSIT_FROM
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1]);
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_head.getACTIVE_PATH_STATUS());
                otnPath.setConnectionIdx("3");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("egress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] +'-'+ tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1]);
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                otnPath.setConnectionIdx("4");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("egress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPathRepository.save(otnPath);
            }
        }

    }

    public void SDNSyncConstraint() throws Exception {
        Stream<OtnConstraint> sdnConstraintStream = tl1OduListForService
            .stream()
            .map(tl1OduList -> {
                Tl1Odu tl1Odu_head = tl1OduList.get(0);
                Tl1Odu tl1Odu_tail = tl1OduList.get(1);

                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1Odu_head.getTID());

                OtnConstraint otnConstraint = new OtnConstraint(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1Odu_head.getNAME(), // service_id
                        "protection type", // const_id
                        "", // const_type
                        "PROTECTION TYPE", // const_name
                        tl1Odu_head.getPROT_TYPE(), // const_value
                        "" // const_operator
                );

                return otnConstraint;
            });
        sdnConstraintStream.forEach(otnConstraintRepository::save);
    }

    public void SDNSyncAccess_if() throws Exception {
        Stream<OtnAccessIf> sdnAccessIfStream = tl1MplsIfList
            .stream()
            .filter(tl1MplsIf -> tl1OduHashMapForMplsTp.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]) != null)
            .map(tl1MplsIf -> {
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1MplsIf.getTID());
                OtnNode otnNode = sdnNodeHashMap.get(tl1MplsIf.getTID());
                OtnConnector otnConnector = sdnConnectorHashMap.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);
                Tl1Odu tl1Odu = tl1OduHashMapForMplsTp.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);

                OtnAccessIf otnAccessIf = new OtnAccessIf(
                        200009, // ems_id
                        tl1SystemInfo.getVENDOR() + separator + otnNode.getSysType() + separator + otnNode.getNeId() + separator + otnConnector.getConnectId(), // access_if_id
                        "", // accessif_name
                        otnNode.getNeId(), // ne_id
                        otnConnector.getConnectId(), // connector_id
                        tl1Odu.getSERVICE(), // accessif_type
                        tl1MplsIf.getOPERATION_STATUS(), // accessif_status
                        "", // service_ref
                        "" // node_connector_ref
                );

                return otnAccessIf;
            });
        sdnAccessIfStream.forEach(otnAccessIfRepository::save);
    }

    public void SDNSyncCryptoModule() throws Exception {
        for(Tl1ModuleInfo tl1ModuleInfo : tl1ModuleInfoList) {
            // aidPieces: [노드이름, 유니트 이름, 슬롯, 포트]
            String[] aidPieces = tl1ModuleInfo.getAID().split("-");
            Tl1CmPort tl1CmPort = tl1CmPortHashMap.get(tl1ModuleInfo.getAID());
            Tl1BypassInfo tl1BypassInfo = tl1BypassInfoHashMap.get(aidPieces[2] + "-" + aidPieces[3]);
            Tl1CmProgramInfo tl1CmProgramInfo = tl1CmProgramInfoHashMap.get(aidPieces[0] + "-" + aidPieces[1] + "-" + aidPieces[2]);

            OtnCryptoModule otnCryptoModule = new OtnCryptoModule();
            otnCryptoModule.setAid(tl1ModuleInfo.getAID());
            otnCryptoModule.setModuleActType(tl1CmPort.getUNIT_TYPE());
            otnCryptoModule.setMid(tl1ModuleInfo.getMID());
            otnCryptoModule.setPmid(tl1ModuleInfo.getPMID());
            otnCryptoModule.setMidContext(tl1ModuleInfo.getMID_CONTEXT());
            otnCryptoModule.setPmidContext(tl1ModuleInfo.getPMID_CONTEXT());
            otnCryptoModule.setBypassMode(tl1BypassInfo.getCURRENT_ACTION());
            otnCryptoModule.setCryptoMode(tl1ModuleInfo.getCRYPTO_MODE());
            otnCryptoModule.setCryptoModulePkgVersion(tl1CmProgramInfo.getPKG_VERSION());
            otnCryptoModule.setCryptoModuleFpgaVersion(tl1CmProgramInfo.getFPGA_VERSION());
            otnCryptoModule.setCryptoModuleCpldVersion(tl1CmProgramInfo.getCPLD_VERSION());
            otnCryptoModule.setCryptoModuleHwVersion(tl1CmProgramInfo.getHW_VERSION());

            System.out.println(otnCryptoModule);
            otnCryptoModuleRepository.save(otnCryptoModule);
        }
    }

    public void SDNSyncCryptoSession() throws Exception {
        Stream<OtnCryptoSession> sdnCryptoSessionStream = tl1SessStateList.stream()
            .map(tl1SessState -> {
            Tl1KeyState tl1KeyState = tl1KeyStateHashMap.get(tl1SessState.getAID());

            OtnCryptoSession otnCryptoSession = new OtnCryptoSession();

            otnCryptoSession.setAid(tl1SessState.getAID());
            otnCryptoSession.setLocalIp(tl1SessState.getLOCAL_IP());
            otnCryptoSession.setRemoteIp(tl1SessState.getREMOTE_IP());
            otnCryptoSession.setKspMode(tl1SessState.getKSP_MODE());
            otnCryptoSession.setDeadTime(tl1SessState.getDEAD_TIME());
            otnCryptoSession.setRetryRequestInterval(tl1SessState.getRETRY_REQ_INTERVAL());
            otnCryptoSession.setDstLid(tl1SessState.getDST_LID());
            otnCryptoSession.setKeySourceMode(tl1SessState.getKEY_SRC_MODE());
            otnCryptoSession.setKeyFailoverMode(tl1SessState.getKEY_FAILOVER());
            otnCryptoSession.setKeyLifeTime(tl1SessState.getKEY_LIFE_TIME());
            otnCryptoSession.setTxKeyState(tl1KeyState.getTX_KEY_STATE());
            otnCryptoSession.setTxKeyBankState(tl1KeyState.getTX_KEY_BANK_STATE());
            otnCryptoSession.setRxKeyState(tl1KeyState.getRX_KEY_STATE());
            otnCryptoSession.setRxKeyBankState(tl1KeyState.getRX_KEY_BANK_STATE());

            return otnCryptoSession;
        });

        sdnCryptoSessionStream.forEach(otnCryptoSessionRepository::save);
    }

    public void OTNSyncPmPw() throws Exception {
        Stream<OtnPmPw> otnPmPwStream = tl1PmPwList.stream()
            .map(tl1PmPw -> {
               OtnPmPw otnPmPw = new OtnPmPw(
                       tl1PmPw.getTid(),
                       tl1PmPw.getSystemType(),
                       tl1PmPw.getSlot(),
                       tl1PmPw.getPort(),
                       tl1PmPw.getTime(),
                       tl1PmPw.getName(),
                       tl1PmPw.getIngPackets(),
                       tl1PmPw.getIngBytes(),
                       tl1PmPw.getIngRate(),
                       tl1PmPw.getEgrPackets(),
                       tl1PmPw.getEgrBytes(),
                       tl1PmPw.getEgrRate(),
                       tl1PmPw.getDate()
               );
               return otnPmPw;
            });
        otnPmPwStream.forEach(otnPmPwRepository::save);
    }

    public void OTNSyncPmTunnel() throws Exception {
        Stream<OtnPmTunnel> otnPmTunnelStream = tl1PmTunnelList.stream()
            .map(tl1PmTunnel -> {
               OtnPmTunnel otnPmTunnel = new OtnPmTunnel(
                       tl1PmTunnel.getTid(),
                       tl1PmTunnel.getSystemType(),
                       tl1PmTunnel.getSlot(),
                       tl1PmTunnel.getPort(),
                       tl1PmTunnel.getTime(),
                       tl1PmTunnel.getName(),
                       tl1PmTunnel.getIngPackets(),
                       tl1PmTunnel.getIngBytes(),
                       tl1PmTunnel.getIngRate(),
                       tl1PmTunnel.getEgrPackets(),
                       tl1PmTunnel.getEgrBytes(),
                       tl1PmTunnel.getEgrRate(),
                       tl1PmTunnel.getDate()
               );
               return otnPmTunnel;
            });
        otnPmTunnelStream.forEach(otnPmTunnelRepository::save);
    }

    public void OTNSyncPmTemperature() throws Exception {
        Stream<OtnPmTemperature> otnPmTemperatureStream = tl1PmTemperatureList.stream()
            .map(tl1PmTemperature -> {
               OtnPmTemperature otnPmTemperature = new OtnPmTemperature(
                       tl1PmTemperature.getTid(),
                       tl1PmTemperature.getSystemType(),
                       tl1PmTemperature.getSlot(),
                       tl1PmTemperature.getTime(),
                       tl1PmTemperature.getMax(),
                       tl1PmTemperature.getMin(),
                       tl1PmTemperature.getAverage(),
                       tl1PmTemperature.getDate()
                       );
               return otnPmTemperature;
            });
        otnPmTemperatureStream.forEach(otnPmTemperatureRepository::save);
    }

    public void OTNSyncPmAc() throws Exception {
        Stream<OtnPmAc> otnPmAcStream = tl1PmAcList.stream()
            .map(tl1PmAc -> {
               OtnPmAc otnPmAc = new OtnPmAc(
                       tl1PmAc.getTid(),
                       tl1PmAc.getSystemType(),
                       tl1PmAc.getSlot(),
                       tl1PmAc.getPort(),
                       tl1PmAc.getTime(),
                       tl1PmAc.getName(),
                       tl1PmAc.getIngPackets(),
                       tl1PmAc.getIngBytes(),
                       tl1PmAc.getIngRate(),
                       tl1PmAc.getEgrPackets(),
                       tl1PmAc.getEgrBytes(),
                       tl1PmAc.getEgrRate(),
                       tl1PmAc.getDate()
               );
               return otnPmAc;
            });
        otnPmAcStream.forEach(otnPmAcRepository::save);
    }

    public void OTNSyncPmOptic() throws Exception {
        Stream<OtnPmOptic> otnPmOpticStream = tl1PmOpticList.stream()
            .map(tl1PmOptic -> {
               OtnPmOptic otnPmOptic = new OtnPmOptic(
                       tl1PmOptic.getTid(),
                       tl1PmOptic.getSystemType(),
                       tl1PmOptic.getSlot(),
                       tl1PmOptic.getPort(),
                       tl1PmOptic.getPmType(),
                       tl1PmOptic.getRxMinPower(),
                       tl1PmOptic.getRxMaxPower(),
                       tl1PmOptic.getRxAvgPower(),
                       tl1PmOptic.getTxMinPower(),
                       tl1PmOptic.getTxMaxPower(),
                       tl1PmOptic.getTxAvgPower(),
                       tl1PmOptic.getDate()
               );
               return otnPmOptic;
            });
        otnPmOpticStream.forEach(otnPmOpticRepository::save);
    }

    public void OTNSyncPm() throws Exception {
        Stream<OtnPm> otnPmStream = tl1PmList.stream()
            .map(tl1Pm -> {
               OtnPm otnPm = new OtnPm(
                   tl1Pm.getTid(),
                   tl1Pm.getSystemType(),
                   tl1Pm.getSlot(),
                   tl1Pm.getPort(),
                   tl1Pm.getSignal(),
                   tl1Pm.getTime(),
                   tl1Pm.getInErrorPackets(),
                   tl1Pm.getEs(),
                   tl1Pm.getSes(),
                   tl1Pm.getUas(),
                   tl1Pm.getInDiscardPackets(),
                   tl1Pm.getOutErrorPackets(),
                   tl1Pm.getOutDiscardPackets(),
                   tl1Pm.getDate()
               );
               return otnPm;
            });
        otnPmStream.forEach(otnPmRepository::save);
    }

    public void OTNSyncPmPort() throws Exception {
        Stream<OtnPmPort> sdnPmPortStream = tl1PmPortList.stream()
        .map(tl1PmPort -> {
            OtnPmPort otnPmPort = new OtnPmPort(
                    tl1PmPort.getTid(),
                    tl1PmPort.getSystemType(),
                    tl1PmPort.getSlot(),
                    tl1PmPort.getPort(),
                    tl1PmPort.getTime(),
                    tl1PmPort.getInOctets(),
                    tl1PmPort.getInOkPackets(),
                    tl1PmPort.getInDiscardPackets(),
                    tl1PmPort.getInErrorPackets(),
                    tl1PmPort.getInPausePackets(),
                    tl1PmPort.getInAlignmentErrors(),
                    tl1PmPort.getInFcsErrors(),
                    tl1PmPort.getInSymbolErrors(),
                    tl1PmPort.getOutOctets(),
                    tl1PmPort.getOutOkPackets(),
                    tl1PmPort.getOutUnicastPackets(),
                    tl1PmPort.getOutNonUnicastPackets(),
                    tl1PmPort.getOutDiscardPackets(),
                    tl1PmPort.getOutErrorPackets(),
                    tl1PmPort.getOutBroadcastPackets(),
                    tl1PmPort.getOutMulticastPackets(),
                    tl1PmPort.getOutPausePackets(),
                    tl1PmPort.getInRate(),
                    tl1PmPort.getOutRate(),
                    tl1PmPort.getInLossRatio(),
                    tl1PmPort.getOutLossRatio(),
                    tl1PmPort.getDate()
            );

            return otnPmPort;
        });
        sdnPmPortStream.forEach(otnPmPortRepository::save);
    }
    public void OTNSyncPmOpticTemperature() throws Exception {
        Stream<OtnPmOpticTemperature> otnPmOpticTemperatureStream = tl1PmOpticTemperatureList.stream()
            .map(tl1PmOpticTemperature -> {
               OtnPmOpticTemperature otnPmOpticTemperature = new OtnPmOpticTemperature(
                       tl1PmOpticTemperature.getTid(),
                       tl1PmOpticTemperature.getSystemType(),
                       tl1PmOpticTemperature.getSlot(),
                       tl1PmOpticTemperature.getTime(),
                       tl1PmOpticTemperature.getMax(),
                       tl1PmOpticTemperature.getMin(),
                       tl1PmOpticTemperature.getAverage(),
                       tl1PmOpticTemperature.getDate()
               );
               return otnPmOpticTemperature;
            });
        otnPmOpticTemperatureStream.forEach(otnPmOpticTemperatureRepository::save);
    }



}
