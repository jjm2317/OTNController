package com.woorinet.plugin.demo.SDN;

import com.woorinet.plugin.demo.DTO.TL1.NODE;
import com.woorinet.plugin.demo.DTO.TL1.SYSTEM_INFO;
import com.woorinet.plugin.demo.Mapper.SDNMapper;

import java.util.List;

public class SDNManager {
    SDNMapper sdnMapper;
    public SDNManager(SDNMapper sdnMapper) throws Exception{
        this.sdnMapper = sdnMapper;
        sdnMapper.initDatabase();
    }


    public void SDNSyncNodeList(List<NODE> nodes, List<SYSTEM_INFO> system_infos) throws Exception {
        sdnMapper.initNodeTable();

        for (NODE node: nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue; // otn장비만

            SYSTEM_INFO system_info = GetSystemInfoByTID(node.getTID(), system_infos);

            com.woorinet.plugin.demo.DTO.SDN.NODE sdnNode = new com.woorinet.plugin.demo.DTO.SDN.NODE();
            sdnNode.setEms_id(200009);
            sdnNode.setNe_id(system_info.getVENDOR()+"_"+node.getSYSTEM_TYPE()+"_"+node.getTID());
            sdnNode.setNe_name(node.getTID());
            sdnNode.setNe_type("");
            //sdnNode.setNe_model();
            if (node.getNODE_STATUS().equals("normal")) {
                sdnNode.setNe_status(node.getNODE_STATUS());
            } else {
                sdnNode.setNe_status("broken");
            }
            sdnNode.setSw_ver(node.getSOFTWARE());
            sdnNode.setIp_addr(node.getIP_ADDR());
            sdnNode.setVendor(system_info.getVENDOR());
            sdnNode.setSerial_num("");
            sdnNode.setSys_type(node.getSYSTEM_TYPE());

            sdnMapper.insertNode(sdnNode);
        }

    }


    private SYSTEM_INFO GetSystemInfoByTID(String TID,List<SYSTEM_INFO> system_infos) {
        for (SYSTEM_INFO system_info : system_infos) {
            if (system_info.getTID().equals(TID)) return system_info;
        }
        return null;
    }

}
