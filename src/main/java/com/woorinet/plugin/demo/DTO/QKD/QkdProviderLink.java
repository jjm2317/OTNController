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
@Table

public class QkdProviderLink {
    @Id
    @GeneratedValue
    int QKD_PROVIDER_LINK_ID;
    String ID;
    String UID;
    String NAME;
    String MODE;
    String SOURCE;
    String DESTINATION;
    String Q_KEY_STORE;

    public QkdProviderLink() {
    }

    public QkdProviderLink(String ID, String UID, String NAME, String MODE, String SOURCE, String DESTINATION, String q_KEY_STORE) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.MODE = MODE;
        this.SOURCE = SOURCE;
        this.DESTINATION = DESTINATION;
        Q_KEY_STORE = q_KEY_STORE;
    }

    @Override
    public String toString() {
        return "QkdProviderLink{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", MODE='" + MODE + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DESTINATION='" + DESTINATION + '\'' +
                ", Q_KEY_STORE='" + Q_KEY_STORE + '\'' +
                '}';
    }
}
