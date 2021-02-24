package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Data
@Entity
public class CM_PORT {
    @Id
    @Generated
    String CM_PORT_ID;
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
