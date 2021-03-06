package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name = "qkd_service")
public class QkdService {
    @Id
    @GeneratedValue
    int qkdServiceId;
    String id;
    String uid;
    String name;
    @Lob
    String operMode;
    @Lob
    String source;
    @Lob
    String dest;
    @Lob
    String presharedKey;
    @Lob
    String qkeyStore;

    public QkdService() {
    }

    public QkdService(String id, String uid, String name, String operMode, String source, String dest, String presharedKey, String qkeyStore) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.operMode = operMode;
        this.source = source;
        this.dest = dest;
        this.presharedKey = presharedKey;
        this.qkeyStore = qkeyStore;
    }

    @Override
    public String toString() {
        return "QkdService{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", operMode='" + operMode + '\'' +
                ", source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", presharedKey='" + presharedKey + '\'' +
                ", qkeyStore='" + qkeyStore + '\'' +
                '}';
    }
}
