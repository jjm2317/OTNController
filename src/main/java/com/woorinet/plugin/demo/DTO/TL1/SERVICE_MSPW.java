package com.woorinet.plugin.demo.DTO.TL1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SERVICE_MSPW {
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String MSPW_ID;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String PW_SRC_LSRID;
    String PW_SRC_SUBNET;
    String PW_SRC_TID;
    String PW_SRC_TID_ID;
    String PW_DST_LSRID;
    String PW_DST_SUBNET;
    String PW_DST_TID;
    String PW_DST_TID_ID;
    String TUNNEL_NAME1;
    String TUNNEL_ID1;
    String TUNNEL_NAME2;
    String TUNNEL_ID2;
    String ING_LSRID1;
    String ING_SUBNET1;
    String ING_TID1;
    String ING_TID_ID1;
    String EGR_LSRID1;
    String EGR_SUBNET1;
    String EGR_TID1;
    String EGR_TID_ID1;
    String ING_LSRID2;
    String ING_SUBNET2;
    String ING_TID2;
    String ING_TID_ID2;
    String EGR_LSRID2;
    String EGR_SUBNET2;
    String EGR_TID2;
    String EGR_TID_ID2;
    String PWXC_OPERATIONAL_STATUS;
    String PWXC_CONFIGURATION_ACTION;
    String PWXC_CONFIGURATION_RESULT;
    String CIR;
    String PIR;
    String PW_DEP_ENABLER;
    String PW_DEP_STATUS;
    String EAST_PW_PATH_STATUS_TYPE;
    String EAST_PW_IN_LABEL;
    String EAST_PW_OUT_LABEL;
    String WEST_PW_PATH_STATUS_TYPE;
    String WEST_PW_IN_LABEL;
    String WEST_PW_OUT_LABEL;
    String PROTECTION_TYPE;
    String PATH_TYPE;

    public SERVICE_MSPW(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.MSPW_ID = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.PW_SRC_LSRID = fields[8];
        this.PW_SRC_SUBNET = fields[9];
        this.PW_SRC_TID = fields[10];
        this.PW_SRC_TID_ID = fields[11];
        this.PW_DST_LSRID = fields[12];
        this.PW_DST_SUBNET = fields[13];
        this.PW_DST_TID = fields[14];
        this.PW_DST_TID_ID = fields[15];
        this.TUNNEL_NAME1 = fields[16];
        this.TUNNEL_ID1 = fields[17];
        this.TUNNEL_NAME2 = fields[18];
        this.TUNNEL_ID2 = fields[19];
        this.ING_LSRID1 = fields[20];
        this.ING_SUBNET1 = fields[21];
        this.ING_TID1 = fields[22];
        this.ING_TID_ID1 = fields[23];
        this.EGR_LSRID1 = fields[24];
        this.EGR_SUBNET1 = fields[25];
        this.EGR_TID1 = fields[26];
        this.EGR_TID_ID1 = fields[27];
        this.ING_LSRID2 = fields[28];
        this.ING_SUBNET2 = fields[29];
        this.ING_TID2 = fields[30];
        this.ING_TID_ID2 = fields[31];
        this.EGR_LSRID2 = fields[32];
        this.EGR_SUBNET2 = fields[33];
        this.EGR_TID2 = fields[34];
        this.EGR_TID_ID2 = fields[35];
        this.PWXC_OPERATIONAL_STATUS = fields[36];
        this.PWXC_CONFIGURATION_ACTION = fields[37];
        this.PWXC_CONFIGURATION_RESULT = fields[38];
        this.CIR = fields[39];
        this.PIR = fields[40];
        this.PW_DEP_ENABLER = fields[41];
        this.PW_DEP_STATUS = fields[42];
        this.EAST_PW_PATH_STATUS_TYPE = fields[43];
        this.EAST_PW_IN_LABEL = fields[44];
        this.EAST_PW_OUT_LABEL = fields[45];
        this.WEST_PW_PATH_STATUS_TYPE = fields[46];
        this.WEST_PW_IN_LABEL = fields[47];
        this.WEST_PW_OUT_LABEL = fields[48];
        this.PROTECTION_TYPE = fields[49];
        this.PATH_TYPE = fields[50];
    }

    @Override
    public String toString() {
        return "SERVICE_MSPW{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", MSPW_ID='" + MSPW_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", PW_SRC_LSRID='" + PW_SRC_LSRID + '\'' +
                ", PW_SRC_SUBNET='" + PW_SRC_SUBNET + '\'' +
                ", PW_SRC_TID='" + PW_SRC_TID + '\'' +
                ", PW_SRC_TID_ID='" + PW_SRC_TID_ID + '\'' +
                ", PW_DST_LSRID='" + PW_DST_LSRID + '\'' +
                ", PW_DST_SUBNET='" + PW_DST_SUBNET + '\'' +
                ", PW_DST_TID='" + PW_DST_TID + '\'' +
                ", PW_DST_TID_ID='" + PW_DST_TID_ID + '\'' +
                ", TUNNEL_NAME1='" + TUNNEL_NAME1 + '\'' +
                ", TUNNEL_ID1='" + TUNNEL_ID1 + '\'' +
                ", TUNNEL_NAME2='" + TUNNEL_NAME2 + '\'' +
                ", TUNNEL_ID2='" + TUNNEL_ID2 + '\'' +
                ", ING_LSRID1='" + ING_LSRID1 + '\'' +
                ", ING_SUBNET1='" + ING_SUBNET1 + '\'' +
                ", ING_TID1='" + ING_TID1 + '\'' +
                ", ING_TID_ID1='" + ING_TID_ID1 + '\'' +
                ", EGR_LSRID1='" + EGR_LSRID1 + '\'' +
                ", EGR_SUBNET1='" + EGR_SUBNET1 + '\'' +
                ", EGR_TID1='" + EGR_TID1 + '\'' +
                ", EGR_TID_ID1='" + EGR_TID_ID1 + '\'' +
                ", ING_LSRID2='" + ING_LSRID2 + '\'' +
                ", ING_SUBNET2='" + ING_SUBNET2 + '\'' +
                ", ING_TID2='" + ING_TID2 + '\'' +
                ", ING_TID_ID2='" + ING_TID_ID2 + '\'' +
                ", EGR_LSRID2='" + EGR_LSRID2 + '\'' +
                ", EGR_SUBNET2='" + EGR_SUBNET2 + '\'' +
                ", EGR_TID2='" + EGR_TID2 + '\'' +
                ", EGR_TID_ID2='" + EGR_TID_ID2 + '\'' +
                ", PWXC_OPERATIONAL_STATUS='" + PWXC_OPERATIONAL_STATUS + '\'' +
                ", PWXC_CONFIGURATION_ACTION='" + PWXC_CONFIGURATION_ACTION + '\'' +
                ", PWXC_CONFIGURATION_RESULT='" + PWXC_CONFIGURATION_RESULT + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", PW_DEP_ENABLER='" + PW_DEP_ENABLER + '\'' +
                ", PW_DEP_STATUS='" + PW_DEP_STATUS + '\'' +
                ", EAST_PW_PATH_STATUS_TYPE='" + EAST_PW_PATH_STATUS_TYPE + '\'' +
                ", EAST_PW_IN_LABEL='" + EAST_PW_IN_LABEL + '\'' +
                ", EAST_PW_OUT_LABEL='" + EAST_PW_OUT_LABEL + '\'' +
                ", WEST_PW_PATH_STATUS_TYPE='" + WEST_PW_PATH_STATUS_TYPE + '\'' +
                ", WEST_PW_IN_LABEL='" + WEST_PW_IN_LABEL + '\'' +
                ", WEST_PW_OUT_LABEL='" + WEST_PW_OUT_LABEL + '\'' +
                ", PROTECTION_TYPE='" + PROTECTION_TYPE + '\'' +
                ", PATH_TYPE='" + PATH_TYPE + '\'' +
                '}';
    }
}
