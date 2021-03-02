package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.DTO.TL1.Tl1AccessIf;
import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.SERVICE;
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
    List<NODE> nodes;
    List<Tl1SystemInfo> tl1SystemInfos;
    List<Tl1OduNodeConnector> tl1OduNodeConnectors;
    List<OPTIC_POWER> optic_powers;
    List<ODU> odus;
    List<ODU_MPLS_IF> odu_mpls_ifs;
    List<SERVICE> services;
    List<Tl1AccessIf> Tl1AccessIfs;
    List<SERVICE_EXT> service_exts;
    List<MPLS_IF> mpls_ifs;
    List<List<ODU>> odu_list_for_service = new ArrayList<>();
    List<INVENTORY> inventories;

    HashMap<String, NODE> nodeHashMap = new HashMap<>();
    HashMap<String, Tl1SystemInfo> system_infoHashMap = new HashMap<>();
    HashMap<String, OPTIC_POWER> optic_powerHashMap = new HashMap<>();
    HashMap<String, Tl1OduNodeConnector> odu_node_connectorHashMap = new HashMap<>();
    HashMap<String, ODU> oduHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, ODU> oduHashMapForMPLSTP = new HashMap<>();
    HashMap<String, Tl1AccessIf> access_ifHashMap = new HashMap<>();
    HashMap<String, ODU> oduNameTailHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, ODU> oduNameHeadHashMapForODUTUNNEL = new HashMap<>();
    HashMap<String, ODU> oduMapInMPLSTPByLocalId = new HashMap<>();
    HashMap<String, ODU_MPLS_IF> odu_mpls_ifHashMap = new HashMap<>();
    HashMap<String, List<ODU>> odu_hashMapForPath = new HashMap<>();

    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.NODE> sdnNodeHashMap = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.CONNECTOR> sdnConnectorHashMap = new HashMap<>();
    HashMap<String, LINK> sdnLinkHashMapForPath = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.SERVICE> sdnServiceHashMapForPath = new HashMap<>();
    public SDNManager(NODERepository nodeRepository, CONNECTORRepository connectorRepository, LINKRepository linkRepository, SERVICERepository serviceRepository, TUNNELRepository tunnelRepository, PATHRepository pathRepository, CONSTRAINTRepository constraintRepository, ACCESS_IFRepository access_ifRepository, List<NODE> nodes, List<Tl1SystemInfo> tl1SystemInfos, List<Tl1OduNodeConnector> tl1OduNodeConnectors, List<OPTIC_POWER> optic_powers, List<ODU> odus, List<ODU_MPLS_IF> odu_mpls_ifs, List<SERVICE> services, List<Tl1AccessIf> Tl1AccessIfs, List<SERVICE_EXT> service_exts, List<MPLS_IF> mpls_ifs, List<INVENTORY> inventories ) throws Exception{
        this.nodeRepository = nodeRepository;
        this.connectorRepository = connectorRepository;
        this.linkRepository = linkRepository;
        this.serviceRepository = serviceRepository;
        this.tunnelRepository = tunnelRepository;
        this.pathRepository = pathRepository;
        this.constraintRepository = constraintRepository;
        this.access_ifRepository = access_ifRepository;
        this.separator = ".";
        this.nodes = nodes;
        this.tl1SystemInfos = tl1SystemInfos;
        this.tl1OduNodeConnectors = tl1OduNodeConnectors;
        this.optic_powers = optic_powers;
        this.odus = odus;
        this.odu_mpls_ifs = odu_mpls_ifs;
        this.services = services;
        this.Tl1AccessIfs = Tl1AccessIfs;
        this.service_exts = service_exts;
        this.mpls_ifs = mpls_ifs;
        this.inventories = inventories;

        makeHashMap();

    }

    private void makeHashMap() {
        for(NODE node : nodes) {
            nodeHashMap.put(node.getTID(), node);
        }
        for(Tl1SystemInfo tl1SystemInfo : tl1SystemInfos) {
            system_infoHashMap.put(tl1SystemInfo.getTID(), tl1SystemInfo);
        }
        for(OPTIC_POWER optic_power : optic_powers) {
            optic_powerHashMap.put(optic_power.getTID()+"/"+optic_power.getAID(), optic_power);
        }
        for(ODU odu : odus) {
            if(odu_hashMapForPath.get(odu.getNAME()) == null ) {
                List<ODU> odu_list = new ArrayList<>();
                odu_list.add(odu);
                odu_hashMapForPath.put(odu.getNAME(), odu_list);
            } else {
                List<ODU> odu_list = odu_hashMapForPath.get(odu.getNAME());
                odu_list.add(odu);
                odu_hashMapForPath.put(odu.getNAME(), odu_list);
            }

            if(odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                oduHashMapForODUTUNNEL.put(odu.getTID() + '/' + odu.getLOCAL_ID().split("-")[0] +'-'+ odu.getLOCAL_ID().split("-")[1], odu);
                if (odu.getROLE().equals("TAIL")) {
                    oduNameTailHashMapForODUTUNNEL.put(odu.getNAME(), odu);

                    if (oduNameHeadHashMapForODUTUNNEL.get(odu.getNAME()) != null) {
                        List<ODU> odu_list = new ArrayList<>();
                        odu_list.add(oduNameHeadHashMapForODUTUNNEL.get(odu.getNAME()));
                        odu_list.add(odu);
                        odu_list_for_service.add(odu_list);
                    }
                } else {
                    oduNameHeadHashMapForODUTUNNEL.put(odu.getNAME(), odu);

                    if (oduNameTailHashMapForODUTUNNEL.get(odu.getNAME()) != null) {
                        List<ODU> odu_list = new ArrayList<>();
                        odu_list.add(odu);
                        odu_list.add(oduNameTailHashMapForODUTUNNEL.get(odu.getNAME()));
                        odu_list_for_service.add(odu_list);
                    }
                }
            } else if (odu.getEMS_SERVICE().equals("MPLS_TP")) {
                oduMapInMPLSTPByLocalId.put(odu.getTID()+'/'+odu.getLOCAL_ID(), odu);
                oduHashMapForMPLSTP.put(odu.getTID()+ '/' + odu.getLOCAL_ID().split("-")[0] +'-'+ odu.getLOCAL_ID().split("-")[1], odu);
            }



        }
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            odu_node_connectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), tl1OduNodeConnector);
        }
        for(Tl1AccessIf Tl1AccessIf : Tl1AccessIfs) {
            access_ifHashMap.put(Tl1AccessIf.getTID(), Tl1AccessIf);
        }
        for(ODU_MPLS_IF odu_mpls_if: odu_mpls_ifs) {
            odu_mpls_ifHashMap.put(odu_mpls_if.getTID()+'/'+odu_mpls_if.getMPLS_TP_ID(), odu_mpls_if);
        }


    }

    public void SDNSyncNodeList() throws Exception {

        for (NODE node: nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(node.getTID());

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = new com.woorinet.plugin.demo.DTO.SDN.NODE();
            sdnNode.setEms_id(200009);
            if (tl1SystemInfo != null) sdnNode.setNe_id(tl1SystemInfo.getVENDOR() + separator + node.getNODE_TYPE() + separator + node.getTID());
            sdnNode.setNe_id("");
            sdnNode.setNe_name(node.getTID());
            sdnNode.setNe_type("");
            sdnNode.setNe_model(node.getSYSTEM_TYPE());
            if (node.getNODE_STATUS().equals("normal")) sdnNode.setNe_status(node.getNODE_STATUS()); else sdnNode.setNe_status("broken");
            sdnNode.setSw_ver(node.getSOFTWARE());
            sdnNode.setIp_addr(node.getIP_ADDR());
            sdnNode.setVendor(tl1SystemInfo.getVENDOR());
            sdnNode.setSerial_num(""); // INVENTORY 에서 가져와야됨
            sdnNode.setSys_type(node.getNODE_TYPE());

            nodeRepository.save(sdnNode);
            sdnNodeHashMap.put(node.getTID(), sdnNode);
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {

        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            CONNECTOR connector = new CONNECTOR();

            NODE node = nodeHashMap.get(tl1OduNodeConnector.getTID());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTID());
            OPTIC_POWER optic_power = optic_powerHashMap.get(tl1OduNodeConnector.getTID()+"/"+ tl1OduNodeConnector.getAID());
            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(node.getTID());

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
            if(optic_power == null) {
                connector.setConnect_type("");
                connector.setConnect_idle("idle");
                connector.setConnect_llcf("");
                connector.setConnect_lambda("");
                connector.setModule_name("");
                connector.setConnect_pec("");
                connector.setConnect_serial("");
                connector.setUnit_type("");
            } else {
                if(optic_power.getPART_NUMBER().equals("TR-PX13L-NG2") ) connector.setConnect_type("sfp+");
                else if (optic_power.getPART_NUMBER().equals("TR-PX13L-NG2") || optic_power.getPART_NUMBER().equals("EOLP-1396-10") || optic_power.getPART_NUMBER().equals("FTLX1471D3BNL") ) connector.setConnect_type("sfp");
                else connector.setConnect_type(optic_power.getPART_NUMBER()); // 구글링 해야됨
                connector.setConnect_idle("occupied");
                connector.setConnect_llcf("");
                connector.setConnect_lambda(optic_power.getTX_WAVELENGTH());
                connector.setModule_name(optic_power.getPART_NUMBER());
                connector.setConnect_pec("");
                connector.setConnect_serial(optic_power.getSERIAL());
                connector.setUnit_type(optic_power.getUNIT_TYPE());
            }

            connectorRepository.save(connector);
            sdnConnectorHashMap.put(tl1OduNodeConnector.getTID() + '/' + tl1OduNodeConnector.getAID(), connector);
        }

    }

    public void SDNSyncLinkList ( ) throws Exception {

        for(ODU_MPLS_IF odu_mpls_if : odu_mpls_ifs) {
            LINK link = new LINK();

//
            Tl1SystemInfo src_tl1SystemInfo = system_infoHashMap.get(odu_mpls_if.getSRC_TID());
            Tl1SystemInfo dst_tl1SystemInfo = system_infoHashMap.get(odu_mpls_if.getDST_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE src_sdnNode = sdnNodeHashMap.get(odu_mpls_if.getSRC_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE dst_sdnNode = sdnNodeHashMap.get(odu_mpls_if.getDST_TID());
            CONNECTOR src_sdnConnector = sdnConnectorHashMap.get(odu_mpls_if.getSRC_TID()+ '/' + odu_mpls_if.getSRC_PORT());
            CONNECTOR dst_sdnConnector = sdnConnectorHashMap.get(odu_mpls_if.getDST_TID()+ '/' + odu_mpls_if.getDST_PORT());
            OPTIC_POWER optic_power = optic_powerHashMap.get(odu_mpls_if.getTID() + '/' + odu_mpls_if.getMPLS_TP_ID());
            ODU odu = oduHashMapForODUTUNNEL.get(odu_mpls_if.getTID()+ '/' + odu_mpls_if.getMPLS_TP_ID());

            int maximum_bandwidth = Integer.parseInt(odu_mpls_if.getMAXIMUM_BANDWIDTH());
            int available_bandwidth = Integer.parseInt(odu_mpls_if.getAVAILABLE_BANDWIDTH());

            link.setEms_id(200009);
            link.setDst_ems_id(200009);
            link.setLink_id(src_tl1SystemInfo.getVENDOR() + separator + src_sdnNode.getSys_type() + separator + src_sdnNode.getNe_name() + separator +
                    src_sdnConnector.getShelf_id() + separator + src_sdnConnector.getSlot_id() + separator + src_sdnConnector.getPort_id()
                    + ":" + dst_tl1SystemInfo.getVENDOR() + separator + dst_sdnNode.getSys_type() + separator + dst_sdnNode.getNe_name() + separator +
                    dst_sdnConnector.getShelf_id() + separator + dst_sdnConnector.getSlot_id() + separator + dst_sdnConnector.getPort_id());
            link.setLink_nm(odu_mpls_if.getNAME());
            link.setSrc_ne_id(src_sdnNode.getNe_id());
            link.setSrc_ne_name(src_sdnNode.getNe_name());
            link.setSrc_node_connector_id(src_sdnConnector.getConnect_id());
            link.setDst_ne_id(dst_sdnNode.getNe_id());
            link.setDst_ne_name(dst_sdnNode.getNe_name());
            link.setDst_node_connector_id(dst_sdnConnector.getConnect_id());
            link.setLink_type(odu_mpls_if.getLINK_TYPE());
            link.setLink_status(odu_mpls_if.getOPERATION_STATUS());
            link.setLink_category("");
            link.setHigh_order_tunnel("");
            link.setLatency("");
            link.setDistance(optic_power.getDISTANCE());
            link.setSrlg("");
            link.setOvpn("");
            if(odu == null ) link.setTimeslot(""); else link.setTimeslot(odu.getTSMAP());
            link.setLambda(optic_power.getTX_WAVELENGTH());
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
            sdnLinkHashMapForPath.put(odu_mpls_if.getSRC_TID() + '/' + odu_mpls_if.getSRC_PORT() + '-' + odu_mpls_if.getDST_TID() + '/' + odu_mpls_if.getDST_PORT(), link);
        }
    }

    public void SDNSyncServiceList( ) throws Exception {

        for (List<ODU> odu_list :odu_list_for_service) {
            ODU odu_head = odu_list.get(0);
            ODU odu_tail = odu_list.get(1);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(odu_head.getTID());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnDstNode = sdnNodeHashMap.get(odu_tail.getTID());
            com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = new com.woorinet.plugin.demo.DTO.SDN.SERVICE();

            CONNECTOR src_sdnConnector = sdnConnectorHashMap.get(odu_head.getTID()+ '/' + odu_head.getLOCAL_ID().split("-")[0] + "-" + odu_head.getLOCAL_ID().split("-")[1]);
            CONNECTOR dst_sdnConnector = sdnConnectorHashMap.get(odu_tail.getTID()+ '/' + odu_tail.getLOCAL_ID().split("-")[0] + "-" + odu_tail.getLOCAL_ID().split("-")[1]);

            ODU_MPLS_IF odu_mpls_if = odu_mpls_ifHashMap.get(odu_head.getTID() + '/' + odu_head.getLOCAL_ID().split("-")[0] + "-" + odu_head.getLOCAL_ID().split("-")[1]);
            OPTIC_POWER optic_power = optic_powerHashMap.get(odu_head.getTID() + '/' + odu_head.getLOCAL_ID().split("-")[0] + "-" + odu_head.getLOCAL_ID().split("-")[1]);

            sdnService.setEms_id(200009);
            sdnService.setService_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + odu_head.getNAME());
            sdnService.setSrc_ne_id(sdnSrcNode.getNe_id());
            sdnService.setSrc_ne_name(sdnSrcNode.getNe_name());
            sdnService.setSrc_connector_id(src_sdnConnector.getConnect_id());
            sdnService.setSrc_accessif_type(odu_head.getSERVICE());
            sdnService.setDst_ne_id(sdnDstNode.getNe_id());
            sdnService.setDst_ne_name(sdnDstNode.getNe_name());
            sdnService.setDst_connector_id(dst_sdnConnector.getConnect_id());
            sdnService.setDst_accessif_type(odu_tail.getSERVICE());
            sdnService.setService_type("");
            sdnService.setService_name(odu_head.getNAME());
            sdnService.setNetwork_type("");
            sdnService.setService_status("");
            sdnService.setRate_type(odu_head.getTYPE());
            sdnService.setService_rate(odu_mpls_if.getLINK_TYPE());
            sdnService.setLatency("");

            if(optic_power == null) {
                sdnService.setWavelength("");
            } else {
                sdnService.setWavelength(optic_power.getTX_WAVELENGTH());
            }
            sdnService.setActive_path(odu_head.getACTIVE_PATH_STATUS());
            sdnService.setCreation_date(odu_head.getCREATION_DATE());

            serviceRepository.save(sdnService);
            sdnServiceHashMapForPath.put(sdnService.getService_name(),sdnService);
        }

    }

    public void SDNSyncTunnelList( ) throws  Exception {

        for (ODU odu : odus) {
            TUNNEL tunnel = new TUNNEL();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(odu.getEMS_SRC_LSR());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnDstNode = sdnNodeHashMap.get(odu.getEMS_DST_LSR());


            tunnel.setEms_id(200009);
            tunnel.setTunnel_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + odu.getNAME());
            tunnel.setSrc_ne_id(sdnSrcNode.getNe_id());
            tunnel.setSrc_ne_name(sdnSrcNode.getNe_name());
            tunnel.setDst_ne_id(sdnDstNode.getNe_id());
            tunnel.setDst_ne_name(sdnDstNode.getNe_name());
            tunnel.setRate_type(odu.getTYPE());
            tunnel.setMultiple_rate("1");
            tunnel.setLocal_id("");
            tunnel.setRequest_id("");
            tunnel.setTunnel_name(odu.getNAME());
            if(odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                tunnel.setTunnel_type("otn");
            }else {
                tunnel.setTunnel_type(odu.getEMS_SERVICE());
            }
            tunnel.setTunnel_status("");
            tunnel.setConfiguration_action("");
            tunnel.setConfiguration_result_type("");
            tunnel.setTunnel_oam_enabler("");
            tunnel.setDeployment_enabler("");
            tunnel.setDeployment_status("");
            tunnel.setActive_path(odu.getACTIVE_PATH_STATUS());
            tunnel.setSrc_node_ref("");
            tunnel.setDst_node_ref("");
            tunnel.setService_ref("");
            tunnel.setAccessif_ref("");
            tunnel.setProtection_type(odu.getPROT_TYPE());
            tunnel.setWorking_path("");
            tunnel.setProtection_path("");
            tunnel.setService_mapping("");
            tunnel.setCreation_date(odu.getCREATION_DATE());

            tunnelRepository.save(tunnel);




        }
    }

    public void SDNSyncPathList() throws  Exception {
        for (Map.Entry<String, List<ODU>> entry : odu_hashMapForPath.entrySet() ) {
            List<ODU> odu_list = entry.getValue();
            if(odu_list.size() != 4) continue;

            ODU odu_head = null;
            ODU odu_tail = null;
            ODU odu_transit_from = null;
            ODU odu_transit_to = null;
            for(ODU odu: odu_list) {
                if (odu.getROLE().equals("TRANSIT_FROM")) odu_transit_from = odu;
                else if(odu.getROLE().equals("TRANSIT_TO")) odu_transit_to = odu;
                else if(odu.getROLE().equals("HEAD")) odu_head = odu;
                else odu_tail = odu;
            }

            odu_list.set(0, odu_head);
            odu_list.set(1, odu_transit_from);
            odu_list.set(2, odu_transit_to);
            odu_list.set(3, odu_tail);


            { // HEAD <--> TRANSIT_FROM
                LINK link = sdnLinkHashMapForPath.get(odu_head.getTID() +'/'+odu_head.getLOCAL_ID().split("-")[0]+'-' +odu_head.getLOCAL_ID().split("-")[1] + '-' + odu_transit_from.getTID() +'/'+odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+odu_transit_from.getLOCAL_ID().split("-")[1] );
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(odu_head.getACTIVE_PATH_STATUS());
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
                LINK link = sdnLinkHashMapForPath.get(odu_transit_to.getTID() +'/'+odu_transit_to.getLOCAL_ID().split("-")[0]+'-' +odu_transit_to.getLOCAL_ID().split("-")[1] + '-' + odu_tail.getTID() +'/'+odu_tail.getLOCAL_ID().split("-")[0]+'-'+odu_tail.getLOCAL_ID().split("-")[1] );
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(odu_transit_to.getACTIVE_PATH_STATUS());
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

        for (Map.Entry<String, List<ODU>> entry : odu_hashMapForPath.entrySet() ) {
            List<ODU> odu_list = entry.getValue();
            if(odu_list.size() != 4) continue;

            ODU odu_head = null;
            ODU odu_tail = null;
            ODU odu_transit_from = null;
            ODU odu_transit_to = null;
            for(ODU odu: odu_list) {
                if (odu.getROLE().equals("TRANSIT_FROM")) odu_transit_from = odu;
                else if(odu.getROLE().equals("TRANSIT_TO")) odu_transit_to = odu;
                else if(odu.getROLE().equals("HEAD")) odu_head = odu;
                else odu_tail = odu;
            }

            odu_list.set(0, odu_head);
            odu_list.set(1, odu_transit_from);
            odu_list.set(2, odu_transit_to);
            odu_list.set(3, odu_tail);


            { // HEAD <--> TRANSIT_FROM
                LINK link = sdnLinkHashMapForPath.get(odu_transit_from.getTID() +'/'+odu_transit_from.getLOCAL_ID().split("-")[0]+'-'+odu_transit_from.getLOCAL_ID().split("-")[1] + '-' +odu_head.getTID() +'/'+odu_head.getLOCAL_ID().split("-")[0]+'-' +odu_head.getLOCAL_ID().split("-")[1]);
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(odu_head.getACTIVE_PATH_STATUS());
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
                LINK link = sdnLinkHashMapForPath.get(odu_tail.getTID() +'/'+odu_tail.getLOCAL_ID().split("-")[0]+'-'+odu_tail.getLOCAL_ID().split("-")[1] +'-'+odu_transit_to.getTID() +'/'+odu_transit_to.getLOCAL_ID().split("-")[0]+'-' +odu_transit_to.getLOCAL_ID().split("-")[1]);
                com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = sdnServiceHashMapForPath.get(odu_head.getNAME());
                PATH path = new PATH();
                path.setEms_id(200009);
                path.setService_id(sdnService.getService_id());
                path.setPath_type(odu_transit_to.getACTIVE_PATH_STATUS());
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

        for (List<ODU> odu_list :odu_list_for_service) {
            ODU odu_head = odu_list.get(0);
            ODU odu_tail = odu_list.get(1);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(odu_head.getTID());

            CONSTRAINT constraint = new CONSTRAINT();

            constraint.setEms_id(200009);
            constraint.setService_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + odu_head.getNAME());
            constraint.setConst_id("protection type");
            constraint.setConst_type("");
            constraint.setConst_name("PROTECTION TYPE");
            constraint.setConst_value(odu_head.getPROT_TYPE());
            constraint.setConst_operator("");


            constraintRepository.save(constraint);

        }
    }

    public void SDNSyncAccess_if() throws Exception {

        for(MPLS_IF mpls_if : mpls_ifs) {

            Tl1SystemInfo tl1SystemInfo = system_infoHashMap.get(mpls_if.getTID());

            com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF sdnAccess_if = new com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(mpls_if.getTID());
            CONNECTOR sdnConnector = sdnConnectorHashMap.get(mpls_if.getTID()+ '/' + mpls_if.getMPLS_TP_ID().split("-")[0] + "-" + mpls_if.getMPLS_TP_ID().split("-")[1]);
            ODU odu = oduHashMapForMPLSTP.get(mpls_if.getTID()+ '/' + mpls_if.getMPLS_TP_ID().split("-")[0] + "-" + mpls_if.getMPLS_TP_ID().split("-")[1]);
            if(odu == null) continue;

            sdnAccess_if.setEms_id(200009);
            sdnAccess_if.setAccessif_id(tl1SystemInfo.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_id() + separator + sdnConnector.getConnect_id()); // 조합
            sdnAccess_if.setAccessif_name("");
            sdnAccess_if.setNe_id(sdnNode.getNe_id());
            sdnAccess_if.setConnector_id(sdnConnector.getConnect_id());
            sdnAccess_if.setAccessif_type(odu.getSERVICE());
            sdnAccess_if.setAccessif_status(mpls_if.getOPERATION_STATUS());
            sdnAccess_if.setService_ref("");
            sdnAccess_if.setNode_connector_ref("");

            access_ifRepository.save(sdnAccess_if);


        }

    }


}
