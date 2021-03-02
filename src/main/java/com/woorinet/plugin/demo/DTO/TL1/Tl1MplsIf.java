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
@Table(name = "tl1_mpls_if")
public class Tl1MplsIf {
    @Id
    @GeneratedValue
    int MPLS_IF_ID;
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    String MPLS_TP_ID;
    String BP;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String SRC_SUBNET;
    String SRC_TID_ID;
    String SRC_TID;
    String SRC_PORT;
    String DST_SUBNET;
    String DST_TID_ID;
    String DST_TID;
    String DST_PORT;
    String OPERATION_STATUS;
    String CONFIGURATION_ACTION;
    String CONFIGURATION_RESULT;
    String CIR;
    String PIR;
    String DEP_ENABLER;
    String DEP_STATUS;
    String CONSTRAINT_ID;
    String CONSTRAINT_NAME;
    String CONSTRAINT_VALUE;
    String CONSTRAINT_OPERATOR;
    String PORT_CONSTRAINT_TYPE;
    String MAXIMUM_BANDWIDTH;
    String AVAILABLE_BANDWIDTH;
    String LINK_TYPE;
    String IS_VENDOR;
    String REMOTE_NODEID;
    String REMOTE_NODE_CONNECTOR;
    String REMOTE_TOPOLOGYID;
    String REMOTE_MPLSIF;
    String PEER_MAC_ADDRESS;
    String MPLSIF_TYPE;

    public Tl1MplsIf() {

    }

