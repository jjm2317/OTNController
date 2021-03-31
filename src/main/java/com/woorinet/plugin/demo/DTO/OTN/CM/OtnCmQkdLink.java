package com.woorinet.plugin.demo.DTO.OTN.CM;

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
@Table(name="otn_cm_qkd_link")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
    String keySize;
    String kmsStatus;
    String vendor;
    String syncDate;

    public OtnCmQkdLink() {
    }

    public OtnCmQkdLink(String tid, String slot, String port, String server, String serverPort, String masterSaeId, String slaveSaeId, String keyIntfIp, String keyIntfNetmask, String keyIntfGateway, String keySize, String kmsStatus, String vendor, String syncDate) {
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
        this.keySize = keySize;
        this.kmsStatus = kmsStatus;
        this.vendor = vendor;
        this.syncDate = syncDate;
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
                ", keySize='" + keySize + '\'' +
                ", kmsStatus='" + kmsStatus + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
