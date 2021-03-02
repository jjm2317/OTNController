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
@Table(name = "tl1_service_tunnel")
public class Tl1ServiceTunnel {
    @Id
    @GeneratedValue
    int SERVICE_TUNNEL_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String PW_ID;
    String SERVICE_NAME;
    String OW_TID;
    String OW_TID_ID;
    String OW_TUNNEL_ID;
    String OW_TUNNEL_NAME;
    String OW_START_CONNID;
    String OW_CONN_ID;
    String OW_CONN_TYPE;
    String OW_INGID;
    String OW_EGRID;
    String OW_SERV_TYPE;
    String OW_SERV_RATE;
    String OW_IN_LABEL;
    String OW_OUT_LABEL;
    String OP_TID;
    String OP_TID_ID;
    String OW_TUNNEL_ID2;
    String OW_TUNNEL_NAME2;
    String OP_START_CONNID;
    String OP_CONN_ID;
    String OP_CONN_TYPE;
    String OP_INGID;
    String OP_EGRID;
    String OP_SERV_TYPE;
    String OP_SERV_RATE;
    String OP_IN_LABEL;
    String OP_OUT_LABEL;
    String HLPCF;
    String PCP;

    public Tl1ServiceTunnel() {

    }

    public Tl1ServiceTunnel(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.PW_ID = fields[4];
        this.SERVICE_NAME = fields[5];
        this.OW_TID = fields[6];
        this.OW_TID_ID = fields[7];
        this.OW_TUNNEL_ID = fields[8];
        this.OW_TUNNEL_NAME = fields[9];
        this.OW_START_CONNID = fields[10];
        this.OW_CONN_ID = fields[11];
        this.OW_CONN_TYPE = fields[12];
        this.OW_INGID = fields[13];
        this.OW_EGRID = fields[14];
        this.OW_SERV_TYPE = fields[15];
        this.OW_SERV_RATE = fields[16];
        this.OW_IN_LABEL = fields[17];
        this.OW_OUT_LABEL = fields[18];
        this.OP_TID = fields[19];
        this.OP_TID_ID = fields[20];
        this.OW_TUNNEL_ID2 = fields[21];
        this.OW_TUNNEL_NAME2 = fields[22];
        this.OP_START_CONNID = fields[23];
        this.OP_CONN_ID = fields[24];
        this.OP_CONN_TYPE = fields[25];
        this.OP_INGID = fields[26];
        this.OP_EGRID = fields[27];
        this.OP_SERV_TYPE = fields[28];
        this.OP_SERV_RATE = fields[29];
        this.OP_IN_LABEL = fields[30];
        this.OP_OUT_LABEL = fields[31];
        this.HLPCF = fields[32];
        this.PCP = fields[33];
    }

    @Override
    public String toString() {
        return "SERVICE_TUNNEL{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", PW_ID='" + PW_ID + '\'' +
                ", SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", OW_TID='" + OW_TID + '\'' +
                ", OW_TID_ID='" + OW_TID_ID + '\'' +
                ", OW_TUNNEL_ID='" + OW_TUNNEL_ID + '\'' +
                ", OW_TUNNEL_NAME='" + OW_TUNNEL_NAME + '\'' +
                ", OW_START_CONNID='" + OW_START_CONNID + '\'' +
                ", OW_CONN_ID='" + OW_CONN_ID + '\'' +
                ", OW_CONN_TYPE='" + OW_CONN_TYPE + '\'' +
                ", OW_INGID='" + OW_INGID + '\'' +
                ", OW_EGRID='" + OW_EGRID + '\'' +
                ", OW_SERV_TYPE='" + OW_SERV_TYPE + '\'' +
                ", OW_SERV_RATE='" + OW_SERV_RATE + '\'' +
                ", OW_IN_LABEL='" + OW_IN_LABEL + '\'' +
                ", OW_OUT_LABEL='" + OW_OUT_LABEL + '\'' +
                ", OP_TID='" + OP_TID + '\'' +
                ", OP_TID_ID='" + OP_TID_ID + '\'' +
                ", OW_TUNNEL_ID2='" + OW_TUNNEL_ID2 + '\'' +
                ", OW_TUNNEL_NAME2='" + OW_TUNNEL_NAME2 + '\'' +
                ", OP_START_CONNID='" + OP_START_CONNID + '\'' +
                ", OP_CONN_ID='" + OP_CONN_ID + '\'' +
                ", OP_CONN_TYPE='" + OP_CONN_TYPE + '\'' +
                ", OP_INGID='" + OP_INGID + '\'' +
                ", OP_EGRID='" + OP_EGRID + '\'' +
                ", OP_SERV_TYPE='" + OP_SERV_TYPE + '\'' +
                ", OP_SERV_RATE='" + OP_SERV_RATE + '\'' +
                ", OP_IN_LABEL='" + OP_IN_LABEL + '\'' +
                ", OP_OUT_LABEL='" + OP_OUT_LABEL + '\'' +
                ", HLPCF='" + HLPCF + '\'' +
                ", PCP='" + PCP + '\'' +
                '}';
    }
}
