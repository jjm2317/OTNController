package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.DTO.TL1.Tl1AccessIf;
import com.woorinet.plugin.demo.DTO.TL1.Tl1Node;
import com.woorinet.plugin.demo.DTO.TL1.Tl1Service;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Repository.SDN.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SDNManager {
    SdnNodeRepository sdnNodeRepository;
    SdnConnectorRepository sdnConnectorRepository;
    SdnLinkRepository sdnLinkRepository;
    SdnServiceRepository sdnServiceRepository;
    SdnTunnelRepository sdnTunnelRepository;
    SdnPathRepository sdnPathRepository;
    SdnConstraintRepository sdnConstraintRepository;
    SdnAccessIfRepository sdnAccessIfRepository;
    SdnCryptoModuleRepository sdnCryptoModuleRepository;
    SdnCryptoSessionRepository sdnCryptoSessionRepository;
    SdnPmPortRepository sdnPmPortRepository;

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
    List<List<Tl1Odu>> odu_list_for_service = new ArrayList<>();
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
    HashMap<String, Tl1OduNodeConnector> odu_node_connectorHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> oduHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, Tl1Odu> oduHashMapForMPLSTP = new HashMap<>();
    HashMap<String, Tl1AccessIf> access_ifHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> oduNameTailHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, Tl1Odu> oduNameHeadHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, Tl1Odu> oduMapInMPLSTPByLocalId = new HashMap<>();
    HashMap<String, Tl1OduMplsIf> odu_mpls_ifHashMap = new HashMap<>();
    HashMap<String, List<Tl1Odu>> odu_hashMapForPath = new HashMap<>();
    HashMap<String, Tl1CmPort> tl1CmPortHashMap = new HashMap<>();
    HashMap<String, Tl1BypassInfo> tl1BypassInfoHashMap = new HashMap<>();
    HashMap<String, Tl1CmProgramInfo> tl1CmProgramInfoHashMap = new HashMap<>();
    HashMap<String, Tl1KeyState> tl1KeyStateHashMap = new HashMap<>();

    HashMap<String, SdnNode> sdnNodeHashMap = new HashMap<>();
    HashMap<String, SdnConnector> sdnConnectorHashMap = new HashMap<>();
    HashMap<String, SdnLink> sdnLinkHashMapForPath = new HashMap<>();
    HashMap<String, SdnService> sdnServiceHashMapForPath = new HashMap<>();

    public SDNManager(SdnNodeRepository sdnNodeRepository,
                      SdnConnectorRepository sdnConnectorRepository,
                      SdnLinkRepository sdnLinkRepository,
                      SdnServiceRepository sdnServiceRepository,
                      SdnTunnelRepository sdnTunnelRepository,
                      SdnPathRepository sdnPathRepository,
                      SdnConstraintRepository sdnConstraintRepository,
                      SdnAccessIfRepository sdnAccessIfRepository,
                      SdnCryptoModuleRepository sdnCryptoModuleRepository,
                      SdnCryptoSessionRepository sdnCryptoSessionRepository,
                      SdnPmPortRepository sdnPmPortRepository,
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
        this.sdnNodeRepository = sdnNodeRepository;
        this.sdnConnectorRepository = sdnConnectorRepository;
        this.sdnLinkRepository = sdnLinkRepository;
        this.sdnServiceRepository = sdnServiceRepository;
        this.sdnTunnelRepository = sdnTunnelRepository;
        this.sdnPathRepository = sdnPathRepository;
        this.sdnConstraintRepository = sdnConstraintRepository;
        this.sdnAccessIfRepository = sdnAccessIfRepository;
        this.sdnCryptoModuleRepository = sdnCryptoModuleRepository;
        this.sdnCryptoSessionRepository = sdnCryptoSessionRepository;
        this.sdnPmPortRepository = sdnPmPortRepository;
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
            if(odu_hashMapForPath.get(tl1Odu.getNAME()) == null ) {
                List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                tl1Odu_list.add(tl1Odu);
                odu_hashMapForPath.put(tl1Odu.getNAME(), tl1Odu_list);
            } else {
                List<Tl1Odu> tl1Odu_list = odu_hashMapForPath.get(tl1Odu.getNAME());
                tl1Odu_list.add(tl1Odu);
                odu_hashMapForPath.put(tl1Odu.getNAME(), tl1Odu_list);
            }

            if(tl1Odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                oduHashMapForODUTUNNEL.put(tl1Odu.getTID() + '/' + tl1Odu.getLOCAL_ID().split("-")[0] +'-'+ tl1Odu.getLOCAL_ID().split("-")[1], tl1Odu);
                if (tl1Odu.getROLE().equals("TAIL")) {
                    oduNameTailHashMapForODUTUNNEL.put(tl1Odu.getNAME(), tl1Odu);

                    if (oduNameHeadHashMapForODUTUNNEL.get(tl1Odu.getNAME()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(oduNameHeadHashMapForODUTUNNEL.get(tl1Odu.getNAME()));
                        tl1Odu_list.add(tl1Odu);
                        odu_list_for_service.add(tl1Odu_list);
                    }
                } else {
                    oduNameHeadHashMapForODUTUNNEL.put(tl1Odu.getNAME(), tl1Odu);

                    if (oduNameTailHashMapForODUTUNNEL.get(tl1Odu.getNAME()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(tl1Odu);
                        tl1Odu_list.add(oduNameTailHashMapForODUTUNNEL.get(tl1Odu.getNAME()));
                        odu_list_for_service.add(tl1Odu_list);
                    }
                }
            } else if (tl1Odu.getEMS_SERVICE().equals("MPLS_TP")) {
                oduMapInMPLSTPByLocalId.put(tl1Odu.getTID()+'/'+ tl1Odu.getLOCAL_ID(), tl1Odu);
                oduHashMapForMPLSTP.put(tl1Odu.getTID()+ '/' + tl1Odu.getLOCAL_ID().split("-")[0] +'-'+ tl1Odu.getLOCAL_ID().split("-")[1], tl1Odu);
            }



        }
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            odu_node_connectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), tl1OduNodeConnector);
        }
        for(Tl1AccessIf Tl1AccessIf : tl1AccessIfList) {
            access_ifHashMap.put(Tl1AccessIf.getTID(), Tl1AccessIf);
        }
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfList) {
            odu_mpls_ifHashMap.put(tl1OduMplsIf.getTID()+'/'+ tl1OduMplsIf.getMPLS_TP_ID(), tl1OduMplsIf);
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
        // Connector 테이블 생성
        SDNSyncConnectorList();
        // Link 테이블 생성
        SDNSyncLinkList();
        // Tunnel 테이블 생성
        SDNSyncTunnelList();
        // Service 테이블 생성
        SDNSyncServiceList();
        // Path 테이블 생성
        SDNSyncPathList();
        // Constraint 테이블 생성
        SDNSyncConstraint();
        // AccessIf 테이블 생성
        SDNSyncAccess_if();
        // CryptoModule 테이블 생성
        SDNSyncCryptoModule();
        // CryptoSession 테이블 생성
        SDNSyncCryptoSession();
        // PmPort 테이블 생성
        SDNSyncPmPort();
    }

    private void SDNSyncNodeList() throws Exception {
        Stream<SdnNode> sdnNodeStream = tl1NodeList
            .stream()
            .filter(tl1NodeState -> tl1NodeState.getNODE_TYPE().equals("otn"))
            .map(tl1NodeState -> {
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1NodeState.getTID());
                Tl1Inventory tl1Inventory = tl1InventoryHashMap.get(tl1NodeState.getTID());

                SdnNode sdnNode = new SdnNode(
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

                sdnNodeHashMap.put(tl1NodeState.getTID(), sdnNode);
                return sdnNode;
            });
        sdnNodeStream.forEach(sdnNodeRepository::save);
    }

    public void SDNSyncConnectorList( ) throws Exception {
        Stream<SdnConnector> sdnConnectorStream = tl1OduNodeConnectorList
            .stream()
            .map(tl1OduNodeConnector -> {
                Tl1Node tl1Node = tl1NodeHashMap.get(tl1OduNodeConnector.getTID());
                SdnNode sdnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTID());
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduNodeConnector.getTID()+"/"+ tl1OduNodeConnector.getAID());
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1Node.getTID());

                String connectId = tl1SystemInfo.getVENDOR() +
                        separator +
                        sdnNode.getSys_type() +
                        separator +
                        sdnNode.getNe_name() +
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

                SdnConnector sdnConnector = new SdnConnector(
                        200009, // ems_id
                        connectId, // connect_id
                        "", // connect_name
                        tl1OpticPower == null ? "" : connectType, // connect_type
                        sdnNode.getNe_id(), // ne_id
                        sdnNode.getNe_name(), // ne_name
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
                sdnConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), sdnConnector);
                return sdnConnector;
            });
        sdnConnectorStream.forEach(sdnConnectorRepository::save);
    }

    public void SDNSyncLinkList ( ) throws Exception {

        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfList) {
            SdnLink sdnLink = new SdnLink();

//
            Tl1SystemInfo src_tl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getSRC_TID());
            Tl1SystemInfo dst_tl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getDST_TID());
            SdnNode src_sdnSdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getSRC_TID());
            SdnNode dst_sdnSdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getDST_TID());
            SdnConnector src_sdnSdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());
            SdnConnector dst_sdnSdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getDST_TID()+ '/' + tl1OduMplsIf.getDST_PORT());
            Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduMplsIf.getTID() + '/' + tl1OduMplsIf.getMPLS_TP_ID());
            Tl1Odu tl1Odu = oduHashMapForODUTUNNEL.get(tl1OduMplsIf.getTID()+ '/' + tl1OduMplsIf.getMPLS_TP_ID());
            Tl1OduNodeConnector tl1OduNodeConnector = odu_node_connectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());

            int maximum_bandwidth = Integer.parseInt(tl1OduMplsIf.getMAXIMUM_BANDWIDTH());
            int available_bandwidth = Integer.parseInt(tl1OduMplsIf.getAVAILABLE_BANDWIDTH());

            sdnLink.setEms_id(200009);
            sdnLink.setDst_ems_id(200009);
            sdnLink.setLink_id(src_tl1SystemInfo.getVENDOR() + separator + src_sdnSdnNode.getSys_type() + separator + src_sdnSdnNode.getNe_name() + separator +
                    src_sdnSdnConnector.getShelf_id() + separator + src_sdnSdnConnector.getSlot_id() + separator + src_sdnSdnConnector.getPort_id()
                    + ":" + dst_tl1SystemInfo.getVENDOR() + separator + dst_sdnSdnNode.getSys_type() + separator + dst_sdnSdnNode.getNe_name() + separator +
                    dst_sdnSdnConnector.getShelf_id() + separator + dst_sdnSdnConnector.getSlot_id() + separator + dst_sdnSdnConnector.getPort_id());
            sdnLink.setLink_nm(tl1OduMplsIf.getNAME());
            sdnLink.setSrc_ne_id(src_sdnSdnNode.getNe_id());
            sdnLink.setSrc_ne_name(src_sdnSdnNode.getNe_name());
            sdnLink.setSrc_node_connector_id(src_sdnSdnConnector.getConnect_id());
            sdnLink.setDst_ne_id(dst_sdnSdnNode.getNe_id());
            sdnLink.setDst_ne_name(dst_sdnSdnNode.getNe_name());
            sdnLink.setDst_node_connector_id(dst_sdnSdnConnector.getConnect_id());
            sdnLink.setLink_type(tl1OduNodeConnector.getPORT_TYPE());
            sdnLink.setLink_status(tl1OduMplsIf.getOPERATION_STATUS());
            sdnLink.setLink_category("");
            sdnLink.setHigh_order_tunnel("");
            sdnLink.setLatency("");
            sdnLink.setDistance(tl1OpticPower.getDISTANCE());
            sdnLink.setSrlg("");
            sdnLink.setOvpn("");
            if(tl1Odu == null ) sdnLink.setTimeslot(""); else sdnLink.setTimeslot(tl1Odu.getTSMAP());
            sdnLink.setLambda(tl1OpticPower.getTX_WAVELENGTH());
            sdnLink.setMaximum_odu0s(maximum_bandwidth);
            sdnLink.setMaximum_odu1s(maximum_bandwidth/2);
            sdnLink.setMaximum_odu2s(maximum_bandwidth/8);
            sdnLink.setMaximum_odu2es(maximum_bandwidth/8);
            sdnLink.setMaximum_odu3s(maximum_bandwidth/32);
            sdnLink.setMaximum_odu4s(maximum_bandwidth/80);
            sdnLink.setMaximum_odu4cns(maximum_bandwidth/160);
            sdnLink.setMaximum_oduflexs(-1);
            sdnLink.setAvailable_odu0s(available_bandwidth);
            sdnLink.setAvailable_odu1s(available_bandwidth/2);
            sdnLink.setAvailable_odu2s(available_bandwidth/8);
            sdnLink.setAvailable_odu2es(available_bandwidth/8);
            sdnLink.setAvailable_odu3s(available_bandwidth/32);
            sdnLink.setAvailable_odu4s(available_bandwidth/80);
            sdnLink.setAvailable_odu4cns(available_bandwidth/160);
            sdnLink.setAvailable_oduflexs(-1);

            sdnLinkRepository.save(sdnLink);
            sdnLinkHashMapForPath.put(tl1OduMplsIf.getSRC_TID() + '/' + tl1OduMplsIf.getSRC_PORT() + '-' + tl1OduMplsIf.getDST_TID() + '/' + tl1OduMplsIf.getDST_PORT(), sdnLink);
        }
    }

    public void SDNSyncServiceList( ) throws Exception {

        for (List<Tl1Odu> tl1Odu_list :odu_list_for_service) {
            Tl1Odu tl1Odu_head = tl1Odu_list.get(0);
            Tl1Odu tl1Odu_tail = tl1Odu_list.get(1);

            SdnNode sdnSrcSdnNode = sdnNodeHashMap.get(tl1Odu_head.getTID());
            SdnNode sdnDstSdnNode = sdnNodeHashMap.get(tl1Odu_tail.getTID());
            SdnService sdnService = new SdnService();

            SdnConnector src_sdnSdnConnector = sdnConnectorHashMap.get(tl1Odu_head.getTID()+ '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);
            SdnConnector dst_sdnSdnConnector = sdnConnectorHashMap.get(tl1Odu_tail.getTID()+ '/' + tl1Odu_tail.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_tail.getLOCAL_ID().split("-")[1]);

            Tl1OduMplsIf tl1OduMplsIf = odu_mpls_ifHashMap.get(tl1Odu_head.getTID() + '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);
            Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1Odu_head.getTID() + '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);

            sdnService.setEms_id(200009);
            sdnService.setService_id(sdnSrcSdnNode.getVendor() + separator + sdnSrcSdnNode.getSys_type() + separator + tl1Odu_head.getNAME());
            sdnService.setSrc_ne_id(sdnSrcSdnNode.getNe_id());
            sdnService.setSrc_ne_name(sdnSrcSdnNode.getNe_name());
            sdnService.setSrc_connector_id(src_sdnSdnConnector.getConnect_id());
            sdnService.setSrc_accessif_type(tl1Odu_head.getSERVICE());
            sdnService.setDst_ne_id(sdnDstSdnNode.getNe_id());
            sdnService.setDst_ne_name(sdnDstSdnNode.getNe_name());
            sdnService.setDst_connector_id(dst_sdnSdnConnector.getConnect_id());
            sdnService.setDst_accessif_type(tl1Odu_tail.getSERVICE());
            sdnService.setService_type("");
            sdnService.setService_name(tl1Odu_head.getNAME());
            sdnService.setNetwork_type("");
            sdnService.setService_status("");
            sdnService.setRate_type(tl1Odu_head.getTYPE());
            sdnService.setService_rate(tl1OduMplsIf.getLINK_TYPE());
            sdnService.setLatency("");

            if(tl1OpticPower == null) {
                sdnService.setWavelength("");
            } else {
                sdnService.setWavelength(tl1OpticPower.getTX_WAVELENGTH());
            }
            sdnService.setActive_path(tl1Odu_head.getACTIVE_PATH_STATUS());
            sdnService.setCreation_date(tl1Odu_head.getCREATION_DATE());

            sdnServiceRepository.save(sdnService);
            sdnServiceHashMapForPath.put(sdnService.getService_name(),sdnService);
        }

    }

    public void SDNSyncTunnelList( ) throws  Exception {

        for (Tl1Odu tl1Odu : tl1OduList) {
            SdnTunnel sdnTunnel = new SdnTunnel();
            SdnNode sdnSrcSdnNode = sdnNodeHashMap.get(tl1Odu.getEMS_SRC_LSR());
            SdnNode sdnDstSdnNode = sdnNodeHashMap.get(tl1Odu.getEMS_DST_LSR());


            sdnTunnel.setEms_id(200009);
            sdnTunnel.setTunnel_id(sdnSrcSdnNode.getVendor() + separator + sdnSrcSdnNode.getSys_type() + separator + tl1Odu.getNAME());
            sdnTunnel.setSrc_ne_id(sdnSrcSdnNode.getNe_id());
            sdnTunnel.setSrc_ne_name(sdnSrcSdnNode.getNe_name());
            sdnTunnel.setDst_ne_id(sdnDstSdnNode.getNe_id());
            sdnTunnel.setDst_ne_name(sdnDstSdnNode.getNe_name());
            sdnTunnel.setRate_type(tl1Odu.getTYPE());
            sdnTunnel.setMultiple_rate("1");
            sdnTunnel.setLocal_id("");
            sdnTunnel.setRequest_id("");
            sdnTunnel.setTunnel_name(tl1Odu.getNAME());
            if(tl1Odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                sdnTunnel.setTunnel_type("otn");
            }else {
                sdnTunnel.setTunnel_type(tl1Odu.getEMS_SERVICE());
            }
            sdnTunnel.setTunnel_status("");
            sdnTunnel.setConfiguration_action("");
            sdnTunnel.setConfiguration_result_type("");
            sdnTunnel.setTunnel_oam_enabler("");
            sdnTunnel.setDeployment_enabler("");
            sdnTunnel.setDeployment_status("");
            sdnTunnel.setActive_path(tl1Odu.getACTIVE_PATH_STATUS());
            sdnTunnel.setSrc_node_ref("");
            sdnTunnel.setDst_node_ref("");
            sdnTunnel.setService_ref("");
            sdnTunnel.setAccessif_ref("");
            sdnTunnel.setProtection_type(tl1Odu.getPROT_TYPE());
            sdnTunnel.setWorking_path("");
            sdnTunnel.setProtection_path("");
            sdnTunnel.setService_mapping("");
            sdnTunnel.setCreation_date(tl1Odu.getCREATION_DATE());

            sdnTunnelRepository.save(sdnTunnel);




        }
    }

    public void SDNSyncPathList() throws  Exception {
        for (Map.Entry<String, List<Tl1Odu>> entry : odu_hashMapForPath.entrySet() ) {
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
                SdnLink sdnLink = sdnLinkHashMapForPath.get(tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] );
                SdnService sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                SdnPath sdnPath = new SdnPath();
                sdnPath.setEms_id(200009);
                sdnPath.setService_id(sdnService.getService_id());
                sdnPath.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                sdnPath.setConnection_idx("1");
                sdnPath.setConnection_type("Forward");
                sdnPath.setDirection_type("ingress");
                sdnPath.setTp_type("");
                sdnPath.setInstance_type("link");
                sdnPath.setInstance_ref(sdnLink.getLink_id());
                sdnPath.setRef_type("");
                sdnPathRepository.save(sdnPath);
            }
            { // TRANSIT_TO <--> TAIL
                SdnLink sdnLink = sdnLinkHashMapForPath.get(tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] );
                SdnService sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                SdnPath sdnPath = new SdnPath();
                sdnPath.setEms_id(200009);
                sdnPath.setService_id(sdnService.getService_id());
                sdnPath.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                sdnPath.setConnection_idx("2");
                sdnPath.setConnection_type("Forward");
                sdnPath.setDirection_type("ingress");
                sdnPath.setTp_type("");
                sdnPath.setInstance_type("link");
                sdnPath.setInstance_ref(sdnLink.getLink_id());
                sdnPath.setRef_type("");
                sdnPathRepository.save(sdnPath);
            }
        }

        for (Map.Entry<String, List<Tl1Odu>> entry : odu_hashMapForPath.entrySet() ) {
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
                SdnLink sdnLink = sdnLinkHashMapForPath.get(tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1]);
                SdnService sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                SdnPath sdnPath = new SdnPath();
                sdnPath.setEms_id(200009);
                sdnPath.setService_id(sdnService.getService_id());
                sdnPath.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                sdnPath.setConnection_idx("3");
                sdnPath.setConnection_type("Forward");
                sdnPath.setDirection_type("egress");
                sdnPath.setTp_type("");
                sdnPath.setInstance_type("link");
                sdnPath.setInstance_ref(sdnLink.getLink_id());
                sdnPath.setRef_type("");
                sdnPathRepository.save(sdnPath);
            }
            { // TRANSIT_TO <--> TAIL
                SdnLink sdnLink = sdnLinkHashMapForPath.get(tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] +'-'+ tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1]);
                SdnService sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                SdnPath sdnPath = new SdnPath();
                sdnPath.setEms_id(200009);
                sdnPath.setService_id(sdnService.getService_id());
                sdnPath.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                sdnPath.setConnection_idx("4");
                sdnPath.setConnection_type("Forward");
                sdnPath.setDirection_type("egress");
                sdnPath.setTp_type("");
                sdnPath.setInstance_type("link");
                sdnPath.setInstance_ref(sdnLink.getLink_id());
                sdnPath.setRef_type("");
                sdnPathRepository.save(sdnPath);
            }
        }

    }

    public void SDNSyncConstraint() throws Exception {

        for (List<Tl1Odu> tl1Odu_list :odu_list_for_service) {
            Tl1Odu tl1Odu_head = tl1Odu_list.get(0);
            Tl1Odu tl1Odu_tail = tl1Odu_list.get(1);

            SdnNode sdnSrcSdnNode = sdnNodeHashMap.get(tl1Odu_head.getTID());

            SdnConstraint sdnConstraint = new SdnConstraint();

            sdnConstraint.setEms_id(200009);
            sdnConstraint.setService_id(sdnSrcSdnNode.getVendor() + separator + sdnSrcSdnNode.getSys_type() + separator + tl1Odu_head.getNAME());
            sdnConstraint.setConst_id("protection type");
            sdnConstraint.setConst_type("");
            sdnConstraint.setConst_name("PROTECTION TYPE");
            sdnConstraint.setConst_value(tl1Odu_head.getPROT_TYPE());
            sdnConstraint.setConst_operator("");


            sdnConstraintRepository.save(sdnConstraint);

        }
    }

    public void SDNSyncAccess_if() throws Exception {

        for(Tl1MplsIf tl1MplsIf : tl1MplsIfList) {

            Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1MplsIf.getTID());

            SdnAccessIf sdnSdnAccessIf = new SdnAccessIf();
            SdnNode sdnNode = sdnNodeHashMap.get(tl1MplsIf.getTID());
            SdnConnector sdnConnector = sdnConnectorHashMap.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);
            Tl1Odu tl1Odu = oduHashMapForMPLSTP.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);
            if(tl1Odu == null) continue;

            sdnSdnAccessIf.setEms_id(200009);
            sdnSdnAccessIf.setAccessif_id(tl1SystemInfo.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_id() + separator + sdnConnector.getConnect_id()); // 조합
            sdnSdnAccessIf.setAccessif_name("");
            sdnSdnAccessIf.setNe_id(sdnNode.getNe_id());
            sdnSdnAccessIf.setConnector_id(sdnConnector.getConnect_id());
            sdnSdnAccessIf.setAccessif_type(tl1Odu.getSERVICE());
            sdnSdnAccessIf.setAccessif_status(tl1MplsIf.getOPERATION_STATUS());
            sdnSdnAccessIf.setService_ref("");
            sdnSdnAccessIf.setNode_connector_ref("");

            sdnAccessIfRepository.save(sdnSdnAccessIf);


        }

    }

    public void SDNSyncCryptoModule() throws Exception {
        for(Tl1ModuleInfo tl1ModuleInfo : tl1ModuleInfoList) {
            // aidPieces: [노드이름, 유니트 이름, 슬롯, 포트]
            String[] aidPieces = tl1ModuleInfo.getAID().split("-");
            Tl1CmPort tl1CmPort = tl1CmPortHashMap.get(tl1ModuleInfo.getAID());
            Tl1BypassInfo tl1BypassInfo = tl1BypassInfoHashMap.get(aidPieces[2] + "-" + aidPieces[3]);
            Tl1CmProgramInfo tl1CmProgramInfo = tl1CmProgramInfoHashMap.get(aidPieces[0] + "-" + aidPieces[1] + "-" + aidPieces[2]);

            SdnCryptoModule sdnCryptoModule = new SdnCryptoModule();
            sdnCryptoModule.setAID(tl1ModuleInfo.getAID());
            sdnCryptoModule.setMODULE_ACT_TYPE(tl1CmPort.getUNIT_TYPE());
            sdnCryptoModule.setMID(tl1ModuleInfo.getMID());
            sdnCryptoModule.setPMID(tl1ModuleInfo.getPMID());
            sdnCryptoModule.setMID_CONTEXT(tl1ModuleInfo.getMID_CONTEXT());
            sdnCryptoModule.setPMID_CONTEXT(tl1ModuleInfo.getPMID_CONTEXT());
            sdnCryptoModule.setBYPASS_MODE(tl1BypassInfo.getCURRENT_ACTION());
            sdnCryptoModule.setCRYPTO_MODE(tl1ModuleInfo.getCRYPTO_MODE());
            sdnCryptoModule.setCRYPTO_MODULE_PKG_VERSION(tl1CmProgramInfo.getPKG_VERSION());
            sdnCryptoModule.setCRYPTO_MODULE_FPGA_VERSION(tl1CmProgramInfo.getFPGA_VERSION());
            sdnCryptoModule.setCRYPTO_MODULE_CPLD_VERSION(tl1CmProgramInfo.getCPLD_VERSION());
            sdnCryptoModule.setCRYPTO_MODULE_HW_VERSION(tl1CmProgramInfo.getHW_VERSION());

            System.out.println(sdnCryptoModule);
            sdnCryptoModuleRepository.save(sdnCryptoModule);
        }
    }

    public void SDNSyncCryptoSession() throws Exception {
        Stream<SdnCryptoSession> sdnCryptoSessionStream = tl1SessStateList.stream()
            .map(tl1SessState -> {
            Tl1KeyState tl1KeyState = tl1KeyStateHashMap.get(tl1SessState.getAID());

            SdnCryptoSession sdnCryptoSession = new SdnCryptoSession();

            sdnCryptoSession.setAID(tl1SessState.getAID());
            sdnCryptoSession.setLOCAL_IP(tl1SessState.getLOCAL_IP());
            sdnCryptoSession.setREMOTE_IP(tl1SessState.getREMOTE_IP());
            sdnCryptoSession.setKSP_MODE(tl1SessState.getKSP_MODE());
            sdnCryptoSession.setDEAD_TIME(tl1SessState.getDEAD_TIME());
            sdnCryptoSession.setRETRY_REQUEST_INTERVAL(tl1SessState.getRETRY_REQ_INTERVAL());
            sdnCryptoSession.setDST_LID(tl1SessState.getDST_LID());
            sdnCryptoSession.setKEY_SOURCE_MODE(tl1SessState.getKEY_SRC_MODE());
            sdnCryptoSession.setKEY_FAILOVER_MODE(tl1SessState.getKEY_FAILOVER());
            sdnCryptoSession.setKEY_LIFE_TIME(tl1SessState.getKEY_LIFE_TIME());
            sdnCryptoSession.setTX_KEY_STATE(tl1KeyState.getTX_KEY_STATE());
            sdnCryptoSession.setTX_KEY_BANK_STATE(tl1KeyState.getTX_KEY_BANK_STATE());
            sdnCryptoSession.setRX_KEY_STATE(tl1KeyState.getRX_KEY_STATE());
            sdnCryptoSession.setRX_KEY_BANK_STATE(tl1KeyState.getRX_KEY_BANK_STATE());

            return sdnCryptoSession;
        });

        sdnCryptoSessionStream.forEach(sdnCryptoSessionRepository::save);
    }

    public void SDNSyncPmPort() throws Exception {
        Stream<SdnPmPort> sdnPmPortStream = tl1PmPortList.stream()
        .map(tl1PmPort -> {
            SdnPmPort sdnPmPort = new SdnPmPort();

            sdnPmPort.setTID(tl1PmPort.getTID());
            sdnPmPort.setAID(tl1PmPort.getAID());
            sdnPmPort.setUNIT(tl1PmPort.getUNIT());
            sdnPmPort.setDATE(tl1PmPort.getDATE());
            sdnPmPort.setTIME(tl1PmPort.getTIME());
            sdnPmPort.setIN_OCTETS(tl1PmPort.getIN_OCTETS());
            sdnPmPort.setIN_OK_PACKETS(tl1PmPort.getIN_OK_PACKETS());
            sdnPmPort.setIN_DISCARD_PACKETS(tl1PmPort.getIN_DISCARD_PACKETS());
            sdnPmPort.setIN_ERROR_PACKETS(tl1PmPort.getIN_ERROR_PACKETS());
            sdnPmPort.setIN_PAUSE_PACKETS(tl1PmPort.getIN_PAUSE_PACKETS());
            sdnPmPort.setIN_ALIGNMENT_ERRORS(tl1PmPort.getIN_ALIGNMENT_ERRORS());
            sdnPmPort.setIN_FCS_ERRORS(tl1PmPort.getIN_FCS_ERRORS());
            sdnPmPort.setIN_SYMBOL_ERRORS(tl1PmPort.getIN_SYMBOL_ERRORS());
            sdnPmPort.setOUT_OCTETS(tl1PmPort.getOUT_OCTETS());
            sdnPmPort.setOUT_OK_PACKETS(tl1PmPort.getOUT_OK_PACKETS());
            sdnPmPort.setOUT_UNICAST_PACKETS(tl1PmPort.getOUT_UNICAST_PACKETS());
            sdnPmPort.setOUT_NON_UNICAST_PACKETS(tl1PmPort.getOUT_NON_UNICAST_PACKETS());
            sdnPmPort.setOUT_DISCARD_PACKETS(tl1PmPort.getOUT_DISCARD_PACKETS());
            sdnPmPort.setOUT_ERROR_PACKETS(tl1PmPort.getOUT_ERROR_PACKETS());
            sdnPmPort.setOUT_BROADCAST_PACKETS(tl1PmPort.getOUT_BROADCAST_PACKETS());
            sdnPmPort.setOUT_MULTICAST_PACKETS(tl1PmPort.getOUT_MULTICAST_PACKETS());
            sdnPmPort.setOUT_PAUSE_PACKETS(tl1PmPort.getOUT_PAUSE_PACKETS());
            sdnPmPort.setIN_RATE(tl1PmPort.getIN_RATE());
            sdnPmPort.setOUT_RATE(tl1PmPort.getOUT_RATE());
            sdnPmPort.setIN_LOSS_RATIO(tl1PmPort.getIN_LOSS_RATIO());
            sdnPmPort.setOUT_LOSS_RATIO(tl1PmPort.getOUT_LOSS_RATIO());

            return sdnPmPort;
        });

        sdnPmPortStream.forEach(sdnPmPortRepository::save);

    }



}
