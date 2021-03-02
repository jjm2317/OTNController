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
@Table(name = "tl1_ces_pw")
public class Tl1CesPw {
    @Id
    @GeneratedValue
    int CES_PW_ID;
    String TID;
    String SERVICE_NAME;
    String DESCRIPTION;
    String AID;
    String SERVICE_TYPE;
    String DS0;
    String UNIT_TYPE;
    String VLAN_ID;
    String DEST_PORT;
    String SRC_PORT;
    String CLK_MASTER;
    String ENABLE;
    String CLK_REC;
    String VSI_ID;
    String JBSIZE;
    String RXSIZE;
    String WINTX;
    String DUSIZE;
    String CREATION_DATE;
    String MODIFIED_DATE;
    String CES_BANDWIDTH;
    String TS_POS;
    String TS_LEN;

    public Tl1CesPw() {

    }

    public Tl1CesPw(String[] fields) {
        this.TID = fields[0];
        this.SERVICE_NAME = fields[1];
        this.DESCRIPTION = fields[2];
        this.AID = fields[3];
        this.SERVICE_TYPE = fields[4];
        this.DS0 = fields[5];
        this.UNIT_TYPE = fields[6];
        this.VLAN_ID = fields[7];
        this.DEST_PORT = fields[8];
        this.SRC_PORT = fields[9];
        this.CLK_MASTER = fields[10];
        this.ENABLE = fields[11];
        this.CLK_REC = fields[12];
        this.VSI_ID = fields[13];
        this.JBSIZE = fields[14];
        this.RXSIZE = fields[15];
        this.WINTX = fields[16];
        this.DUSIZE = fields[17];
        this.CREATION_DATE = fields[18];
        this.MODIFIED_DATE = fields[19];
        this.CES_BANDWIDTH = fields[20];
        this.TS_POS = fields[21];
        this.TS_LEN = fields[22];
    }

    @Override
    public String toString() {
        return "CES_PW{" +
                "TID='" + TID + '\'' +
                ", SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", AID='" + AID + '\'' +
                ", SERVICE_TYPE='" + SERVICE_TYPE + '\'' +
                ", DS0='" + DS0 + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", VLAN_ID='" + VLAN_ID + '\'' +
                ", DEST_PORT='" + DEST_PORT + '\'' +
                ", SRC_PORT='" + SRC_PORT + '\'' +
                ", CLK_MASTER='" + CLK_MASTER + '\'' +
                ", ENABLE='" + ENABLE + '\'' +
                ", CLK_REC='" + CLK_REC + '\'' +
                ", VSI_ID='" + VSI_ID + '\'' +
                ", JBSIZE='" + JBSIZE + '\'' +
                ", RXSIZE='" + RXSIZE + '\'' +
                ", WINTX='" + WINTX + '\'' +
                ", DUSIZE='" + DUSIZE + '\'' +
                ", CREATION_DATE='" + CREATION_DATE + '\'' +
                ", MODIFIED_DATE='" + MODIFIED_DATE + '\'' +
                ", CES_BANDWIDTH='" + CES_BANDWIDTH + '\'' +
                ", TS_POS='" + TS_POS + '\'' +
                ", TS_LEN='" + TS_LEN + '\'' +
                '}';
    }
}
