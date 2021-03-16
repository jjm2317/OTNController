package com.woorinet.plugin.demo.DTO.PORTAL;


import com.google.gson.Gson;
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
@Table(name="portal_otn_material")
public class PortalOtnMaterial {
    @Id
    @GeneratedValue
    int HOLA_SDN_OTN_MATERIAL_ID;
    String VENDOR;
    String CELL;
    String NODE;
    String IP;
    String SHELF;
    String UNIT_LIST;

    public PortalOtnMaterial() {
    }

    public PortalOtnMaterial(String VENDOR, String CELL, String NODE, String IP, String SHELF, String UNIT_LIST) {
        this.VENDOR = VENDOR;
        this.CELL = CELL;
        this.NODE = NODE;
        this.IP = IP;
        this.SHELF = SHELF;
        this.UNIT_LIST = UNIT_LIST;
    }

    @Override
    public String toString() {
        return "HolaOtnMaterial{" +
                "HOLA_SDN_OTN_MATERIAL_ID=" + HOLA_SDN_OTN_MATERIAL_ID +
                ", VENDOR='" + VENDOR + '\'' +
                ", CELL='" + CELL + '\'' +
                ", NODE='" + NODE + '\'' +
                ", IP='" + IP + '\'' +
                ", SHELF='" + SHELF + '\'' +
                ", UNIT_LIST='" + UNIT_LIST + '\'' +
                '}';
    }

    public String getUnit( String[] fields) {
       Unit unit = new Unit(fields);
       return (new Gson()).toJson(unit);
    }

    class Unit {
        String UNIT_TYPE;
        String UNIT_COUNT;
        String ALL_PORT_COUNT;
        String USAGE_PORT_COUNT;
        String USAGE_RATIO;

        public Unit() {
        }

        public Unit(String[] fields) {
            this.UNIT_TYPE = fields[0];
            this.UNIT_COUNT = fields[1];
            this.ALL_PORT_COUNT = fields[2];
            this.USAGE_PORT_COUNT = fields[3];
            this.USAGE_RATIO = fields[4];
        }


    }
}
