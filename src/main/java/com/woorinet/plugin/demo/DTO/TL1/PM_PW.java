package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Setter
@Getter
@Table(name = "TL1_PM_PW")
public class PM_PW {
    @Id
    @GeneratedValue
    int PM_PW_ID;
    String TID;
    String SERVICE_NAME;
    String AC_ID;
    String TYPE;
    String DATE;
    String TIME;
    String ING_PKT;
    String ING_BYTE;
    String ING_RATE;
    String EGR_PKT;
    String EGR_BYTE;
    String EGR_RATE;

    public PM_PW() {
    }

    public PM_PW(String TID, String SERVICE_NAME, String AC_ID, String TYPE, String DATE, String TIME, String ING_PKT, String ING_BYTE, String ING_RATE, String EGR_PKT, String EGR_BYTE, String EGR_RATE) {
        this.TID = TID;
        this.SERVICE_NAME = SERVICE_NAME;
        this.AC_ID = AC_ID;
        this.TYPE = TYPE;
        this.DATE = DATE;
        this.TIME = TIME;
        this.ING_PKT = ING_PKT;
        this.ING_BYTE = ING_BYTE;
        this.ING_RATE = ING_RATE;
        this.EGR_PKT = EGR_PKT;
        this.EGR_BYTE = EGR_BYTE;
        this.EGR_RATE = EGR_RATE;
    }

    public PM_PW(String[] fields) {
        this.TID = fields[0];
        this.SERVICE_NAME = fields[1];
        this.AC_ID = fields[2];
        this.TYPE = fields[3];
        this.DATE = fields[4];
        this.TIME = fields[5];
        this.ING_PKT = fields[6];
        this.ING_BYTE = fields[7];
        this.ING_RATE = fields[8];
        this.EGR_PKT = fields[9];
        this.EGR_BYTE = fields[10];
        this.EGR_RATE = fields[11];
    }

    @Override
    public String toString() {
        return "PM_PW{" +
                "TID='" + TID + '\'' +
                ", SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", AC_ID='" + AC_ID + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                ", ING_PKT='" + ING_PKT + '\'' +
                ", ING_BYTE='" + ING_BYTE + '\'' +
                ", ING_RATE='" + ING_RATE + '\'' +
                ", EGR_PKT='" + EGR_PKT + '\'' +
                ", EGR_BYTE='" + EGR_BYTE + '\'' +
                ", EGR_RATE='" + EGR_RATE + '\'' +
                '}';
    }
}
