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
@Table(name = "tl1_service_mspw")
public class Tl1ServiceMspw {
    @Id
    @GeneratedValue
    int serviceMspwId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String mspwId;
    String localId;
    String requestId;
    String name;
    String pwSrcLsrid;
    String pwSrcSubnet;
    String pwSrcTid;
    String pwSrcTidId;
    String pwDstLsrid;
    String pwDstSubnet;
    String pwDstTid;
    String pwDstTidId;
    String tunnelName1;
    String tunnelId1;
    String tunnelName2;
    String tunnelId2;
    String ingLsrid1;
    String ingSubnet1;
    String ingTid1;
    String ingTidId1;
    String egrLsrid1;
    String egrSubnet1;
    String egrTid1;
    String egrTidId1;
    String ingLsrid2;
    String ingSubnet2;
    String ingTid2;
    String ingTidId2;
    String egrLsrid2;
    String egrSubnet2;
    String egrTid2;
    String egrTidId2;
    String pwxcOperationalStatus;
    String pwxcConfigurationAction;
    String pwxcConfigurationResult;
    String cir;
    String pir;
    String pwDepEnabler;
    String pwDepStatus;
    String eastPwPathStatusType;
    String eastPwInLabel;
    String eastPwOutLabel;
    String westPwPathStatusType;
    String westPwInLabel;
    String westPwOutLabel;
    String protectionType;
    String pathType;
    String syncDate;

    public Tl1ServiceMspw() {

    }

    public Tl1ServiceMspw(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.mspwId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.pwSrcLsrid = fields[8];
        this.pwSrcSubnet = fields[9];
        this.pwSrcTid = fields[10];
        this.pwSrcTidId = fields[11];
        this.pwDstLsrid = fields[12];
        this.pwDstSubnet = fields[13];
        this.pwDstTid = fields[14];
        this.pwDstTidId = fields[15];
        this.tunnelName1 = fields[16];
        this.tunnelId1 = fields[17];
        this.tunnelName2 = fields[18];
        this.tunnelId2 = fields[19];
        this.ingLsrid1 = fields[20];
        this.ingSubnet1 = fields[21];
        this.ingTid1 = fields[22];
        this.ingTidId1 = fields[23];
        this.egrLsrid1 = fields[24];
        this.egrSubnet1 = fields[25];
        this.egrTid1 = fields[26];
        this.egrTidId1 = fields[27];
        this.ingLsrid2 = fields[28];
        this.ingSubnet2 = fields[29];
        this.ingTid2 = fields[30];
        this.ingTidId2 = fields[31];
        this.egrLsrid2 = fields[32];
        this.egrSubnet2 = fields[33];
        this.egrTid2 = fields[34];
        this.egrTidId2 = fields[35];
        this.pwxcOperationalStatus = fields[36];
        this.pwxcConfigurationAction = fields[37];
        this.pwxcConfigurationResult = fields[38];
        this.cir = fields[39];
        this.pir = fields[40];
        this.pwDepEnabler = fields[41];
        this.pwDepStatus = fields[42];
        this.eastPwPathStatusType = fields[43];
        this.eastPwInLabel = fields[44];
        this.eastPwOutLabel = fields[45];
        this.westPwPathStatusType = fields[46];
        this.westPwInLabel = fields[47];
        this.westPwOutLabel = fields[48];
        this.protectionType = fields[49];
        this.pathType = fields[50];
        this.syncDate = syncDate;
    }

