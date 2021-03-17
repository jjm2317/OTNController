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
    int qkdNodeId;
    String kmsId;
    String kmsName;
    String groupId;
    String groupName;
    String id;
    String uid;
    String name;
    String description;
    String agent;
    String network;
    String qncWebApiUrl;
    String qncWebApiAuth;
    String interfaces;
    String node;
    String locX;
    String locY;
    String lat;
    String longitude;

    public QkdProviderNode() {
    }

    public QkdProviderNode(String kmsId, String kmsName, String groupId, String groupName, String id, String uid, String name, String description, String agent, String network, String qncWebApiUrl, String qncWebApiAuth, String interfaces, String node, String locX, String locY, String lat, String longitude) {
        this.kmsId = kmsId;
        this.kmsName = kmsName;
        this.groupId = groupId;
        this.groupName = groupName;
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.agent = agent;
        this.network = network;
        this.qncWebApiUrl = qncWebApiUrl;
        this.qncWebApiAuth = qncWebApiAuth;
        this.interfaces = interfaces;
        this.node = node;
        this.locX = locX;
        this.locY = locY;
        this.lat = lat;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "QkdProviderNode{" +
                "kmsId='" + kmsId + '\'' +
                ", kmsName='" + kmsName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", agent='" + agent + '\'' +
                ", network='" + network + '\'' +
                ", qncWebApiUrl='" + qncWebApiUrl + '\'' +
                ", qncWebApiAuth='" + qncWebApiAuth + '\'' +
                ", interfaces='" + interfaces + '\'' +
                ", node='" + node + '\'' +
                ", locX='" + locX + '\'' +
                ", locY='" + locY + '\'' +
                ", lat='" + lat + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
