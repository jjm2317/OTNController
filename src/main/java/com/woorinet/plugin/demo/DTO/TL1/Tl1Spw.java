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
@Table(name = "tl1_spw")
public class Tl1Spw {
    @Id
    @GeneratedValue
    int SPW_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String PW_ID;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String PW_TYPE;
    String TUNNEL_ID;
    String TUNNEL_NAME;
    String ING_LSRID;
    String EGR_LSRID;
    String PEER_LSRID;
    String SRC_SUBNET;
    String SRC_TID_ID;
    String SRC_TID;
    String DST_SUBNET;
    String DST_TID_ID;
    String DST_TID;
    String VSI_ID;
    String PW_OPERATIONAL_STATUS;
    String PW_CONFIGURATION_ACTION;
    String PW_CONFIGURATION_RESULT;
    String PW_OAM_ENABLER;
    String CIR;
    String PIR;
    String PW_DEP_ENABLER;
    String PW_DEP_STATUS;
    String PW_DEP_STATUS_TYPE;
    String ACTIVE_PATH_STATUS;
    String SERVICE_TYPE;
    String PATH_STATUS;
    String IN_LABEL;
    String OUT_LABEL;
    String PEER_SUBNET;
    String PEER_TID;
    String PEER_TID_ID;
    String PROTECTION_TYPE;
    String PROTECTION_REVERT_TYPE;
    String PROTECTION_PROTOCOL_TYPE;
    String PROTECTION_HOLD_OFF_TIME;
    String PROTECTION_WTR_TIME;
    String OAM_LOCAL_ID;
    String OAM_TYPE;
    String OAM_INTERVAL_TIME;
    String OAM_REMOTE_ID;
    String OAM_GROUP_NAME;

    public Tl1Spw(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.PW_ID = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.PW_TYPE = fields[8];
        this.TUNNEL_ID = fields[9];
        this.TUNNEL_NAME = fields[10];
        this.ING_LSRID = fields[11];
        this.EGR_LSRID = fields[12];
        this.PEER_LSRID = fields[13];
        this.SRC_SUBNET = fields[14];
        this.SRC_TID_ID = fields[15];
        this.SRC_TID = fields[16];
        this.DST_SUBNET = fields[17];
        this.DST_TID_ID = fields[18];
        this.DST_TID = fields[19];
        this.VSI_ID = fields[20];
        this.PW_OPERATIONAL_STATUS = fields[21];
        this.PW_CONFIGURATION_ACTION = fields[22];
        this.PW_CONFIGURATION_RESULT = fields[23];
        this.PW_OAM_ENABLER = fields[24];
        this.CIR = fields[25];
        this.PIR = fields[26];
        this.PW_DEP_ENABLER = fields[27];
        this.PW_DEP_STATUS = fields[28];
        this.PW_DEP_STATUS_TYPE = fields[29];
        this.ACTIVE_PATH_STATUS = fields[30];
        this.SERVICE_TYPE = fields[31];
        this.PATH_STATUS = fields[32];
        this.IN_LABEL = fields[33];
        this.OUT_LABEL = fields[34];
        this.PEER_SUBNET = fields[35];
        this.PEER_TID = fields[36];
        this.PEER_TID_ID = fields[37];
        this.PROTECTION_TYPE = fields[38];
        this.PROTECTION_REVERT_TYPE = fields[39];
        this.PROTECTION_PROTOCOL_TYPE = fields[40];
        this.PROTECTION_HOLD_OFF_TIME = fields[41];
        this.PROTECTION_WTR_TIME = fields[42];
        this.OAM_LOCAL_ID = fields[43];
        this.OAM_TYPE = fields[44];
        this.OAM_INTERVAL_TIME = fields[45];
        this.OAM_REMOTE_ID = fields[46];
        this.OAM_GROUP_NAME = fields[47];
    }

    @Override
    public String toString() {
        return "SPW{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", PW_ID='" + PW_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", PW_TYPE='" + PW_TYPE + '\'' +
                ", TUNNEL_ID='" + TUNNEL_ID + '\'' +
                ", TUNNEL_NAME='" + TUNNEL_NAME + '\'' +
                ", ING_LSRID='" + ING_LSRID + '\'' +
                ", EGR_LSRID='" + EGR_LSRID + '\'' +
                ", PEER_LSRID='" + PEER_LSRID + '\'' +
                ", SRC_SUBNET='" + SRC_SUBNET + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", DST_SUBNET='" + DST_SUBNET + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", VSI_ID='" + VSI_ID + '\'' +
                ", PW_OPERATIONAL_STATUS='" + PW_OPERATIONAL_STATUS + '\'' +
                ", PW_CONFIGURATION_ACTION='" + PW_CONFIGURATION_ACTION + '\'' +
                ", PW_CONFIGURATION_RESULT='" + PW_CONFIGURATION_RESULT + '\'' +
                ", PW_OAM_ENABLER='" + PW_OAM_ENABLER + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", PW_DEP_ENABLER='" + PW_DEP_ENABLER + '\'' +
                ", PW_DEP_STATUS='" + PW_DEP_STATUS + '\'' +
                ", PW_DEP_STATUS_TYPE='" + PW_DEP_STATUS_TYPE + '\'' +
                ", ACTIVE_PATH_STATUS='" + ACTIVE_PATH_STATUS + '\'' +
                ", SERVICE_TYPE='" + SERVICE_TYPE + '\'' +
                ", PATH_STATUS='" + PATH_STATUS + '\'' +
                ", IN_LABEL='" + IN_LABEL + '\'' +
                ", OUT_LABEL='" + OUT_LABEL + '\'' +
                ", PEER_SUBNET='" + PEER_SUBNET + '\'' +
                ", PEER_TID='" + PEER_TID + '\'' +
                ", PEER_TID_ID='" + PEER_TID_ID + '\'' +
                ", PROTECTION_TYPE='" + PROTECTION_TYPE + '\'' +
                ", PROTECTION_REVERT_TYPE='" + PROTECTION_REVERT_TYPE + '\'' +
                ", PROTECTION_PROTOCOL_TYPE='" + PROTECTION_PROTOCOL_TYPE + '\'' +
                ", PROTECTION_HOLD_OFF_TIME='" + PROTECTION_HOLD_OFF_TIME + '\'' +
                ", PROTECTION_WTR_TIME='" + PROTECTION_WTR_TIME + '\'' +
                ", OAM_LOCAL_ID='" + OAM_LOCAL_ID + '\'' +
                ", OAM_TYPE='" + OAM_TYPE + '\'' +
                ", OAM_INTERVAL_TIME='" + OAM_INTERVAL_TIME + '\'' +
                ", OAM_REMOTE_ID='" + OAM_REMOTE_ID + '\'' +
                ", OAM_GROUP_NAME='" + OAM_GROUP_NAME + '\'' +
                '}';
    }
}
