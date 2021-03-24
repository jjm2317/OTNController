package com.woorinet.plugin.demo.DTO.TL1;


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
@Table(name = "tl1_pm_pw")
public class Tl1PmPw {
    @Id
    @GeneratedValue
    int pmPwId;
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

    public Tl1PmPw() {
    }

    public Tl1PmPw(String tid, String systemType, String slot, String port, String time, String name, String ingPackets, String ingBytes, String ingRate, String egrPackets, String egrBytes, String egrRate, String date) {
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
    }

    public Tl1PmPw(String[] fields) {
        this.tid = fields[0];
        this.systemType = fields[1];
        this.slot = fields[2];
        this.port = fields[3];
        this.time = fields[4];
        this.name = fields[5];
        this.ingPackets = fields[6];
        this.ingBytes = fields[7];
        this.ingRate = fields[8];
        this.egrPackets = fields[9];
        this.egrBytes = fields[10];
        this.egrRate = fields[11];
        this.date = fields[12];
    }

    @Override
    public String toString() {
        return "Tl1PmPw{" +
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
