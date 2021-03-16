package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Setter
@Getter
@Table(name="qkd_provider_node")

public class QkdProviderNode {
    @Id
    @GeneratedValue
    int QKD_NODE_ID;
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
    String QNC_WEB_API_URL;
    String QNC_WEB_API_AUTH;
    String INTERFACES;
    String NODE;
    String LOC_X;
    String LOC_Y;
    String LAT;
    String LONG;

    public QkdProviderNode() {
    }

    public QkdProviderNode(String KMS_ID, String KMS_NAME, String GROUP_ID, String GROUP_NAME, String ID, String UID, String NAME, String DESCRIPTION, String AGENT, String NETWORK, String QNC_WEB_API_URL, String QNC_WEB_API_AUTH, String INTERFACES, String NODE, String LOC_X, String LOC_Y, String LAT, String LONG) {
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
        this.QNC_WEB_API_URL = QNC_WEB_API_URL;
        this.QNC_WEB_API_AUTH = QNC_WEB_API_AUTH;
        this.INTERFACES = INTERFACES;
        this.NODE = NODE;
        this.LOC_X = LOC_X;
        this.LOC_Y = LOC_Y;
        this.LAT = LAT;
        this.LONG = LONG;
    }

    @Override
    public String toString() {
        return "QkdProviderNode{" +
                "KMS_ID='" + KMS_ID + '\'' +
                ", KMS_NAME='" + KMS_NAME + '\'' +
                ", GROUP_ID='" + GROUP_ID + '\'' +
                ", GROUP_NAME='" + GROUP_NAME + '\'' +
                ", ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", AGENT='" + AGENT + '\'' +
                ", NETWORK='" + NETWORK + '\'' +
                ", QNC_WEB_API_URL='" + QNC_WEB_API_URL + '\'' +
                ", QNC_WEB_API_AUTH='" + QNC_WEB_API_AUTH + '\'' +
                ", INTERFACES='" + INTERFACES + '\'' +
                ", NODE='" + NODE + '\'' +
                ", LOC_X='" + LOC_X + '\'' +
                ", LOC_Y='" + LOC_Y + '\'' +
                ", LAT='" + LAT + '\'' +
                ", LONG='" + LONG + '\'' +
                '}';
    }
}
