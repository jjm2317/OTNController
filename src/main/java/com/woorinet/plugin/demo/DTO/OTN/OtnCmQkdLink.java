package com.woorinet.plugin.demo.DTO.OTN;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Data
@Entity
public class OtnCmQkdLink {
    @Id
    @GeneratedValue
    int otnCmQkdLink;
    String tid;
    String slot;
    String port;
    String server;
    String serverPort;
    String masterSaeId;
    String slaveSaeId;
    String keyIntfIp;
    String keyIntfNetmask;
    String keyIntfGateway;
    String keySkeySize;
    String kmsStatus;
    String vendor;

    public OtnCmQkdLink() {
    }

    public OtnCmQkdLink(String tid, String slot, String port, String server, String serverPort, String masterSaeId, String slaveSaeId, String keyIntfIp, String keyIntfNetmask, String keyIntfGateway, String keySkeySize, String kmsStatus, String vendor) {
        this.tid = tid;
        this.slot = slot;
        this.port = port;
        this.server = server;
        this.serverPort = serverPort;
        this.masterSaeId = masterSaeId;
        this.slaveSaeId = slaveSaeId;
        this.keyIntfIp = keyIntfIp;
        this.keyIntfNetmask = keyIntfNetmask;
        this.keyIntfGateway = keyIntfGateway;
        this.keySkeySize = keySkeySize;
        this.kmsStatus = kmsStatus;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "OtnCmQkdLink{" +
                "tid='" + tid + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", server='" + server + '\'' +
                ", serverPort='" + serverPort + '\'' +
                ", masterSaeId='" + masterSaeId + '\'' +
                ", slaveSaeId='" + slaveSaeId + '\'' +
                ", keyIntfIp='" + keyIntfIp + '\'' +
                ", keyIntfNetmask='" + keyIntfNetmask + '\'' +
                ", keyIntfGateway='" + keyIntfGateway + '\'' +
                ", keySkeySize='" + keySkeySize + '\'' +
                ", kmsStatus='" + kmsStatus + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
