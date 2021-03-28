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
@Table(name = "tl1_stunnel_ext")
public class Tl1StunnelExt {
    @Id
    @GeneratedValue
    int stunnelExtId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String name;
    String descr;
    String tuId;
    String protection;
    String activePathStatus;
    String ingSubnet;
    String ingTid;
    String ingTidId;
    String ingLsrid;
    String egrSubnet;
    String egrTid;
    String egrTidId;
    String egrLsrid;
    String role;
    String direction;
    String fromSubnet;
    String fromTidId;
    String fromTid;
    String fromPort;
    String fromInLabel;
    String fromOutLabel;
    String toSubnet;
    String toTidId;
    String toTid;
    String toPort;
    String toInLabel;
    String toOutLabel;
    String qmapId;
    String phbId;
    String exp;
    String useBw;
    String autoBw;
    String cir;
    String pir;
    String cir6;
    String pir6;
    String cir5;
    String pir5;
    String cir4;
    String pir4;
    String cir3;
    String pir3;
    String cir2;
    String pir2;
    String cir1;
    String pir1;
    String oamId;
    String protId;
    String counter;
    String lmCounter;
    String pollRate;
    String report;
    String noPacket;
    String createDate;
    String modifiDate;
    String syncDate;

    public Tl1StunnelExt() {

    }

    public Tl1StunnelExt(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.name = fields[4];
        this.descr = fields[5];
        this.tuId = fields[6];
        this.protection = fields[7];
        this.activePathStatus = fields[8];
        this.ingSubnet = fields[9];
        this.ingTid = fields[10];
        this.ingTidId = fields[11];
        this.ingLsrid = fields[12];
        this.egrSubnet = fields[13];
        this.egrTid = fields[14];
        this.egrTidId = fields[15];
        this.egrLsrid = fields[16];
        this.role = fields[17];
        this.direction = fields[18];
        this.fromSubnet = fields[19];
        this.fromTidId = fields[20];
        this.fromTid = fields[21];
        this.fromPort = fields[22];
        this.fromInLabel = fields[23];
        this.fromOutLabel = fields[24];
        this.toSubnet = fields[25];
        this.toTidId = fields[26];
        this.toTid = fields[27];
        this.toPort = fields[28];
        this.toInLabel = fields[29];
        this.toOutLabel = fields[30];
        this.qmapId = fields[31];
        this.phbId = fields[32];
        this.exp = fields[33];
        this.useBw = fields[34];
        this.autoBw = fields[35];
        this.cir = fields[36];
        this.pir = fields[37];
        this.cir6 = fields[38];
        this.pir6 = fields[39];
        this.cir5 = fields[40];
        this.pir5 = fields[41];
        this.cir4 = fields[42];
        this.pir4 = fields[43];
        this.cir3 = fields[44];
        this.pir3 = fields[45];
        this.cir2 = fields[46];
        this.pir2 = fields[47];
        this.cir1 = fields[48];
        this.pir1 = fields[49];
        this.oamId = fields[50];
        this.protId = fields[51];
        this.counter = fields[52];
        this.lmCounter = fields[53];
        this.pollRate = fields[54];
        this.report = fields[55];
        this.noPacket = fields[56];
        this.createDate = fields[57];
        this.modifiDate = fields[58];
        this.syncDate = syncDate;
    }

