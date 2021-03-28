package com.woorinet.plugin.demo.DTO.TL1.PM;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name = "tl1_pm")
public class Tl1Pm {
    @Id
    @GeneratedValue
    int pmId;
    String tid;
    String systemType;
    String slot;
    String port;
    String signal;
    String time;
    String inErrorPackets;
    String es;
    String ses;
    String uas;
    String inDiscardPackets;
    String outErrorPackets;
    String outDiscardPackets;
    String date;
    String syncDate;

    public Tl1Pm() {
    }

    public Tl1Pm(String tid, String systemType, String slot, String port, String signal, String time, String inErrorPackets, String es, String ses, String uas, String inDiscardPackets, String outErrorPackets, String outDiscardPackets, String date) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.signal = signal;
        this.time = time;
        this.inErrorPackets = inErrorPackets;
        this.es = es;
        this.ses = ses;
        this.uas = uas;
        this.inDiscardPackets = inDiscardPackets;
        this.outErrorPackets = outErrorPackets;
        this.outDiscardPackets = outDiscardPackets;
        this.date = date;
        this.syncDate = syncDate;
    }

    public Tl1Pm(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.systemType = fields[1];
        this.slot = fields[2];
        this.port  = fields[3];
        this.signal = fields[4];
        this.time = fields[5];
        this.inErrorPackets = fields[6];
        this.es = fields[7];
        this.ses = fields[8];
        this.uas = fields[9];
        this.inDiscardPackets  = fields[10];
        this.outErrorPackets = fields[11];
        this.outDiscardPackets = fields[12];
        this.date = fields[13];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Pm{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", signal='" + signal + '\'' +
                ", time='" + time + '\'' +
                ", inErrorPackets='" + inErrorPackets + '\'' +
                ", es='" + es + '\'' +
                ", ses='" + ses + '\'' +
                ", uas='" + uas + '\'' +
                ", inDiscardPackets='" + inDiscardPackets + '\'' +
                ", outErrorPackets='" + outErrorPackets + '\'' +
                ", outDiscardPackets='" + outDiscardPackets + '\'' +
                ", date='" + date + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
