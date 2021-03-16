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
    int QKD_LINK_ID;
    String ID;
    String NAME;
    String UID;
    @Lob
    String TYPE;
    @Lob
    String ALGORITHM;
    String WEIGHT;
    @Lob
    String PSK;
    @Lob
    String SOURCE;
    @Lob
    String DEST;


    public QkdLink() {
    }

    public QkdLink(String ID, String NAME, String UID, String TYPE, String ALGORITHM, String WEIGHT, String PSK, String SOURCE, String DEST) {
        this.ID = ID;
        this.NAME = NAME;
        this.UID = UID;
        this.TYPE = TYPE;
        this.ALGORITHM = ALGORITHM;
        this.WEIGHT = WEIGHT;
        this.PSK = PSK;
        this.SOURCE = SOURCE;
        this.DEST = DEST;
    }

    @Override
    public String toString() {
        return "QkdLink{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", UID='" + UID + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", ALGORITHM='" + ALGORITHM + '\'' +
                ", WEIGHT='" + WEIGHT + '\'' +
                ", PSK='" + PSK + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DEST='" + DEST + '\'' +
                '}';
    }
}