    public Tl1StunnelExt(String tidId, String tid, String subnetId, String subnet, String name, String descr, String tuId, String protection, String activePathStatus, String ingSubnet, String ingTid, String ingTidId, String ingLsrid, String egrSubnet, String egrTid, String egrTidId, String egrLsrid, String role, String direction, String fromSubnet, String fromTidId, String fromTid, String fromPort, String fromInLabel, String fromOutLabel, String toSubnet, String toTidId, String toTid, String toPort, String toInLabel, String toOutLabel, String qmapId, String phbId, String exp, String useBw, String autoBw, String cir, String pir, String cir6, String pir6, String cir5, String pir5, String cir4, String pir4, String cir3, String pir3, String cir2, String pir2, String cir1, String pir1, String oamId, String protId, String counter, String lmCounter, String pollRate, String report, String noPacket, String createDate, String modifiDate, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.name = name;
        this.descr = descr;
        this.tuId = tuId;
        this.protection = protection;
        this.activePathStatus = activePathStatus;
        this.ingSubnet = ingSubnet;
        this.ingTid = ingTid;
        this.ingTidId = ingTidId;
        this.ingLsrid = ingLsrid;
        this.egrSubnet = egrSubnet;
        this.egrTid = egrTid;
        this.egrTidId = egrTidId;
        this.egrLsrid = egrLsrid;
        this.role = role;
        this.direction = direction;
        this.fromSubnet = fromSubnet;
        this.fromTidId = fromTidId;
        this.fromTid = fromTid;
        this.fromPort = fromPort;
        this.fromInLabel = fromInLabel;
        this.fromOutLabel = fromOutLabel;
        this.toSubnet = toSubnet;
        this.toTidId = toTidId;
        this.toTid = toTid;
        this.toPort = toPort;
        this.toInLabel = toInLabel;
        this.toOutLabel = toOutLabel;
        this.qmapId = qmapId;
        this.phbId = phbId;
        this.exp = exp;
        this.useBw = useBw;
        this.autoBw = autoBw;
        this.cir = cir;
        this.pir = pir;
        this.cir6 = cir6;
        this.pir6 = pir6;
        this.cir5 = cir5;
        this.pir5 = pir5;
        this.cir4 = cir4;
        this.pir4 = pir4;
        this.cir3 = cir3;
        this.pir3 = pir3;
        this.cir2 = cir2;
        this.pir2 = pir2;
        this.cir1 = cir1;
        this.pir1 = pir1;
        this.oamId = oamId;
        this.protId = protId;
        this.counter = counter;
        this.lmCounter = lmCounter;
        this.pollRate = pollRate;
        this.report = report;
        this.noPacket = noPacket;
        this.createDate = createDate;
        this.modifiDate = modifiDate;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1StunnelExt{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", tuId='" + tuId + '\'' +
                ", protection='" + protection + '\'' +
                ", activePathStatus='" + activePathStatus + '\'' +
                ", ingSubnet='" + ingSubnet + '\'' +
                ", ingTid='" + ingTid + '\'' +
                ", ingTidId='" + ingTidId + '\'' +
                ", ingLsrid='" + ingLsrid + '\'' +
                ", egrSubnet='" + egrSubnet + '\'' +
                ", egrTid='" + egrTid + '\'' +
                ", egrTidId='" + egrTidId + '\'' +
                ", egrLsrid='" + egrLsrid + '\'' +
                ", role='" + role + '\'' +
                ", direction='" + direction + '\'' +
                ", fromSubnet='" + fromSubnet + '\'' +
                ", fromTidId='" + fromTidId + '\'' +
                ", fromTid='" + fromTid + '\'' +
                ", fromPort='" + fromPort + '\'' +
                ", fromInLabel='" + fromInLabel + '\'' +
                ", fromOutLabel='" + fromOutLabel + '\'' +
                ", toSubnet='" + toSubnet + '\'' +
                ", toTidId='" + toTidId + '\'' +
                ", toTid='" + toTid + '\'' +
                ", toPort='" + toPort + '\'' +
                ", toInLabel='" + toInLabel + '\'' +
                ", toOutLabel='" + toOutLabel + '\'' +
                ", qmapId='" + qmapId + '\'' +
                ", phbId='" + phbId + '\'' +
                ", exp='" + exp + '\'' +
                ", useBw='" + useBw + '\'' +
                ", autoBw='" + autoBw + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", cir6='" + cir6 + '\'' +
                ", pir6='" + pir6 + '\'' +
                ", cir5='" + cir5 + '\'' +
                ", pir5='" + pir5 + '\'' +
                ", cir4='" + cir4 + '\'' +
                ", pir4='" + pir4 + '\'' +
                ", cir3='" + cir3 + '\'' +
                ", pir3='" + pir3 + '\'' +
                ", cir2='" + cir2 + '\'' +
                ", pir2='" + pir2 + '\'' +
                ", cir1='" + cir1 + '\'' +
                ", pir1='" + pir1 + '\'' +
                ", oamId='" + oamId + '\'' +
                ", protId='" + protId + '\'' +
                ", counter='" + counter + '\'' +
                ", lmCounter='" + lmCounter + '\'' +
                ", pollRate='" + pollRate + '\'' +
                ", report='" + report + '\'' +
                ", noPacket='" + noPacket + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifiDate='" + modifiDate + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
