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
public class BYPASS_INFO {
    @Id
    @GeneratedValue
    int BYPASS_INFO_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String MODE;
    String ACTION;
    String CURRENT_ACTION;
    String PEER_MODE;
    String PEER_ACTION;
    String PEER_CURRENT_ACTION;

    public BYPASS_INFO() {
    }

    public BYPASS_INFO(String TID, String SUBNETWORK, String AID, String MODE, String ACTION, String CURRENT_ACTION, String PEER_MODE, String PEER_ACTION, String PEER_CURRENT_ACTION) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.MODE = MODE;
        this.ACTION = ACTION;
        this.CURRENT_ACTION = CURRENT_ACTION;
        this.PEER_MODE = PEER_MODE;
        this.PEER_ACTION = PEER_ACTION;
        this.PEER_CURRENT_ACTION = PEER_CURRENT_ACTION;
    }

    public BYPASS_INFO(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.MODE = fields[3];
        this.ACTION = fields[4];
        this.CURRENT_ACTION = fields[5];
        this.PEER_MODE = fields[6];
        this.PEER_ACTION = fields[7];
        this.PEER_CURRENT_ACTION = fields[8];
    }

    @Override
    public String toString() {
        return "BYPASS_INFO{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", MODE='" + MODE + '\'' +
                ", ACTION='" + ACTION + '\'' +
                ", CURRENT_ACTION='" + CURRENT_ACTION + '\'' +
                ", PEER_MODE='" + PEER_MODE + '\'' +
                ", PEER_ACTION='" + PEER_ACTION + '\'' +
                ", PEER_CURRENT_ACTION='" + PEER_CURRENT_ACTION + '\'' +
                '}';
    }
}