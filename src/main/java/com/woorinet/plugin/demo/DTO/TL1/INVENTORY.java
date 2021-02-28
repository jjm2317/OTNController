package com.woorinet.plugin.demo.DTO.TL1;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Data
@Table(name = "TL1_INVENTORY")
public class INVENTORY {

    @Id
    @Generated
    String TID;
    String UNIT_TYPE;
    String VENDOR;
    String DAT;
    String SERIAL_NU;

    public INVENTORY() {
    }

    public INVENTORY(String TID, String UNIT_TYPE, String VENDOR, String DAT, String SERIAL_NU) {
        this.TID = TID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.VENDOR = VENDOR;
        this.DAT = DAT;
        this.SERIAL_NU = SERIAL_NU;
    }

    public INVENTORY(String[] fields) {
        this.TID = fields[0];
        this.UNIT_TYPE = fields[1];
        this.VENDOR = fields[2];
        this.DAT = fields[3];
        this.SERIAL_NU = fields[4];
    }

    @Override
    public String toString() {
        return "INVENTORY{" +
                "TID='" + TID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", VENDOR='" + VENDOR + '\'' +
                ", DAT='" + DAT + '\'' +
                ", SERIAL_NU='" + SERIAL_NU + '\'' +
                '}';
    }
}
