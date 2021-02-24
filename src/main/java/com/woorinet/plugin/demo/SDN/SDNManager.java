package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.DTO.TL1.ACCESS_IF;
import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.SERVICE;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Repository.SDN.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    List<SYSTEM_INFO> system_infos;
    List<ODU_NODE_CONNECTOR> odu_node_connectors;
    List<OPTIC_POWER> optic_powers;
    List<ODU> odus;
    List<ODU_MPLS_IF> odu_mpls_ifs;
    List<SERVICE> services;
    List<ACCESS_IF> access_ifs;
    List<SERVICE_EXT> service_exts;
    List<List<ODU>> odu_list_for_service = new ArrayList<>();

    HashMap<String, NODE> nodeHashMap = new HashMap<>();
    HashMap<String, SYSTEM_INFO> system_infoHashMap = new HashMap<>();
    HashMap<String, OPTIC_POWER> optic_powerHashMap = new HashMap<>();
    HashMap<String, ODU_NODE_CONNECTOR> odu_node_connectorHashMap = new HashMap<>();
    HashMap<String, ODU> oduHashMap = new HashMap<>();
    HashMap<String, ACCESS_IF> access_ifHashMap = new HashMap<>();
    HashMap<String, ODU> oduNameTailHashMap = new HashMap<>();
    HashMap<String, ODU> oduNameHeadHashMap = new HashMap<>();
    HashMap<String, ODU_MPLS_IF> odu_mpls_ifHashMap = new HashMap<>();

    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.NODE> sdnNodeHashMap = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.CONNECTOR> sdnConnectorHashMap = new HashMap<>();
    public SDNManager(NODERepository nodeRepository, CONNECTORRepository connectorRepository, LINKRepository linkRepository, SERVICERepository serviceRepository, TUNNELRepository tunnelRepository,PATHRepository pathRepository, CONSTRAINTRepository constraintRepository,ACCESS_IFRepository access_ifRepository, List<NODE> nodes, List<SYSTEM_INFO> system_infos, List<ODU_NODE_CONNECTOR> odu_node_connectors, List<OPTIC_POWER> optic_powers, List<ODU> odus, List<ODU_MPLS_IF> odu_mpls_ifs,List<SERVICE> services,List<ACCESS_IF> access_ifs, List<SERVICE_EXT> service_exts ) throws Exception{
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
        this.system_infos = system_infos;
        this.odu_node_connectors = odu_node_connectors;
        this.optic_powers = optic_powers;
        this.odus = odus;
        this.odu_mpls_ifs = odu_mpls_ifs;
        this.services = services;
        this.access_ifs = access_ifs;
        this.service_exts = service_exts;

        makeHashMap();
    }

    private void makeHashMap() {
        for(NODE node : nodes) {
            nodeHashMap.put(node.getTID(), node);
        }
        for(SYSTEM_INFO system_info: system_infos) {
            system_infoHashMap.put(system_info.getTID(), system_info);
        }
        for(OPTIC_POWER optic_power : optic_powers) {
            optic_powerHashMap.put(optic_power.getTID()+"/"+optic_power.getAID(), optic_power);
        }
        for(ODU odu : odus) {
            oduHashMap.put(odu.getTID(), odu);
        }
        for(ODU_NODE_CONNECTOR odu_node_connector : odu_node_connectors) {
            odu_node_connectorHashMap.put(odu_node_connector.getTID() + '/' + odu_node_connector.getAID(), odu_node_connector);
        }
        for(ACCESS_IF access_if : access_ifs) {
            access_ifHashMap.put(access_if.getTID(), access_if);
        }
        for(ODU_MPLS_IF odu_mpls_if: odu_mpls_ifs) {
            odu_mpls_ifHashMap.put(odu_mpls_if.getTID()+'/'+odu_mpls_if.getMPLS_TP_ID(), odu_mpls_if);
        }

    }

    public void SDNSyncNodeList() throws Exception {

        for (NODE node: nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            SYSTEM_INFO system_info = system_infoHashMap.get(node.getTID());

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = new com.woorinet.plugin.demo.DTO.SDN.NODE();
            sdnNode.setEms_id(200009);
            if (system_info != null) {
                sdnNode.setNe_id(system_info.getVENDOR() + separator + node.getNODE_TYPE() + separator + node.getTID());
            } else {
                sdnNode.setNe_id("");
            }
            sdnNode.setNe_name(node.getTID());
            sdnNode.setNe_type("");
            sdnNode.setNe_model(node.getSYSTEM_TYPE());
            if (node.getNODE_STATUS().equals("normal")) {
                sdnNode.setNe_status(node.getNODE_STATUS());
            } else {
                sdnNode.setNe_status("broken");
            }
            sdnNode.setSw_ver(node.getSOFTWARE());
            sdnNode.setIp_addr(node.getIP_ADDR());
            sdnNode.setVendor(system_info.getVENDOR());
            sdnNode.setSerial_num(""); // INVENTORY 에서 가져와야됨
            sdnNode.setSys_type(node.getNODE_TYPE());

            nodeRepository.save(sdnNode);
            sdnNodeHashMap.put(node.getTID(), sdnNode);
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {

        for(ODU_NODE_CONNECTOR odu_node_connector :  odu_node_connectors) {
            CONNECTOR connector = new CONNECTOR();

            NODE node = nodeHashMap.get(odu_node_connector.getTID());
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(odu_node_connector.getTID());
            OPTIC_POWER optic_power = optic_powerHashMap.get(odu_node_connector.getTID()+"/"+odu_node_connector.getAID());
            SYSTEM_INFO system_info = system_infoHashMap.get(node.getTID());

            connector.setEms_id(200009);
            connector.setConnect_id(system_info.getVENDOR() + separator + sdnNode.getSys_type() + separator + sdnNode.getNe_name() + separator + odu_node_connector.getSHELF_INDEX() + separator + odu_node_connector.getSLOT_INDEX() + separator + odu_node_connector.getPORT_INDEX());
            connector.setConnect_name("");
            connector.setNe_id(sdnNode.getNe_id());
            connector.setNe_name(sdnNode.getNe_name());
            connector.setRack_id("");
            connector.setShelf_id(odu_node_connector.getSHELF_INDEX());
            connector.setSlot_id(odu_node_connector.getSLOT_INDEX());
            connector.setSubslot_id("");
            connector.setPort_id(odu_node_connector.getPORT_INDEX());
            if (odu_node_connector.getPORT_STATUS().equals("ACT")) {
                connector.setConnect_status("up");
            } else if (odu_node_connector.getPORT_STATUS().equals("DEACT")) {
                connector.setConnect_status("down");
            }
            connector.setConnect_role(odu_node_connector.getPORT_ROLE());
            if(optic_power == null) {
                connector.setConnect_type(""); // 구글링 해야됨
                connector.setConnect_idle("idle");
                connector.setConnect_llcf("");
                connector.setConnect_lambda("");
                connector.setModule_name("");
                connector.setConnect_pec("");
                connector.setConnect_serial("");
                connector.setUnit_type("");
            } else {
                if(optic_power.getPART_NUMBER().equals("TR-PX13L-NG2") ) {
                    connector.setConnect_type("sfp+");
                } else if (optic_power.getPART_NUMBER().equals("TR-PX13L-NG2") || optic_power.getPART_NUMBER().equals("EOLP-1396-10") || optic_power.getPART_NUMBER().equals("FTLX1471D3BNL") ) {
                    connector.setConnect_type("sfp");
                } else {
                    connector.setConnect_type(optic_power.getPART_NUMBER()); // 구글링 해야됨
                }
                connector.setConnect_idle("occupied");
                connector.setConnect_llcf("");
                connector.setConnect_lambda(optic_power.getTX_WAVELENGTH());
                connector.setModule_name(optic_power.getPART_NUMBER());
                connector.setConnect_pec("");
                connector.setConnect_serial(optic_power.getSERIAL());
                connector.setUnit_type(optic_power.getUNIT_TYPE());
            }



            connectorRepository.save(connector);
            sdnConnectorHashMap.put(odu_node_connector.getTID() + '/' + odu_node_connector.getAID(), connector);
        }

    }

    public void SDNSyncLinkList ( ) throws Exception {

        for(ODU_MPLS_IF odu_mpls_if : odu_mpls_ifs) {
            LINK link = new LINK();

//
            SYSTEM_INFO src_system_info = system_infoHashMap.get(odu_mpls_if.getSRC_TID());
            SYSTEM_INFO dst_system_info = system_infoHashMap.get(odu_mpls_if.getDST_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE src_sdnNode = sdnNodeHashMap.get(odu_mpls_if.getSRC_TID());
            com.woorinet.plugin.demo.DTO.SDN.NODE dst_sdnNode = sdnNodeHashMap.get(odu_mpls_if.getDST_TID());
            CONNECTOR src_sdnConnector = sdnConnectorHashMap.get(odu_mpls_if.getSRC_TID()+ '/' + odu_mpls_if.getSRC_PORT());
            CONNECTOR dst_sdnConnector = sdnConnectorHashMap.get(odu_mpls_if.getDST_TID()+ '/' + odu_mpls_if.getDST_PORT());
            OPTIC_POWER optic_power = optic_powerHashMap.get(odu_mpls_if.getTID() + '/' + odu_mpls_if.getMPLS_TP_ID());
            ODU odu = oduHashMap.get(odu_mpls_if.getTID());

            int maximum_bandwidth = Integer.parseInt(odu_mpls_if.getMAXIMUM_BANDWIDTH());
            int available_bandwidth = Integer.parseInt(odu_mpls_if.getAVAILABLE_BANDWIDTH());

            link.setEms_id(200009);
            link.setDst_ems_id(200009);
            link.setLink_id(src_system_info.getVENDOR() + separator + src_sdnNode.getSys_type() + separator + src_sdnNode.getNe_name() + separator +
                    src_sdnConnector.getShelf_id() + separator + src_sdnConnector.getSlot_id() + separator + src_sdnConnector.getPort_id()
                    + ":" + dst_system_info.getVENDOR() + separator + dst_sdnNode.getSys_type() + separator + dst_sdnNode.getNe_name() + separator +
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
            link.setTimeslot(odu.getTSMAP());
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
                sdnService.setWavelength(""); // OPTIC_POWER.TX_WAVELENGTH
            } else {
                sdnService.setWavelength(optic_power.getTX_WAVELENGTH());
            }
            sdnService.setActive_path(odu_head.getACTIVE_PATH_STATUS());
            sdnService.setCreation_date(odu_head.getCREATION_DATE());

            serviceRepository.save(sdnService);
        }

    }

    public void SDNSyncTunnelList( ) throws  Exception {

        for (ODU odu : odus) {
            TUNNEL tunnel = new TUNNEL();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(odu.getTID());


            tunnel.setEms_id(200009);
            tunnel.setTunnel_id(sdnNode.getVendor() + separator + sdnNode.getSys_type() + separator + odu.getNAME());
            tunnel.setSrc_ne_id(sdnNode.getNe_id());
            tunnel.setSrc_ne_name(sdnNode.getNe_name());
            tunnel.setDst_ne_id(sdnNode.getNe_id());
            tunnel.setDst_ne_name(sdnNode.getNe_name());
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


            if(odu.getEMS_SERVICE().equals("ODU_TUNNEL")) {
                if(odu.getROLE().equals("TAIL")) {
                    oduNameTailHashMap.put(odu.getNAME(),odu);

                    if(oduNameHeadHashMap.get(odu.getNAME()) != null){
                        List<ODU> odu_list = new ArrayList<>();
                        odu_list.add(oduNameHeadHashMap.get(odu.getNAME()));
                        odu_list.add(odu);
                        odu_list_for_service.add(odu_list);
                    }
                } else {
                    oduNameHeadHashMap.put(odu.getNAME(),odu);

                    if(oduNameTailHashMap.get(odu.getNAME()) != null) {
                        List<ODU> odu_list = new ArrayList<>();
                        odu_list.add(odu);
                        odu_list.add(oduNameTailHashMap.get(odu.getNAME()));
                        odu_list_for_service.add(odu_list);
                    }
                }

            }

        }
    }

    public void SDNSyncPathList() throws  Exception {
        for (List<ODU> odu_list :odu_list_for_service) {
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnSrcNode = sdnNodeHashMap.get(odu_list.get(0).getEMS_SRC_LSR());

            PATH path = new PATH();
            path.setEms_id(200009);
            //path.setService_id(sdnSrcNode.getVendor() + separator + sdnSrcNode.getSys_type() + separator + odu.getNAME());
            //path.setPath_type(odu.getACTIVE_PATH_STATUS());
            path.setConnection_idx("1");
            path.setConnection_type("");
            path.setDirection_type("egress");
            path.setTp_type("");
            path.setInstance_type("tunnel");
            path.setInstance_ref("");
            path.setRef_type("");
            pathRepository.save(path);

            PATH path2 = new PATH();
            path2.setEms_id(200009);
            //path2.setService_id(odu.getNAME());
            //path2.setPath_type(odu.getACTIVE_PATH_STATUS());
            path2.setConnection_idx("2");
            path2.setConnection_type("");
            path2.setDirection_type("ingress");
            path2.setTp_type("");
            path2.setInstance_type("tunnel");
            path2.setInstance_ref("");
            path2.setRef_type("");
            pathRepository.save(path2);
        }
    }

    public void SDNsyncConstraint() throws Exception {

        for(ODU_MPLS_IF odu_mpls_if : odu_mpls_ifs) {
            CONSTRAINT constraint = new CONSTRAINT();

            constraint.setEms_id(200009);
            constraint.setService_id("");
            constraint.setConst_id(odu_mpls_if.getCONSTRAINT_ID());
            constraint.setConst_type("");
            constraint.setConst_name(odu_mpls_if.getCONSTRAINT_NAME());
            constraint.setConst_value(odu_mpls_if.getCONSTRAINT_VALUE());
            constraint.setConst_operator("");

            constraintRepository.save(constraint);

        }
    }

    public void SDNSyncAccess_if() throws Exception {

        for(ACCESS_IF access_if : access_ifs) {
            com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF sdnAccess_if = new com.woorinet.plugin.demo.DTO.SDN.ACCESS_IF();

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(access_if.getTID());
            CONNECTOR sdnConnector = sdnConnectorHashMap.get(access_if.getTID()+ '/' + access_if.getACCESS_IF_ID());

            if(sdnNode == null || !sdnNode.getSys_type().equals("otn")) continue;

            sdnAccess_if.setEms_id(200009);
            sdnAccess_if.setAccessif_id(access_if.getACCESS_IF_ID());
            sdnAccess_if.setAccessif_name("");
            sdnAccess_if.setNe_id(sdnNode.getNe_id());
            if (sdnConnector == null ) {
                sdnAccess_if.setConnector_id("");
            } else {
                sdnAccess_if.setConnector_id(sdnConnector.getConnect_id());
            }
            sdnAccess_if.setAccessif_type(access_if.getACCESS_IF_TYPE());
            sdnAccess_if.setAccessif_status(access_if.getACCESS_IF_OPERATIONAL_STATUS());

            access_ifRepository.save(sdnAccess_if);
        }

    }


}
