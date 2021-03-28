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
@Table(name = "tl1_service_tunnel")
public class Tl1ServiceTunnel {
    @Id
    @GeneratedValue
    int serviceTunnelId;
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    String pwId;
    String serviceName;
    String owTid;
    String owTidId;
    String owTunnelId;
    String owTunnelName;
    String owStartConnid;
    String owConnId;
    String owConnType;
    String owIngid;
    String owEgrid;
    String owServType;
    String owServRate;
    String owInLabel;
    String owOutLabel;
    String opTid;
    String opTidId;
    String owTunnelId2;
    String owTunnelName2;
    String opStartConnid;
    String opConnId;
    String opConnType;
    String opIngid;
    String opEgrid;
    String opServType;
    String opServRate;
    String opInLabel;
    String opOutLabel;
    String hlpcf;
    String pcp;
    String syncDate;

    public Tl1ServiceTunnel() {

    }

    public Tl1ServiceTunnel(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.pwId = fields[4];
        this.serviceName = fields[5];
        this.owTid = fields[6];
        this.owTidId = fields[7];
        this.owTunnelId = fields[8];
        this.owTunnelName = fields[9];
        this.owStartConnid = fields[10];
        this.owConnId = fields[11];
        this.owConnType = fields[12];
        this.owIngid = fields[13];
        this.owEgrid = fields[14];
        this.owServType = fields[15];
        this.owServRate = fields[16];
        this.owInLabel = fields[17];
        this.owOutLabel = fields[18];
        this.opTid = fields[19];
        this.opTidId = fields[20];
        this.owTunnelId2 = fields[21];
        this.owTunnelName2 = fields[22];
        this.opStartConnid = fields[23];
        this.opConnId = fields[24];
        this.opConnType = fields[25];
        this.opIngid = fields[26];
        this.opEgrid = fields[27];
        this.opServType = fields[28];
        this.opServRate = fields[29];
        this.opInLabel = fields[30];
        this.opOutLabel = fields[31];
        this.hlpcf = fields[32];
        this.pcp = fields[33];
        this.syncDate = syncDate;
    }

    public Tl1ServiceTunnel(String tidId, String tid, String subnetId, String subnet, String pwId, String serviceName, String owTid, String owTidId, String owTunnelId, String owTunnelName, String owStartConnid, String owConnId, String owConnType, String owIngid, String owEgrid, String owServType, String owServRate, String owInLabel, String owOutLabel, String opTid, String opTidId, String owTunnelId2, String owTunnelName2, String opStartConnid, String opConnId, String opConnType, String opIngid, String opEgrid, String opServType, String opServRate, String opInLabel, String opOutLabel, String hlpcf, String pcp) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.pwId = pwId;
        this.serviceName = serviceName;
        this.owTid = owTid;
        this.owTidId = owTidId;
        this.owTunnelId = owTunnelId;
        this.owTunnelName = owTunnelName;
        this.owStartConnid = owStartConnid;
        this.owConnId = owConnId;
        this.owConnType = owConnType;
        this.owIngid = owIngid;
        this.owEgrid = owEgrid;
        this.owServType = owServType;
        this.owServRate = owServRate;
        this.owInLabel = owInLabel;
        this.owOutLabel = owOutLabel;
        this.opTid = opTid;
        this.opTidId = opTidId;
        this.owTunnelId2 = owTunnelId2;
        this.owTunnelName2 = owTunnelName2;
        this.opStartConnid = opStartConnid;
        this.opConnId = opConnId;
        this.opConnType = opConnType;
        this.opIngid = opIngid;
        this.opEgrid = opEgrid;
        this.opServType = opServType;
        this.opServRate = opServRate;
        this.opInLabel = opInLabel;
        this.opOutLabel = opOutLabel;
        this.hlpcf = hlpcf;
        this.pcp = pcp;
    }

    @Override
    public String toString() {
        return "Tl1ServiceTunnel{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", pwId='" + pwId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", owTid='" + owTid + '\'' +
                ", owTidId='" + owTidId + '\'' +
                ", owTunnelId='" + owTunnelId + '\'' +
                ", owTunnelName='" + owTunnelName + '\'' +
                ", owStartConnid='" + owStartConnid + '\'' +
                ", owConnId='" + owConnId + '\'' +
                ", owConnType='" + owConnType + '\'' +
                ", owIngid='" + owIngid + '\'' +
                ", owEgrid='" + owEgrid + '\'' +
                ", owServType='" + owServType + '\'' +
                ", owServRate='" + owServRate + '\'' +
                ", owInLabel='" + owInLabel + '\'' +
                ", owOutLabel='" + owOutLabel + '\'' +
                ", opTid='" + opTid + '\'' +
                ", opTidId='" + opTidId + '\'' +
                ", owTunnelId2='" + owTunnelId2 + '\'' +
                ", owTunnelName2='" + owTunnelName2 + '\'' +
                ", opStartConnid='" + opStartConnid + '\'' +
                ", opConnId='" + opConnId + '\'' +
                ", opConnType='" + opConnType + '\'' +
                ", opIngid='" + opIngid + '\'' +
                ", opEgrid='" + opEgrid + '\'' +
                ", opServType='" + opServType + '\'' +
                ", opServRate='" + opServRate + '\'' +
                ", opInLabel='" + opInLabel + '\'' +
                ", opOutLabel='" + opOutLabel + '\'' +
                ", hlpcf='" + hlpcf + '\'' +
                ", pcp='" + pcp + '\'' +
                '}';
    }
}
