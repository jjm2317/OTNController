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
@Table(name = "tl1_stunnel_transit")
public class Tl1StunnelTransit {
    @Id
    @GeneratedValue
    int STUNNEL_TRANSIT_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String TU_XC_ID;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String DESCR;
    String CROSS_CONNECT_TYPE;
    String ROLE;
    String SRC_SUBNET;
    String SRC_TID_ID;
    String SRC_TID;
    String DST_SUBNET;
    String DST_TID_ID;
    String DST_TID;
    String TU_XC_OPERATIONAL_STATUS;
    String TU_XC_CONFIGURATION_ACTION;
    String TU_XC_CONFIGURATION_RESULT;
    String DEPLOYMENT_ENABLER;
    String DEPLOYMENT_STATUS;
    String CIR;
    String PIR;
    String PATH_PROTECTION;
    String PATH_STATUS;
    String FROM_PORT;
    String EAST_IN_LABEL;
    String EAST_OUT_LABEL;
    String TO_PORT;
    String WEST_IN_LABEL;
    String WEST_OUT_LABEL;
    String PROTECTION_TYPE;
    String PATH_TYPE;
    String ING_LSR;
    String ENG_LSR;

    public Tl1StunnelTransit() {

    }
    public Tl1StunnelTransit(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.TU_XC_ID = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.DESCR = fields[8];
        this.CROSS_CONNECT_TYPE = fields[9];
        this.ROLE = fields[10];
        this.SRC_SUBNET = fields[11];
        this.SRC_TID_ID = fields[12];
        this.SRC_TID = fields[13];
        this.DST_SUBNET = fields[14];
        this.DST_TID_ID = fields[15];
        this.DST_TID = fields[16];
        this.TU_XC_OPERATIONAL_STATUS = fields[17];
        this.TU_XC_CONFIGURATION_ACTION = fields[18];
        this.TU_XC_CONFIGURATION_RESULT = fields[19];
        this.DEPLOYMENT_ENABLER = fields[20];
        this.DEPLOYMENT_STATUS = fields[21];
        this.CIR = fields[22];
        this.PIR = fields[23];
        this.PATH_PROTECTION = fields[24];
        this.PATH_STATUS = fields[25];
        this.FROM_PORT = fields[26];
        this.EAST_IN_LABEL = fields[27];
        this.EAST_OUT_LABEL = fields[28];
        this.TO_PORT = fields[29];
        this.WEST_IN_LABEL = fields[30];
        this.WEST_OUT_LABEL = fields[31];
        this.PROTECTION_TYPE = fields[32];
        this.PATH_TYPE = fields[33];
        this.ING_LSR = fields[34];
        this.ENG_LSR = fields[35];
    }

    @Override
    public String toString() {
        return "STUNNEL_TRANSIT{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", TU_XC_ID='" + TU_XC_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", CROSS_CONNECT_TYPE='" + CROSS_CONNECT_TYPE + '\'' +
                ", ROLE='" + ROLE + '\'' +
                ", SRC_SUBNET='" + SRC_SUBNET + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", DST_SUBNET='" + DST_SUBNET + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", TU_XC_OPERATIONAL_STATUS='" + TU_XC_OPERATIONAL_STATUS + '\'' +
                ", TU_XC_CONFIGURATION_ACTION='" + TU_XC_CONFIGURATION_ACTION + '\'' +
                ", TU_XC_CONFIGURATION_RESULT='" + TU_XC_CONFIGURATION_RESULT + '\'' +
                ", DEPLOYMENT_ENABLER='" + DEPLOYMENT_ENABLER + '\'' +
                ", DEPLOYMENT_STATUS='" + DEPLOYMENT_STATUS + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", PATH_PROTECTION='" + PATH_PROTECTION + '\'' +
                ", PATH_STATUS='" + PATH_STATUS + '\'' +
                ", FROM_PORT='" + FROM_PORT + '\'' +
                ", EAST_IN_LABEL='" + EAST_IN_LABEL + '\'' +
                ", EAST_OUT_LABEL='" + EAST_OUT_LABEL + '\'' +
                ", TO_PORT='" + TO_PORT + '\'' +
                ", WEST_IN_LABEL='" + WEST_IN_LABEL + '\'' +
                ", WEST_OUT_LABEL='" + WEST_OUT_LABEL + '\'' +
                ", PROTECTION_TYPE='" + PROTECTION_TYPE + '\'' +
                ", PATH_TYPE='" + PATH_TYPE + '\'' +
                ", ING_LSR='" + ING_LSR + '\'' +
                ", ENG_LSR='" + ENG_LSR + '\'' +
                '}';
    }
}
