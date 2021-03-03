package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
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
@Table(name = "tl1_pm_tunnel")
public class Tl1PmTunnel {
    @Id
    @GeneratedValue
    int PM_TUNNEL_ID;
    String TID;
    String TUNNEL_NAME;
    String TUNNEL_ID;
    String LSP_ID;
    String ING_LSRID;
    String EGR_LSRID;
    String TYPE;
    String DATE;
    String TIME;
    String ING_PKT;
    String ING_BYTE;
    String ING_RATE;
    String EGR_PKT;
    String EGR_BYTE;
    String EGR_RATE;
    String LM_COUNTER;

    public Tl1PmTunnel() {
    }

    public Tl1PmTunnel(String TID, String TUNNEL_NAME, String TUNNEL_ID, String LSP_ID, String ING_LSRID, String EGR_LSRID, String TYPE, String DATE, String TIME, String ING_PKT, String ING_BYTE, String ING_RATE, String EGR_PKT, String EGR_BYTE, String EGR_RATE, String LM_COUNTER) {
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

    public Tl1PmTunnel(String[] fields) {
        this.TID = fields[0];
        this.TUNNEL_NAME = fields[1];
        this.TUNNEL_ID = fields[2];
        this.LSP_ID = fields[3];
        this.ING_LSRID = fields[4];
        this.EGR_LSRID = fields[5];
        this.TYPE = fields[6];
        this.DATE = fields[7];
        this.TIME = fields[8];
        this.ING_PKT = fields[9];
        this.ING_BYTE = fields[10];
        this.ING_RATE = fields[11];
        this.EGR_PKT = fields[12];
        this.EGR_BYTE = fields[13];
        this.EGR_RATE = fields[14];
        this.LM_COUNTER = fields[15];
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
