package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name = "qkd_link")
public class QkdLink {
    @Id
    @GeneratedValue
    int qkdLinkId;
    String id;
    String name;
    String uid;
    @Lob
    String type;
    @Lob
    String algorithm;
    String weight;
    @Lob
    String psk;
    @Lob
    String source;
    @Lob
    String dest;


    public QkdLink() {
    }

    public QkdLink(String id, String name, String uid, String type, String algorithm, String weight, String psk, String source, String dest) {
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.type = type;
        this.algorithm = algorithm;
        this.weight = weight;
        this.psk = psk;
        this.source = source;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "QkdLink{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", type='" + type + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", weight='" + weight + '\'' +
                ", psk='" + psk + '\'' +
                ", source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
