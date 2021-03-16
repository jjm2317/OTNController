package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Setter
@Getter
@Table(name="qkd_node")
public class QkdNode {
    @Id
    @GeneratedValue
    int KMS_NODE_ID;
    String ID;
    String UID;
    String NAME;
    String ENABLED;
    String DESCRIPTION;
    String GROUP_ID;
    String GROUP;
    String UNIQUE_ID;
    String QNC_WEB_API_URL;
    String QNC_WEB_API_AUTH;
    String CERT;
    String KEMS_CERT;
    String NETWORK;
    @Lob
    String CONSUMERS;
    @Lob
    String PROVIDERS;
    String LOC_X;
    String LOC_Y;

    public QkdNode() {
    }

    public QkdNode(String ID, String UID, String NAME, String ENABLED, String DESCRIPTION, String GROUP_ID, String GROUP, String UNIQUE_ID, String QNC_WEB_API_URL, String QNC_WEB_API_AUTH, String CERT, String KEMS_CERT, String NETWORK, String CONSUMERS, String PROVIDERS, String LOC_X, String LOC_Y) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.ENABLED = ENABLED;
        this.DESCRIPTION = DESCRIPTION;
        this.GROUP_ID = GROUP_ID;
        this.GROUP = GROUP;
        this.UNIQUE_ID = UNIQUE_ID;
        this.QNC_WEB_API_URL = QNC_WEB_API_URL;
        this.QNC_WEB_API_AUTH = QNC_WEB_API_AUTH;
        this.CERT = CERT;
        this.KEMS_CERT = KEMS_CERT;
        this.NETWORK = NETWORK;
        this.CONSUMERS = CONSUMERS;
        this.PROVIDERS = PROVIDERS;
        this.LOC_X = LOC_X;
        this.LOC_Y = LOC_Y;
    }

    @Override
    public String toString() {
        return "QkdNode{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ENABLED='" + ENABLED + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", GROUP_ID='" + GROUP_ID + '\'' +
                ", GROUP='" + GROUP + '\'' +
                ", UNIQUE_ID='" + UNIQUE_ID + '\'' +
                ", QNC_WEB_API_URL='" + QNC_WEB_API_URL + '\'' +
                ", QNC_WEB_API_AUTH='" + QNC_WEB_API_AUTH + '\'' +
                ", CERT='" + CERT + '\'' +
                ", KEMS_CERT='" + KEMS_CERT + '\'' +
                ", NETWORK='" + NETWORK + '\'' +
                ", CONSUMERS='" + CONSUMERS + '\'' +
                ", PROVIDERS='" + PROVIDERS + '\'' +
                ", LOC_X='" + LOC_X + '\'' +
                ", LOC_Y='" + LOC_Y + '\'' +
                '}';
    }
}
