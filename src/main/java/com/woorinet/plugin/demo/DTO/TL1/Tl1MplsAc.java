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
@Table(name = "tl1_mpls_ac")
public class Tl1MplsAc {
    @Id
    @GeneratedValue
    int mplsAcId;
    String tidId;
    String tid;
    String aid;
    String serviceName;
    String descr;
    String unitType;
    String acId;
    String vsiId;
    String tcBy;
    String vlan;
    String vlanInner;
    String vlanPri;
    String qInQ;
    String phbmapId;
    String phbmapType;
    String acCount;
    String exp;
    String protPid;
    String policerId;
    String lagId;
    String rgId;
    String counter;
    String pollRate;
    String report;
    String noPacket;
    String creationDate;
    String modifiedDate;
    String syncDate;

    public Tl1MplsAc() {

    }

    public Tl1MplsAc(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.aid = fields[2];
        this.serviceName = fields[3];
        this.descr = fields[4];
        this.unitType = fields[5];
        this.acId = fields[6];
        this.vsiId = fields[7];
        this.tcBy = fields[8];
        this.vlan = fields[9];
        this.vlanInner = fields[10];
        this.vlanPri = fields[11];
        this.qInQ = fields[12];
        this.phbmapId = fields[13];
        this.phbmapType = fields[14];
        this.acCount = fields[15];
        this.exp = fields[16];
        this.protPid = fields[17];
        this.policerId = fields[18];
        this.lagId = fields[19];
        this.rgId = fields[20];
        this.counter = fields[21];
        this.pollRate = fields[22];
        this.report = fields[23];
        this.noPacket = fields[24];
        this.creationDate = fields[25];
        this.modifiedDate = fields[26];
        this.syncDate = syncDate;
    }

    public Tl1MplsAc(String tidId, String tid, String aid, String serviceName, String descr, String unitType, String acId, String vsiId, String tcBy, String vlan, String vlanInner, String vlanPri, String qInQ, String phbmapId, String phbmapType, String acCount, String exp, String protPid, String policerId, String lagId, String rgId, String counter, String pollRate, String report, String noPacket, String creationDate, String modifiedDate, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.aid = aid;
        this.serviceName = serviceName;
        this.descr = descr;
        this.unitType = unitType;
        this.acId = acId;
        this.vsiId = vsiId;
        this.tcBy = tcBy;
        this.vlan = vlan;
        this.vlanInner = vlanInner;
        this.vlanPri = vlanPri;
        this.qInQ = qInQ;
        this.phbmapId = phbmapId;
        this.phbmapType = phbmapType;
        this.acCount = acCount;
        this.exp = exp;
        this.protPid = protPid;
        this.policerId = policerId;
        this.lagId = lagId;
        this.rgId = rgId;
        this.counter = counter;
        this.pollRate = pollRate;
        this.report = report;
        this.noPacket = noPacket;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1MplsAc{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", descr='" + descr + '\'' +
                ", unitType='" + unitType + '\'' +
                ", acId='" + acId + '\'' +
                ", vsiId='" + vsiId + '\'' +
                ", tcBy='" + tcBy + '\'' +
                ", vlan='" + vlan + '\'' +
                ", vlanInner='" + vlanInner + '\'' +
                ", vlanPri='" + vlanPri + '\'' +
                ", qInQ='" + qInQ + '\'' +
                ", phbmapId='" + phbmapId + '\'' +
                ", phbmapType='" + phbmapType + '\'' +
                ", acCount='" + acCount + '\'' +
                ", exp='" + exp + '\'' +
                ", protPid='" + protPid + '\'' +
                ", policerId='" + policerId + '\'' +
                ", lagId='" + lagId + '\'' +
                ", rgId='" + rgId + '\'' +
                ", counter='" + counter + '\'' +
                ", pollRate='" + pollRate + '\'' +
                ", report='" + report + '\'' +
                ", noPacket='" + noPacket + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
