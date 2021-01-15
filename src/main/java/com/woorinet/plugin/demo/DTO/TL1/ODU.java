package com.woorinet.plugin.demo.DTO.TL1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ODU {
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String LOCAL_ID;
    String EMS_SERVICE;
    String EMS_SERVICE_SIG;
    String EMS_SRC_SUBNET;
    String EMS_SRC_LSR;
    String EMS_DST_SUBNET;
    String EMS_DST_LSR;
    String NAME;
    String DESCR;
    String TRAIL_ID;
    String PATH_ID;
    String ING_SUBNET;
    String ING_LSR;
    String EGR_SUBNET;
    String EGR_LSR;
    String ROLE;
    String DIRECTION;
    String SERVICE;
    String TYPE;
    String START_TS;
    String RATE;
    String TSMAP;
    String MAP_MODE;
    String SF;
    String SD;
    String LOOP_TYPE;
    String LOCK;
    String LOCAL_IFINDEX;
    String REMOTE_IFINDEX;
    String ENCRYPTION;
    String LOCAL_SSL_ID;
    String REMOTE_SSL_ID;
    String LEA_PORT;
    String GMPLS;
    String UNI_XC_ID;
    String NNI_XC_ID;
    String PROTECTION;
    String PROT_ID;
    String PROT_MODE;
    String PROT_TYPE;
    String ACTIVE_PATH_STATUS;
    String SF_DETECT;
    String CREATION_DATE;
    String MODIFIED_DATE;
    String TUNNEL_PORT;

    public ODU(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.LOCAL_ID = fields[4];
        this.EMS_SERVICE = fields[5];
        this.EMS_SERVICE_SIG = fields[6];
        this.EMS_SRC_SUBNET = fields[7];
        this.EMS_SRC_LSR = fields[8];
        this.EMS_DST_SUBNET = fields[9];
        this.EMS_DST_LSR = fields[10];
        this.NAME = fields[11];
        this.DESCR = fields[12];
        this.TRAIL_ID = fields[13];
        this.PATH_ID = fields[14];
        this.ING_SUBNET = fields[15];
        this.ING_LSR = fields[16];
        this.EGR_SUBNET = fields[17];
        this.EGR_LSR = fields[18];
        this.ROLE = fields[19];
        this.DIRECTION = fields[20];
        this.SERVICE = fields[21];
        this.TYPE = fields[22];
        this.START_TS = fields[23];
        this.RATE = fields[24];
        this.TSMAP = fields[25];
        this.MAP_MODE = fields[26];
        this.SF = fields[27];
        this.SD = fields[28];
        this.LOOP_TYPE = fields[29];
        this.LOCK = fields[30];
        this.LOCAL_IFINDEX = fields[31];
        this.REMOTE_IFINDEX = fields[32];
        this.ENCRYPTION = fields[33];
        this.LOCAL_SSL_ID = fields[34];
        this.REMOTE_SSL_ID = fields[35];
        this.LEA_PORT = fields[36];
        this.GMPLS = fields[37];
        this.UNI_XC_ID = fields[38];
        this.NNI_XC_ID = fields[39];
        this.PROTECTION = fields[40];
        this.PROT_ID = fields[41];
        this.PROT_MODE = fields[42];
        this.PROT_TYPE = fields[43];
        this.ACTIVE_PATH_STATUS = fields[44];
        this.SF_DETECT = fields[45];
        this.CREATION_DATE = fields[46];
        this.MODIFIED_DATE = fields[47];
        this.TUNNEL_PORT = fields[48];
    }

    @Override
    public String toString() {
        return "ODU{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", EMS_SERVICE='" + EMS_SERVICE + '\'' +
                ", EMS_SERVICE_SIG='" + EMS_SERVICE_SIG + '\'' +
                ", EMS_SRC_SUBNET='" + EMS_SRC_SUBNET + '\'' +
                ", EMS_SRC_LSR='" + EMS_SRC_LSR + '\'' +
                ", EMS_DST_SUBNET='" + EMS_DST_SUBNET + '\'' +
                ", EMS_DST_LSR='" + EMS_DST_LSR + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", TRAIL_ID='" + TRAIL_ID + '\'' +
                ", PATH_ID='" + PATH_ID + '\'' +
                ", ING_SUBNET='" + ING_SUBNET + '\'' +
                ", ING_LSR='" + ING_LSR + '\'' +
                ", EGR_SUBNET='" + EGR_SUBNET + '\'' +
                ", EGR_LSR='" + EGR_LSR + '\'' +
                ", ROLE='" + ROLE + '\'' +
                ", DIRECTION='" + DIRECTION + '\'' +
                ", SERVICE='" + SERVICE + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", START_TS='" + START_TS + '\'' +
                ", RATE='" + RATE + '\'' +
                ", TSMAP='" + TSMAP + '\'' +
                ", MAP_MODE='" + MAP_MODE + '\'' +
                ", SF='" + SF + '\'' +
                ", SD='" + SD + '\'' +
                ", LOOP_TYPE='" + LOOP_TYPE + '\'' +
                ", LOCK='" + LOCK + '\'' +
                ", LOCAL_IFINDEX='" + LOCAL_IFINDEX + '\'' +
                ", REMOTE_IFINDEX='" + REMOTE_IFINDEX + '\'' +
                ", ENCRYPTION='" + ENCRYPTION + '\'' +
                ", LOCAL_SSL_ID='" + LOCAL_SSL_ID + '\'' +
                ", REMOTE_SSL_ID='" + REMOTE_SSL_ID + '\'' +
                ", LEA_PORT='" + LEA_PORT + '\'' +
                ", GMPLS='" + GMPLS + '\'' +
                ", UNI_XC_ID='" + UNI_XC_ID + '\'' +
                ", NNI_XC_ID='" + NNI_XC_ID + '\'' +
                ", PROTECTION='" + PROTECTION + '\'' +
                ", PROT_ID='" + PROT_ID + '\'' +
                ", PROT_MODE='" + PROT_MODE + '\'' +
                ", PROT_TYPE='" + PROT_TYPE + '\'' +
                ", ACTIVE_PATH_STATUS='" + ACTIVE_PATH_STATUS + '\'' +
                ", SF_DETECT='" + SF_DETECT + '\'' +
                ", CREATION_DATE='" + CREATION_DATE + '\'' +
                ", MODIFIED_DATE='" + MODIFIED_DATE + '\'' +
                ", TUNNEL_PORT='" + TUNNEL_PORT + '\'' +
                '}';
    }
}
