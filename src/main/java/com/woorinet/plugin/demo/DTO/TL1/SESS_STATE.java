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
@Table(name = "TL1_SESS_STATE")
public class SESS_STATE {
    @Id
    @GeneratedValue
    int SESS_STATE_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String LOCAL_IP;
    String REMOTE_IP;
    String KSP_MODE;
    String DEAD_TIME;
    String KEY_LIFE_TIME;
    String KEY_SRC_MODE;
    String KEY_FAILOVER;
    String RETRY_REQ_INTERVAL;
    String SESSION_STATE;
    String DST_LID;
    String CURRENT_TX_KEY_SRC_MODE;
    String CURRENT_RX_KEY_SRC_MODE;


    public SESS_STATE(String TID, String SUBNETWORK, String AID, String LOCAL_IP, String REMOTE_IP, String KSP_MODE, String DEAD_TIME, String KEY_LIFE_TIME, String KEY_SRC_MODE, String KEY_FAILOVER, String RETRY_REQ_INTERVAL, String SESSION_STATE, String DST_LID, String CURRENT_TX_KEY_SRC_MODE, String CURRENT_RX_KEY_SRC_MODE) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.LOCAL_IP = LOCAL_IP;
        this.REMOTE_IP = REMOTE_IP;
        this.KSP_MODE = KSP_MODE;
        this.DEAD_TIME = DEAD_TIME;
        this.KEY_LIFE_TIME = KEY_LIFE_TIME;
        this.KEY_SRC_MODE = KEY_SRC_MODE;
        this.KEY_FAILOVER = KEY_FAILOVER;
        this.RETRY_REQ_INTERVAL = RETRY_REQ_INTERVAL;
        this.SESSION_STATE = SESSION_STATE;
        this.DST_LID = DST_LID;
        this.CURRENT_TX_KEY_SRC_MODE = CURRENT_TX_KEY_SRC_MODE;
        this.CURRENT_RX_KEY_SRC_MODE = CURRENT_RX_KEY_SRC_MODE;
    }

    public SESS_STATE(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.LOCAL_IP = fields[3];
        this.REMOTE_IP = fields[4];
        this.KSP_MODE = fields[5];
        this.DEAD_TIME = fields[6];
        this.KEY_LIFE_TIME = fields[7];
        this.KEY_SRC_MODE = fields[8];
        this.KEY_FAILOVER = fields[9];
        this.RETRY_REQ_INTERVAL = fields[10];
        this.SESSION_STATE = fields[11];
        this.DST_LID = fields[12];
        this.CURRENT_TX_KEY_SRC_MODE = fields[13];
        this.CURRENT_RX_KEY_SRC_MODE = fields[14];
    }
    public SESS_STATE() {
    }
}
