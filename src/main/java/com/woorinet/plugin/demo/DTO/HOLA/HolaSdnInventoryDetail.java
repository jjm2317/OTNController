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
@Table(name="hola_sdn_inventory_detail")
public class HolaSdnInventoryDetail {
    @Id
    @GeneratedValue
    int HOLA_SDN_INVENTORY_DETAIL;
    String VENDOR;
    String CELL;
    String TID;
    String SHELF_ID;
    String IP;
    String NE_TYPE;
    String UNIT_TYPE;
    String UNIT_PEC;
    String SERIAL_NUMBER;
    String SLOT_ID;
    String PORT_ID;
    String CONNECT_STATUS;
    String LLCF;
    String MODULE_NAME;
    String MODULE_PEC;
    String DISTANCE;
    String MODULE_DESCRIPTION;
    String CABLE_NAME;
    String REMARKS_LIST;

    public HolaSdnInventoryDetail() {
    }

    public HolaSdnInventoryDetail(String VENDOR, String CELL, String TID, String SHELF_ID, String IP, String NE_TYPE, String UNIT_TYPE, String UNIT_PEC, String SERIAL_NUMBER, String SLOT_ID, String PORT_ID, String CONNECT_STATUS, String LLCF, String MODULE_NAME, String MODULE_PEC, String DISTANCE, String MODULE_DESCRIPTION, String CABLE_NAME, String REMARKS_LIST) {
        this.VENDOR = VENDOR;
        this.CELL = CELL;
        this.TID = TID;
        this.SHELF_ID = SHELF_ID;
        this.IP = IP;
        this.NE_TYPE = NE_TYPE;
        this.UNIT_TYPE = UNIT_TYPE;
        this.UNIT_PEC = UNIT_PEC;
        this.SERIAL_NUMBER = SERIAL_NUMBER;
        this.SLOT_ID = SLOT_ID;
        this.PORT_ID = PORT_ID;
        this.CONNECT_STATUS = CONNECT_STATUS;
        this.LLCF = LLCF;
        this.MODULE_NAME = MODULE_NAME;
        this.MODULE_PEC = MODULE_PEC;
        this.DISTANCE = DISTANCE;
        this.MODULE_DESCRIPTION = MODULE_DESCRIPTION;
        this.CABLE_NAME = CABLE_NAME;
        this.REMARKS_LIST = REMARKS_LIST;
    }

    @Override
    public String toString() {
        return "HolaSdnInventoryDetail{" +
                "HOLA_SDN_INVENTORY_DETAIL=" + HOLA_SDN_INVENTORY_DETAIL +
                ", VENDOR='" + VENDOR + '\'' +
                ", CELL='" + CELL + '\'' +
                ", TID='" + TID + '\'' +
                ", SHELF_ID='" + SHELF_ID + '\'' +
                ", IP='" + IP + '\'' +
                ", NE_TYPE='" + NE_TYPE + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", UNIT_PEC='" + UNIT_PEC + '\'' +
                ", SERIAL_NUMBER='" + SERIAL_NUMBER + '\'' +
                ", SLOT_ID='" + SLOT_ID + '\'' +
                ", PORT_ID='" + PORT_ID + '\'' +
                ", CONNECT_STATUS='" + CONNECT_STATUS + '\'' +
                ", LLCF='" + LLCF + '\'' +
                ", MODULE_NAME='" + MODULE_NAME + '\'' +
                ", MODULE_PEC='" + MODULE_PEC + '\'' +
                ", DISTANCE='" + DISTANCE + '\'' +
                ", MODULE_DESCRIPTION='" + MODULE_DESCRIPTION + '\'' +
                ", CABLE_NAME='" + CABLE_NAME + '\'' +
                ", REMARKS_LIST='" + REMARKS_LIST + '\'' +
                '}';
    }
}
