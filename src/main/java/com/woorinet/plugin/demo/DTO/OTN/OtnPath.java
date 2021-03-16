package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@Table(name="sdn_path")
public class OtnPath {
    @GeneratedValue
    @Id
    int id;
    int ems_id;
    String service_id;
    String path_type;
    String connection_idx;
    String connection_type;
    String direction_type;
    String tp_type;
    String instance_type;
    String instance_ref;
    String ref_type;

    public OtnPath() {

    }

    public OtnPath(int ems_id, String service_id, String path_type, String connection_idx, String connection_type, String direction_type, String tp_type, String instance_type, String instance_ref, String ref_type) {
        this.ems_id = ems_id;
        this.service_id = service_id;
        this.path_type = path_type;
        this.connection_idx = connection_idx;
        this.connection_type = connection_type;
        this.direction_type = direction_type;
        this.tp_type = tp_type;
        this.instance_type = instance_type;
        this.instance_ref = instance_ref;
        this.ref_type = ref_type;
    }

    @Override
    public String toString() {
        return "PATH{" +
                "ems_id=" + ems_id +
                ", service_id='" + service_id + '\'' +
                ", path_type='" + path_type + '\'' +
                ", connection_idx='" + connection_idx + '\'' +
                ", connection_type='" + connection_type + '\'' +
                ", direction_type='" + direction_type + '\'' +
                ", tp_type='" + tp_type + '\'' +
                ", instance_type='" + instance_type + '\'' +
                ", instance_ref='" + instance_ref + '\'' +
                ", ref_type='" + ref_type + '\'' +
                '}';
    }
}
