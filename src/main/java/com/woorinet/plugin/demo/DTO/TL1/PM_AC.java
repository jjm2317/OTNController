package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
public class PM_AC {

    String TID;
    String SERVICE_NAME;
    @Id
    @Generated
    int AC_ID;
    String TYPE;
    String DATE;
    String TIME;
    int ING_PKT;
    int ING_BYTE;
    int ING_RATE;
    int EGR_PKT;
    int EGR_BYTE;
    int EGR_RATE;

    public PM_AC() {
    }

    public PM_AC(String TID, String SERVICE_NAME, int AC_ID, String TYPE, String DATE, String TIME, int ING_PKT, int ING_BYTE, int ING_RATE, int EGR_PKT, int EGR_BYTE, int EGR_RATE) {
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

    @Override
    public String toString() {
        return "PM_AC{" +
                "TID='" + TID + '\'' +
                ", SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", AC_ID=" + AC_ID +
                ", TYPE='" + TYPE + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                ", ING_PKT=" + ING_PKT +
                ", ING_BYTE=" + ING_BYTE +
                ", ING_RATE=" + ING_RATE +
                ", EGR_PKT=" + EGR_PKT +
                ", EGR_BYTE=" + EGR_BYTE +
                ", EGR_RATE=" + EGR_RATE +
                '}';
    }
}
