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


    String separator;
    List<Tl1Node> tl1Nodes;
    List<Tl1SystemInfo> tl1SystemInfos;
    List<Tl1OduNodeConnector> tl1OduNodeConnectors;
    List<Tl1OpticPower> tl1OpticPowers;
    List<Tl1Odu> oduses;
    List<Tl1OduMplsIf> tl1OduMplsIfs;
    List<Tl1Service> tl1Services;
    List<Tl1AccessIf> Tl1AccessIfs;
    List<Tl1ServiceExt> tl1ServiceExts;
    List<Tl1MplsIf> tl1MplsIfs;
    List<List<Tl1Odu>> odu_list_for_service = new ArrayList<>();
    List<Tl1Inventory> inventories;
    List<Tl1CmPort> tl1CmPorts;
    List<Tl1ModuleInfo> tl1ModuleInfos;
    List<Tl1BypassInfo> tl1BypassInfos;
    List<Tl1CmProgramInfo> tl1CmProgramInfos;
    List<Tl1SessState> tl1SessStates;
    List<Tl1KeyState> tl1KeyStates;

    HashMap<String, Tl1Node> nodeHashMap = new HashMap<>();
    HashMap<String, Tl1SystemInfo> system_infoHashMap = new HashMap<>();
    HashMap<String, Tl1OpticPower> optic_powerHashMap = new HashMap<>();
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
                      List<Tl1Node> tl1Nodes,
                      List<Tl1SystemInfo> tl1SystemInfos,
                      List<Tl1OduNodeConnector> tl1OduNodeConnectors,
                      List<Tl1OpticPower> tl1OpticPowers,
                      List<Tl1Odu> oduses,
                      List<Tl1OduMplsIf> tl1OduMplsIfs,
                      List<Tl1Service> tl1Services,
                      List<Tl1AccessIf> Tl1AccessIfs,
                      List<Tl1ServiceExt> tl1ServiceExts,
                      List<Tl1MplsIf> tl1MplsIfs,
                      List<Tl1Inventory> inventories,
                      List<Tl1CmPort> tl1CmPorts,
                      List<Tl1ModuleInfo> tl1ModuleInfos,
                      List<Tl1BypassInfo> tl1BypassInfos,
                      List<Tl1CmProgramInfo> tl1CmProgramInfos,
                      List<Tl1SessState> tl1SessStates,
                      List<Tl1KeyState> tl1KeyStates) throws Exception{
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
        this.separator = ".";
        this.tl1Nodes = tl1Nodes;
        this.tl1SystemInfos = tl1SystemInfos;
        this.tl1OduNodeConnectors = tl1OduNodeConnectors;
        this.tl1OpticPowers = tl1OpticPowers;
        this.oduses = oduses;
        this.tl1OduMplsIfs = tl1OduMplsIfs;
        this.tl1Services = tl1Services;
        this.Tl1AccessIfs = Tl1AccessIfs;
        this.tl1ServiceExts = tl1ServiceExts;
        this.tl1MplsIfs = tl1MplsIfs;
        this.inventories = inventories;
        this.tl1CmPorts = tl1CmPorts;
        this.tl1ModuleInfos = tl1ModuleInfos;
        this.tl1BypassInfos = tl1BypassInfos;
        this.tl1CmProgramInfos = tl1CmProgramInfos;
        this.tl1SessStates = tl1SessStates;
        this.tl1KeyStates = tl1KeyStates;

        makeHashMap();

    }

    private void makeHashMap() {
        for(Tl1Node tl1Node : tl1Nodes) {
            nodeHashMap.put(tl1Node.getTID(), tl1Node);
        }
        for(Tl1SystemInfo tl1SystemInfo : tl1SystemInfos) {
            system_infoHashMap.put(tl1SystemInfo.getTID(), tl1SystemInfo);
        }
        for(Tl1OpticPower tl1OpticPower : tl1OpticPowers) {
            optic_powerHashMap.put(tl1OpticPower.getTID()+"/"+ tl1OpticPower.getAID(), tl1OpticPower);
        }
        for(Tl1Odu tl1Odu : oduses) {
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
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            odu_node_connectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), tl1OduNodeConnector);
        }
        for(Tl1AccessIf Tl1AccessIf : Tl1AccessIfs) {
            access_ifHashMap.put(Tl1AccessIf.getTID(), Tl1AccessIf);
        }
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfs) {
            odu_mpls_ifHashMap.put(tl1OduMplsIf.getTID()+'/'+ tl1OduMplsIf.getMPLS_TP_ID(), tl1OduMplsIf);
        }
        for(Tl1CmPort tl1CmPort : tl1CmPorts) {
            tl1CmPortHashMap.put(tl1CmPort.getAID(), tl1CmPort);
        }
        for(Tl1BypassInfo tl1BypassInfo :tl1BypassInfos) {
            tl1BypassInfoHashMap.put(tl1BypassInfo.getAID(), tl1BypassInfo);
        }
        for(Tl1CmProgramInfo tl1CmProgramInfo : tl1CmProgramInfos) {
            tl1CmProgramInfoHashMap.put(tl1CmProgramInfo.getAID(), tl1CmProgramInfo);
        }

        for(Tl1KeyState tl1keyState: tl1KeyStates) {
            System.out.println(tl1keyState+"test..");
        }
        Stream<Tl1KeyState> tl1KeyStateStream = tl1KeyStates.stream();
        tl1KeyStateStream.forEach(keystate -> tl1KeyStateHashMap.put(keystate.getAID(), keystate));
        System.out.println("test..." + tl1KeyStateHashMap.size());
        for (Map.Entry<String, Tl1KeyState> entry : tl1KeyStateHashMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public void SDNSyncNodeList() throws Exception {

        for (Tl1Node tl1Node : tl1Nodes) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1Node.getTID());

            SdnNode sdnNode = new SdnNode();
            sdnNode.setEms_id(200009);
            if (tl1SystemInfo != null) sdnNode.setNe_id(tl1SystemInfo.getVENDOR() + separator + tl1Node.getNODE_TYPE() + separator + tl1Node.getTID());
            sdnNode.setNe_id("");
            sdnNode.setNe_name(tl1Node.getTID());
            sdnNode.setNe_type("");
            sdnNode.setNe_model(tl1Node.getSYSTEM_TYPE());
            if (tl1Node.getNODE_STATUS().equals("normal")) sdnNode.setNe_status(tl1Node.getNODE_STATUS()); else sdnNode.setNe_status("broken");
            sdnNode.setSw_ver(tl1Node.getSOFTWARE());
            sdnNode.setIp_addr(tl1Node.getIP_ADDR());
            sdnNode.setVendor(tl1SystemInfo.getVENDOR());
            sdnNode.setSerial_num(""); // INVENTORY 에서 가져와야됨
            sdnNode.setSys_type(tl1Node.getNODE_TYPE());

            sdnNodeRepository.save(sdnNode);
            sdnNodeHashMap.put(tl1Node.getTID(), sdnNode);
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {

        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            SdnConnector sdnConnector = new SdnConnector();

            Tl1Node tl1Node = nodeHashMap.get(tl1OduNodeConnector.getTID());
            SdnNode sdnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTID());
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1OduNodeConnector.getTID()+"/"+ tl1OduNodeConnector.getAID());
            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1Node.getTID());

            sdnConnector.setEms_id(200009);
            sdnConnector.setConnect_id(tl1SystemInfo.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_name() + separator + tl1OduNodeConnector.getSHELF_INDEX() + separator + tl1OduNodeConnector.getSLOT_INDEX() + separator + tl1OduNodeConnector.getPORT_INDEX());
            sdnConnector.setConnect_name("");
            sdnConnector.setNe_id(sdnNode.getNe_id());
            sdnConnector.setNe_name(sdnNode.getNe_name());
            sdnConnector.setRack_id("");
            sdnConnector.setShelf_id(tl1OduNodeConnector.getSHELF_INDEX());
            sdnConnector.setSlot_id(tl1OduNodeConnector.getSLOT_INDEX());
            sdnConnector.setSubslot_id("");
            sdnConnector.setPort_id(tl1OduNodeConnector.getPORT_INDEX());
            if (tl1OduNodeConnector.getPORT_STATUS().equals("ACT")) sdnConnector.setConnect_status("up");
            else if (tl1OduNodeConnector.getPORT_STATUS().equals("DEACT")) sdnConnector.setConnect_status("down");
            sdnConnector.setConnect_role(tl1OduNodeConnector.getPORT_ROLE());
            if(tl1OpticPower == null) {
                sdnConnector.setConnect_type("");
                sdnConnector.setConnect_idle("idle");
                sdnConnector.setConnect_llcf("");
                sdnConnector.setConnect_lambda("");
                sdnConnector.setModule_name("");
                sdnConnector.setConnect_pec("");
                sdnConnector.setConnect_serial("");
                sdnConnector.setUnit_type("");
            } else {
                if(tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2") ) sdnConnector.setConnect_type("sfp+");
                else if (tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2") || tl1OpticPower.getPART_NUMBER().equals("EOLP-1396-10") || tl1OpticPower.getPART_NUMBER().equals("FTLX1471D3BNL") ) sdnConnector.setConnect_type("sfp");
                else sdnConnector.setConnect_type(tl1OpticPower.getPART_NUMBER()); // 구글링 해야됨
                sdnConnector.setConnect_idle("occupied");
                sdnConnector.setConnect_llcf("");
                sdnConnector.setConnect_lambda(tl1OpticPower.getTX_WAVELENGTH());
                sdnConnector.setModule_name(tl1OpticPower.getPART_NUMBER());
                sdnConnector.setConnect_pec("");
                sdnConnector.setConnect_serial(tl1OpticPower.getSERIAL());
                sdnConnector.setUnit_type(tl1OpticPower.getUNIT_TYPE());
            }

            sdnConnectorRepository.save(sdnConnector);
            sdnConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), sdnConnector);
        }

    }

    public void SDNSyncLinkList ( ) throws Exception {

        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfs) {
            SdnLink sdnLink = new SdnLink();

//
            Tl1SystemInfo src_tl1SystemInfo = system_infoHashMap.get(tl1OduMplsIf.getSRC_TID());
            Tl1SystemInfo dst_tl1SystemInfo = system_infoHashMap.get(tl1OduMplsIf.getDST_TID());
            SdnNode src_sdnSdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getSRC_TID());
            SdnNode dst_sdnSdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getDST_TID());
            SdnConnector src_sdnSdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());
            SdnConnector dst_sdnSdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getDST_TID()+ '/' + tl1OduMplsIf.getDST_PORT());
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1OduMplsIf.getTID() + '/' + tl1OduMplsIf.getMPLS_TP_ID());
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
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1Odu_head.getTID() + '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);

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

        for (Tl1Odu tl1Odu : oduses) {
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

        for(Tl1MplsIf tl1MplsIf : tl1MplsIfs) {

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1MplsIf.getTID());

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
        for(Tl1ModuleInfo tl1ModuleInfo : tl1ModuleInfos) {
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
        Stream<Tl1SessState> tl1SessStateStream = tl1SessStates.stream();

        Stream<SdnCryptoSession> sdnCryptoSessionStream = tl1SessStateStream.map(tl1SessState -> {
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



}
