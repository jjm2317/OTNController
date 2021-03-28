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
@Table(name = "tl1_service")
public class Tl1Service {
    @Id
    @GeneratedValue
    int serviceId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String pwId;
    String name;
    String desc;
    String vsiId;
    String localId;
    String sType;
    String nType;
    String servicePathStatus;
    String operStatus;
    String confAction;
    String confResult;
    String depEnabler;
    String tuId;
    String tuName;
    String ingLsr;
    String egrLsr;
    String peerLsrid;
    String srcTid;
    String srcTidId;
    String dstTid;
    String dstTidId;
    String peerTid;
    String peerTidId;
    String syncDate;

    public Tl1Service() {

    }

    public Tl1Service(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.pwId = fields[4];
        this.name = fields[5];
        this.desc = fields[6];
        this.vsiId = fields[7];
        this.localId = fields[8];
        this.sType = fields[9];
        this.nType = fields[10];
        this.servicePathStatus = fields[11];
        this.operStatus = fields[12];
        this.confAction = fields[13];
        this.confResult = fields[14];
        this.depEnabler = fields[15];
        this.tuId = fields[16];
        this.tuName = fields[17];
        this.ingLsr = fields[18];
        this.egrLsr = fields[19];
        this.peerLsrid = fields[20];
        this.srcTid = fields[21];
        this.srcTidId = fields[22];
        this.dstTid = fields[23];
        this.dstTidId = fields[24];
        this.peerTid = fields[25];
        this.peerTidId = fields[26];
        this.syncDate = syncDate;
    }

    public Tl1Service(String tidId, String tid, String subnetId, String subnet, String pwId, String name, String desc, String vsiId, String localId, String sType, String nType, String servicePathStatus, String operStatus, String confAction, String confResult, String depEnabler, String tuId, String tuName, String ingLsr, String egrLsr, String peerLsrid, String srcTid, String srcTidId, String dstTid, String dstTidId, String peerTid, String peerTidId, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.pwId = pwId;
        this.name = name;
        this.desc = desc;
        this.vsiId = vsiId;
        this.localId = localId;
        this.sType = sType;
        this.nType = nType;
        this.servicePathStatus = servicePathStatus;
        this.operStatus = operStatus;
        this.confAction = confAction;
        this.confResult = confResult;
        this.depEnabler = depEnabler;
        this.tuId = tuId;
        this.tuName = tuName;
        this.ingLsr = ingLsr;
        this.egrLsr = egrLsr;
        this.peerLsrid = peerLsrid;
        this.srcTid = srcTid;
        this.srcTidId = srcTidId;
        this.dstTid = dstTid;
        this.dstTidId = dstTidId;
        this.peerTid = peerTid;
        this.peerTidId = peerTidId;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Service{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", pwId='" + pwId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", vsiId='" + vsiId + '\'' +
                ", localId='" + localId + '\'' +
                ", sType='" + sType + '\'' +
                ", nType='" + nType + '\'' +
                ", servicePathStatus='" + servicePathStatus + '\'' +
                ", operStatus='" + operStatus + '\'' +
                ", confAction='" + confAction + '\'' +
                ", confResult='" + confResult + '\'' +
                ", depEnabler='" + depEnabler + '\'' +
                ", tuId='" + tuId + '\'' +
                ", tuName='" + tuName + '\'' +
                ", ingLsr='" + ingLsr + '\'' +
                ", egrLsr='" + egrLsr + '\'' +
                ", peerLsrid='" + peerLsrid + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", peerTid='" + peerTid + '\'' +
                ", peerTidId='" + peerTidId + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
