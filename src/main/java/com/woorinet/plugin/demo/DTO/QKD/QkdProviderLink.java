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
@Table(name="qkd_provider_link")
public class QkdProviderLink {
    @Id
    @GeneratedValue
    int qkdProviderLinkId;
    String id;
    String uid;
    String name;
    String mode;
    String source;
    String destination;
    String qkeyStore;

    public QkdProviderLink() {
    }

    public QkdProviderLink(String id, String uid, String name, String mode, String source, String destination, String qkeyStore) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.mode = mode;
        this.source = source;
        this.destination = destination;
        this.qkeyStore = qkeyStore;
    }

    @Override
    public String toString() {
        return "QkdProviderLink{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", qkeyStore='" + qkeyStore + '\'' +
                '}';
    }
}
