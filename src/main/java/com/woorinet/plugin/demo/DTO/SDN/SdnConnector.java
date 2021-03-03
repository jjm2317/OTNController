package com.woorinet.plugin.demo.DTO.SDN;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@Table(name="sdn_connector")
public class SdnConnector {
    int ems_id;
    @Id
    @Generated
    String connect_id;
    String connect_name;
    String connect_type;
    String ne_id;
    String ne_name;
    String rack_id;
    String shelf_id;
    String slot_id;
    String subslot_id;
    String port_id;
    String connect_status;
    String connect_role;
    String connect_idle;
    String connect_llcf;
    String connect_lambda;
    String module_name;
    String connect_pec;
    String connect_serial;
    String unit_type;

    public SdnConnector() {

    }

    public SdnConnector(int ems_id, String connect_id, String connect_name, String connect_type, String ne_id, String ne_name, String rack_id, String shelf_id, String slot_id, String subslot_id, String port_id, String connect_status, String connect_role, String connect_idle, String connect_llcf, String connect_lambda, String module_name, String connect_pec, String connect_serial, String unit_type) {
        this.ems_id = ems_id;
        this.connect_id = connect_id;
        this.connect_name = connect_name;
        this.connect_type = connect_type;
        this.ne_id = ne_id;
        this.ne_name = ne_name;
        this.rack_id = rack_id;
        this.shelf_id = shelf_id;
        this.slot_id = slot_id;
        this.subslot_id = subslot_id;
        this.port_id = port_id;
        this.connect_status = connect_status;
        this.connect_role = connect_role;
        this.connect_idle = connect_idle;
        this.connect_llcf = connect_llcf;
        this.connect_lambda = connect_lambda;
        this.module_name = module_name;
        this.connect_pec = connect_pec;
        this.connect_serial = connect_serial;
        this.unit_type = unit_type;
    }

    @Override
    public String toString() {
        return "CONNECTOR{" +
                "ems_id=" + ems_id +
                ", connect_id='" + connect_id + '\'' +
                ", connect_name='" + connect_name + '\'' +
                ", connect_type='" + connect_type + '\'' +
                ", ne_id='" + ne_id + '\'' +
                ", ne_name='" + ne_name + '\'' +
                ", rack_id='" + rack_id + '\'' +
                ", shelf_id='" + shelf_id + '\'' +
                ", slot_id='" + slot_id + '\'' +
                ", subslot_id='" + subslot_id + '\'' +
                ", port_id='" + port_id + '\'' +
                ", connect_status='" + connect_status + '\'' +
                ", connect_role='" + connect_role + '\'' +
                ", connect_idle='" + connect_idle + '\'' +
                ", connect_llcf='" + connect_llcf + '\'' +
                ", connect_lambda='" + connect_lambda + '\'' +
                ", module_name='" + module_name + '\'' +
                ", connect_pec='" + connect_pec + '\'' +
                ", connect_serial='" + connect_serial + '\'' +
                ", unit_type='" + unit_type + '\'' +
                '}';
    }
}
