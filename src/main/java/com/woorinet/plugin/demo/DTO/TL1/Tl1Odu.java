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
@Table(name = "tl1_odu")
public class Tl1Odu {
    @Id
    @GeneratedValue
    int oduId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String localId;
    String emsService;
    String emsServiceSig;
    String emsSrcSubnet;
    String emsSrcLsr;
    String emsDstSubnet;
    String emsDstLsr;
    String name;
    String descr;
    String trailId;
    String pathId;
    String ingSubnet;
    String ingLsr;
    String egrSubnet;
    String egrLsr;
    String role;
    String direction;
    String service;
    String type;
    String startTs;
    String rate;
    String tsmap;
    String mapMode;
    String sf;
    String sd;
    String loopType;
    String lock;
    String localIfindex;
    String remoteIfindex;
    String encryption;
    String localSslId;
    String remoteSslId;
    String leaPort;
    String gmpls;
    String uniXcId;
    String nniXcId;
    String protection;
    String protId;
    String protMode;
    String protType;
    String activePathStatus;
    String sfDetect;
    String creationDate;
    String modifiedDate;
    String tunnelPort;
    String syncDate;

    public Tl1Odu() {

    }

    public Tl1Odu(String[] fields) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.localId = fields[4];
        this.emsService = fields[5];
        this.emsServiceSig = fields[6];
        this.emsSrcSubnet = fields[7];
        this.emsSrcLsr = fields[8];
        this.emsDstSubnet = fields[9];
        this.emsDstLsr = fields[10];
        this.name = fields[11];
        this.descr = fields[12];
        this.trailId = fields[13];
        this.pathId = fields[14];
        this.ingSubnet = fields[15];
        this.ingLsr = fields[16];
        this.egrSubnet = fields[17];
        this.egrLsr = fields[18];
        this.role = fields[19];
        this.direction = fields[20];
        this.service = fields[21];
        this.type = fields[22];
        this.startTs = fields[23];
        this.rate = fields[24];
        this.tsmap = fields[25];
        this.mapMode = fields[26];
        this.sf = fields[27];
        this.sd = fields[28];
        this.loopType = fields[29];
        this.lock = fields[30];
        this.localIfindex = fields[31];
        this.remoteIfindex = fields[32];
        this.encryption = fields[33];
        this.localSslId = fields[34];
        this.remoteSslId = fields[35];
        this.leaPort = fields[36];
        this.gmpls = fields[37];
        this.uniXcId = fields[38];
        this.nniXcId = fields[39];
        this.protection = fields[40];
        this.protId = fields[41];
        this.protMode = fields[42];
        this.protType = fields[43];
        this.activePathStatus = fields[44];
        this.sfDetect = fields[45];
        this.creationDate = fields[46];
        this.modifiedDate = fields[47];
        this.tunnelPort = fields[48];
    }

    @Override
    public String toString() {
        return "Tl1Odu{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", localId='" + localId + '\'' +
                ", emsService='" + emsService + '\'' +
                ", emsServiceSig='" + emsServiceSig + '\'' +
                ", emsSrcSubnet='" + emsSrcSubnet + '\'' +
                ", emsSrcLsr='" + emsSrcLsr + '\'' +
                ", emsDstSubnet='" + emsDstSubnet + '\'' +
                ", emsDstLsr='" + emsDstLsr + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", trailId='" + trailId + '\'' +
                ", pathId='" + pathId + '\'' +
                ", ingSubnet='" + ingSubnet + '\'' +
                ", ingLsr='" + ingLsr + '\'' +
                ", egrSubnet='" + egrSubnet + '\'' +
                ", egrLsr='" + egrLsr + '\'' +
                ", role='" + role + '\'' +
                ", direction='" + direction + '\'' +
                ", service='" + service + '\'' +
                ", type='" + type + '\'' +
                ", startTs='" + startTs + '\'' +
                ", rate='" + rate + '\'' +
                ", tsmap='" + tsmap + '\'' +
                ", mapMode='" + mapMode + '\'' +
                ", sf='" + sf + '\'' +
                ", sd='" + sd + '\'' +
                ", loopType='" + loopType + '\'' +
                ", lock='" + lock + '\'' +
                ", localIfindex='" + localIfindex + '\'' +
                ", remoteIfindex='" + remoteIfindex + '\'' +
                ", encryption='" + encryption + '\'' +
                ", localSslId='" + localSslId + '\'' +
                ", remoteSslId='" + remoteSslId + '\'' +
                ", leaPort='" + leaPort + '\'' +
                ", gmpls='" + gmpls + '\'' +
                ", uniXcId='" + uniXcId + '\'' +
                ", nniXcId='" + nniXcId + '\'' +
                ", protection='" + protection + '\'' +
                ", protId='" + protId + '\'' +
                ", protMode='" + protMode + '\'' +
                ", protType='" + protType + '\'' +
                ", activePathStatus='" + activePathStatus + '\'' +
                ", sfDetect='" + sfDetect + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", tunnelPort='" + tunnelPort + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
