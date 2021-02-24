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
public class KEY_STATE {
    @Id
    @Generated
    String KEY_STATE_ID;
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
