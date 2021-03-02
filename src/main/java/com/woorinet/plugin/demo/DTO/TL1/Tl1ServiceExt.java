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
@Table(name = "tl1_service_ext")
public class Tl1ServiceExt {
    @Id
    @GeneratedValue
    int SERVICE_EXT_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String SERV_NAME;
    String CIR;
    String PIR;
    String PW_ID;
    String SC_ID;
    String SCC_NAME;
    String SCC_VALUE;
    String SCC_OPERATOR;
    String SC_TYPE;
    String NODE_ROLE;
    String TID_ROLE;
    String SRC_PWID;
    String SRC_VSI_ID;
    String SRC_SUBNET;
    String SRC_TID;
    String SRC_TID_ID;
    String SRC_AID;
    String SRC_NODE_AIF_ID;
    String SRC_NODE_AIF_NAME;
    String SRC_NODE_AIF_TYPE;
    String SRC_PORT_CID;
    String SRC_PORT_CNAME;
    String SRC_PORT_CVALUE;
    String SRC_PORT_COPERATOR;
    String SRC_PORT_CTYPE;
    String SRC_ING_LSRID;
    String SRC_EGR_LSRID;
    String SRC_IN_LABEL;
    String SRC_OUT_LABEL;
    String DST_PWID;
    String DST_VSI_ID;
    String DST_SUBNET;
    String DST_TID;
    String DST_TID_ID;
    String DST_AID;
    String DST_NODE_AIF_ID;
    String DST_NODE_AIF_NAME;
    String DST_NODE_AIF_TYPE;
    String DST_PORT_CID;
    String DST_PORT_CNAME;
    String DST_PORT_CVALUE;
    String DST_PORT_COPERATOR;
    String DST_PORT_CTYPE;
    String DST_ING_LSRID;
    String DST_EGR_LSRID;
    String DST_IN_LABEL;
    String DST_OUT_LABEL;
    String MS_TUNNEL_COUNT;
    String MS_PW_COUNT;

    public Tl1ServiceExt() {

    }

