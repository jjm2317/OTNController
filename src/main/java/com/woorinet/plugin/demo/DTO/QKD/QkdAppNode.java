package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Setter
@Getter
@Table

public class QkdAppNode {
    @Id
    @GeneratedValue
    int QKD_APP_NODE_ID;
    String LEVEL;
    String KMS_ID;
    String KMS_NAME;
    String GROUP_ID;
    String GROUP_NAME;
    String ID;
    String UID;
    String NAME;
    String DESCRIPTION;
    String AGENT;
    String NETWORK;
    String INTERFACES;
    String LOC_X;
    String LOC_Y;
    String LAT;
    String LONG;

    public QkdAppNode() {
    }

    public QkdAppNode(String LEVEL, String KMS_ID, String KMS_NAME, String GROUP_ID, String GROUP_NAME, String ID, String UID, String NAME, String DESCRIPTION, String AGENT, String NETWORK, String INTERFACES, String LOC_X, String LOC_Y, String LAT, String LONG) {
        this.LEVEL = LEVEL;
        this.KMS_ID = KMS_ID;
        this.KMS_NAME = KMS_NAME;
        this.GROUP_ID = GROUP_ID;
        this.GROUP_NAME = GROUP_NAME;
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.AGENT = AGENT;
        this.NETWORK = NETWORK;
        this.INTERFACES = INTERFACES;
        this.LOC_X = LOC_X;
        this.LOC_Y = LOC_Y;
        this.LAT = LAT;
        this.LONG = LONG;
    }

    @Override
    public String toString() {
        return "QkdAppNode{" +
                "LEVEL='" + LEVEL + '\'' +
                ", KMS_ID='" + KMS_ID + '\'' +
                ", KMS_NAME='" + KMS_NAME + '\'' +
                ", GROUP_ID='" + GROUP_ID + '\'' +
                ", GROUP_NAME='" + GROUP_NAME + '\'' +
                ", ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", AGENT='" + AGENT + '\'' +
                ", NETWORK='" + NETWORK + '\'' +
                ", INTERFACES='" + INTERFACES + '\'' +
                ", LOC_X='" + LOC_X + '\'' +
                ", LOC_Y='" + LOC_Y + '\'' +
                ", LAT='" + LAT + '\'' +
                ", LONG='" + LONG + '\'' +
                '}';
    }
}
