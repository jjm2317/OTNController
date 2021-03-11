package com.woorinet.plugin.demo.DTO.HOLA;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name="hola_sdn_otn_material")
public class HolaSdnOtnMaterial {
    @Id
    @GeneratedValue
    int HOLA_SDN_OTN_MATERIAL;
    String VENDOR;
    String CELL;
    String NODE;
    String IP;
    String SHELF;
    String UNIT_LIST;

    public HolaSdnOtnMaterial() {
    }

    public HolaSdnOtnMaterial(String VENDOR, String CELL, String NODE, String IP, String SHELF, String UNIT_LIST) {
        this.VENDOR = VENDOR;
        this.CELL = CELL;
        this.NODE = NODE;
        this.IP = IP;
        this.SHELF = SHELF;
        this.UNIT_LIST = UNIT_LIST;
    }

    @Override
    public String toString() {
        return "HolaSdnOtnMaterial{" +
                "HOLA_SDN_OTN_MATERIAL=" + HOLA_SDN_OTN_MATERIAL +
                ", VENDOR='" + VENDOR + '\'' +
                ", CELL='" + CELL + '\'' +
                ", NODE='" + NODE + '\'' +
                ", IP='" + IP + '\'' +
                ", SHELF='" + SHELF + '\'' +
                ", UNIT_LIST='" + UNIT_LIST + '\'' +
                '}';
    }
}
