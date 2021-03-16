package com.woorinet.plugin.demo.DTO.KMS;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Setter
@Getter

public class KmsNode {
    @Id
    @GeneratedValue
    int KMS_NODE_ID;
    String ID;
    String UID;
    String NAME;
    String ENABLED;
    String DESCRIPTION;
    String GROUP_ID;
    String QNC_WEB_API_URL;
    String QNC_WEB_APIAUTH;
    String CERT;
    String KEMS_CERT;
    String NETWORK;
    String CONSUMERS;
    String PROVIDERS;
    String LOC_X;
    String LOC_Y;

    public KmsNode() {
    }

    public KmsNode(String ID, String UID, String NAME, String ENABLED, String DESCRIPTION, String GROUP_ID, String QNC_WEB_API_URL, String QNC_WEB_APIAUTH, String CERT, String KEMS_CERT, String NETWORK, String CONSUMERS, String PROVIDERS, String LOC_X, String LOC_Y) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.ENABLED = ENABLED;
        this.DESCRIPTION = DESCRIPTION;
        this.GROUP_ID = GROUP_ID;
        this.QNC_WEB_API_URL = QNC_WEB_API_URL;
        this.QNC_WEB_APIAUTH = QNC_WEB_APIAUTH;
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
        return "KmsNode{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ENABLED='" + ENABLED + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", GROUP_ID='" + GROUP_ID + '\'' +
                ", QNC_WEB_API_URL='" + QNC_WEB_API_URL + '\'' +
                ", QNC_WEB_APIAUTH='" + QNC_WEB_APIAUTH + '\'' +
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
