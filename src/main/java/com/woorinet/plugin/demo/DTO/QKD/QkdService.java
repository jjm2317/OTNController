package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name="qkd_service")
public class QkdService {
    @Id
    @GeneratedValue
    int QKD_SERVICE_ID;
    String ID;
    String UID;
    String NAME;
    @Lob
    String OPER_MODE;
    @Lob
    String SOURCE;
    @Lob
    String DEST;
    @Lob
    String PRESHARED_KEY;
    @Lob
    String QKEY_STORE;

    public QkdService() {
    }

    public QkdService(String ID, String UID, String NAME, String OPER_MODE, String SOURCE, String DEST, String PRESHARED_KEY, String QKEY_STORE) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.OPER_MODE = OPER_MODE;
        this.SOURCE = SOURCE;
        this.DEST = DEST;
        this.PRESHARED_KEY = PRESHARED_KEY;
        this.QKEY_STORE = QKEY_STORE;
    }

    @Override
    public String toString() {
        return "QkdService{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", OPER_MODE='" + OPER_MODE + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DEST='" + DEST + '\'' +
                ", PRESHARED_KEY='" + PRESHARED_KEY + '\'' +
                ", QKEY_STORE='" + QKEY_STORE + '\'' +
                '}';
    }
}
