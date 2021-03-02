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
@Table(name = "tl1_stunnel_ext")
public class Tl1StunnelExt {
    @Id
    @GeneratedValue
    int STUNNEL_EXT_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String NAME;
    String DESCR;
    String TU_ID;
    String PROTECTION;
    String ACTIVE_PATH_STATUS;
    String ING_SUBNET;
    String ING_TID;
    String ING_TID_ID;
    String ING_LSRID;
    String EGR_SUBNET;
    String EGR_TID;
    String EGR_TID_ID;
    String EGR_LSRID;
    String ROLE;
    String DIRECTION;
    String FROM_SUBNET;
    String FROM_TID_ID;
    String FROM_TID;
    String FROM_PORT;
    String FROM_IN_LABEL;
    String FROM_OUT_LABEL;
    String TO_SUBNET;
    String TO_TID_ID;
    String TO_TID;
    String TO_PORT;
    String TO_IN_LABEL;
    String TO_OUT_LABEL;
    String QMAP_ID;
    String PHB_ID;
    String EXP;
    String USE_BW;
    String AUTO_BW;
    String CIR;
    String PIR;
    String CIR6;
    String PIR6;
    String CIR5;
    String PIR5;
    String CIR4;
    String PIR4;
    String CIR3;
    String PIR3;
    String CIR2;
    String PIR2;
    String CIR1;
    String PIR1;
    String OAM_ID;
    String PROT_ID;
    String COUNTER;
    String LM_COUNTER;
    String POLL_RATE;
    String REPORT;
    String NO_PACKET;
    String CREATE_DATE;
    String MODIFI_DATE;

    public Tl1StunnelExt() {

    }

    public Tl1StunnelExt(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.NAME = fields[4];
        this.DESCR = fields[5];
        this.TU_ID = fields[6];
        this.PROTECTION = fields[7];
        this.ACTIVE_PATH_STATUS = fields[8];
        this.ING_SUBNET = fields[9];
        this.ING_TID = fields[10];
        this.ING_TID_ID = fields[11];
        this.ING_LSRID = fields[12];
        this.EGR_SUBNET = fields[13];
        this.EGR_TID = fields[14];
        this.EGR_TID_ID = fields[15];
        this.EGR_LSRID = fields[16];
        this.ROLE = fields[17];
        this.DIRECTION = fields[18];
        this.FROM_SUBNET = fields[19];
        this.FROM_TID_ID = fields[20];
        this.FROM_TID = fields[21];
        this.FROM_PORT = fields[22];
        this.FROM_IN_LABEL = fields[23];
        this.FROM_OUT_LABEL = fields[24];
        this.TO_SUBNET = fields[25];
        this.TO_TID_ID = fields[26];
        this.TO_TID = fields[27];
        this.TO_PORT = fields[28];
        this.TO_IN_LABEL = fields[29];
        this.TO_OUT_LABEL = fields[30];
        this.QMAP_ID = fields[31];
        this.PHB_ID = fields[32];
        this.EXP = fields[33];
        this.USE_BW = fields[34];
        this.AUTO_BW = fields[35];
        this.CIR = fields[36];
        this.PIR = fields[37];
        this.CIR6 = fields[38];
        this.PIR6 = fields[39];
        this.CIR5 = fields[40];
        this.PIR5 = fields[41];
        this.CIR4 = fields[42];
        this.PIR4 = fields[43];
        this.CIR3 = fields[44];
        this.PIR3 = fields[45];
        this.CIR2 = fields[46];
        this.PIR2 = fields[47];
        this.CIR1 = fields[48];
        this.PIR1 = fields[49];
        this.OAM_ID = fields[50];
        this.PROT_ID = fields[51];
        this.COUNTER = fields[52];
        this.LM_COUNTER = fields[53];
        this.POLL_RATE = fields[54];
        this.REPORT = fields[55];
        this.NO_PACKET = fields[56];
        this.CREATE_DATE = fields[57];
        this.MODIFI_DATE = fields[58];
    }

    @Override
    public String toString() {
        return "STUNNEL_EXT{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", TU_ID='" + TU_ID + '\'' +
                ", PROTECTION='" + PROTECTION + '\'' +
                ", ACTIVE_PATH_STATUS='" + ACTIVE_PATH_STATUS + '\'' +
                ", ING_SUBNET='" + ING_SUBNET + '\'' +
                ", ING_TID='" + ING_TID + '\'' +
                ", ING_TID_ID='" + ING_TID_ID + '\'' +
                ", ING_LSRID='" + ING_LSRID + '\'' +
                ", EGR_SUBNET='" + EGR_SUBNET + '\'' +
                ", EGR_TID='" + EGR_TID + '\'' +
                ", EGR_TID_ID='" + EGR_TID_ID + '\'' +
                ", EGR_LSRID='" + EGR_LSRID + '\'' +
                ", ROLE='" + ROLE + '\'' +
                ", DIRECTION='" + DIRECTION + '\'' +
                ", FROM_SUBNET='" + FROM_SUBNET + '\'' +
                ", FROM_TID_ID='" + FROM_TID_ID + '\'' +
                ", FROM_TID='" + FROM_TID + '\'' +
                ", FROM_PORT='" + FROM_PORT + '\'' +
                ", FROM_IN_LABEL='" + FROM_IN_LABEL + '\'' +
                ", FROM_OUT_LABEL='" + FROM_OUT_LABEL + '\'' +
                ", TO_SUBNET='" + TO_SUBNET + '\'' +
                ", TO_TID_ID='" + TO_TID_ID + '\'' +
                ", TO_TID='" + TO_TID + '\'' +
                ", TO_PORT='" + TO_PORT + '\'' +
                ", TO_IN_LABEL='" + TO_IN_LABEL + '\'' +
                ", TO_OUT_LABEL='" + TO_OUT_LABEL + '\'' +
                ", QMAP_ID='" + QMAP_ID + '\'' +
                ", PHB_ID='" + PHB_ID + '\'' +
                ", EXP='" + EXP + '\'' +
                ", USE_BW='" + USE_BW + '\'' +
                ", AUTO_BW='" + AUTO_BW + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", CIR6='" + CIR6 + '\'' +
                ", PIR6='" + PIR6 + '\'' +
                ", CIR5='" + CIR5 + '\'' +
                ", PIR5='" + PIR5 + '\'' +
                ", CIR4='" + CIR4 + '\'' +
                ", PIR4='" + PIR4 + '\'' +
                ", CIR3='" + CIR3 + '\'' +
                ", PIR3='" + PIR3 + '\'' +
                ", CIR2='" + CIR2 + '\'' +
                ", PIR2='" + PIR2 + '\'' +
                ", CIR1='" + CIR1 + '\'' +
                ", PIR1='" + PIR1 + '\'' +
                ", OAM_ID='" + OAM_ID + '\'' +
                ", PROT_ID='" + PROT_ID + '\'' +
                ", COUNTER='" + COUNTER + '\'' +
                ", LM_COUNTER='" + LM_COUNTER + '\'' +
                ", POLL_RATE='" + POLL_RATE + '\'' +
                ", REPORT='" + REPORT + '\'' +
                ", NO_PACKET='" + NO_PACKET + '\'' +
                ", CREATE_DATE='" + CREATE_DATE + '\'' +
                ", MODIFI_DATE='" + MODIFI_DATE + '\'' +
                '}';
    }
}
