package com.woorinet.plugin.demo.DTO.OTN.PM;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name="otn_pm")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPm {
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

    public OtnPm(String tid, String systemType, String slot, String port, String signal, String time, String inErrorPackets, String es, String ses, String uas, String inDiscardPackets, String outErrorPackets, String outDiscardPackets, String date) {
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
    }

    @Override
    public String toString() {
        return "OtnPm{" +
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
                '}';
    }
}
