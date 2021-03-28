package com.woorinet.plugin.demo.DTO.TL1.PM;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@Table(name = "tl1_pm_ac")
public class Tl1PmAc {
    @Id
    @GeneratedValue
    int pmAcId;
    String tid;
    String systemType;
    String slot;
    String port;
    String time;
    String name;
    String ingPackets;
    String ingBytes;
    String ingRate;
    String egrPackets;
    String egrBytes;
    String egrRate;
    String date;
    String syncDate;


    public Tl1PmAc() {
    }

    public Tl1PmAc(String tid, String systemType, String slot, String port, String time, String name, String ingPackets, String ingBytes, String ingRate, String egrPackets, String egrBytes, String egrRate, String date, String syncDate) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.time = time;
        this.name = name;
        this.ingPackets = ingPackets;
        this.ingBytes = ingBytes;
        this.ingRate = ingRate;
        this.egrPackets = egrPackets;
        this.egrBytes = egrBytes;
        this.egrRate = egrRate;
        this.date = date;
        this.syncDate = syncDate;
    }

    public Tl1PmAc(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.systemType = fields[1];
        this.slot = fields[2];
        this.port = fields[3];
        this.time = fields[4];
        this.name = fields[5];
        this.ingPackets = fields[6];
        this.ingBytes = fields[7];
        this.ingRate= fields[8];
        this.egrPackets = fields[9];
        this.egrBytes = fields[10];
        this.egrRate = fields[11];
        this.date = fields[12];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1PmAc{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", ingPackets='" + ingPackets + '\'' +
                ", ingBytes='" + ingBytes + '\'' +
                ", ingRate='" + ingRate + '\'' +
                ", egrPackets='" + egrPackets + '\'' +
                ", egrBytes='" + egrBytes + '\'' +
                ", egrRate='" + egrRate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
