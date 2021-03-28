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
@Table(name = "tl1_stunnel_transit")
public class Tl1StunnelTransit {
    @Id
    @GeneratedValue
    int stunnelTransitId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String tuXcId;
    String localId;
    String requestId;
    String name;
    String descr;
    String crossConnectType;
    String role;
    String srcSubnet;
    String srcTidId;
    String srcTid;
    String dstSubnet;
    String dstTidId;
    String dstTid;
    String tuXcOperationalStatus;
    String tuXcConfigurationAction;
    String tuXcConfigurationResult;
    String deploymentEnabler;
    String deploymentStatus;
    String cir;
    String pir;
    String pathProtection;
    String pathStatus;
    String fromPort;
    String eastInLabel;
    String eastOutLabel;
    String toPort;
    String westInLabel;
    String westOutLabel;
    String protectionType;
    String pathType;
    String ingLsr;
    String engLsr;
    String syncDate;

    public Tl1StunnelTransit() {

    }
    public Tl1StunnelTransit(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.tuXcId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.descr = fields[8];
        this.crossConnectType = fields[9];
        this.role = fields[10];
        this.srcSubnet = fields[11];
        this.srcTidId = fields[12];
        this.srcTid = fields[13];
        this.dstSubnet = fields[14];
        this.dstTidId = fields[15];
        this.dstTid = fields[16];
        this.tuXcOperationalStatus = fields[17];
        this.tuXcConfigurationAction = fields[18];
        this.tuXcConfigurationResult = fields[19];
        this.deploymentEnabler = fields[20];
        this.deploymentStatus = fields[21];
        this.cir = fields[22];
        this.pir = fields[23];
        this.pathProtection = fields[24];
        this.pathStatus = fields[25];
        this.fromPort = fields[26];
        this.eastInLabel = fields[27];
        this.eastOutLabel = fields[28];
        this.toPort = fields[29];
        this.westInLabel = fields[30];
        this.westOutLabel = fields[31];
        this.protectionType = fields[32];
        this.pathType = fields[33];
        this.ingLsr = fields[34];
        this.engLsr = fields[35];
        this.syncDate = syncDate;
    }

    public Tl1StunnelTransit(String tidId, String tid, String subnetId, String subnet, String tuXcId, String localId, String requestId, String name, String descr, String crossConnectType, String role, String srcSubnet, String srcTidId, String srcTid, String dstSubnet, String dstTidId, String dstTid, String tuXcOperationalStatus, String tuXcConfigurationAction, String tuXcConfigurationResult, String deploymentEnabler, String deploymentStatus, String cir, String pir, String pathProtection, String pathStatus, String fromPort, String eastInLabel, String eastOutLabel, String toPort, String westInLabel, String westOutLabel, String protectionType, String pathType, String ingLsr, String engLsr, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.tuXcId = tuXcId;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.descr = descr;
        this.crossConnectType = crossConnectType;
        this.role = role;
        this.srcSubnet = srcSubnet;
        this.srcTidId = srcTidId;
        this.srcTid = srcTid;
        this.dstSubnet = dstSubnet;
        this.dstTidId = dstTidId;
        this.dstTid = dstTid;
        this.tuXcOperationalStatus = tuXcOperationalStatus;
        this.tuXcConfigurationAction = tuXcConfigurationAction;
        this.tuXcConfigurationResult = tuXcConfigurationResult;
        this.deploymentEnabler = deploymentEnabler;
        this.deploymentStatus = deploymentStatus;
        this.cir = cir;
        this.pir = pir;
        this.pathProtection = pathProtection;
        this.pathStatus = pathStatus;
        this.fromPort = fromPort;
        this.eastInLabel = eastInLabel;
        this.eastOutLabel = eastOutLabel;
        this.toPort = toPort;
        this.westInLabel = westInLabel;
        this.westOutLabel = westOutLabel;
        this.protectionType = protectionType;
        this.pathType = pathType;
        this.ingLsr = ingLsr;
        this.engLsr = engLsr;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1StunnelTransit{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", tuXcId='" + tuXcId + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", crossConnectType='" + crossConnectType + '\'' +
                ", role='" + role + '\'' +
                ", srcSubnet='" + srcSubnet + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", dstSubnet='" + dstSubnet + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", tuXcOperationalStatus='" + tuXcOperationalStatus + '\'' +
                ", tuXcConfigurationAction='" + tuXcConfigurationAction + '\'' +
                ", tuXcConfigurationResult='" + tuXcConfigurationResult + '\'' +
                ", deploymentEnabler='" + deploymentEnabler + '\'' +
                ", deploymentStatus='" + deploymentStatus + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", pathProtection='" + pathProtection + '\'' +
                ", pathStatus='" + pathStatus + '\'' +
                ", fromPort='" + fromPort + '\'' +
                ", eastInLabel='" + eastInLabel + '\'' +
                ", eastOutLabel='" + eastOutLabel + '\'' +
                ", toPort='" + toPort + '\'' +
                ", westInLabel='" + westInLabel + '\'' +
                ", westOutLabel='" + westOutLabel + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", pathType='" + pathType + '\'' +
                ", ingLsr='" + ingLsr + '\'' +
                ", engLsr='" + engLsr + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
