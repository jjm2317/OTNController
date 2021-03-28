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
@Table(name = "tl1_mpls_if")
public class Tl1MplsIf {
    @Id
    @GeneratedValue
    int mplsIfId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String mplsTpId;
    String bp;
    String localId;
    String requestId;
    String name;
    String srcSubnet;
    String srcTidId;
    String srcTid;
    String srcPort;
    String dstSubnet;
    String dstTidId;
    String dstTid;
    String dstPort;
    String operationStatus;
    String configurationAction;
    String configurationResult;
    String cir;
    String pir;
    String depEnabler;
    String depStatus;
    String constraintId;
    String constraintName;
    String constraintValue;
    String constraintOperator;
    String portConstraintType;
    String maximumBandwidth;
    String availableBandwidth;
    String linkType;
    String isVendor;
    String remoteNodeid;
    String remoteNodeConnector;
    String remoteTopologyid;
    String remoteMplsif;
    String peerMacAddress;
    String mplsifType;
    String syncDate;

    public Tl1MplsIf() {

    }

    public Tl1MplsIf(String tidId, String tid, String subnetId, String subnet, String mplsTpId, String bp, String localId, String requestId, String name, String srcSubnet, String srcTidId, String srcTid, String srcPort, String dstSubnet, String dstTidId, String dstTid, String dstPort, String operationStatus, String configurationAction, String configurationResult, String cir, String pir, String depEnabler, String depStatus, String constraintId, String constraintName, String constraintValue, String constraintOperator, String portConstraintType, String maximumBandwidth, String availableBandwidth, String linkType, String isVendor, String remoteNodeid, String remoteNodeConnector, String remoteTopologyid, String remoteMplsif, String peerMacAddress, String mplsifType, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.mplsTpId = mplsTpId;
        this.bp = bp;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.srcSubnet = srcSubnet;
        this.srcTidId = srcTidId;
        this.srcTid = srcTid;
        this.srcPort = srcPort;
        this.dstSubnet = dstSubnet;
        this.dstTidId = dstTidId;
        this.dstTid = dstTid;
        this.dstPort = dstPort;
        this.operationStatus = operationStatus;
        this.configurationAction = configurationAction;
        this.configurationResult = configurationResult;
        this.cir = cir;
        this.pir = pir;
        this.depEnabler = depEnabler;
        this.depStatus = depStatus;
        this.constraintId = constraintId;
        this.constraintName = constraintName;
        this.constraintValue = constraintValue;
        this.constraintOperator = constraintOperator;
        this.portConstraintType = portConstraintType;
        this.maximumBandwidth = maximumBandwidth;
        this.availableBandwidth = availableBandwidth;
        this.linkType = linkType;
        this.isVendor = isVendor;
        this.remoteNodeid = remoteNodeid;
        this.remoteNodeConnector = remoteNodeConnector;
        this.remoteTopologyid = remoteTopologyid;
        this.remoteMplsif = remoteMplsif;
        this.peerMacAddress = peerMacAddress;
        this.mplsifType = mplsifType;
        this.syncDate = syncDate;
    }

    public Tl1MplsIf(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.mplsTpId = fields[4];
        this.bp = fields[5];
        this.localId = fields[6];
        this.requestId = fields[7];
        this.name = fields[8];
        this.srcSubnet = fields[9];
        this.srcTidId = fields[10];
        this.srcTid = fields[11];
        this.srcPort = fields[12];
        this.dstSubnet = fields[13];
        this.dstTidId = fields[14];
        this.dstTid = fields[15];
        this.dstPort = fields[16];
        this.operationStatus = fields[17];
        this.configurationAction = fields[18];
        this.configurationResult = fields[19];
        this.cir = fields[20];
        this.pir = fields[21];
        this.depEnabler = fields[22];
        this.depStatus = fields[23];
        this.constraintId = fields[24];
        this.constraintName = fields[25];
        this.constraintValue = fields[26];
        this.constraintOperator = fields[27];
        this.portConstraintType = fields[28];
        this.maximumBandwidth = fields[29];
        this.availableBandwidth = fields[30];
        this.linkType = fields[31];
        this.isVendor = fields[32];
        this.remoteNodeid = fields[33];
        this.remoteNodeConnector = fields[34];
        this.remoteTopologyid = fields[35];
        this.remoteMplsif = fields[36];
        this.peerMacAddress = fields[37];
        this.mplsifType = fields[38];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1MplsIf{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", mplsTpId='" + mplsTpId + '\'' +
                ", bp='" + bp + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", srcSubnet='" + srcSubnet + '\'' +
                ", srcTidId='" + srcTidId + '\'' +
                ", srcTid='" + srcTid + '\'' +
                ", srcPort='" + srcPort + '\'' +
                ", dstSubnet='" + dstSubnet + '\'' +
                ", dstTidId='" + dstTidId + '\'' +
                ", dstTid='" + dstTid + '\'' +
                ", dstPort='" + dstPort + '\'' +
                ", operationStatus='" + operationStatus + '\'' +
                ", configurationAction='" + configurationAction + '\'' +
                ", configurationResult='" + configurationResult + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", depEnabler='" + depEnabler + '\'' +
                ", depStatus='" + depStatus + '\'' +
                ", constraintId='" + constraintId + '\'' +
                ", constraintName='" + constraintName + '\'' +
                ", constraintValue='" + constraintValue + '\'' +
                ", constraintOperator='" + constraintOperator + '\'' +
                ", portConstraintType='" + portConstraintType + '\'' +
                ", maximumBandwidth='" + maximumBandwidth + '\'' +
                ", availableBandwidth='" + availableBandwidth + '\'' +
                ", linkType='" + linkType + '\'' +
                ", isVendor='" + isVendor + '\'' +
                ", remoteNodeid='" + remoteNodeid + '\'' +
                ", remoteNodeConnector='" + remoteNodeConnector + '\'' +
                ", remoteTopologyid='" + remoteTopologyid + '\'' +
                ", remoteMplsif='" + remoteMplsif + '\'' +
                ", peerMacAddress='" + peerMacAddress + '\'' +
                ", mplsifType='" + mplsifType + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
