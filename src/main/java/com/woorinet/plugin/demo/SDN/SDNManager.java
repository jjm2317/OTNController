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

public class SDNManager {
    NODERepository nodeRepository;
    CONNECTORRepository connectorRepository;
    LINKRepository linkRepository;
    SERVICERepository serviceRepository;
    TUNNELRepository tunnelRepository;
    PATHRepository pathRepository;
    CONSTRAINTRepository constraintRepository;
    ACCESS_IFRepository access_ifRepository;


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

    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.NODE> sdnNodeHashMap = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.CONNECTOR> sdnConnectorHashMap = new HashMap<>();
    HashMap<String, LINK> sdnLinkHashMapForPath = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.SERVICE> sdnServiceHashMapForPath = new HashMap<>();
    public SDNManager(NODERepository nodeRepository, CONNECTORRepository connectorRepository, LINKRepository linkRepository, SERVICERepository serviceRepository, TUNNELRepository tunnelRepository, PATHRepository pathRepository, CONSTRAINTRepository constraintRepository, ACCESS_IFRepository access_ifRepository, List<Tl1Node> tl1Nodes, List<Tl1SystemInfo> tl1SystemInfos, List<Tl1OduNodeConnector> tl1OduNodeConnectors, List<Tl1OpticPower> tl1OpticPowers, List<Tl1Odu> oduses, List<Tl1OduMplsIf> tl1OduMplsIfs, List<Tl1Service> tl1Services, List<Tl1AccessIf> Tl1AccessIfs, List<Tl1ServiceExt> tl1ServiceExts, List<Tl1MplsIf> tl1MplsIfs, List<Tl1Inventory> inventories ) throws Exception{
        this.nodeRepository = nodeRepository;
        this.connectorRepository = connectorRepository;
        this.linkRepository = linkRepository;
        this.serviceRepository = serviceRepository;
        this.tunnelRepository = tunnelRepository;
        this.pathRepository = pathRepository;
        this.constraintRepository = constraintRepository;
        this.access_ifRepository = access_ifRepository;
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


    }

    public void SDNSyncNodeList() throws Exception {

        for (Tl1Node tl1Node : tl1Nodes) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1Node.getTID());

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = new com.woorinet.plugin.demo.DTO.SDN.NODE();
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

