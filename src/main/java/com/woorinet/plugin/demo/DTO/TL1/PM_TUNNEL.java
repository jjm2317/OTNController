package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
public class PM_TUNNEL {

    String TID;
    @Id
    @Generated
    String TUNNEL_NAME;
    String TUNNEL_ID;
    String LSP_ID;
    String ING_LSRID;
    String EGR_LSRID;
    String TYPE;
    String DATE;
    String TIME;
    int ING_PKT;
    int ING_BYTE;
    int ING_RATE;
    int EGR_PKT;
    int EGR_BYTE;
    int EGR_RATE;
    String LM_COUNTER;

    public PM_TUNNEL() {
    }

    public PM_TUNNEL(String TID, String TUNNEL_NAME, String TUNNEL_ID, String LSP_ID, String ING_LSRID, String EGR_LSRID, String TYPE, String DATE, String TIME, int ING_PKT, int ING_BYTE, int ING_RATE, int EGR_PKT, int EGR_BYTE, int EGR_RATE, String LM_COUNTER) {
        this.TID = TID;
        this.TUNNEL_NAME = TUNNEL_NAME;
        this.TUNNEL_ID = TUNNEL_ID;
        this.LSP_ID = LSP_ID;
        this.ING_LSRID = ING_LSRID;
        this.EGR_LSRID = EGR_LSRID;
        this.TYPE = TYPE;
        this.DATE = DATE;
        this.TIME = TIME;
        this.ING_PKT = ING_PKT;
        this.ING_BYTE = ING_BYTE;
        this.ING_RATE = ING_RATE;
        this.EGR_PKT = EGR_PKT;
        this.EGR_BYTE = EGR_BYTE;
        this.EGR_RATE = EGR_RATE;
        this.LM_COUNTER = LM_COUNTER;
    }

    @Override
    public String toString() {
        return "PM_TUNNEL{" +
                "TID='" + TID + '\'' +
                ", TUNNEL_NAME='" + TUNNEL_NAME + '\'' +
                ", TUNNEL_ID='" + TUNNEL_ID + '\'' +
                ", LSP_ID='" + LSP_ID + '\'' +
                ", ING_LSRID='" + ING_LSRID + '\'' +
                ", EGR_LSRID='" + EGR_LSRID + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                ", ING_PKT=" + ING_PKT +
                ", ING_BYTE=" + ING_BYTE +
                ", ING_RATE=" + ING_RATE +
                ", EGR_PKT=" + EGR_PKT +
                ", EGR_BYTE=" + EGR_BYTE +
                ", EGR_RATE=" + EGR_RATE +
                ", LM_COUNTER='" + LM_COUNTER + '\'' +
                '}';
    }
}
