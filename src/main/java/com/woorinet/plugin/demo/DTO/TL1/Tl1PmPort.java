package com.woorinet.plugin.demo.DTO.TL1;


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
@Table(name = "tl1_pm_port")
public class Tl1PmPort {
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
    String inUnicastPackets;
    String inNonUnicastPackets;
    String inDiscardPackets;
    String inErrorPackets;
    String inBroadcastPackets;
    String inMulticastPackets;
    String inPackets64Octets;
    String inPackets65To127Octets;
    String inPackets128To255Octets;
    String inPackets256To511Octets;
    String inPackets512To1023Octets;
    String inPackets1024To1518Octets;
    String inPackets1519ToMaxOctets;
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
    String inNoPktSec;
    String outNoPktSec;
    String inLossRatio;
    String outLossRatio;
    String date;

    public Tl1PmPort() {

    }

    public Tl1PmPort(String tid, String systemType, String slot, String port, String time, String inOctets, String inOkPackets, String inUnicastPackets, String inNonUnicastPackets, String inDiscardPackets, String inErrorPackets, String inBroadcastPackets, String inMulticastPackets, String inPackets64Octets, String inPackets65To127Octets, String inPackets128To255Octets, String inPackets256To511Octets, String inPackets512To1023Octets, String inPackets1024To1518Octets, String inPackets1519ToMaxOctets, String inPausePackets, String inAlignmentErrors, String inFcsErrors, String inSymbolErrors, String outOctets, String outOkPackets, String outUnicastPackets, String outNonUnicastPackets, String outDiscardPackets, String outErrorPackets, String outBroadcastPackets, String outMulticastPackets, String outPausePackets, String inRate, String outRate, String inNoPktSec, String outNoPktSec, String inLossRatio, String outLossRatio, String date) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.time = time;
        this.inOctets = inOctets;
        this.inOkPackets = inOkPackets;
        this.inUnicastPackets = inUnicastPackets;
        this.inNonUnicastPackets = inNonUnicastPackets;
        this.inDiscardPackets = inDiscardPackets;
        this.inErrorPackets = inErrorPackets;
        this.inBroadcastPackets = inBroadcastPackets;
        this.inMulticastPackets = inMulticastPackets;
        this.inPackets64Octets = inPackets64Octets;
        this.inPackets65To127Octets = inPackets65To127Octets;
        this.inPackets128To255Octets = inPackets128To255Octets;
        this.inPackets256To511Octets = inPackets256To511Octets;
        this.inPackets512To1023Octets = inPackets512To1023Octets;
        this.inPackets1024To1518Octets = inPackets1024To1518Octets;
        this.inPackets1519ToMaxOctets = inPackets1519ToMaxOctets;
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
        this.inNoPktSec = inNoPktSec;
        this.outNoPktSec = outNoPktSec;
        this.inLossRatio = inLossRatio;
        this.outLossRatio = outLossRatio;
        this.date = date;
    }

    public Tl1PmPort(String []fields) {
        this.tid = fields[0];
        this.systemType = fields[1];
        this.slot = fields[2];
        this.port = fields[3];
        this.time = fields[4];
        this.inOctets = fields[5];
        this.inOkPackets = fields[6];
        this.inUnicastPackets = fields[7];
        this.inNonUnicastPackets = fields[8];
        this.inDiscardPackets = fields[9];
        this.inErrorPackets = fields[10];
        this.inBroadcastPackets = fields[11];
        this.inMulticastPackets = fields[12];
        this.inPackets64Octets = fields[13];
        this.inPackets65To127Octets = fields[14];
        this.inPackets128To255Octets = fields[15];
        this.inPackets256To511Octets = fields[16];
        this.inPackets512To1023Octets = fields[17];
        this.inPackets1024To1518Octets = fields[18];
        this.inPackets1519ToMaxOctets = fields[19];
        this.inPausePackets = fields[20];
        this.inAlignmentErrors = fields[21];
        this.inFcsErrors = fields[22];
        this.inSymbolErrors = fields[23];
        this.outOctets = fields[24];
        this.outOkPackets = fields[25];
        this.outUnicastPackets = fields[26];
        this.outNonUnicastPackets = fields[27];
        this.outDiscardPackets = fields[28];
        this.outErrorPackets = fields[29];
        this.outBroadcastPackets = fields[30];
        this.outMulticastPackets = fields[31];
        this.outPausePackets = fields[32];
        this.inRate = fields[33];
        this.outRate = fields[34];
        this.inNoPktSec = fields[35];
        this.outNoPktSec = fields[36];
        this.inLossRatio = fields[37];
        this.outLossRatio = fields[38];
        this.date = fields[39];
    }

    @Override
    public String toString() {
        return "Tl1PmPort{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", time='" + time + '\'' +
                ", inOctets='" + inOctets + '\'' +
                ", inOkPackets='" + inOkPackets + '\'' +
                ", inUnicastPackets='" + inUnicastPackets + '\'' +
                ", inNonUnicastPackets='" + inNonUnicastPackets + '\'' +
                ", inDiscardPackets='" + inDiscardPackets + '\'' +
                ", inErrorPackets='" + inErrorPackets + '\'' +
                ", inBroadcastPackets='" + inBroadcastPackets + '\'' +
                ", inMulticastPackets='" + inMulticastPackets + '\'' +
                ", inPackets64Octets='" + inPackets64Octets + '\'' +
                ", inPackets65To127Octets='" + inPackets65To127Octets + '\'' +
                ", inPackets128To255Octets='" + inPackets128To255Octets + '\'' +
                ", inPackets256To511Octets='" + inPackets256To511Octets + '\'' +
                ", inPackets512To1023Octets='" + inPackets512To1023Octets + '\'' +
                ", inPackets1024To1518Octets='" + inPackets1024To1518Octets + '\'' +
                ", inPackets1519ToMaxOctets='" + inPackets1519ToMaxOctets + '\'' +
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
                ", inNoPktSec='" + inNoPktSec + '\'' +
                ", outNoPktSec='" + outNoPktSec + '\'' +
                ", inLossRatio='" + inLossRatio + '\'' +
                ", outLossRatio='" + outLossRatio + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
