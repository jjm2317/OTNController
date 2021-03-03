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
@Table(name="sdn_tunnel")
public class SdnTunnel {
    int ems_id;
    @Id
    @Generated
    String tunnel_id;
    String src_ne_id;
    String src_ne_name;
    String dst_ne_id;
    String dst_ne_name;
    String rate_type;
    String multiple_rate;
    String local_id;
    String request_id;
    String tunnel_name;
    String tunnel_type;
    String tunnel_status;
    String configuration_action;
    String configuration_result_type;
    String tunnel_oam_enabler;
    String deployment_enabler;
    String deployment_status;
    String active_path;
    String src_node_ref;
    String dst_node_ref;
    String service_ref;
    String accessif_ref;
    String protection_type;
    String working_path;
    String protection_path;
    String service_mapping;
    String creation_date;

    public SdnTunnel() {
    }

    public SdnTunnel(int ems_id, String tunnel_id, String src_ne_id, String src_ne_name, String dst_ne_id, String dst_ne_name, String rate_type, String multiple_rate, String local_id, String request_id, String tunnel_name, String tunnel_type, String tunnel_status, String configuration_action, String configuration_result_type, String tunnel_oam_enabler, String deployment_enabler, String deployment_status, String active_path, String src_node_ref, String dst_node_ref, String service_ref, String accessif_ref, String protection_type, String working_path, String protection_path, String service_mapping, String creation_date) {
        this.ems_id = ems_id;
        this.tunnel_id = tunnel_id;
        this.src_ne_id = src_ne_id;
        this.src_ne_name = src_ne_name;
        this.dst_ne_id = dst_ne_id;
        this.dst_ne_name = dst_ne_name;
        this.rate_type = rate_type;
        this.multiple_rate = multiple_rate;
        this.local_id = local_id;
        this.request_id = request_id;
        this.tunnel_name = tunnel_name;
        this.tunnel_type = tunnel_type;
        this.tunnel_status = tunnel_status;
        this.configuration_action = configuration_action;
        this.configuration_result_type = configuration_result_type;
        this.tunnel_oam_enabler = tunnel_oam_enabler;
        this.deployment_enabler = deployment_enabler;
        this.deployment_status = deployment_status;
        this.active_path = active_path;
        this.src_node_ref = src_node_ref;
        this.dst_node_ref = dst_node_ref;
        this.service_ref = service_ref;
        this.accessif_ref = accessif_ref;
        this.protection_type = protection_type;
        this.working_path = working_path;
        this.protection_path = protection_path;
        this.service_mapping = service_mapping;
        this.creation_date = creation_date;
    }

    @Override
    public String toString() {
        return "TUNNEL{" +
                "ems_id=" + ems_id +
                ", tunnel_id='" + tunnel_id + '\'' +
                ", src_ne_id='" + src_ne_id + '\'' +
                ", src_ne_name='" + src_ne_name + '\'' +
                ", dst_ne_id='" + dst_ne_id + '\'' +
                ", dst_ne_name='" + dst_ne_name + '\'' +
                ", rate_type='" + rate_type + '\'' +
                ", multiple_rate='" + multiple_rate + '\'' +
                ", local_id='" + local_id + '\'' +
                ", request_id='" + request_id + '\'' +
                ", tunnel_name='" + tunnel_name + '\'' +
                ", tunnel_type='" + tunnel_type + '\'' +
                ", tunnel_status='" + tunnel_status + '\'' +
                ", configuration_action='" + configuration_action + '\'' +
                ", configuration_result_type='" + configuration_result_type + '\'' +
                ", tunnel_oam_enabler='" + tunnel_oam_enabler + '\'' +
                ", deployment_enabler='" + deployment_enabler + '\'' +
                ", deployment_status='" + deployment_status + '\'' +
                ", active_path='" + active_path + '\'' +
                ", src_node_ref='" + src_node_ref + '\'' +
                ", dst_node_ref='" + dst_node_ref + '\'' +
                ", service_ref='" + service_ref + '\'' +
                ", accessif_ref='" + accessif_ref + '\'' +
                ", protection_type='" + protection_type + '\'' +
                ", working_path='" + working_path + '\'' +
                ", protection_path='" + protection_path + '\'' +
                ", service_mapping='" + service_mapping + '\'' +
                ", creation_date='" + creation_date + '\'' +
                '}';
    }
}
