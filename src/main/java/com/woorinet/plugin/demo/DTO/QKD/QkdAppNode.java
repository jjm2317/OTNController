package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name="qkd_app_node")
public class QkdAppNode {
    @Id
    @GeneratedValue
    int qkdAppNodeId;
    String level;
    String kmsId;
    String kmsName;
    String groupId;
    String groupName;
    String id;
    String uid;
    String name;
    String description;
    @Lob
    String agent;
    @Lob
    String network;
    @Lob
    String interfaces;
    String locX;
    String locY;
    String lat;
    String longitude;

    public QkdAppNode() {
    }

    public QkdAppNode(String level, String kmsId, String kmsName, String groupId, String groupName, String id, String uid, String name, String description, String agent, String network, String interfaces, String locX, String locY, String lat, String longitude) {
        this.level = level;
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
        this.interfaces = interfaces;
        this.locX = locX;
        this.locY = locY;
        this.lat = lat;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "QkdAppNode{" +
                "level='" + level + '\'' +
                ", kmsId='" + kmsId + '\'' +
                ", kmsName='" + kmsName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", agent='" + agent + '\'' +
                ", network='" + network + '\'' +
                ", interfaces='" + interfaces + '\'' +
                ", locX='" + locX + '\'' +
                ", locY='" + locY + '\'' +
                ", lat='" + lat + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
