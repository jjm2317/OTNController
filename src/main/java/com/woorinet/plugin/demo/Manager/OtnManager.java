package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.DTO.TL1.Tl1AccessIf;
import com.woorinet.plugin.demo.DTO.TL1.Tl1Node;
import com.woorinet.plugin.demo.DTO.TL1.Tl1Service;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Repository.OTN.*;

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
    OtnPmPortRepository otnPmPortRepository;

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
    List<Tl1PmPort> tl1PmPortList;

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
                      OtnPmPortRepository otnPmPortRepository,
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
                      List<Tl1PmPort> tl1PmPortList) throws Exception{
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
        this.otnPmPortRepository = otnPmPortRepository;
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
        this.tl1PmPortList = tl1PmPortList;

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
        // PmPort 데이터 업데이트
        SDNSyncPmPort();
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
                        tl1SystemInfo.getVENDOR() + separator + tl1NodeState.getNODE_TYPE() + separator + tl1NodeState.getTID(), // ne_id
                        tl1NodeState.getTID(), // ne_name
                        "", //ne_type
                        tl1NodeState.getSYSTEM_TYPE(), // ne_model
                        tl1NodeState.getNODE_STATUS().equals("normal") ? tl1NodeState.getNODE_STATUS() : "broken", // ne_status
                        tl1NodeState.getSOFTWARE(), // sw_ver
                        tl1NodeState.getIP_ADDR(), // ip_addr
                        tl1SystemInfo.getVENDOR(), // vendor
                        tl1Inventory.getSERIAL_NUM().equals("---") ? "" : tl1Inventory.getSERIAL_NUM(), // serial_num
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
                        otnNode.getSys_type() +
                        separator +
                        otnNode.getNe_name() +
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
                        otnNode.getNe_id(), // ne_id
                        otnNode.getNe_name(), // ne_name
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

                String linkId = srcTl1SystemInfo.getVENDOR() + separator + srcOtnNode.getSys_type() + separator + srcOtnNode.getNe_name() + separator +
                        srcOtnConnector.getShelf_id() + separator + srcOtnConnector.getSlot_id() + separator + srcOtnConnector.getPort_id()
                        + ":" + dstTl1SystemInfo.getVENDOR() + separator + dstOtnNode.getSys_type() + separator + dstOtnNode.getNe_name() + separator +
                        dstOtnConnector.getShelf_id() + separator + dstOtnConnector.getSlot_id() + separator + dstOtnConnector.getPort_id();

                OtnLink otnLink = new OtnLink(
                        200009, // ems_id
                        200009, // dst_ems_id
                        linkId, // link_id
                        tl1OduMplsIf.getNAME(), // link_nm
                        srcOtnNode.getNe_id(), // src_ne_id
                        srcOtnNode.getNe_name(), // src_ne_name
                        srcOtnConnector.getConnect_id(), // src_node_connector_id
                        dstOtnNode.getNe_id(), // dst_ne_id
                        dstOtnNode.getNe_name(), // dst_ne_name
                        dstOtnConnector.getConnect_id(), // dst_node_connector_id
                        tl1OduNodeConnector.getPORT_TYPE(), // link_type
                        tl1OduMplsIf.getOPERATION_STATUS(), // link_status
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
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSys_type() + separator + tl1OduHead.getNAME(), // service_id
                        srcOtnNode.getNe_id(), // src_ne_id
                        srcOtnNode.getNe_name(), // src_ne_name
                        srcOtnConnector.getConnect_id(), // src_connect_id
                        tl1OduHead.getSERVICE(), // src_accessif_type
                        dstOtnNode.getNe_id(), // dst_ne_id
                        dstOtnNode.getNe_name(), // dst_ne_name
                        dstOtnConnector.getConnect_id(), // dst_connect_id
                        tl1OduTail.getSERVICE(), // dst_accessif_type
                        "", // service_type
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
                sdnServiceHashMapForPath.put(otnService.getService_name(), otnService);
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
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSys_type() + separator + tl1Odu.getNAME(), // tunnel_id
                        srcOtnNode.getNe_id(), // src_ne_id
                        srcOtnNode.getNe_name(), // src_ne_name
                        dstOtnNode.getNe_id(), // dst_ne_id
                        dstOtnNode.getNe_name(), // dst_ne_name
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
                otnPath.setEms_id(200009);
                otnPath.setService_id(otnService.getService_id());
                otnPath.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                otnPath.setConnection_idx("1");
                otnPath.setConnection_type("Forward");
                otnPath.setDirection_type("ingress");
                otnPath.setTp_type("");
                otnPath.setInstance_type("link");
                otnPath.setInstance_ref(otnLink.getLink_id());
                otnPath.setRef_type("");
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] );
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEms_id(200009);
                otnPath.setService_id(otnService.getService_id());
                otnPath.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                otnPath.setConnection_idx("2");
                otnPath.setConnection_type("Forward");
                otnPath.setDirection_type("ingress");
                otnPath.setTp_type("");
                otnPath.setInstance_type("link");
                otnPath.setInstance_ref(otnLink.getLink_id());
                otnPath.setRef_type("");
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
                otnPath.setEms_id(200009);
                otnPath.setService_id(otnService.getService_id());
                otnPath.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                otnPath.setConnection_idx("3");
                otnPath.setConnection_type("Forward");
                otnPath.setDirection_type("egress");
                otnPath.setTp_type("");
                otnPath.setInstance_type("link");
                otnPath.setInstance_ref(otnLink.getLink_id());
                otnPath.setRef_type("");
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] +'-'+ tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1]);
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                OtnPath otnPath = new OtnPath();
                otnPath.setEms_id(200009);
                otnPath.setService_id(otnService.getService_id());
                otnPath.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                otnPath.setConnection_idx("4");
                otnPath.setConnection_type("Forward");
                otnPath.setDirection_type("egress");
                otnPath.setTp_type("");
                otnPath.setInstance_type("link");
                otnPath.setInstance_ref(otnLink.getLink_id());
                otnPath.setRef_type("");
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
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSys_type() + separator + tl1Odu_head.getNAME(), // service_id
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
                        tl1SystemInfo.getVENDOR() + separator + otnNode.getSys_type() + separator + otnNode.getNe_id() + separator + otnConnector.getConnect_id(), // access_if_id
                        "", // accessif_name
                        otnNode.getNe_id(), // ne_id
                        otnConnector.getConnect_id(), // connector_id
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
            otnCryptoModule.setAID(tl1ModuleInfo.getAID());
            otnCryptoModule.setMODULE_ACT_TYPE(tl1CmPort.getUNIT_TYPE());
            otnCryptoModule.setMID(tl1ModuleInfo.getMID());
            otnCryptoModule.setPMID(tl1ModuleInfo.getPMID());
            otnCryptoModule.setMID_CONTEXT(tl1ModuleInfo.getMID_CONTEXT());
            otnCryptoModule.setPMID_CONTEXT(tl1ModuleInfo.getPMID_CONTEXT());
            otnCryptoModule.setBYPASS_MODE(tl1BypassInfo.getCURRENT_ACTION());
            otnCryptoModule.setCRYPTO_MODE(tl1ModuleInfo.getCRYPTO_MODE());
            otnCryptoModule.setCRYPTO_MODULE_PKG_VERSION(tl1CmProgramInfo.getPKG_VERSION());
            otnCryptoModule.setCRYPTO_MODULE_FPGA_VERSION(tl1CmProgramInfo.getFPGA_VERSION());
            otnCryptoModule.setCRYPTO_MODULE_CPLD_VERSION(tl1CmProgramInfo.getCPLD_VERSION());
            otnCryptoModule.setCRYPTO_MODULE_HW_VERSION(tl1CmProgramInfo.getHW_VERSION());

            System.out.println(otnCryptoModule);
            otnCryptoModuleRepository.save(otnCryptoModule);
        }
    }

    public void SDNSyncCryptoSession() throws Exception {
        Stream<OtnCryptoSession> sdnCryptoSessionStream = tl1SessStateList.stream()
            .map(tl1SessState -> {
            Tl1KeyState tl1KeyState = tl1KeyStateHashMap.get(tl1SessState.getAID());

            OtnCryptoSession otnCryptoSession = new OtnCryptoSession();

            otnCryptoSession.setAID(tl1SessState.getAID());
            otnCryptoSession.setLOCAL_IP(tl1SessState.getLOCAL_IP());
            otnCryptoSession.setREMOTE_IP(tl1SessState.getREMOTE_IP());
            otnCryptoSession.setKSP_MODE(tl1SessState.getKSP_MODE());
            otnCryptoSession.setDEAD_TIME(tl1SessState.getDEAD_TIME());
            otnCryptoSession.setRETRY_REQUEST_INTERVAL(tl1SessState.getRETRY_REQ_INTERVAL());
            otnCryptoSession.setDST_LID(tl1SessState.getDST_LID());
            otnCryptoSession.setKEY_SOURCE_MODE(tl1SessState.getKEY_SRC_MODE());
            otnCryptoSession.setKEY_FAILOVER_MODE(tl1SessState.getKEY_FAILOVER());
            otnCryptoSession.setKEY_LIFE_TIME(tl1SessState.getKEY_LIFE_TIME());
            otnCryptoSession.setTX_KEY_STATE(tl1KeyState.getTX_KEY_STATE());
            otnCryptoSession.setTX_KEY_BANK_STATE(tl1KeyState.getTX_KEY_BANK_STATE());
            otnCryptoSession.setRX_KEY_STATE(tl1KeyState.getRX_KEY_STATE());
            otnCryptoSession.setRX_KEY_BANK_STATE(tl1KeyState.getRX_KEY_BANK_STATE());

            return otnCryptoSession;
        });

        sdnCryptoSessionStream.forEach(otnCryptoSessionRepository::save);
    }

    public void SDNSyncPmPort() throws Exception {
        Stream<OtnPmPort> sdnPmPortStream = tl1PmPortList.stream()
        .map(tl1PmPort -> {
            OtnPmPort otnPmPort = new OtnPmPort();

            otnPmPort.setTID(tl1PmPort.getTID());
            otnPmPort.setAID(tl1PmPort.getAID());
            otnPmPort.setUNIT(tl1PmPort.getUNIT());
            otnPmPort.setDATE(tl1PmPort.getDATE());
            otnPmPort.setTIME(tl1PmPort.getTIME());
            otnPmPort.setIN_OCTETS(tl1PmPort.getIN_OCTETS());
            otnPmPort.setIN_OK_PACKETS(tl1PmPort.getIN_OK_PACKETS());
            otnPmPort.setIN_DISCARD_PACKETS(tl1PmPort.getIN_DISCARD_PACKETS());
            otnPmPort.setIN_ERROR_PACKETS(tl1PmPort.getIN_ERROR_PACKETS());
            otnPmPort.setIN_PAUSE_PACKETS(tl1PmPort.getIN_PAUSE_PACKETS());
            otnPmPort.setIN_ALIGNMENT_ERRORS(tl1PmPort.getIN_ALIGNMENT_ERRORS());
            otnPmPort.setIN_FCS_ERRORS(tl1PmPort.getIN_FCS_ERRORS());
            otnPmPort.setIN_SYMBOL_ERRORS(tl1PmPort.getIN_SYMBOL_ERRORS());
            otnPmPort.setOUT_OCTETS(tl1PmPort.getOUT_OCTETS());
            otnPmPort.setOUT_OK_PACKETS(tl1PmPort.getOUT_OK_PACKETS());
            otnPmPort.setOUT_UNICAST_PACKETS(tl1PmPort.getOUT_UNICAST_PACKETS());
            otnPmPort.setOUT_NON_UNICAST_PACKETS(tl1PmPort.getOUT_NON_UNICAST_PACKETS());
            otnPmPort.setOUT_DISCARD_PACKETS(tl1PmPort.getOUT_DISCARD_PACKETS());
            otnPmPort.setOUT_ERROR_PACKETS(tl1PmPort.getOUT_ERROR_PACKETS());
            otnPmPort.setOUT_BROADCAST_PACKETS(tl1PmPort.getOUT_BROADCAST_PACKETS());
            otnPmPort.setOUT_MULTICAST_PACKETS(tl1PmPort.getOUT_MULTICAST_PACKETS());
            otnPmPort.setOUT_PAUSE_PACKETS(tl1PmPort.getOUT_PAUSE_PACKETS());
            otnPmPort.setIN_RATE(tl1PmPort.getIN_RATE());
            otnPmPort.setOUT_RATE(tl1PmPort.getOUT_RATE());
            otnPmPort.setIN_LOSS_RATIO(tl1PmPort.getIN_LOSS_RATIO());
            otnPmPort.setOUT_LOSS_RATIO(tl1PmPort.getOUT_LOSS_RATIO());

            return otnPmPort;
        });

        sdnPmPortStream.forEach(otnPmPortRepository::save);

    }



}
