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

public class PM {
    /* TID,AID,UNIT-TYPE,SIGNAL,INTERVAL,PM-TYPE,BIP,ES,SES,UAS,BEI */
    @Id
    @Generated
    String PM_ID;
    String TID;
    String AID;
    String UNIT_TYPE;
    String SIGNAL;
    String INTERVAL;
    String PM_TYPE;
    String BIP;
    String ES;
    String SES;
    String UAS;
    String BEI;


    public PM() {
    }

    public PM(String TID, String AID, String UNIT_TYPE, String SIGNAL, String INTERVAL, String PM_TYPE, String BIP, String ES, String SES, String UAS, String BEI) {
        this.TID = TID;
        this.AID = AID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.SIGNAL = SIGNAL;
        this.INTERVAL = INTERVAL;
        this.PM_TYPE = PM_TYPE;
        this.BIP = BIP;
        this.ES = ES;
        this.SES = SES;
        this.UAS = UAS;
        this.BEI = BEI;
    }

    public PM(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.UNIT_TYPE = fields[2];
        this.SIGNAL = fields[3];
        this.INTERVAL = fields[4];
        this.PM_TYPE = fields[5];
        this.BIP = fields[6];
        this.ES = fields[7];
        this.SES = fields[8];
        this.UAS = fields[9];
        this.BEI = fields[10];
    }

    @Override
    public String toString() {
        return "PM{" +
                "PM_ID='" + PM_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", SIGNAL='" + SIGNAL + '\'' +
                ", INTERVAL='" + INTERVAL + '\'' +
                ", PM_TYPE='" + PM_TYPE + '\'' +
                ", BIP='" + BIP + '\'' +
                ", ES='" + ES + '\'' +
                ", SES='" + SES + '\'' +
                ", UAS='" + UAS + '\'' +
                ", BEI='" + BEI + '\'' +
                '}';
    }
}
