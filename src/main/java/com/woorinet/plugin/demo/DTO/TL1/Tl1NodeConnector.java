package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name = "tl1_node_connector")
public class Tl1NodeConnector {
    @Id
    @GeneratedValue
    int NODE_CONNECTOR_ID;
    String TID_ID;
    String TID;
    String AID;
    String SUBNET_ID;
    String SUBNET;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String NUMBER;
    String PORT_TYPE;
    String PORT_ROLE;
    String PORT_STATUS;
    String SHELF_TYPE;
    String SHELF_INDEX;
    String SLOT_TYPE;
    String SLOT_INDEX;
    String SUB_SLOT_TYPE;
    String SUB_SLOT_INDEX;
    String PORT_TYPE2;
    String PORT_INDEX;
    String MAC_ADDR;
    String SLOT_SERVICE;

    public Tl1NodeConnector() {

    }

    public Tl1NodeConnector(String TID_ID, String TID, String AID, String SUBNET_ID, String SUBNET, String LOCAL_ID, String REQUEST_ID, String NAME, String NUMBER, String PORT_TYPE, String PORT_ROLE, String PORT_STATUS, String SHELF_TYPE, String SHELF_INDEX, String SLOT_TYPE, String SLOT_INDEX, String SUB_SLOT_TYPE, String SUB_SLOT_INDEX, String PORT_TYPE2, String PORT_INDEX, String MAC_ADDR, String SLOT_SERVICE) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.AID = AID;
        this.SUBNET_ID = SUBNET_ID;
        this.SUBNET = SUBNET;
        this.LOCAL_ID = LOCAL_ID;
        this.REQUEST_ID = REQUEST_ID;
        this.NAME = NAME;
        this.NUMBER = NUMBER;
        this.PORT_TYPE = PORT_TYPE;
        this.PORT_ROLE = PORT_ROLE;
        this.PORT_STATUS = PORT_STATUS;
        this.SHELF_TYPE = SHELF_TYPE;
        this.SHELF_INDEX = SHELF_INDEX;
        this.SLOT_TYPE = SLOT_TYPE;
        this.SLOT_INDEX = SLOT_INDEX;
        this.SUB_SLOT_TYPE = SUB_SLOT_TYPE;
        this.SUB_SLOT_INDEX = SUB_SLOT_INDEX;
        this.PORT_TYPE2 = PORT_TYPE2;
        this.PORT_INDEX = PORT_INDEX;
        this.MAC_ADDR = MAC_ADDR;
        this.SLOT_SERVICE = SLOT_SERVICE;
    }

    public Tl1NodeConnector(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.AID = fields[2];
        this.SUBNET_ID = fields[3];
        this.SUBNET = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.NUMBER = fields[8];
        this.PORT_TYPE = fields[9];
        this.PORT_ROLE = fields[10];
        this.PORT_STATUS = fields[11];
        this.SHELF_TYPE = fields[12];
        this.SHELF_INDEX = fields[13];
        this.SLOT_TYPE = fields[14];
        this.SLOT_INDEX = fields[15];
        this.SUB_SLOT_TYPE = fields[16];
        this.SUB_SLOT_INDEX = fields[17];
        this.PORT_TYPE2 = fields[18];
        this.PORT_INDEX = fields[19];
        this.MAC_ADDR = fields[20];
        this.SLOT_SERVICE = fields[21];
    }

    @Override
    public String toString() {
        return "NodeConnector{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", NUMBER='" + NUMBER + '\'' +
                ", PORT_TYPE='" + PORT_TYPE + '\'' +
                ", PORT_ROLE='" + PORT_ROLE + '\'' +
                ", PORT_STATUS='" + PORT_STATUS + '\'' +
                ", SHELF_TYPE='" + SHELF_TYPE + '\'' +
                ", SHELF_INDEX='" + SHELF_INDEX + '\'' +
                ", SLOT_TYPE='" + SLOT_TYPE + '\'' +
                ", SLOT_INDEX='" + SLOT_INDEX + '\'' +
                ", SUB_SLOT_TYPE='" + SUB_SLOT_TYPE + '\'' +
                ", SUB_SLOT_INDEX='" + SUB_SLOT_INDEX + '\'' +
                ", PORT_TYPE2='" + PORT_TYPE2 + '\'' +
                ", PORT_INDEX='" + PORT_INDEX + '\'' +
                ", MAC_ADDR='" + MAC_ADDR + '\'' +
                ", SLOT_SERVICE='" + SLOT_SERVICE + '\'' +
                '}';
    }
}
