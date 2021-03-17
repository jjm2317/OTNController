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
    int qkdNodeId;
    String id;
    String uid;
    String name;
    String enabled;
    String description;
    String groupId;
    String group;
    String uniqueId;
    String qncWebApiUrl;
    String qncWebApiAuth;
    String cert;
    String kemsCert;
    String network;
    @Lob
    String consumers;
    @Lob
    String providers;
    String locX;
    String locY;

    public QkdNode() {
    }

    public QkdNode(String id, String uid, String name, String enabled, String description, String groupId, String group, String uniqueId, String qncWebApiUrl, String qncWebApiAuth, String cert, String kemsCert, String network, String consumers, String providers, String locX, String locY) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.enabled = enabled;
        this.description = description;
        this.groupId = groupId;
        this.group = group;
        this.uniqueId = uniqueId;
        this.qncWebApiUrl = qncWebApiUrl;
        this.qncWebApiAuth = qncWebApiAuth;
        this.cert = cert;
        this.kemsCert = kemsCert;
        this.network = network;
        this.consumers = consumers;
        this.providers = providers;
        this.locX = locX;
        this.locY = locY;
    }

    @Override
    public String toString() {
        return "QkdNode{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", enabled='" + enabled + '\'' +
                ", description='" + description + '\'' +
                ", groupId='" + groupId + '\'' +
                ", group='" + group + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", qncWebApiUrl='" + qncWebApiUrl + '\'' +
                ", qncWebApiAuth='" + qncWebApiAuth + '\'' +
                ", cert='" + cert + '\'' +
                ", kemsCert='" + kemsCert + '\'' +
                ", network='" + network + '\'' +
                ", consumers='" + consumers + '\'' +
                ", providers='" + providers + '\'' +
                ", locX='" + locX + '\'' +
                ", locY='" + locY + '\'' +
                '}';
    }
}
