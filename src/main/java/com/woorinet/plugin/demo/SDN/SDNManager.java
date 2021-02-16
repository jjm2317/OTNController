package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.CONNECTOR;
import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.ODU_NODE_CONNECTOR;
import com.woorinet.plugin.demo.DTO.TL1.OPTIC_POWER;
import com.woorinet.plugin.demo.DTO.TL1.SYSTEM_INFO;
import com.woorinet.plugin.demo.Mapper.SDNMapper;

import java.util.HashMap;
import java.util.List;

public class SDNManager {
    SDNMapper sdnMapper;
    String separator;
    List<NODE> nodes;
    List<SYSTEM_INFO> system_infos;
    List<ODU_NODE_CONNECTOR> odu_node_connectors;
    List<OPTIC_POWER> optic_powers;

    HashMap<String, NODE> nodeHashMap = new HashMap<>();
    HashMap<String, SYSTEM_INFO> system_infoHashMap = new HashMap<>();
    HashMap<String, OPTIC_POWER> optic_powerHashMap = new HashMap<>();

    HashMap<String, com.woorinet.plugin.demo.DTO.SDN.NODE> sdnNodeHashMap = new HashMap<>();
    public SDNManager(SDNMapper sdnMapper, List<NODE> nodes, List<SYSTEM_INFO> system_infos,  List<ODU_NODE_CONNECTOR> odu_node_connectors, List<OPTIC_POWER> optic_powers) throws Exception{
        this.sdnMapper = sdnMapper;
        this.separator = "_";
        this.nodes = nodes;
        this.system_infos = system_infos;
        this.odu_node_connectors = odu_node_connectors;
        this.optic_powers = optic_powers;

        sdnMapper.initDatabase();
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

    }

    public void SDNSyncNodeList() throws Exception {
        sdnMapper.initNodeTable();

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

            sdnMapper.insertNode(sdnNode);
            sdnNodeHashMap.put(node.getTID(), sdnNode);
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {
        sdnMapper.initConnector();

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



            sdnMapper.insertConnector(connector);
        }

    }



}
