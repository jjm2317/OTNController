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
@Table(name = "tl1_service_ext")
public class Tl1ServiceExt {
    @Id
    @GeneratedValue
    int serviceExtId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String servName;
    String cir;
    String pir;
    String pwId;
    String scId;
    String sccName;
    String sccValue;
    String sccOperator;
    String scType;
    String nodeRole;
    String tidRole;
    String srcPwid;
    String srcVsiId;
    String srcSubnet;
    String srcTid;
    String srcTidId;
    String srcAid;
    String srcNodeAifId;
    String srcNodeAifName;
    String srcNodeAifType;
    String srcPortCid;
    String srcPortCname;
    String srcPortCvalue;
    String srcPortCoperator;
    String srcPortCtype;
    String srcIngLsrid;
    String srcEgrLsrid;
    String srcInLabel;
    String srcOutLabel;
    String dstPwid;
    String dstVsiId;
    String dstSubnet;
    String dstTid;
    String dstTidId;
    String dstAid;
    String dstNodeAifId;
    String dstNodeAifName;
    String dstNodeAifType;
    String dstPortCid;
    String dstPortCname;
    String dstPortCvalue;
    String dstPortCoperator;
    String dstPortCtype;
    String dstIngLsrid;
    String dstEgrLsrid;
    String dstInLabel;
    String dstOutLabel;
    String msTunnelCount;
    String msPwCount;
    String syncDate;

    public Tl1ServiceExt() {

    }

    public Tl1ServiceExt(String[] fields, String syncDate) {
        tidId = fields[0];
        tid = fields[1];
        subnetId = fields[2];
        subnet = fields[3];
        servName = fields[4];
        cir = fields[5];
        pir = fields[6];
        pwId = fields[7];
        scId = fields[8];
        sccName = fields[9];
        sccValue = fields[10];
        sccOperator = fields[11];
        scType = fields[12];
        nodeRole = fields[13];
        tidRole = fields[14];
        srcPwid = fields[15];
        srcVsiId = fields[16];
        srcSubnet = fields[17];
        srcTid = fields[18];
        srcTidId = fields[19];
        srcAid = fields[20];
        srcNodeAifId = fields[21];
        srcNodeAifName = fields[22];
        srcNodeAifType = fields[23];
        srcPortCid = fields[24];
        srcPortCname = fields[25];
        srcPortCvalue = fields[26];
        srcPortCoperator = fields[27];
        srcPortCtype = fields[28];
        srcIngLsrid = fields[29];
        srcEgrLsrid = fields[30];
        srcInLabel = fields[31];
        srcOutLabel = fields[32];
        dstPwid = fields[33];
        dstVsiId = fields[34];
        dstSubnet = fields[35];
        dstTid = fields[36];
        dstTidId = fields[37];
        dstAid = fields[38];
        dstNodeAifId = fields[39];
        dstNodeAifName = fields[40];
        dstNodeAifType = fields[41];
        dstPortCid = fields[42];
        dstPortCname = fields[43];
        dstPortCvalue = fields[44];
        dstPortCoperator = fields[45];
        dstPortCtype = fields[46];
        dstIngLsrid = fields[47];
        dstEgrLsrid = fields[48];
        dstInLabel = fields[49];
        dstOutLabel = fields[50];
        msTunnelCount = fields[51];
        msPwCount = fields[52];
        this.syncDate = syncDate;
    }

