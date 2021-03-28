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
@Table(name = "tl1_stunnel")
public class Tl1Stunnel {
    @Id
    @GeneratedValue
    int stunnelId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String tuId;
    String localId;
    String requestId;
    String name;
    String descr;
    String tuType;
    String role;
    String port;
    String srcSubnet;
    String srcTidId;
    String srcTid;
    String dstSubnet;
    String dstTidId;
    String dstTid;
    String tuOperationalStatus;
    String tuConfigurationAction;
    String tuConfigurationResult;
    String tuOamEnabler;
    String deploymentEnabler;
    String deploymentStatus;
    String cir;
    String pir;
    String activePathStatus;
    String oamLocalId;
    String oamRemoteId;
    String oamGroupName;
    String oamMessageInvervalTime;
    String oamType;
    String protection;
    String pathStatus;
    String inLabel;
    String outLabel;
    String protectionType;
    String protectionReverType;
    String protectionProtocolType;
    String protectionHoldOffTime;
    String protectionWtrTime;
    String ingLsr;
    String engLsr;
    String syncDate;

    public Tl1Stunnel() {

    }

    public Tl1Stunnel(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.tuId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.descr = fields[8];
        this.tuType = fields[9];
        this.role = fields[10];
        this.port = fields[11];
        this.srcSubnet = fields[12];
        this.srcTidId = fields[13];
        this.srcTid = fields[14];
        this.dstSubnet = fields[15];
        this.dstTidId = fields[16];
        this.dstTid = fields[17];
        this.tuOperationalStatus = fields[18];
        this.tuConfigurationAction = fields[19];
        this.tuConfigurationResult = fields[20];
        this.tuOamEnabler = fields[21];
        this.deploymentEnabler = fields[22];
        this.deploymentStatus = fields[23];
        this.cir = fields[24];
        this.pir = fields[25];
        this.activePathStatus = fields[26];
        this.oamLocalId = fields[27];
        this.oamRemoteId = fields[28];
        this.oamGroupName = fields[29];
        this.oamMessageInvervalTime = fields[30];
        this.oamType = fields[31];
        this.protection = fields[32];
        this.pathStatus = fields[33];
        this.inLabel = fields[34];
        this.outLabel = fields[35];
        this.protectionType = fields[36];
        this.protectionReverType = fields[37];
        this.protectionProtocolType = fields[38];
        this.protectionHoldOffTime = fields[39];
        this.protectionWtrTime = fields[40];
        this.ingLsr = fields[41];
        this.engLsr = fields[42];
        this.syncDate = syncDate;
    }

    public Tl1Stunnel(String tidId, String tid, String subnetId, String subnet, String tuId, String localId, String requestId, String name, String descr, String tuType, String role, String port, String srcSubnet, String srcTidId, String srcTid, String dstSubnet, String dstTidId, String dstTid, String tuOperationalStatus, String tuConfigurationAction, String tuConfigurationResult, String tuOamEnabler, String deploymentEnabler, String deploymentStatus, String cir, String pir, String activePathStatus, String oamLocalId, String oamRemoteId, String oamGroupName, String oamMessageInvervalTime, String oamType, String protection, String pathStatus, String inLabel, String outLabel, String protectionType, String protectionReverType, String protectionProtocolType, String protectionHoldOffTime, String protectionWtrTime, String ingLsr, String engLsr, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.tuId = tuId;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.descr = descr;
        this.tuType = tuType;
        this.role = role;
        this.port = port;
        this.srcSubnet = srcSubnet;
        this.srcTidId = srcTidId;
        this.srcTid = srcTid;
        this.dstSubnet = dstSubnet;
        this.dstTidId = dstTidId;
        this.dstTid = dstTid;
        this.tuOperationalStatus = tuOperationalStatus;
        this.tuConfigurationAction = tuConfigurationAction;
        this.tuConfigurationResult = tuConfigurationResult;
        this.tuOamEnabler = tuOamEnabler;
        this.deploymentEnabler = deploymentEnabler;
        this.deploymentStatus = deploymentStatus;
        this.cir = cir;
        this.pir = pir;
        this.activePathStatus = activePathStatus;
        this.oamLocalId = oamLocalId;
        this.oamRemoteId = oamRemoteId;
        this.oamGroupName = oamGroupName;
        this.oamMessageInvervalTime = oamMessageInvervalTime;
        this.oamType = oamType;
        this.protection = protection;
        this.pathStatus = pathStatus;
        this.inLabel = inLabel;
        this.outLabel = outLabel;
        this.protectionType = protectionType;
        this.protectionReverType = protectionReverType;
        this.protectionProtocolType = protectionProtocolType;
        this.protectionHoldOffTime = protectionHoldOffTime;
        this.protectionWtrTime = protectionWtrTime;
        this.ingLsr = ingLsr;
        this.engLsr = engLsr;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Stunnel{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", tuId='" + tuId + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", tuType='" + tuType + '\'' +
                ", role='" + role + '\'' +
                ", port='" + port + '\'' +
                ", srcSubnet='" + srcSubnet + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", dstSubnet='" + dstSubnet + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", tuOperationalStatus='" + tuOperationalStatus + '\'' +
                ", tuConfigurationAction='" + tuConfigurationAction + '\'' +
                ", tuConfigurationResult='" + tuConfigurationResult + '\'' +
                ", tuOamEnabler='" + tuOamEnabler + '\'' +
                ", deploymentEnabler='" + deploymentEnabler + '\'' +
                ", deploymentStatus='" + deploymentStatus + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", activePathStatus='" + activePathStatus + '\'' +
                ", oamLocalId='" + oamLocalId + '\'' +
                ", oamRemoteId='" + oamRemoteId + '\'' +
                ", oamGroupName='" + oamGroupName + '\'' +
                ", oamMessageInvervalTime='" + oamMessageInvervalTime + '\'' +
                ", oamType='" + oamType + '\'' +
                ", protection='" + protection + '\'' +
                ", pathStatus='" + pathStatus + '\'' +
                ", inLabel='" + inLabel + '\'' +
                ", outLabel='" + outLabel + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", protectionReverType='" + protectionReverType + '\'' +
                ", protectionProtocolType='" + protectionProtocolType + '\'' +
                ", protectionHoldOffTime='" + protectionHoldOffTime + '\'' +
                ", protectionWtrTime='" + protectionWtrTime + '\'' +
                ", ingLsr='" + ingLsr + '\'' +
                ", engLsr='" + engLsr + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
