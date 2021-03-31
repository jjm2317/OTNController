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
@Table(name="otn_pm_port")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPmPort {
    @Id
    @GeneratedValue
    int pmPortId;
    String tid;
    String systemType;
    String slot;
    String port;
    String time;
    String inOctets;
    String inOkPackets;
    String inDiscardPackets;
    String inErrorPackets;
    String inPausePackets;
    String inAlignmentErrors;
    String inFcsErrors;
    String inSymbolErrors;
    String outOctets;
    String outOkPackets;
    String outUnicastPackets;
    String outNonUnicastPackets;
    String outDiscardPackets;
    String outErrorPackets;
    String outBroadcastPackets;
    String outMulticastPackets;
    String outPausePackets;
    String inRate;
    String outRate;
    String inLossRatio;
    String outLossRatio;
    String date;
    String syncDate;

    public OtnPmPort() {

    }

    public OtnPmPort(String tid, String systemType, String slot, String port, String time, String inOctets, String inOkPackets, String inDiscardPackets, String inErrorPackets, String inPausePackets, String inAlignmentErrors, String inFcsErrors, String inSymbolErrors, String outOctets, String outOkPackets, String outUnicastPackets, String outNonUnicastPackets, String outDiscardPackets, String outErrorPackets, String outBroadcastPackets, String outMulticastPackets, String outPausePackets, String inRate, String outRate, String inLossRatio, String outLossRatio, String date, String syncDate) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.time = time;
        this.inOctets = inOctets;
        this.inOkPackets = inOkPackets;
        this.inDiscardPackets = inDiscardPackets;
        this.inErrorPackets = inErrorPackets;
        this.inPausePackets = inPausePackets;
        this.inAlignmentErrors = inAlignmentErrors;
        this.inFcsErrors = inFcsErrors;
        this.inSymbolErrors = inSymbolErrors;
        this.outOctets = outOctets;
        this.outOkPackets = outOkPackets;
        this.outUnicastPackets = outUnicastPackets;
        this.outNonUnicastPackets = outNonUnicastPackets;
        this.outDiscardPackets = outDiscardPackets;
        this.outErrorPackets = outErrorPackets;
        this.outBroadcastPackets = outBroadcastPackets;
        this.outMulticastPackets = outMulticastPackets;
        this.outPausePackets = outPausePackets;
        this.inRate = inRate;
        this.outRate = outRate;
        this.inLossRatio = inLossRatio;
        this.outLossRatio = outLossRatio;
        this.date = date;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnPmPort{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", time='" + time + '\'' +
                ", inOctets='" + inOctets + '\'' +
                ", inOkPackets='" + inOkPackets + '\'' +
                ", inDiscardPackets='" + inDiscardPackets + '\'' +
                ", inErrorPackets='" + inErrorPackets + '\'' +
                ", inPausePackets='" + inPausePackets + '\'' +
                ", inAlignmentErrors='" + inAlignmentErrors + '\'' +
                ", inFcsErrors='" + inFcsErrors + '\'' +
                ", inSymbolErrors='" + inSymbolErrors + '\'' +
                ", outOctets='" + outOctets + '\'' +
                ", outOkPackets='" + outOkPackets + '\'' +
                ", outUnicastPackets='" + outUnicastPackets + '\'' +
                ", outNonUnicastPackets='" + outNonUnicastPackets + '\'' +
                ", outDiscardPackets='" + outDiscardPackets + '\'' +
                ", outErrorPackets='" + outErrorPackets + '\'' +
                ", outBroadcastPackets='" + outBroadcastPackets + '\'' +
                ", outMulticastPackets='" + outMulticastPackets + '\'' +
                ", outPausePackets='" + outPausePackets + '\'' +
                ", inRate='" + inRate + '\'' +
                ", outRate='" + outRate + '\'' +
                ", inLossRatio='" + inLossRatio + '\'' +
                ", outLossRatio='" + outLossRatio + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}