    public Tl1ServiceExt(String tidId, String tid, String subnetId, String subnet, String servName, String cir, String pir, String pwId, String scId, String sccName, String sccValue, String sccOperator, String scType, String nodeRole, String tidRole, String srcPwid, String srcVsiId, String srcSubnet, String srcTid, String srcTidId, String srcAid, String srcNodeAifId, String srcNodeAifName, String srcNodeAifType, String srcPortCid, String srcPortCname, String srcPortCvalue, String srcPortCoperator, String srcPortCtype, String srcIngLsrid, String srcEgrLsrid, String srcInLabel, String srcOutLabel, String dstPwid, String dstVsiId, String dstSubnet, String dstTid, String dstTidId, String dstAid, String dstNodeAifId, String dstNodeAifName, String dstNodeAifType, String dstPortCid, String dstPortCname, String dstPortCvalue, String dstPortCoperator, String dstPortCtype, String dstIngLsrid, String dstEgrLsrid, String dstInLabel, String dstOutLabel, String msTunnelCount, String msPwCount, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.servName = servName;
        this.cir = cir;
        this.pir = pir;
        this.pwId = pwId;
        this.scId = scId;
        this.sccName = sccName;
        this.sccValue = sccValue;
        this.sccOperator = sccOperator;
        this.scType = scType;
        this.nodeRole = nodeRole;
        this.tidRole = tidRole;
        this.srcPwid = srcPwid;
        this.srcVsiId = srcVsiId;
        this.srcSubnet = srcSubnet;
        this.srcTid = srcTid;
        this.srcTidId = srcTidId;
        this.srcAid = srcAid;
        this.srcNodeAifId = srcNodeAifId;
        this.srcNodeAifName = srcNodeAifName;
        this.srcNodeAifType = srcNodeAifType;
        this.srcPortCid = srcPortCid;
        this.srcPortCname = srcPortCname;
        this.srcPortCvalue = srcPortCvalue;
        this.srcPortCoperator = srcPortCoperator;
        this.srcPortCtype = srcPortCtype;
        this.srcIngLsrid = srcIngLsrid;
        this.srcEgrLsrid = srcEgrLsrid;
        this.srcInLabel = srcInLabel;
        this.srcOutLabel = srcOutLabel;
        this.dstPwid = dstPwid;
        this.dstVsiId = dstVsiId;
        this.dstSubnet = dstSubnet;
        this.dstTid = dstTid;
        this.dstTidId = dstTidId;
        this.dstAid = dstAid;
        this.dstNodeAifId = dstNodeAifId;
        this.dstNodeAifName = dstNodeAifName;
        this.dstNodeAifType = dstNodeAifType;
        this.dstPortCid = dstPortCid;
        this.dstPortCname = dstPortCname;
        this.dstPortCvalue = dstPortCvalue;
        this.dstPortCoperator = dstPortCoperator;
        this.dstPortCtype = dstPortCtype;
        this.dstIngLsrid = dstIngLsrid;
        this.dstEgrLsrid = dstEgrLsrid;
        this.dstInLabel = dstInLabel;
        this.dstOutLabel = dstOutLabel;
        this.msTunnelCount = msTunnelCount;
        this.msPwCount = msPwCount;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1ServiceExt{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", servName='" + servName + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", pwId='" + pwId + '\'' +
                ", scId='" + scId + '\'' +
                ", sccName='" + sccName + '\'' +
                ", sccValue='" + sccValue + '\'' +
                ", sccOperator='" + sccOperator + '\'' +
                ", scType='" + scType + '\'' +
                ", nodeRole='" + nodeRole + '\'' +
                ", tidRole='" + tidRole + '\'' +
                ", srcPwid='" + srcPwid + '\'' +
                ", srcVsiId='" + srcVsiId + '\'' +
                ", srcSubnet='" + srcSubnet + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", srcAid='" + srcAid + '\'' +
                ", srcNodeAifId='" + srcNodeAifId + '\'' +
                ", srcNodeAifName='" + srcNodeAifName + '\'' +
                ", srcNodeAifType='" + srcNodeAifType + '\'' +
                ", srcPortCid='" + srcPortCid + '\'' +
                ", srcPortCname='" + srcPortCname + '\'' +
                ", srcPortCvalue='" + srcPortCvalue + '\'' +
                ", srcPortCoperator='" + srcPortCoperator + '\'' +
                ", srcPortCtype='" + srcPortCtype + '\'' +
                ", srcIngLsrid='" + srcIngLsrid + '\'' +
                ", srcEgrLsrid='" + srcEgrLsrid + '\'' +
                ", srcInLabel='" + srcInLabel + '\'' +
                ", srcOutLabel='" + srcOutLabel + '\'' +
                ", dstPwid='" + dstPwid + '\'' +
                ", dstVsiId='" + dstVsiId + '\'' +
                ", dstSubnet='" + dstSubnet + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", dstAid='" + dstAid + '\'' +
                ", dstNodeAifId='" + dstNodeAifId + '\'' +
                ", dstNodeAifName='" + dstNodeAifName + '\'' +
                ", dstNodeAifType='" + dstNodeAifType + '\'' +
                ", dstPortCid='" + dstPortCid + '\'' +
                ", dstPortCname='" + dstPortCname + '\'' +
                ", dstPortCvalue='" + dstPortCvalue + '\'' +
                ", dstPortCoperator='" + dstPortCoperator + '\'' +
                ", dstPortCtype='" + dstPortCtype + '\'' +
                ", dstIngLsrid='" + dstIngLsrid + '\'' +
                ", dstEgrLsrid='" + dstEgrLsrid + '\'' +
                ", dstInLabel='" + dstInLabel + '\'' +
                ", dstOutLabel='" + dstOutLabel + '\'' +
                ", msTunnelCount='" + msTunnelCount + '\'' +
                ", msPwCount='" + msPwCount + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