    public Tl1ServiceMspw(String tidId, String tid, String subnetId, String subnet, String mspwId, String localId, String requestId, String name, String pwSrcLsrid, String pwSrcSubnet, String pwSrcTid, String pwSrcTidId, String pwDstLsrid, String pwDstSubnet, String pwDstTid, String pwDstTidId, String tunnelName1, String tunnelId1, String tunnelName2, String tunnelId2, String ingLsrid1, String ingSubnet1, String ingTid1, String ingTidId1, String egrLsrid1, String egrSubnet1, String egrTid1, String egrTidId1, String ingLsrid2, String ingSubnet2, String ingTid2, String ingTidId2, String egrLsrid2, String egrSubnet2, String egrTid2, String egrTidId2, String pwxcOperationalStatus, String pwxcConfigurationAction, String pwxcConfigurationResult, String cir, String pir, String pwDepEnabler, String pwDepStatus, String eastPwPathStatusType, String eastPwInLabel, String eastPwOutLabel, String westPwPathStatusType, String westPwInLabel, String westPwOutLabel, String protectionType, String pathType, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.mspwId = mspwId;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.pwSrcLsrid = pwSrcLsrid;
        this.pwSrcSubnet = pwSrcSubnet;
        this.pwSrcTid = pwSrcTid;
        this.pwSrcTidId = pwSrcTidId;
        this.pwDstLsrid = pwDstLsrid;
        this.pwDstSubnet = pwDstSubnet;
        this.pwDstTid = pwDstTid;
        this.pwDstTidId = pwDstTidId;
        this.tunnelName1 = tunnelName1;
        this.tunnelId1 = tunnelId1;
        this.tunnelName2 = tunnelName2;
        this.tunnelId2 = tunnelId2;
        this.ingLsrid1 = ingLsrid1;
        this.ingSubnet1 = ingSubnet1;
        this.ingTid1 = ingTid1;
        this.ingTidId1 = ingTidId1;
        this.egrLsrid1 = egrLsrid1;
        this.egrSubnet1 = egrSubnet1;
        this.egrTid1 = egrTid1;
        this.egrTidId1 = egrTidId1;
        this.ingLsrid2 = ingLsrid2;
        this.ingSubnet2 = ingSubnet2;
        this.ingTid2 = ingTid2;
        this.ingTidId2 = ingTidId2;
        this.egrLsrid2 = egrLsrid2;
        this.egrSubnet2 = egrSubnet2;
        this.egrTid2 = egrTid2;
        this.egrTidId2 = egrTidId2;
        this.pwxcOperationalStatus = pwxcOperationalStatus;
        this.pwxcConfigurationAction = pwxcConfigurationAction;
        this.pwxcConfigurationResult = pwxcConfigurationResult;
        this.cir = cir;
        this.pir = pir;
        this.pwDepEnabler = pwDepEnabler;
        this.pwDepStatus = pwDepStatus;
        this.eastPwPathStatusType = eastPwPathStatusType;
        this.eastPwInLabel = eastPwInLabel;
        this.eastPwOutLabel = eastPwOutLabel;
        this.westPwPathStatusType = westPwPathStatusType;
        this.westPwInLabel = westPwInLabel;
        this.westPwOutLabel = westPwOutLabel;
        this.protectionType = protectionType;
        this.pathType = pathType;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1ServiceMspw{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", mspwId='" + mspwId + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", pwSrcLsrid='" + pwSrcLsrid + '\'' +
                ", pwSrcSubnet='" + pwSrcSubnet + '\'' +
                ", pwSrcTid='" + pwSrcTid + '\'' +
                ", pwSrcTidId='" + pwSrcTidId + '\'' +
                ", pwDstLsrid='" + pwDstLsrid + '\'' +
                ", pwDstSubnet='" + pwDstSubnet + '\'' +
                ", pwDstTid='" + pwDstTid + '\'' +
                ", pwDstTidId='" + pwDstTidId + '\'' +
                ", tunnelName1='" + tunnelName1 + '\'' +
                ", tunnelId1='" + tunnelId1 + '\'' +
                ", tunnelName2='" + tunnelName2 + '\'' +
                ", tunnelId2='" + tunnelId2 + '\'' +
                ", ingLsrid1='" + ingLsrid1 + '\'' +
                ", ingSubnet1='" + ingSubnet1 + '\'' +
                ", ingTid1='" + ingTid1 + '\'' +
                ", ingTidId1='" + ingTidId1 + '\'' +
                ", egrLsrid1='" + egrLsrid1 + '\'' +
                ", egrSubnet1='" + egrSubnet1 + '\'' +
                ", egrTid1='" + egrTid1 + '\'' +
                ", egrTidId1='" + egrTidId1 + '\'' +
                ", ingLsrid2='" + ingLsrid2 + '\'' +
                ", ingSubnet2='" + ingSubnet2 + '\'' +
                ", ingTid2='" + ingTid2 + '\'' +
                ", ingTidId2='" + ingTidId2 + '\'' +
                ", egrLsrid2='" + egrLsrid2 + '\'' +
                ", egrSubnet2='" + egrSubnet2 + '\'' +
                ", egrTid2='" + egrTid2 + '\'' +
                ", egrTidId2='" + egrTidId2 + '\'' +
                ", pwxcOperationalStatus='" + pwxcOperationalStatus + '\'' +
                ", pwxcConfigurationAction='" + pwxcConfigurationAction + '\'' +
                ", pwxcConfigurationResult='" + pwxcConfigurationResult + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", pwDepEnabler='" + pwDepEnabler + '\'' +
                ", pwDepStatus='" + pwDepStatus + '\'' +
                ", eastPwPathStatusType='" + eastPwPathStatusType + '\'' +
                ", eastPwInLabel='" + eastPwInLabel + '\'' +
                ", eastPwOutLabel='" + eastPwOutLabel + '\'' +
                ", westPwPathStatusType='" + westPwPathStatusType + '\'' +
                ", westPwInLabel='" + westPwInLabel + '\'' +
                ", westPwOutLabel='" + westPwOutLabel + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", pathType='" + pathType + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