    public Tl1ServiceExt(String TID_ID, String TID, String SUBNET_ID, String SUBNET, String SERV_NAME, String CIR, String PIR, String PW_ID, String SC_ID, String SCC_NAME, String SCC_VALUE, String SCC_OPERATOR, String SC_TYPE, String NODE_ROLE, String TID_ROLE, String SRC_PWID, String SRC_VSI_ID, String SRC_SUBNET, String SRC_TID, String SRC_TID_ID, String SRC_AID, String SRC_NODE_AIF_ID, String SRC_NODE_AIF_NAME, String SRC_NODE_AIF_TYPE, String SRC_PORT_CID, String SRC_PORT_CNAME, String SRC_PORT_CVALUE, String SRC_PORT_COPERATOR, String SRC_PORT_CTYPE, String SRC_ING_LSRID, String SRC_EGR_LSRID, String SRC_IN_LABEL, String SRC_OUT_LABEL, String DST_PWID, String DST_VSI_ID, String DST_SUBNET, String DST_TID, String DST_TID_ID, String DST_AID, String DST_NODE_AIF_ID, String DST_NODE_AIF_NAME, String DST_NODE_AIF_TYPE, String DST_PORT_CID, String DST_PORT_CNAME, String DST_PORT_CVALUE, String DST_PORT_COPERATOR, String DST_PORT_CTYPE, String DST_ING_LSRID, String DST_EGR_LSRID, String DST_IN_LABEL, String DST_OUT_LABEL, String MS_TUNNEL_COUNT, String MS_PW_COUNT) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.SUBNET_ID = SUBNET_ID;
        this.SUBNET = SUBNET;
        this.SERV_NAME = SERV_NAME;
        this.CIR = CIR;
        this.PIR = PIR;
        this.PW_ID = PW_ID;
        this.SC_ID = SC_ID;
        this.SCC_NAME = SCC_NAME;
        this.SCC_VALUE = SCC_VALUE;
        this.SCC_OPERATOR = SCC_OPERATOR;
        this.SC_TYPE = SC_TYPE;
        this.NODE_ROLE = NODE_ROLE;
        this.TID_ROLE = TID_ROLE;
        this.SRC_PWID = SRC_PWID;
        this.SRC_VSI_ID = SRC_VSI_ID;
        this.SRC_SUBNET = SRC_SUBNET;
        this.SRC_TID = SRC_TID;
        this.SRC_TID_ID = SRC_TID_ID;
        this.SRC_AID = SRC_AID;
        this.SRC_NODE_AIF_ID = SRC_NODE_AIF_ID;
        this.SRC_NODE_AIF_NAME = SRC_NODE_AIF_NAME;
        this.SRC_NODE_AIF_TYPE = SRC_NODE_AIF_TYPE;
        this.SRC_PORT_CID = SRC_PORT_CID;
        this.SRC_PORT_CNAME = SRC_PORT_CNAME;
        this.SRC_PORT_CVALUE = SRC_PORT_CVALUE;
        this.SRC_PORT_COPERATOR = SRC_PORT_COPERATOR;
        this.SRC_PORT_CTYPE = SRC_PORT_CTYPE;
        this.SRC_ING_LSRID = SRC_ING_LSRID;
        this.SRC_EGR_LSRID = SRC_EGR_LSRID;
        this.SRC_IN_LABEL = SRC_IN_LABEL;
        this.SRC_OUT_LABEL = SRC_OUT_LABEL;
        this.DST_PWID = DST_PWID;
        this.DST_VSI_ID = DST_VSI_ID;
        this.DST_SUBNET = DST_SUBNET;
        this.DST_TID = DST_TID;
        this.DST_TID_ID = DST_TID_ID;
        this.DST_AID = DST_AID;
        this.DST_NODE_AIF_ID = DST_NODE_AIF_ID;
        this.DST_NODE_AIF_NAME = DST_NODE_AIF_NAME;
        this.DST_NODE_AIF_TYPE = DST_NODE_AIF_TYPE;
        this.DST_PORT_CID = DST_PORT_CID;
        this.DST_PORT_CNAME = DST_PORT_CNAME;
        this.DST_PORT_CVALUE = DST_PORT_CVALUE;
        this.DST_PORT_COPERATOR = DST_PORT_COPERATOR;
        this.DST_PORT_CTYPE = DST_PORT_CTYPE;
        this.DST_ING_LSRID = DST_ING_LSRID;
        this.DST_EGR_LSRID = DST_EGR_LSRID;
        this.DST_IN_LABEL = DST_IN_LABEL;
        this.DST_OUT_LABEL = DST_OUT_LABEL;
        this.MS_TUNNEL_COUNT = MS_TUNNEL_COUNT;
        this.MS_PW_COUNT = MS_PW_COUNT;
    }

    public Tl1ServiceExt(String[] fields) {
        TID_ID = fields[0];
        TID = fields[1];
        SUBNET_ID = fields[2];
        SUBNET = fields[3];
        SERV_NAME = fields[4];
        CIR = fields[5];
        PIR = fields[6];
        PW_ID = fields[7];
        SC_ID = fields[8];
        SCC_NAME = fields[9];
        SCC_VALUE = fields[10];
        SCC_OPERATOR = fields[11];
        SC_TYPE = fields[12];
        NODE_ROLE = fields[13];
        TID_ROLE = fields[14];
        SRC_PWID = fields[15];
        SRC_VSI_ID = fields[16];
        SRC_SUBNET = fields[17];
        SRC_TID = fields[18];
        SRC_TID_ID = fields[19];
        SRC_AID = fields[20];
        SRC_NODE_AIF_ID = fields[21];
        SRC_NODE_AIF_NAME = fields[22];
        SRC_NODE_AIF_TYPE = fields[23];
        SRC_PORT_CID = fields[24];
        SRC_PORT_CNAME = fields[25];
        SRC_PORT_CVALUE = fields[26];
        SRC_PORT_COPERATOR = fields[27];
        SRC_PORT_CTYPE = fields[28];
        SRC_ING_LSRID = fields[29];
        SRC_EGR_LSRID = fields[30];
        SRC_IN_LABEL = fields[31];
        SRC_OUT_LABEL = fields[32];
        DST_PWID = fields[33];
        DST_VSI_ID = fields[34];
        DST_SUBNET = fields[35];
        DST_TID = fields[36];
        DST_TID_ID = fields[37];
        DST_AID = fields[38];
        DST_NODE_AIF_ID = fields[39];
        DST_NODE_AIF_NAME = fields[40];
        DST_NODE_AIF_TYPE = fields[41];
        DST_PORT_CID = fields[42];
        DST_PORT_CNAME = fields[43];
        DST_PORT_CVALUE = fields[44];
        DST_PORT_COPERATOR = fields[45];
        DST_PORT_CTYPE = fields[46];
        DST_ING_LSRID = fields[47];
        DST_EGR_LSRID = fields[48];
        DST_IN_LABEL = fields[49];
        DST_OUT_LABEL = fields[50];
        MS_TUNNEL_COUNT = fields[51];
        MS_PW_COUNT = fields[52];
    }

    @Override
    public String toString() {
        return "SERVICE_EXT{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", SERV_NAME='" + SERV_NAME + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", PW_ID='" + PW_ID + '\'' +
                ", SC_ID='" + SC_ID + '\'' +
                ", SCC_NAME='" + SCC_NAME + '\'' +
                ", SCC_VALUE='" + SCC_VALUE + '\'' +
                ", SCC_OPERATOR='" + SCC_OPERATOR + '\'' +
                ", SC_TYPE='" + SC_TYPE + '\'' +
                ", NODE_ROLE='" + NODE_ROLE + '\'' +
                ", TID_ROLE='" + TID_ROLE + '\'' +
                ", SRC_PWID='" + SRC_PWID + '\'' +
                ", SRC_VSI_ID='" + SRC_VSI_ID + '\'' +
                ", SRC_SUBNET='" + SRC_SUBNET + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", SRC_AID='" + SRC_AID + '\'' +
                ", SRC_NODE_AIF_ID='" + SRC_NODE_AIF_ID + '\'' +
                ", SRC_NODE_AIF_NAME='" + SRC_NODE_AIF_NAME + '\'' +
                ", SRC_NODE_AIF_TYPE='" + SRC_NODE_AIF_TYPE + '\'' +
                ", SRC_PORT_CID='" + SRC_PORT_CID + '\'' +
                ", SRC_PORT_CNAME='" + SRC_PORT_CNAME + '\'' +
                ", SRC_PORT_CVALUE='" + SRC_PORT_CVALUE + '\'' +
                ", SRC_PORT_COPERATOR='" + SRC_PORT_COPERATOR + '\'' +
                ", SRC_PORT_CTYPE='" + SRC_PORT_CTYPE + '\'' +
                ", SRC_ING_LSRID='" + SRC_ING_LSRID + '\'' +
                ", SRC_EGR_LSRID='" + SRC_EGR_LSRID + '\'' +
                ", SRC_IN_LABEL='" + SRC_IN_LABEL + '\'' +
                ", SRC_OUT_LABEL='" + SRC_OUT_LABEL + '\'' +
                ", DST_PWID='" + DST_PWID + '\'' +
                ", DST_VSI_ID='" + DST_VSI_ID + '\'' +
                ", DST_SUBNET='" + DST_SUBNET + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", DST_AID='" + DST_AID + '\'' +
                ", DST_NODE_AIF_ID='" + DST_NODE_AIF_ID + '\'' +
                ", DST_NODE_AIF_NAME='" + DST_NODE_AIF_NAME + '\'' +
                ", DST_NODE_AIF_TYPE='" + DST_NODE_AIF_TYPE + '\'' +
                ", DST_PORT_CID='" + DST_PORT_CID + '\'' +
                ", DST_PORT_CNAME='" + DST_PORT_CNAME + '\'' +
                ", DST_PORT_CVALUE='" + DST_PORT_CVALUE + '\'' +
                ", DST_PORT_COPERATOR='" + DST_PORT_COPERATOR + '\'' +
                ", DST_PORT_CTYPE='" + DST_PORT_CTYPE + '\'' +
                ", DST_ING_LSRID='" + DST_ING_LSRID + '\'' +
                ", DST_EGR_LSRID='" + DST_EGR_LSRID + '\'' +
                ", DST_IN_LABEL='" + DST_IN_LABEL + '\'' +
                ", DST_OUT_LABEL='" + DST_OUT_LABEL + '\'' +
                ", MS_TUNNEL_COUNT='" + MS_TUNNEL_COUNT + '\'' +
                ", MS_PW_COUNT='" + MS_PW_COUNT + '\'' +
                '}';
    }
}
