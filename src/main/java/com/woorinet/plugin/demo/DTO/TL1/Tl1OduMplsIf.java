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
@Table(name = "tl1_odu_mpls_if")
public class Tl1OduMplsIf {
    @Id
    @GeneratedValue
    int oduMplsIfId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String mplsTpId;
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

    public Tl1OduMplsIf() {

    }


    public Tl1OduMplsIf(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.mplsTpId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.srcSubnet = fields[8];
        this.srcTidId = fields[9];
        this.srcTid = fields[10];
        this.srcPort = fields[11];
        this.dstSubnet = fields[12];
        this.dstTidId = fields[13];
        this.dstTid = fields[14];
        this.dstPort = fields[15];
        this.operationStatus = fields[16];
        this.configurationAction = fields[17];
        this.configurationResult = fields[18];
        this.cir = fields[19];
        this.pir = fields[20];
        this.depEnabler = fields[21];
        this.depStatus = fields[22];
        this.constraintId = fields[23];
        this.constraintName = fields[24];
        this.constraintValue = fields[25];
        this.constraintOperator = fields[26];
        this.portConstraintType = fields[27];
        this.maximumBandwidth = fields[28];
        this.availableBandwidth = fields[29];
        this.linkType = fields[30];
        this.isVendor = fields[31];
        this.remoteNodeid = fields[32];
        this.remoteNodeConnector = fields[33];
        this.remoteTopologyid = fields[34];
        this.remoteMplsif = fields[35];
        this.peerMacAddress = fields[36];
        this.mplsifType = fields[37];
        this.syncDate = syncDate;
    }




}
