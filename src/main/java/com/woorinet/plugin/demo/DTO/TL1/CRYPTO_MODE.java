package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Data
@Entity
public class CRYPTO_MODE {
    @Id
    @Generated
    String CRYPTO_MODE_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String UNIT_TYPE;
    String MODE;

    public CRYPTO_MODE() {
    }

    public CRYPTO_MODE(String TID, String SUBNETWORK, String AID, String UNIT_TYPE, String MODE) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.MODE = MODE;
    }

    public CRYPTO_MODE(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.UNIT_TYPE = fields[3];
        this.MODE = fields[4];
    }


    @Override
    public String toString() {
        return "CRYPTO_MODE{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", MODE='" + MODE + '\'' +
                '}';
    }
}
