package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Data
@Entity
public class CM_PORT {
    @Id
    @GeneratedValue
    int CM_PORT_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String UNIT_TYPE;
    String SIGNAL;
    String VLAN_ID;

    public CM_PORT() {
    }

    public CM_PORT(String TID, String SUBNETWORK, String AID, String UNIT_TYPE, String SIGNAL, String VLAN_ID) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.SIGNAL = SIGNAL;
        this.VLAN_ID = VLAN_ID;
    }

    public CM_PORT(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.UNIT_TYPE = fields[3];
        this.SIGNAL = fields[4];
        this.VLAN_ID = fields[5];
    }

    @Override
    public String toString() {
        return "CM_PORT{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", SIGNAL='" + SIGNAL + '\'' +
                ", VLAN_ID='" + VLAN_ID + '\'' +
                '}';
    }
}
