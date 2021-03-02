package com.woorinet.plugin.demo.DTO.TL1;

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
@Table(name = "tl1_ces_port")
public class Tl1CesPort {
    @Id
    @GeneratedValue
    int CES_PORT_ID;
    String TID;
    String AID;
    String UNIT_TYPE;
    String STRUCT;
    String FRAME;
    String CAS;
    String CLK_REC;
    String IN_SERVICE;
    String DS0_SLOT_COUNT;
    String AUG;
    String AU;
    String TUG;

    public Tl1CesPort() {

    }

    public Tl1CesPort(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.UNIT_TYPE = fields[2];
        this.STRUCT = fields[3];
        this.FRAME = fields[4];
        this.CAS = fields[5];
        this.CLK_REC = fields[6];
        this.IN_SERVICE = fields[7];
        this.DS0_SLOT_COUNT = fields[8];
        this.AUG = fields[9];
        this.AU = fields[10];
        this.TUG = fields[11];
    }

    @Override
    public String toString() {
        return "CES_PORT{" +
                "TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", STRUCT='" + STRUCT + '\'' +
                ", FRAME='" + FRAME + '\'' +
                ", CAS='" + CAS + '\'' +
                ", CLK_REC='" + CLK_REC + '\'' +
                ", IN_SERVICE='" + IN_SERVICE + '\'' +
                ", DS0_SLOT_COUNT='" + DS0_SLOT_COUNT + '\'' +
                ", AUG='" + AUG + '\'' +
                ", AU='" + AU + '\'' +
                ", TUG='" + TUG + '\'' +
                '}';
    }
}
