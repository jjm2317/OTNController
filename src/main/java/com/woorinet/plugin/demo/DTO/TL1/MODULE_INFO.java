package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Setter
@Getter
@Table(name = "TL1_MODULE_INFO")
public class MODULE_INFO {
    @Id
    @GeneratedValue
    int MODULE_INFO_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String MID;
    String MID_CONTEXT;
    String PMID;
    String PMID_CONTEXT;
    String OPERATION_STATE;
    String OPERATION_STATE_REASON;
    String CRYPTO_MODE;

    public MODULE_INFO() {
    }

    public MODULE_INFO(String TID, String SUBNETWORK, String AID, String MID, String MID_CONTEXT, String PMID, String PMID_CONTEXT, String OPERATION_STATE, String OPERATION_STATE_REASON, String CRYPTO_MODE) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.MID = MID;
        this.MID_CONTEXT = MID_CONTEXT;
        this.PMID = PMID;
        this.PMID_CONTEXT = PMID_CONTEXT;
        this.OPERATION_STATE = OPERATION_STATE;
        this.OPERATION_STATE_REASON = OPERATION_STATE_REASON;
        this.CRYPTO_MODE = CRYPTO_MODE;
    }

    public MODULE_INFO(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.MID = fields[3];
        this.MID_CONTEXT = fields[4];
        this.PMID = fields[5];
        this.PMID_CONTEXT = fields[6];
        this.OPERATION_STATE = fields[7];
        this.OPERATION_STATE_REASON = fields[8];
        this.CRYPTO_MODE = fields[9];
    }

    @Override
    public String toString() {
        return "MODULE_INFO{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", MID='" + MID + '\'' +
                ", MID_CONTEXT='" + MID_CONTEXT + '\'' +
                ", PMID='" + PMID + '\'' +
                ", PMID_CONTEXT='" + PMID_CONTEXT + '\'' +
                ", OPERATION_STATE='" + OPERATION_STATE + '\'' +
                ", OPERATION_STATE_REASON='" + OPERATION_STATE_REASON + '\'' +
                ", CRYPTO_MODE='" + CRYPTO_MODE + '\'' +
                '}';
    }
}
