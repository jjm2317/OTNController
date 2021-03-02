package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MPLS_AC {
    String TID_ID;
    String TID;
    String AID;
    String SERVICE_NAME;
    String DESCR;
    String UNIT_TYPE;
    String AC_ID;
    String VSI_ID;
    String TC_BY;
    String VLAN;
    String VLAN_INNER;
    String VLAN_PRI;
    String Q_IN_Q;
    String PHBMAP_ID;
    String PHBMAP_TYPE;
    String AC_COUNT;
    String EXP;
    String PROT_PID;
    String POLICER_ID;
    String LAG_ID;
    String RG_ID;
    String COUNTER;
    String POLL_RATE;
    String REPORT;
    String NO_PACKET;
    String CREATION_DATE;
    String MODIFIED_DATE;

    public MPLS_AC(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.AID = fields[2];
        this.SERVICE_NAME = fields[3];
        this.DESCR = fields[4];
        this.UNIT_TYPE = fields[5];
        this.AC_ID = fields[6];
        this.VSI_ID = fields[7];
        this.TC_BY = fields[8];
        this.VLAN = fields[9];
        this.VLAN_INNER = fields[10];
        this.VLAN_PRI = fields[11];
        this.Q_IN_Q = fields[12];
        this.PHBMAP_ID = fields[13];
        this.PHBMAP_TYPE = fields[14];
        this.AC_COUNT = fields[15];
        this.EXP = fields[16];
        this.PROT_PID = fields[17];
        this.POLICER_ID = fields[18];
        this.LAG_ID = fields[19];
        this.RG_ID = fields[20];
        this.COUNTER = fields[21];
        this.POLL_RATE = fields[22];
        this.REPORT = fields[23];
        this.NO_PACKET = fields[24];
        this.CREATION_DATE = fields[25];
        this.MODIFIED_DATE = fields[26];
    }

    public MPLS_AC(String TID_ID, String TID, String AID, String SERVICE_NAME, String DESCR, String UNIT_TYPE, String AC_ID, String VSI_ID, String TC_BY, String VLAN, String VLAN_INNER, String VLAN_PRI, String q_IN_Q, String PHBMAP_ID, String PHBMAP_TYPE, String AC_COUNT, String EXP, String PROT_PID, String POLICER_ID, String LAG_ID, String RG_ID, String COUNTER, String POLL_RATE, String REPORT, String NO_PACKET, String CREATION_DATE, String MODIFIED_DATE) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.AID = AID;
        this.SERVICE_NAME = SERVICE_NAME;
        this.DESCR = DESCR;
        this.UNIT_TYPE = UNIT_TYPE;
        this.AC_ID = AC_ID;
        this.VSI_ID = VSI_ID;
        this.TC_BY = TC_BY;
        this.VLAN = VLAN;
        this.VLAN_INNER = VLAN_INNER;
        this.VLAN_PRI = VLAN_PRI;
        Q_IN_Q = q_IN_Q;
        this.PHBMAP_ID = PHBMAP_ID;
        this.PHBMAP_TYPE = PHBMAP_TYPE;
        this.AC_COUNT = AC_COUNT;
        this.EXP = EXP;
        this.PROT_PID = PROT_PID;
        this.POLICER_ID = POLICER_ID;
        this.LAG_ID = LAG_ID;
        this.RG_ID = RG_ID;
        this.COUNTER = COUNTER;
        this.POLL_RATE = POLL_RATE;
        this.REPORT = REPORT;
        this.NO_PACKET = NO_PACKET;
        this.CREATION_DATE = CREATION_DATE;
        this.MODIFIED_DATE = MODIFIED_DATE;
    }

    @Override
    public String toString() {
        return "MPLS_AC{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", SERVICE_NAME='" + SERVICE_NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", AC_ID='" + AC_ID + '\'' +
                ", VSI_ID='" + VSI_ID + '\'' +
                ", TC_BY='" + TC_BY + '\'' +
                ", VLAN='" + VLAN + '\'' +
                ", VLAN_INNER='" + VLAN_INNER + '\'' +
                ", VLAN_PRI='" + VLAN_PRI + '\'' +
                ", Q_IN_Q='" + Q_IN_Q + '\'' +
                ", PHBMAP_ID='" + PHBMAP_ID + '\'' +
                ", PHBMAP_TYPE='" + PHBMAP_TYPE + '\'' +
                ", AC_COUNT='" + AC_COUNT + '\'' +
                ", EXP='" + EXP + '\'' +
                ", PROT_PID='" + PROT_PID + '\'' +
                ", POLICER_ID='" + POLICER_ID + '\'' +
                ", LAG_ID='" + LAG_ID + '\'' +
                ", RG_ID='" + RG_ID + '\'' +
                ", COUNTER='" + COUNTER + '\'' +
                ", POLL_RATE='" + POLL_RATE + '\'' +
                ", REPORT='" + REPORT + '\'' +
                ", NO_PACKET='" + NO_PACKET + '\'' +
                ", CREATION_DATE='" + CREATION_DATE + '\'' +
                ", MODIFIED_DATE='" + MODIFIED_DATE + '\'' +
                '}';
    }
}
