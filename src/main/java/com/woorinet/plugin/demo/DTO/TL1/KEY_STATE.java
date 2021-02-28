package com.woorinet.plugin.demo.DTO.TL1;


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
@Table(name = "TL1_KEY_STATE")
public class KEY_STATE {
    @Id
    @GeneratedValue
    int KEY_STATE_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String TX_KEY_STATE;
    String TX_KEY_BANK_STAT;
    String RX_KEY_STATE;
    String RX_KEY_BANK_STATE;

    public KEY_STATE() {
    }

    public KEY_STATE(String TID, String SUBNETWORK, String AID, String TX_KEY_STATE, String TX_KEY_BANK_STAT, String RX_KEY_STATE, String RX_KEY_BANK_STATE) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.TX_KEY_STATE = TX_KEY_STATE;
        this.TX_KEY_BANK_STAT = TX_KEY_BANK_STAT;
        this.RX_KEY_STATE = RX_KEY_STATE;
        this.RX_KEY_BANK_STATE = RX_KEY_BANK_STATE;
    }

    public KEY_STATE(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.TX_KEY_STATE = fields[3];
        this.TX_KEY_BANK_STAT = fields[4];
        this.RX_KEY_STATE = fields[5];
        this.RX_KEY_BANK_STATE = fields[6];
    }

    @Override
    public String toString() {
        return "KEY_STATE{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", TX_KEY_STATE='" + TX_KEY_STATE + '\'' +
                ", TX_KEY_BANK_STAT='" + TX_KEY_BANK_STAT + '\'' +
                ", RX_KEY_STATE='" + RX_KEY_STATE + '\'' +
                ", RX_KEY_BANK_STATE='" + RX_KEY_BANK_STATE + '\'' +
                '}';
    }
}
