package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.DTO.TL1.ACCESS_IF;
import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.SERVICE;
import com.woorinet.plugin.demo.Repository.SDN.*;

import java.util.HashMap;
import java.util.List;

public class SDNManager {
    NODERepository nodeRepository;
    CONNECTORRepository connectorRepository;
    LINKRepository linkRepository;
    SERVICERepository serviceRepository;
    TUNNELRepository tunnelRepository;
    CONSTRAINTRepository constraintRepository;

    String separator;
    List<NODE> nodes;
    List<SYSTEM_INFO> system_infos;
    List<ODU_NODE_CONNECTOR> odu_node_connectors;
    List<OPTIC_POWER> optic_powers;
    List<ODU> odus;
    List<ODU_MPLS_IF> odu_mpls_ifs;
    List<SERVICE> services;
    List<ACCESS_IF> access_ifs;

    HashMap<String, NODE> nodeHashMap = new HashMap<>();
    HashMap<String, SYSTEM_INFO> system_infoHashMap = new HashMap<>();
    HashMap<String, OPTIC_POWER> optic_powerHashMap = new HashMap<>();
    HashMap<String, ODU_NODE_CONNECTOR> odu_node_connectorHashMap = new HashMap<>();
    HashMap<String, ODU> oduHashMap = new HashMap<>();
    HashMap<String, ACCESS_IF> access_ifHashMap = new HashMap<>();

    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.NODE> sdnNodeHashMap = new HashMap<>();
    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.CONNECTOR> sdnConnectorHashMap = new HashMap<>();
    public SDNManager(NODERepository nodeRepository, CONNECTORRepository connectorRepository, LINKRepository linkRepository, SERVICERepository serviceRepository, TUNNELRepository tunnelRepository, CONSTRAINTRepository constraintRepository, List<NODE> nodes, List<SYSTEM_INFO> system_infos, List<ODU_NODE_CONNECTOR> odu_node_connectors, List<OPTIC_POWER> optic_powers, List<ODU> odus, List<ODU_MPLS_IF> odu_mpls_ifs,List<SERVICE> services,List<ACCESS_IF> access_ifs ) throws Exception{
        this.nodeRepository = nodeRepository;
        this.connectorRepository = connectorRepository;
        this.linkRepository = linkRepository;
        this.serviceRepository = serviceRepository;
        this.tunnelRepository = tunnelRepository;
        this.constraintRepository = constraintRepository;
        this.separator = "_";
        this.nodes = nodes;
        this.system_infos = system_infos;
        this.odu_node_connectors = odu_node_connectors;
        this.optic_powers = optic_powers;
        this.odus = odus;
        this.odu_mpls_ifs = odu_mpls_ifs;
        this.services = services;
        this.access_ifs = access_ifs;

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
            sdnNode.setSerial_num("");
            sdnNode.setSys_type(node.getNODE_TYPE());

            //sdnMapper.insertNode(sdnNode);
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

            link.setEms_id(200009);
            link.setDst_ems_id(200009);
            link.setLink_id(src_system_info.getVENDOR() + separator + src_sdnNode.getSys_type() + separator + src_sdnNode.getNe_name() + separator +
                    src_sdnConnector.getShelf_id() + separator + src_sdnConnector.getSlot_id() + separator + src_sdnConnector.getPort_id()
                    + '-' + dst_system_info.getVENDOR() + separator + dst_sdnNode.getSys_type() + separator + dst_sdnNode.getNe_name() + separator +
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
            link.setMaximum_odu0s(-1);
            link.setMaximum_odu1s(-1);
            link.setMaximum_odu2s(-1);
            link.setMaximum_odu2es(-1);
            link.setMaximum_odu3s(-1);
            link.setMaximum_odu4s(-1);
            link.setMaximum_odu4cns(-1);
            link.setMaximum_oduflexs(-1);
            link.setAvailable_odu0s(-1);
            link.setAvailable_odu1s(-1);
            link.setAvailable_odu2s(-1);
            link.setAvailable_odu2es(-1);
            link.setAvailable_odu3s(-1);
            link.setAvailable_odu4s(-1);
            link.setAvailable_odu4cns(-1);
            link.setAvailable_oduflexs(-1);

            linkRepository.save(link);
        }
    }

    public void SDNSyncServiceList( ) throws Exception {

        for (SERVICE service : services) {
            NODE node = nodeHashMap.get(service.getTID());
            if(!node.getNODE_TYPE().equals("otn")) continue;

            com.woorinet.plugin.demo.DTO.SDN.SERVICE sdnService = new com.woorinet.plugin.demo.DTO.SDN.SERVICE();
            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = sdnNodeHashMap.get(service.getTID());
//            CONNECTOR connector = sdnConnectorHashMap.get(service.getTID(), service.)
            ACCESS_IF access_if = access_ifHashMap.get(service.getTID());


            sdnService.setEms_id(200009);
            sdnService.setService_id(sdnNode.getVendor() + separator + sdnNode.getSys_type() + separator + service.getNAME());
            sdnService.setSrc_ne_id(sdnNode.getNe_id());
            sdnService.setSrc_ne_name(sdnNode.getNe_name());
            sdnService.setSrc_connector_id("");//sdnConnector connect_id 들어가야됨
            sdnService.setSrc_accessif_type(access_if.getACCESS_IF_TYPE());
            sdnService.setDst_ne_id(sdnNode.getNe_id());
            sdnService.setDst_ne_name(sdnNode.getNe_name());
            sdnService.setDst_connector_id("");//sdnConnector connect_id 들어가야됨
            sdnService.setDst_accessif_type(access_if.getACCESS_IF_TYPE());
            sdnService.setService_type(service.getS_TYPE());
            sdnService.setService_name(service.getNAME());
            sdnService.setNetwork_type("");
            sdnService.setService_status(service.getOPER_STATUS());
            sdnService.setRate_type("");
            sdnService.setService_rate("");
            sdnService.setLatency("");
            sdnService.setWavelength("");
            sdnService.setActive_path("");
            sdnService.setCreation_date("");

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

        }
    }

    public void SDNSyncPathList() throws  Exception {
//        for() {
//            PATH path = new PATH();
//
//            path.setEms_id();
//            path.setService_id();
//            path.setPath_type();
//            path.setConnection_idx();
//            path.setConnection_type();
//            path.setDirection_type();
//            path.setTp_type();
//            path.setInstance_type();
//            path.setInstance_ref();
//            path.setRef_type();
//        }
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


}
