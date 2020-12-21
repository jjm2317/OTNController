package com.woorinet.plugin.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SERVICE {
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String PW_ID;
    String NAME;
    String DESC;
    String VSI_ID;
    String LOCAL_ID;
    String S_TYPE;
    String N_TYPE;
    String SERVICE_PATH_STATUS;
    String OPER_STATUS;
    String CONF_ACTION;
    String CONF_RESULT;
    String DEP_ENABLER;
    String TU_ID;
    String TU_NAME;
    String ING_LSR;
    String EGR_LSR;
    String PEER_LSRID;
    String SRC_TID;
    String SRC_TID_ID;
    String DST_TID;
    String DST_TID_ID;
    String PEER_TID;
    String PEER_TID_ID;

    public SERVICE(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.PW_ID = fields[4];
        this.NAME = fields[5];
        this.DESC = fields[6];
        this.VSI_ID = fields[7];
        this.LOCAL_ID = fields[8];
        this.S_TYPE = fields[9];
        this.N_TYPE = fields[10];
        this.SERVICE_PATH_STATUS = fields[11];
        this.OPER_STATUS = fields[12];
        this.CONF_ACTION = fields[13];
        this.CONF_RESULT = fields[14];
        this.DEP_ENABLER = fields[15];
        this.TU_ID = fields[16];
        this.TU_NAME = fields[17];
        this.ING_LSR = fields[18];
        this.EGR_LSR = fields[19];
        this.PEER_LSRID = fields[20];
        this.SRC_TID = fields[21];
        this.SRC_TID_ID = fields[22];
        this.DST_TID = fields[23];
        this.DST_TID_ID = fields[24];
        this.PEER_TID = fields[25];
        this.PEER_TID_ID = fields[26];
    }

    @Override
    public String toString() {
        return "SERVICE{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", PW_ID='" + PW_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESC='" + DESC + '\'' +
                ", VSI_ID='" + VSI_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", S_TYPE='" + S_TYPE + '\'' +
                ", N_TYPE='" + N_TYPE + '\'' +
                ", SERVICE_PATH_STATUS='" + SERVICE_PATH_STATUS + '\'' +
                ", OPER_STATUS='" + OPER_STATUS + '\'' +
                ", CONF_ACTION='" + CONF_ACTION + '\'' +
                ", CONF_RESULT='" + CONF_RESULT + '\'' +
                ", DEP_ENABLER='" + DEP_ENABLER + '\'' +
                ", TU_ID='" + TU_ID + '\'' +
                ", TU_NAME='" + TU_NAME + '\'' +
                ", ING_LSR='" + ING_LSR + '\'' +
                ", EGR_LSR='" + EGR_LSR + '\'' +
                ", PEER_LSRID='" + PEER_LSRID + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", PEER_TID='" + PEER_TID + '\'' +
                ", PEER_TID_ID='" + PEER_TID_ID + '\'' +
                '}';
    }
}