            nodeRepository.save(sdnNode);
            sdnNodeHashMap.put(tl1Node.getTID(), sdnNode);
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {

        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            CONNECTOR connector = new CONNECTOR();

            Tl1Node tl1Node = nodeHashMap.get(tl1OduNodeConnector.getTID());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTID());
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1OduNodeConnector.getTID()+"/"+ tl1OduNodeConnector.getAID());
            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1Node.getTID());

            connector.setEms_id(200009);
            connector.setConnect_id(tl1SystemInfo.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_name() + separator + tl1OduNodeConnector.getSHELF_INDEX() + separator + tl1OduNodeConnector.getSLOT_INDEX() + separator + tl1OduNodeConnector.getPORT_INDEX());
            connector.setConnect_name("");
            connector.setNe_id(sdnNode.getNe_id());
            connector.setNe_name(sdnNode.getNe_name());
            connector.setRack_id("");
            connector.setShelf_id(tl1OduNodeConnector.getSHELF_INDEX());
            connector.setSlot_id(tl1OduNodeConnector.getSLOT_INDEX());
            connector.setSubslot_id("");
            connector.setPort_id(tl1OduNodeConnector.getPORT_INDEX());
            if (tl1OduNodeConnector.getPORT_STATUS().equals("ACT")) connector.setConnect_status("up");
            else if (tl1OduNodeConnector.getPORT_STATUS().equals("DEACT")) connector.setConnect_status("down");
            connector.setConnect_role(tl1OduNodeConnector.getPORT_ROLE());
            if(tl1OpticPower == null) {
                connector.setConnect_type("");
                connector.setConnect_idle("idle");
                connector.setConnect_llcf("");
                connector.setConnect_lambda("");
                connector.setModule_name("");
                connector.setConnect_pec("");
                connector.setConnect_serial("");
                connector.setUnit_type("");
            } else {
                if(tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2") ) connector.setConnect_type("sfp+");
                else if (tl1OpticPower.getPART_NUMBER().equals("TR-PX13L-NG2") || tl1OpticPower.getPART_NUMBER().equals("EOLP-1396-10") || tl1OpticPower.getPART_NUMBER().equals("FTLX1471D3BNL") ) connector.setConnect_type("sfp");
                else connector.setConnect_type(tl1OpticPower.getPART_NUMBER()); // 구글링 해야됨
                connector.setConnect_idle("occupied");
                connector.setConnect_llcf("");
                connector.setConnect_lambda(tl1OpticPower.getTX_WAVELENGTH());
                connector.setModule_name(tl1OpticPower.getPART_NUMBER());
                connector.setConnect_pec("");
                connector.setConnect_serial(tl1OpticPower.getSERIAL());
                connector.setUnit_type(tl1OpticPower.getUNIT_TYPE());
            }

            connectorRepository.save(connector);
            sdnConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), connector);
        }

    }

    public void SDNSyncLinkList ( ) throws Exception {

        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfs) {
            LINK link = new LINK();

//
            Tl1SystemInfo src_tl1SystemInfo = system_infoHashMap.get(tl1OduMplsIf.getSRC_TID());
            Tl1SystemInfo dst_tl1SystemInfo = system_infoHashMap.get(tl1OduMplsIf.getDST_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE src_sdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getSRC_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE dst_sdnNode = sdnNodeHashMap.get(tl1OduMplsIf.getDST_TID());
            CONNECTOR src_sdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getSRC_TID()+ '/' + tl1OduMplsIf.getSRC_PORT());
            CONNECTOR dst_sdnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getDST_TID()+ '/' + tl1OduMplsIf.getDST_PORT());
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1OduMplsIf.getTID() + '/' + tl1OduMplsIf.getMPLS_TP_ID());
            Tl1Odu tl1Odu = oduHashMapForODUTUNNEL.get(tl1OduMplsIf.getTID()+ '/' + tl1OduMplsIf.getMPLS_TP_ID());

            int maximum_bandwidth = Integer.parseInt(tl1OduMplsIf.getMAXIMUM_BANDWIDTH());
            int available_bandwidth = Integer.parseInt(tl1OduMplsIf.getAVAILABLE_BANDWIDTH());

            link.setEms_id(200009);
            link.setDst_ems_id(200009);
            link.setLink_id(src_tl1SystemInfo.getVENDOR() + separator + src_sdnNode.getSys_type() + separator + src_sdnNode.getNe_name() + separator +
                    src_sdnConnector.getShelf_id() + separator + src_sdnConnector.getSlot_id() + separator + src_sdnConnector.getPort_id()
                    + ":" + dst_tl1SystemInfo.getVENDOR() + separator + dst_sdnNode.getSys_type() + separator + dst_sdnNode.getNe_name() + separator +
                    dst_sdnConnector.getShelf_id() + separator + dst_sdnConnector.getSlot_id() + separator + dst_sdnConnector.getPort_id());
            link.setLink_nm(tl1OduMplsIf.getNAME());
            link.setSrc_ne_id(src_sdnNode.getNe_id());
            link.setSrc_ne_name(src_sdnNode.getNe_name());
            link.setSrc_node_connector_id(src_sdnConnector.getConnect_id());
            link.setDst_ne_id(dst_sdnNode.getNe_id());
            link.setDst_ne_name(dst_sdnNode.getNe_name());
            link.setDst_node_connector_id(dst_sdnConnector.getConnect_id());
            link.setLink_type(tl1OduMplsIf.getLINK_TYPE());
            link.setLink_status(tl1OduMplsIf.getOPERATION_STATUS());
            link.setLink_category("");
            link.setHigh_order_tunnel("");
            link.setLatency("");
            link.setDistance(tl1OpticPower.getDISTANCE());
            link.setSrlg("");
            link.setOvpn("");
            if(tl1Odu == null ) link.setTimeslot(""); else link.setTimeslot(tl1Odu.getTSMAP());
            link.setLambda(tl1OpticPower.getTX_WAVELENGTH());
            link.setMaximum_odu0s(maximum_bandwidth);
            link.setMaximum_odu1s(maximum_bandwidth/2);
            link.setMaximum_odu2s(maximum_bandwidth/8);
            link.setMaximum_odu2es(maximum_bandwidth/8);
            link.setMaximum_odu3s(0);
            link.setMaximum_odu4s(0);
            link.setMaximum_odu4cns(0);
            link.setMaximum_oduflexs(0);
            link.setAvailable_odu0s(available_bandwidth);
            link.setAvailable_odu1s(available_bandwidth/2);
            link.setAvailable_odu2s(available_bandwidth/8);
            link.setAvailable_odu2es(available_bandwidth/8);
            link.setAvailable_odu3s(0);
            link.setAvailable_odu4s(0);
            link.setAvailable_odu4cns(0);
            link.setAvailable_oduflexs(0);

            linkRepository.save(link);
            sdnLinkHashMapForPath.put(tl1OduMplsIf.getSRC_TID() + '/' + tl1OduMplsIf.getSRC_PORT() + '-' + tl1OduMplsIf.getDST_TID() + '/' + tl1OduMplsIf.getDST_PORT(), link);
        }
    }

    public void SDNSyncServiceList( ) throws Exception {

        for (List<Tl1Odu> tl1Odu_list :odu_list_for_service) {
            Tl1Odu tl1Odu_head = tl1Odu_list.get(0);
            Tl1Odu tl1Odu_tail = tl1Odu_list.get(1);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(tl1Odu_head.getTID());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnDstNode = sdnNodeHashMap.get(tl1Odu_tail.getTID());
            com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = new com.woorinet.plugin.demo.DTO.SDN.SERVICE();

            CONNECTOR src_sdnConnector = sdnConnectorHashMap.get(tl1Odu_head.getTID()+ '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);
            CONNECTOR dst_sdnConnector = sdnConnectorHashMap.get(tl1Odu_tail.getTID()+ '/' + tl1Odu_tail.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_tail.getLOCAL_ID().split("-")[1]);

            Tl1OduMplsIf tl1OduMplsIf = odu_mpls_ifHashMap.get(tl1Odu_head.getTID() + '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);
            Tl1OpticPower tl1OpticPower = optic_powerHashMap.get(tl1Odu_head.getTID() + '/' + tl1Odu_head.getLOCAL_ID().split("-")[0] + "-" + tl1Odu_head.getLOCAL_ID().split("-")[1]);

            sdnService.setEms_id(200009);
            sdnService.setService_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + tl1Odu_head.getNAME());
            sdnService.setSrc_ne_id(sdnSrcNode.getNe_id());
            sdnService.setSrc_ne_name(sdnSrcNode.getNe_name());
            sdnService.setSrc_connector_id(src_sdnConnector.getConnect_id());
            sdnService.setSrc_accessif_type(tl1Odu_head.getSERVICE());
            sdnService.setDst_ne_id(sdnDstNode.getNe_id());
            sdnService.setDst_ne_name(sdnDstNode.getNe_name());
            sdnService.setDst_connector_id(dst_sdnConnector.getConnect_id());
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

            serviceRepository.save(sdnService);
            sdnServiceHashMapForPath.put(sdnService.getService_name(),sdnService);
        }

    }

    public void SDNSyncTunnelList( ) throws  Exception {

        for (Tl1Odu tl1Odu : oduses) {
            TUNNEL tunnel = new TUNNEL();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(tl1Odu.getEMS_SRC_LSR());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnDstNode = sdnNodeHashMap.get(tl1Odu.getEMS_DST_LSR());


            tunnel.setEms_id(200009);
            tunnel.setTunnel_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + tl1Odu.getNAME());
            tunnel.setSrc_ne_id(sdnSrcNode.getNe_id());
            tunnel.setSrc_ne_name(sdnSrcNode.getNe_name());
            tunnel.setDst_ne_id(sdnDstNode.getNe_id());
            tunnel.setDst_ne_name(sdnDstNode.getNe_name());
            tunnel.setRate_type(tl1Odu.getTYPE());
            tunnel.setMultiple_rate("1");
            tunnel.setLocal_id("");
            tunnel.setRequest_id("");
            tunnel.setTunnel_name(tl1Odu.getNAME());
            if(tl1Odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                tunnel.setTunnel_type("otn");
            }else {
                tunnel.setTunnel_type(tl1Odu.getEMS_SERVICE());
            }
            tunnel.setTunnel_status("");
            tunnel.setConfiguration_action("");
            tunnel.setConfiguration_result_type("");
            tunnel.setTunnel_oam_enabler("");
            tunnel.setDeployment_enabler("");
            tunnel.setDeployment_status("");
            tunnel.setActive_path(tl1Odu.getACTIVE_PATH_STATUS());
            tunnel.setSrc_node_ref("");
            tunnel.setDst_node_ref("");
            tunnel.setService_ref("");
            tunnel.setAccessif_ref("");
            tunnel.setProtection_type(tl1Odu.getPROT_TYPE());
            tunnel.setWorking_path("");
            tunnel.setProtection_path("");
            tunnel.setService_mapping("");
            tunnel.setCreation_date(tl1Odu.getCREATION_DATE());

            tunnelRepository.save(tunnel);




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
                LINK link = sdnLinkHashMapForPath.get(tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] );
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                path.setConnection_idx("1");
                path.setConnection_type("Forward");
                path.setDirection_type("ingress");
                path.setTp_type("");
                path.setInstance_type("link");
                path.setInstance_ref(link.getLink_id());
                path.setRef_type("");
                pathRepository.save(path);
            }
            { // TRANSIT_TO <--> TAIL
                LINK link = sdnLinkHashMapForPath.get(tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] );
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                path.setConnection_idx("2");
                path.setConnection_type("Forward");
                path.setDirection_type("ingress");
                path.setTp_type("");
                path.setInstance_type("link");
                path.setInstance_ref(link.getLink_id());
                path.setRef_type("");
                pathRepository.save(path);
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
                LINK link = sdnLinkHashMapForPath.get(tl1Odu_transit_from.getTID() +'/'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_transit_from.getLOCAL_ID().split("-")[1] + '-' + tl1Odu_head.getTID() +'/'+ tl1Odu_head.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_head.getLOCAL_ID().split("-")[1]);
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(tl1Odu_head.getACTIVE_PATH_STATUS());
                path.setConnection_idx("3");
                path.setConnection_type("Forward");
                path.setDirection_type("egress");
                path.setTp_type("");
                path.setInstance_type("link");
                path.setInstance_ref(link.getLink_id());
                path.setRef_type("");
                pathRepository.save(path);
            }
            { // TRANSIT_TO <--> TAIL
                LINK link = sdnLinkHashMapForPath.get(tl1Odu_tail.getTID() +'/'+ tl1Odu_tail.getLOCAL_ID().split("-")[0]+'-'+ tl1Odu_tail.getLOCAL_ID().split("-")[1] +'-'+ tl1Odu_transit_to.getTID() +'/'+ tl1Odu_transit_to.getLOCAL_ID().split("-")[0]+'-' + tl1Odu_transit_to.getLOCAL_ID().split("-")[1]);
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(tl1Odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(tl1Odu_transit_to.getACTIVE_PATH_STATUS());
                path.setConnection_idx("4");
                path.setConnection_type("Forward");
                path.setDirection_type("egress");
                path.setTp_type("");
                path.setInstance_type("link");
                path.setInstance_ref(link.getLink_id());
                path.setRef_type("");
                pathRepository.save(path);
            }
        }

    }

    public void SDNSyncConstraint() throws Exception {

        for (List<Tl1Odu> tl1Odu_list :odu_list_for_service) {
            Tl1Odu tl1Odu_head = tl1Odu_list.get(0);
            Tl1Odu tl1Odu_tail = tl1Odu_list.get(1);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(tl1Odu_head.getTID());

            CONSTRAINT constraint = new CONSTRAINT();

            constraint.setEms_id(200009);
            constraint.setService_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + tl1Odu_head.getNAME());
            constraint.setConst_id("protection type");
            constraint.setConst_type("");
            constraint.setConst_name("PROTECTION TYPE");
            constraint.setConst_value(tl1Odu_head.getPROT_TYPE());
            constraint.setConst_operator("");


            constraintRepository.save(constraint);

        }
    }

    public void SDNSyncAccess_if() throws Exception {

        for(Tl1MplsIf tl1MplsIf : tl1MplsIfs) {

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(tl1MplsIf.getTID());

            com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF sdnAccess_if = new com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(tl1MplsIf.getTID());
            CONNECTOR sdnConnector = sdnConnectorHashMap.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);
            Tl1Odu tl1Odu = oduHashMapForMPLSTP.get(tl1MplsIf.getTID()+ '/' + tl1MplsIf.getMPLS_TP_ID().split("-")[0] + "-" + tl1MplsIf.getMPLS_TP_ID().split("-")[1]);
            if(tl1Odu == null) continue;

            sdnAccess_if.setEms_id(200009);
            sdnAccess_if.setAccessif_id(tl1SystemInfo.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_id() + separator + sdnConnector.getConnect_id()); // 조합
            sdnAccess_if.setAccessif_name("");
            sdnAccess_if.setNe_id(sdnNode.getNe_id());
            sdnAccess_if.setConnector_id(sdnConnector.getConnect_id());
            sdnAccess_if.setAccessif_type(tl1Odu.getSERVICE());
            sdnAccess_if.setAccessif_status(tl1MplsIf.getOPERATION_STATUS());
            sdnAccess_if.setService_ref("");
            sdnAccess_if.setNode_connector_ref("");

            access_ifRepository.save(sdnAccess_if);


        }

    }


}
