package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.SDN.CONNECTOR;
import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.ODU_NODE_CONNECTOR;
import com.woorinet.plugin.demo.DTO.TL1.SYSTEM_INFO;
import com.woorinet.plugin.demo.Mapper.SDNMapper;

import java.util.List;

public class SDNManager {
    SDNMapper sdnMapper;
    String separator;
    List<NODE> nodes;
    List<SYSTEM_INFO> system_infos;
    List<ODU_NODE_CONNECTOR> odu_node_connectors;
    public SDNManager(SDNMapper sdnMapper, List<NODE> nodes, List<SYSTEM_INFO> system_infos,  List<ODU_NODE_CONNECTOR> odu_node_connectors) throws Exception{
        this.sdnMapper = sdnMapper;
        this.separator = "_";
        this.nodes = nodes;
        this.system_infos = system_infos;
        this.odu_node_connectors = odu_node_connectors;
        sdnMapper.initDatabase();
    }


    public void SDNSyncNodeList() throws Exception {
        sdnMapper.initNodeTable();

        for (NODE node: nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            SYSTEM_INFO system_info = GetSystemInfoByTID(node.getTID(), system_infos);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = new com.woorinet.plugin.demo.DTO.SDN.NODE();
            sdnNode.setEms_id(200009);
            sdnNode.setNe_id(system_info.getVENDOR()+separator+node.getNODE_TYPE()+separator+node.getTID());
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
        }

    }

    public void SDNSyncConnectorList( ) throws Exception {
        sdnMapper.initConnector();

        for(ODU_NODE_CONNECTOR odu_node_connector :  odu_node_connectors) {

        }

    }


    private SYSTEM_INFO GetSystemInfoByTID(String TID,List<SYSTEM_INFO> system_infos) {
        for (SYSTEM_INFO system_info : system_infos) {
            if (system_info.getTID().equals(TID)) return system_info;
        }
        return null;
    }

}