    public Tl1MplsIf(String TID_ID, String TID, String SUBNET_ID, String SUBNET, String MPLS_TP_ID, String BP, String LOCAL_ID, String REQUEST_ID, String NAME, String SRC_SUBNET, String SRC_TID_ID, String SRC_TID, String SRC_PORT, String DST_SUBNET, String DST_TID_ID, String DST_TID, String DST_PORT, String OPERATION_STATUS, String CONFIGURATION_ACTION, String CONFIGURATION_RESULT, String CIR, String PIR, String DEP_ENABLER, String DEP_STATUS, String CONSTRAINT_ID, String CONSTRAINT_NAME, String CONSTRAINT_VALUE, String CONSTRAINT_OPERATOR, String PORT_CONSTRAINT_TYPE, String MAXIMUM_BANDWIDTH, String AVAILABLE_BANDWIDTH, String LINK_TYPE, String IS_VENDOR, String REMOTE_NODEID, String REMOTE_NODE_CONNECTOR, String REMOTE_TOPOLOGYID, String REMOTE_MPLSIF, String PEER_MAC_ADDRESS, String MPLSIF_TYPE) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.SUBNET_ID = SUBNET_ID;
        this.SUBNET = SUBNET;
        this.MPLS_TP_ID = MPLS_TP_ID;
        this.BP = BP;
        this.LOCAL_ID = LOCAL_ID;
        this.REQUEST_ID = REQUEST_ID;
        this.NAME = NAME;
        this.SRC_SUBNET = SRC_SUBNET;
        this.SRC_TID_ID = SRC_TID_ID;
        this.SRC_TID = SRC_TID;
        this.SRC_PORT = SRC_PORT;
        this.DST_SUBNET = DST_SUBNET;
        this.DST_TID_ID = DST_TID_ID;
        this.DST_TID = DST_TID;
        this.DST_PORT = DST_PORT;
        this.OPERATION_STATUS = OPERATION_STATUS;
        this.CONFIGURATION_ACTION = CONFIGURATION_ACTION;
        this.CONFIGURATION_RESULT = CONFIGURATION_RESULT;
        this.CIR = CIR;
        this.PIR = PIR;
        this.DEP_ENABLER = DEP_ENABLER;
        this.DEP_STATUS = DEP_STATUS;
        this.CONSTRAINT_ID = CONSTRAINT_ID;
        this.CONSTRAINT_NAME = CONSTRAINT_NAME;
        this.CONSTRAINT_VALUE = CONSTRAINT_VALUE;
        this.CONSTRAINT_OPERATOR = CONSTRAINT_OPERATOR;
        this.PORT_CONSTRAINT_TYPE = PORT_CONSTRAINT_TYPE;
        this.MAXIMUM_BANDWIDTH = MAXIMUM_BANDWIDTH;
        this.AVAILABLE_BANDWIDTH = AVAILABLE_BANDWIDTH;
        this.LINK_TYPE = LINK_TYPE;
        this.IS_VENDOR = IS_VENDOR;
        this.REMOTE_NODEID = REMOTE_NODEID;
        this.REMOTE_NODE_CONNECTOR = REMOTE_NODE_CONNECTOR;
        this.REMOTE_TOPOLOGYID = REMOTE_TOPOLOGYID;
        this.REMOTE_MPLSIF = REMOTE_MPLSIF;
        this.PEER_MAC_ADDRESS = PEER_MAC_ADDRESS;
        this.MPLSIF_TYPE = MPLSIF_TYPE;
    }

    public Tl1MplsIf(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.MPLS_TP_ID = fields[4];
        this.BP = fields[5];
        this.LOCAL_ID = fields[6];
        this.REQUEST_ID = fields[7];
        this.NAME = fields[8];
        this.SRC_SUBNET = fields[9];
        this.SRC_TID_ID = fields[10];
        this.SRC_TID = fields[11];
        this.SRC_PORT = fields[12];
        this.DST_SUBNET = fields[13];
        this.DST_TID_ID = fields[14];
        this.DST_TID = fields[15];
        this.DST_PORT = fields[16];
        this.OPERATION_STATUS = fields[17];
        this.CONFIGURATION_ACTION = fields[18];
        this.CONFIGURATION_RESULT = fields[19];
        this.CIR = fields[20];
        this.PIR = fields[21];
        this.DEP_ENABLER = fields[22];
        this.DEP_STATUS = fields[23];
        this.CONSTRAINT_ID = fields[24];
        this.CONSTRAINT_NAME = fields[25];
        this.CONSTRAINT_VALUE = fields[26];
        this.CONSTRAINT_OPERATOR = fields[27];
        this.PORT_CONSTRAINT_TYPE = fields[28];
        this.MAXIMUM_BANDWIDTH = fields[29];
        this.AVAILABLE_BANDWIDTH = fields[30];
        this.LINK_TYPE = fields[31];
        this.IS_VENDOR = fields[32];
        this.REMOTE_NODEID = fields[33];
        this.REMOTE_NODE_CONNECTOR = fields[34];
        this.REMOTE_TOPOLOGYID = fields[35];
        this.REMOTE_MPLSIF = fields[36];
        this.PEER_MAC_ADDRESS = fields[37];
        this.MPLSIF_TYPE = fields[38];
    }

    @Override
    public String toString() {
        return "MPLS_IF{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", MPLS_TP_ID='" + MPLS_TP_ID + '\'' +
                ", BP='" + BP + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", SRC_SUBNET='" + SRC_SUBNET + '\'' +
                ", SRC_TID_ID='" + SRC_TID_ID + '\'' +
                ", SRC_TID='" + SRC_TID + '\'' +
                ", SRC_PORT='" + SRC_PORT + '\'' +
                ", DST_SUBNET='" + DST_SUBNET + '\'' +
                ", DST_TID_ID='" + DST_TID_ID + '\'' +
                ", DST_TID='" + DST_TID + '\'' +
                ", DST_PORT='" + DST_PORT + '\'' +
                ", OPERATION_STATUS='" + OPERATION_STATUS + '\'' +
                ", CONFIGURATION_ACTION='" + CONFIGURATION_ACTION + '\'' +
                ", CONFIGURATION_RESULT='" + CONFIGURATION_RESULT + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", DEP_ENABLER='" + DEP_ENABLER + '\'' +
                ", DEP_STATUS='" + DEP_STATUS + '\'' +
                ", CONSTRAINT_ID='" + CONSTRAINT_ID + '\'' +
                ", CONSTRAINT_NAME='" + CONSTRAINT_NAME + '\'' +
                ", CONSTRAINT_VALUE='" + CONSTRAINT_VALUE + '\'' +
                ", CONSTRAINT_OPERATOR='" + CONSTRAINT_OPERATOR + '\'' +
                ", PORT_CONSTRAINT_TYPE='" + PORT_CONSTRAINT_TYPE + '\'' +
                ", MAXIMUM_BANDWIDTH='" + MAXIMUM_BANDWIDTH + '\'' +
                ", AVAILABLE_BANDWIDTH='" + AVAILABLE_BANDWIDTH + '\'' +
                ", LINK_TYPE='" + LINK_TYPE + '\'' +
                ", IS_VENDOR='" + IS_VENDOR + '\'' +
                ", REMOTE_NODEID='" + REMOTE_NODEID + '\'' +
                ", REMOTE_NODE_CONNECTOR='" + REMOTE_NODE_CONNECTOR + '\'' +
                ", REMOTE_TOPOLOGYID='" + REMOTE_TOPOLOGYID + '\'' +
                ", REMOTE_MPLSIF='" + REMOTE_MPLSIF + '\'' +
                ", PEER_MAC_ADDRESS='" + PEER_MAC_ADDRESS + '\'' +
                ", MPLSIF_TYPE='" + MPLSIF_TYPE + '\'' +
                '}';
    }
}
