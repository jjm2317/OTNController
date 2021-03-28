package com.woorinet.plugin.demo.DTO.TL1.CM;

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
@Table(name = "tl1_qkd_info")
public class Tl1QkdInfo {
    @Id
    @GeneratedValue
    int qkdInfoId;
    String tid;
    String subnet;
    String aid;
    String server;
    String serverPort;
    String masterSaeId;
    String slaveSaeId;
    String keyIntfIp;
    String keyIntfNetmask;
    String keyIntfGateway;
    String keySrc;
    String keyFailover;
    String keySize;
    String kmsStatus;
    String vendor;

    public Tl1QkdInfo() {
    }

    public Tl1QkdInfo(String tid, String subnet, String aid, String server, String serverPort, String masterSaeId, String slaveSaeId, String keyIntfIp, String keyIntfNetmask, String keyIntfGateway, String keySrc, String keyFailover, String keySize, String kmsStatus, String vendor) {
        this.tid = tid;
        this.subnet = subnet;
        this.aid = aid;
        this.server = server;
        this.serverPort = serverPort;
        this.masterSaeId = masterSaeId;
        this.slaveSaeId = slaveSaeId;
        this.keyIntfIp = keyIntfIp;
        this.keyIntfNetmask = keyIntfNetmask;
        this.keyIntfGateway = keyIntfGateway;
        this.keySrc = keySrc;
        this.keyFailover = keyFailover;
        this.keySize = keySize;
        this.kmsStatus = kmsStatus;
        this.vendor = vendor;
    }

    public Tl1QkdInfo(String[] fields) {
        this.tid = fields[0];
        this.subnet = fields[1];
        this.aid = fields[2];
        this.server = fields[3];
        this.serverPort = fields[4];
        this.masterSaeId = fields[5];
        this.slaveSaeId = fields[6];
        this.keyIntfIp = fields[7];
        this.keyIntfNetmask = fields[8];
        this.keyIntfGateway = fields[9];
        this.keySrc = fields[10];
        this.keyFailover = fields[11];
        this.keySize = fields[12];
        this.kmsStatus = fields[13];
        this.vendor = fields[14];
    }

    @Override
    public String toString() {
        return "Tl1QkdInfo{" +
                "tid='" + tid + '\'' +
                ", subnet='" + subnet + '\'' +
                ", aid='" + aid + '\'' +
                ", server='" + server + '\'' +
                ", serverPort='" + serverPort + '\'' +
                ", masterSaeId='" + masterSaeId + '\'' +
                ", slaveSaeId='" + slaveSaeId + '\'' +
                ", keyIntfIp='" + keyIntfIp + '\'' +
                ", keyIntfNetmask='" + keyIntfNetmask + '\'' +
                ", keyIntfGateway='" + keyIntfGateway + '\'' +
                ", keySrc='" + keySrc + '\'' +
                ", keyFailover='" + keyFailover + '\'' +
                ", keySize='" + keySize + '\'' +
                ", kmsStatus='" + kmsStatus + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
