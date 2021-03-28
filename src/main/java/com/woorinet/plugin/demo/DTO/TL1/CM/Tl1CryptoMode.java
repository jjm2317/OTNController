package com.woorinet.plugin.demo.DTO.TL1.CM;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name = "tl1_crypto_mode")
public class Tl1CryptoMode {
    @Id
    @GeneratedValue
    int cryptoModeId;
    String tid;
    String subnetwork;
    String aid;
    String unitType;
    String mode;
    String syncDate;

    public Tl1CryptoMode() {
    }

    public Tl1CryptoMode(String tid, String subnetwork, String aid, String unitType, String mode) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.unitType = unitType;
        this.mode = mode;
    }

    public Tl1CryptoMode(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.unitType = fields[3];
        this.mode = fields[4];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1CryptoMode{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", unitType='" + unitType + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
