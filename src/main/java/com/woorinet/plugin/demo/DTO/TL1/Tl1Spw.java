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
@Table(name = "tl1_spw")
public class Tl1Spw {
    @Id
    @GeneratedValue
    int spwId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String pwId;
    String localId;
    String requestId;
    String name;
    String pwType;
    String tunnelId;
    String tunnelName;
    String ingLsrid;
    String egrLsrid;
    String peerLsrid;
    String srcSubnet;
    String srcTidId;
    String srcTid;
    String dstSubnet;
    String dstTidId;
    String dstTid;
    String vsiId;
    String pwOperationalStatus;
    String pwConfigurationAction;
    String pwConfigurationResult;
    String pwOamEnabler;
    String cir;
    String pir;
    String pwDepEnabler;
    String pwDepStatus;
    String pwDepStatusType;
    String activePathStatus;
    String serviceType;
    String pathStatus;
    String inLabel;
    String outLabel;
    String peerSubnet;
    String peerTid;
    String peerTidId;
    String protectionType;
    String protectionRevertType;
    String protectionProtocolType;
    String protectionHoldOffTime;
    String protectionWtrTime;
    String oamLocalId;
    String oamType;
    String oamIntervalTime;
    String oamRemoteId;
    String oamGroupName;
    String syncDate;

    public Tl1Spw() {

    }

    public Tl1Spw(String[] fields,String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.pwId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.pwType = fields[8];
        this.tunnelId = fields[9];
        this.tunnelName = fields[10];
        this.ingLsrid = fields[11];
        this.egrLsrid = fields[12];
        this.peerLsrid = fields[13];
        this.srcSubnet = fields[14];
        this.srcTidId = fields[15];
        this.srcTid = fields[16];
        this.dstSubnet = fields[17];
        this.dstTidId = fields[18];
        this.dstTid = fields[19];
        this.vsiId = fields[20];
        this.pwOperationalStatus = fields[21];
        this.pwConfigurationAction = fields[22];
        this.pwConfigurationResult = fields[23];
        this.pwOamEnabler = fields[24];
        this.cir = fields[25];
        this.pir = fields[26];
        this.pwDepEnabler = fields[27];
        this.pwDepStatus = fields[28];
        this.pwDepStatusType = fields[29];
        this.activePathStatus = fields[30];
        this.serviceType = fields[31];
        this.pathStatus = fields[32];
        this.inLabel = fields[33];
        this.outLabel = fields[34];
        this.peerSubnet = fields[35];
        this.peerTid = fields[36];
        this.peerTidId = fields[37];
        this.protectionType = fields[38];
        this.protectionRevertType = fields[39];
        this.protectionProtocolType = fields[40];
        this.protectionHoldOffTime = fields[41];
        this.protectionWtrTime = fields[42];
        this.oamLocalId = fields[43];
        this.oamType = fields[44];
        this.oamIntervalTime = fields[45];
        this.oamRemoteId = fields[46];
        this.oamGroupName = fields[47];
        this.syncDate = syncDate;
    }

    public Tl1Spw(String tidId, String tid, String subnetId, String subnet, String pwId, String localId, String requestId, String name, String pwType, String tunnelId, String tunnelName, String ingLsrid, String egrLsrid, String peerLsrid, String srcSubnet, String srcTidId, String srcTid, String dstSubnet, String dstTidId, String dstTid, String vsiId, String pwOperationalStatus, String pwConfigurationAction, String pwConfigurationResult, String pwOamEnabler, String cir, String pir, String pwDepEnabler, String pwDepStatus, String pwDepStatusType, String activePathStatus, String serviceType, String pathStatus, String inLabel, String outLabel, String peerSubnet, String peerTid, String peerTidId, String protectionType, String protectionRevertType, String protectionProtocolType, String protectionHoldOffTime, String protectionWtrTime, String oamLocalId, String oamType, String oamIntervalTime, String oamRemoteId, String oamGroupName, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.pwId = pwId;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.pwType = pwType;
        this.tunnelId = tunnelId;
        this.tunnelName = tunnelName;
        this.ingLsrid = ingLsrid;
        this.egrLsrid = egrLsrid;
        this.peerLsrid = peerLsrid;
        this.srcSubnet = srcSubnet;
        this.srcTidId = srcTidId;
        this.srcTid = srcTid;
        this.dstSubnet = dstSubnet;
        this.dstTidId = dstTidId;
        this.dstTid = dstTid;
        this.vsiId = vsiId;
        this.pwOperationalStatus = pwOperationalStatus;
        this.pwConfigurationAction = pwConfigurationAction;
        this.pwConfigurationResult = pwConfigurationResult;
        this.pwOamEnabler = pwOamEnabler;
        this.cir = cir;
        this.pir = pir;
        this.pwDepEnabler = pwDepEnabler;
        this.pwDepStatus = pwDepStatus;
        this.pwDepStatusType = pwDepStatusType;
        this.activePathStatus = activePathStatus;
        this.serviceType = serviceType;
        this.pathStatus = pathStatus;
        this.inLabel = inLabel;
        this.outLabel = outLabel;
        this.peerSubnet = peerSubnet;
        this.peerTid = peerTid;
        this.peerTidId = peerTidId;
        this.protectionType = protectionType;
        this.protectionRevertType = protectionRevertType;
        this.protectionProtocolType = protectionProtocolType;
        this.protectionHoldOffTime = protectionHoldOffTime;
        this.protectionWtrTime = protectionWtrTime;
        this.oamLocalId = oamLocalId;
        this.oamType = oamType;
        this.oamIntervalTime = oamIntervalTime;
        this.oamRemoteId = oamRemoteId;
        this.oamGroupName = oamGroupName;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Spw{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", pwId='" + pwId + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", pwType='" + pwType + '\'' +
                ", tunnelId='" + tunnelId + '\'' +
                ", tunnelName='" + tunnelName + '\'' +
                ", ingLsrid='" + ingLsrid + '\'' +
                ", egrLsrid='" + egrLsrid + '\'' +
                ", peerLsrid='" + peerLsrid + '\'' +
                ", srcSubnet='" + srcSubnet + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", dstSubnet='" + dstSubnet + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", vsiId='" + vsiId + '\'' +
                ", pwOperationalStatus='" + pwOperationalStatus + '\'' +
                ", pwConfigurationAction='" + pwConfigurationAction + '\'' +
                ", pwConfigurationResult='" + pwConfigurationResult + '\'' +
                ", pwOamEnabler='" + pwOamEnabler + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", pwDepEnabler='" + pwDepEnabler + '\'' +
                ", pwDepStatus='" + pwDepStatus + '\'' +
                ", pwDepStatusType='" + pwDepStatusType + '\'' +
                ", activePathStatus='" + activePathStatus + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", pathStatus='" + pathStatus + '\'' +
                ", inLabel='" + inLabel + '\'' +
                ", outLabel='" + outLabel + '\'' +
                ", peerSubnet='" + peerSubnet + '\'' +
                ", peerTid='" + peerTid + '\'' +
                ", peerTidId='" + peerTidId + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", protectionRevertType='" + protectionRevertType + '\'' +
                ", protectionProtocolType='" + protectionProtocolType + '\'' +
                ", protectionHoldOffTime='" + protectionHoldOffTime + '\'' +
                ", protectionWtrTime='" + protectionWtrTime + '\'' +
                ", oamLocalId='" + oamLocalId + '\'' +
                ", oamType='" + oamType + '\'' +
                ", oamIntervalTime='" + oamIntervalTime + '\'' +
                ", oamRemoteId='" + oamRemoteId + '\'' +
                ", oamGroupName='" + oamGroupName + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
