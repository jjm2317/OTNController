package com.woorinet.plugin.demo.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class STUNNEL {
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String TU_ID;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String DESCR;
    String TU_TYPE;
    String ROLE;
    String PORT;
    String SRC_SUBNET;
    String SRC_TID_ID;
    String SRC_TID;
    String DST_SUBNET;
    String DST_TID_ID;
    String DST_TID;
    String TU_OPERATIONAL_STATUS;
    String TU_CONFIGURATION_ACTION;
    String TU_CONFIGURATION_RESULT;
    String TU_OAM_ENABLER;
    String DEPLOYMENT_ENABLER;
    String DEPLOYMENT_STATUS;
    String CIR;
    String PIR;
    String ACTIVE_PATH_STATUS;
    String OAM_LOCAL_ID;
    String OAM_REMOTE_ID;
    String OAM_GROUP_NAME;
    String OAM_MESSAGE_INVERVAL_TIME;
    String OAM_TYPE;
    String PROTECTION;
    String PATH_STATUS;
    String IN_LABEL;
    String OUT_LABEL;
    String PROTECTION_TYPE;
    String PROTECTION_REVER_TYPE;
    String PROTECTION_PROTOCOL_TYPE;
    String PROTECTION_HOLD_OFF_TIME;
    String PROTECTION_WTR_TIME;
    String ING_LSR;
    String ENG_LSR;

    public STUNNEL(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.TU_ID = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.DESCR = fields[8];
        this.TU_TYPE = fields[9];
        this.ROLE = fields[10];
        this.PORT = fields[11];
        this.SRC_SUBNET = fields[12];
        this.SRC_TID_ID = fields[13];
        this.SRC_TID = fields[14];
        this.DST_SUBNET = fields[15];
        this.DST_TID_ID = fields[16];
        this.DST_TID = fields[17];
        this.TU_OPERATIONAL_STATUS = fields[18];
        this.TU_CONFIGURATION_ACTION = fields[19];
        this.TU_CONFIGURATION_RESULT = fields[20];
        this.TU_OAM_ENABLER = fields[21];
        this.DEPLOYMENT_ENABLER = fields[22];
        this.DEPLOYMENT_STATUS = fields[23];
        this.CIR = fields[24];
        this.PIR = fields[25];
        this.ACTIVE_PATH_STATUS = fields[26];
        this.OAM_LOCAL_ID = fields[27];
        this.OAM_REMOTE_ID = fields[28];
        this.OAM_GROUP_NAME = fields[29];
        this.OAM_MESSAGE_INVERVAL_TIME = fields[30];
        this.OAM_TYPE = fields[31];
        this.PROTECTION = fields[32];
        this.PATH_STATUS = fields[33];
        this.IN_LABEL = fields[34];
        this.OUT_LABEL = fields[35];
        this.PROTECTION_TYPE = fields[36];
        this.PROTECTION_REVER_TYPE = fields[37];
        this.PROTECTION_PROTOCOL_TYPE = fields[38];
        this.PROTECTION_HOLD_OFF_TIME = fields[39];
        this.PROTECTION_WTR_TIME = fields[40];
        this.ING_LSR = fields[41];
        this.ENG_LSR = fields[42];
    }

    @Override
    public String toString() {
        return "STUNNEL{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", TU_ID='" + TU_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", TU_TYPE='" + TU_TYPE + '\'' +
                ", ROLE='" + ROLE + '\'' +
                ", PORT='" + PORT + '\'' +
                ", SRC_SUBNET='" + SRC_SUBNET + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", DST_SUBNET='" + DST_SUBNET + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", TU_OPERATIONAL_STATUS='" + TU_OPERATIONAL_STATUS + '\'' +
                ", TU_CONFIGURATION_ACTION='" + TU_CONFIGURATION_ACTION + '\'' +
                ", TU_CONFIGURATION_RESULT='" + TU_CONFIGURATION_RESULT + '\'' +
                ", TU_OAM_ENABLER='" + TU_OAM_ENABLER + '\'' +
                ", DEPLOYMENT_ENABLER='" + DEPLOYMENT_ENABLER + '\'' +
                ", DEPLOYMENT_STATUS='" + DEPLOYMENT_STATUS + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", ACTIVE_PATH_STATUS='" + ACTIVE_PATH_STATUS + '\'' +
                ", OAM_LOCAL_ID='" + OAM_LOCAL_ID + '\'' +
                ", OAM_REMOTE_ID='" + OAM_REMOTE_ID + '\'' +
                ", OAM_GROUP_NAME='" + OAM_GROUP_NAME + '\'' +
                ", OAM_MESSAGE_INVERVAL_TIME='" + OAM_MESSAGE_INVERVAL_TIME + '\'' +
                ", OAM_TYPE='" + OAM_TYPE + '\'' +
                ", PROTECTION='" + PROTECTION + '\'' +
                ", PATH_STATUS='" + PATH_STATUS + '\'' +
                ", IN_LABEL='" + IN_LABEL + '\'' +
                ", OUT_LABEL='" + OUT_LABEL + '\'' +
                ", PROTECTION_TYPE='" + PROTECTION_TYPE + '\'' +
                ", PROTECTION_REVER_TYPE='" + PROTECTION_REVER_TYPE + '\'' +
                ", PROTECTION_PROTOCOL_TYPE='" + PROTECTION_PROTOCOL_TYPE + '\'' +
                ", PROTECTION_HOLD_OFF_TIME='" + PROTECTION_HOLD_OFF_TIME + '\'' +
                ", PROTECTION_WTR_TIME='" + PROTECTION_WTR_TIME + '\'' +
                ", ING_LSR='" + ING_LSR + '\'' +
                ", ENG_LSR='" + ENG_LSR + '\'' +
                '}';
    }
}
