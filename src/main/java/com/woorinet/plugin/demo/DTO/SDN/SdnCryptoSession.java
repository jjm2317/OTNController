package com.woorinet.plugin.demo.DTO.SDN;


import lombok.Data;
import lombok.Generated;
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
@Table(name="sdn_crypto_session")
public class SdnCryptoSession {
    @Id
    @GeneratedValue
    int CRYPTO_SESSION_ID;
    String AID;
    String LOCAL_IP;
    String REMOTE_IP;
    String KSP_MODE;
    String DEAD_TIME;
    String RETRY_REQUEST_INTERVAL;
    String DST_LID;
    String KEY_SOURCE_MODE;
    String KEY_FAILOVER_MODE;
    String KEY_LIFE_TIME;
    String TX_KEY_STATE;
    String TX_KEY_BANK_STATE;
    String RX_KEY_STATE;
    String RX_KEY_BANK_STATE;

    public SdnCryptoSession() {

    }

    public SdnCryptoSession(String AID,String LOCAL_IP, String REMOTE_IP, String KSP_MODE, String DEAD_TIME, String RETRY_REQUEST_INTERVAL, String DST_LID, String KEY_SOURCE_MODE, String KEY_FAILOVER_MODE, String KEY_LIFE_TIME, String TX_KEY_STATE, String TX_KEY_BANK_STATE, String RX_KEY_STATE, String RX_KEY_BANK_STATE) {
        this.AID = AID;
        this.LOCAL_IP = LOCAL_IP;
        this.REMOTE_IP = REMOTE_IP;
        this.KSP_MODE = KSP_MODE;
        this.DEAD_TIME = DEAD_TIME;
        this.RETRY_REQUEST_INTERVAL = RETRY_REQUEST_INTERVAL;
        this.DST_LID = DST_LID;
        this.KEY_SOURCE_MODE = KEY_SOURCE_MODE;
        this.KEY_FAILOVER_MODE = KEY_FAILOVER_MODE;
        this.KEY_LIFE_TIME = KEY_LIFE_TIME;
        this.TX_KEY_STATE = TX_KEY_STATE;
        this.TX_KEY_BANK_STATE = TX_KEY_BANK_STATE;
        this.RX_KEY_STATE = RX_KEY_STATE;
        this.RX_KEY_BANK_STATE = RX_KEY_BANK_STATE;
    }

    @Override
    public String toString() {
        return "SdnCryptoSession{" +
                "AID='" + AID + '\'' +
                ", LOCAL_IP='" + LOCAL_IP + '\'' +
                ", REMOTE_IP='" + REMOTE_IP + '\'' +
                ", KSP_MODE='" + KSP_MODE + '\'' +
                ", DEAD_TIME='" + DEAD_TIME + '\'' +
                ", RETRY_REQUEST_INTERVAL='" + RETRY_REQUEST_INTERVAL + '\'' +
                ", DST_LID='" + DST_LID + '\'' +
                ", KEY_SOURCE_MODE='" + KEY_SOURCE_MODE + '\'' +
                ", KEY_FAILOVER_MODE='" + KEY_FAILOVER_MODE + '\'' +
                ", KEY_LIFE_TIME='" + KEY_LIFE_TIME + '\'' +
                ", TX_KEY_STATE='" + TX_KEY_STATE + '\'' +
                ", TX_KEY_BANK_STATE='" + TX_KEY_BANK_STATE + '\'' +
                ", RX_KEY_STATE='" + RX_KEY_STATE + '\'' +
                ", RX_KEY_BANK_STATE='" + RX_KEY_BANK_STATE + '\'' +
                '}';
    }
}
