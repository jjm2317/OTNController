package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sdn_service")
@Data
public class OtnService {
    int ems_id;
    @Id
    @Generated
    String service_id;
    String src_ne_id;
    String src_ne_name;
    String src_connector_id;
    String src_accessif_type;
    String dst_ne_id;
    String dst_ne_name;
    String dst_connector_id;
    String dst_accessif_type;
    String service_type;
    String service_name;
    String network_type;
    String service_status;
    String rate_type;
    String service_rate;
    String latency;
    String wavelength;
    String active_path;
    String creation_date;

    public OtnService() {
    }

    public OtnService(int ems_id, String service_id, String src_ne_id, String src_ne_name, String src_connector_id, String src_accessif_type, String dst_ne_id, String dst_ne_name, String dst_connector_id, String dst_accessif_type, String service_type, String service_name, String network_type, String service_status, String rate_type, String service_rate, String latency, String wavelength, String active_path, String creation_date) {
        this.ems_id = ems_id;
        this.service_id = service_id;
        this.src_ne_id = src_ne_id;
        this.src_ne_name = src_ne_name;
        this.src_connector_id = src_connector_id;
        this.src_accessif_type = src_accessif_type;
        this.dst_ne_id = dst_ne_id;
        this.dst_ne_name = dst_ne_name;
        this.dst_connector_id = dst_connector_id;
        this.dst_accessif_type = dst_accessif_type;
        this.service_type = service_type;
        this.service_name = service_name;
        this.network_type = network_type;
        this.service_status = service_status;
        this.rate_type = rate_type;
        this.service_rate = service_rate;
        this.latency = latency;
        this.wavelength = wavelength;
        this.active_path = active_path;
        this.creation_date = creation_date;
    }

    @Override
    public String toString() {
        return "SERVICE{" +
                "ems_id=" + ems_id +
                ", service_id='" + service_id + '\'' +
                ", src_ne_id='" + src_ne_id + '\'' +
                ", src_ne_name='" + src_ne_name + '\'' +
                ", src_connector_id='" + src_connector_id + '\'' +
                ", src_accessif_type='" + src_accessif_type + '\'' +
                ", dst_ne_id='" + dst_ne_id + '\'' +
                ", dst_ne_name='" + dst_ne_name + '\'' +
                ", dst_connector_id='" + dst_connector_id + '\'' +
                ", dst_accessif_type='" + dst_accessif_type + '\'' +
                ", service_type='" + service_type + '\'' +
                ", service_name='" + service_name + '\'' +
                ", network_type='" + network_type + '\'' +
                ", service_status='" + service_status + '\'' +
                ", rate_type='" + rate_type + '\'' +
                ", service_rate='" + service_rate + '\'' +
                ", latency='" + latency + '\'' +
                ", wavelength='" + wavelength + '\'' +
                ", active_path='" + active_path + '\'' +
                ", creation_date='" + creation_date + '\'' +
                '}';
    }
}
