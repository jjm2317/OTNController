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
    int cesPortId;
    String tid;
    String aid;
    String unitType;
    String struct;
    String frame;
    String cas;
    String clkRec;
    String inService;
    String ds0SlotCount;
    String aug;
    String au;
    String tug;
    String syncDate;

    public Tl1CesPort() {

    }

    public Tl1CesPort(String tid, String aid, String unitType, String struct, String frame, String cas, String clkRec, String inService, String ds0SlotCount, String aug, String au, String tug, String syncDate) {
        this.tid = tid;
        this.aid = aid;
        this.unitType = unitType;
        this.struct = struct;
        this.frame = frame;
        this.cas = cas;
        this.clkRec = clkRec;
        this.inService = inService;
        this.ds0SlotCount = ds0SlotCount;
        this.aug = aug;
        this.au = au;
        this.tug = tug;
        this.syncDate = syncDate;
    }

    public Tl1CesPort(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.aid = fields[1];
        this.unitType = fields[2];
        this.struct = fields[3];
        this.frame = fields[4];
        this.cas = fields[5];
        this.clkRec = fields[6];
        this.inService = fields[7];
        this.ds0SlotCount = fields[8];
        this.aug = fields[9];
        this.au = fields[10];
        this.tug = fields[11];
    }

    @Override
    public String toString() {
        return "Tl1CesPort{" +
                "tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", unitType='" + unitType + '\'' +
                ", struct='" + struct + '\'' +
                ", frame='" + frame + '\'' +
                ", cas='" + cas + '\'' +
                ", clkRec='" + clkRec + '\'' +
                ", inService='" + inService + '\'' +
                ", ds0SlotCount='" + ds0SlotCount + '\'' +
                ", aug='" + aug + '\'' +
                ", au='" + au + '\'' +
                ", tug='" + tug + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
