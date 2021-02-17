package com.woorinet.plugin.demo.DTO.SDN;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class ACCESS_IF {
    int ems_id;
    @Id
    @Generated
    String accessif_id;
    String accessif_name;
    String ne_id;
    String connector_id;
    String accessif_type;
    String accessif_status;
    String service_ref;
    String node_connector_ref;

    public ACCESS_IF() {

    }

    public ACCESS_IF(int ems_id, String accessif_id, String accessif_name, String ne_id, String connector_id, String accessif_type, String accessif_status, String service_ref, String node_connector_ref) {
        this.ems_id = ems_id;
        this.accessif_id = accessif_id;
        this.accessif_name = accessif_name;
        this.ne_id = ne_id;
        this.connector_id = connector_id;
        this.accessif_type = accessif_type;
        this.accessif_status = accessif_status;
        this.service_ref = service_ref;
        this.node_connector_ref = node_connector_ref;
    }

    @Override
    public String toString() {
        return "ACCESS_IF{" +
                "ems_id=" + ems_id +
                ", accessif_id='" + accessif_id + '\'' +
                ", accessif_name='" + accessif_name + '\'' +
                ", ne_id='" + ne_id + '\'' +
                ", connector_id='" + connector_id + '\'' +
                ", accessif_type='" + accessif_type + '\'' +
                ", accessif_status='" + accessif_status + '\'' +
                ", service_ref='" + service_ref + '\'' +
                ", node_connector_ref='" + node_connector_ref + '\'' +
                '}';
    }
}
