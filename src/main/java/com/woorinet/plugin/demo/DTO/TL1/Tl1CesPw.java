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
@Table(name = "tl1_ces_pw")
public class Tl1CesPw {
    @Id
    @GeneratedValue
    int cesPwId;
    String tid;
    String serviceName;
    String description;
    String aid;
    String serviceType;
    String ds0;
    String unitType;
    String vlanId;
    String destPort;
    String srcPort;
    String clkMaster;
    String enable;
    String clkRec;
    String vsiId;
    String jbsize;
    String rxsize;
    String wintx;
    String dusize;
    String creationDate;
    String modifiedDate;
    String cesBandwidth;
    String tsPos;
    String tsLen;
    String syncDate;

    public Tl1CesPw() {

    }

    public Tl1CesPw(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.serviceName = fields[1];
        this.description = fields[2];
        this.aid = fields[3];
        this.serviceType = fields[4];
        this.ds0 = fields[5];
        this.unitType = fields[6];
        this.vlanId = fields[7];
        this.destPort = fields[8];
        this.srcPort = fields[9];
        this.clkMaster = fields[10];
        this.enable = fields[11];
        this.clkRec = fields[12];
        this.vsiId = fields[13];
        this.jbsize = fields[14];
        this.rxsize = fields[15];
        this.wintx = fields[16];
        this.dusize = fields[17];
        this.creationDate = fields[18];
        this.modifiedDate = fields[19];
        this.cesBandwidth = fields[20];
        this.tsPos = fields[21];
        this.tsLen = fields[22];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1CesPw{" +
                "tid='" + tid + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", aid='" + aid + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", ds0='" + ds0 + '\'' +
                ", unitType='" + unitType + '\'' +
                ", vlanId='" + vlanId + '\'' +
                ", destPort='" + destPort + '\'' +
                ", srcPort='" + srcPort + '\'' +
                ", clkMaster='" + clkMaster + '\'' +
                ", enable='" + enable + '\'' +
                ", clkRec='" + clkRec + '\'' +
                ", vsiId='" + vsiId + '\'' +
                ", jbsize='" + jbsize + '\'' +
                ", rxsize='" + rxsize + '\'' +
                ", wintx='" + wintx + '\'' +
                ", dusize='" + dusize + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", cesBandwidth='" + cesBandwidth + '\'' +
                ", tsPos='" + tsPos + '\'' +
                ", tsLen='" + tsLen + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }

    public Tl1CesPw(String tid, String serviceName, String description, String aid, String serviceType, String ds0, String unitType, String vlanId, String destPort, String srcPort, String clkMaster, String enable, String clkRec, String vsiId, String jbsize, String rxsize, String wintx, String dusize, String creationDate, String modifiedDate, String cesBandwidth, String tsPos, String tsLen, String syncDate) {
        this.tid = tid;
        this.serviceName = serviceName;
        this.description = description;
        this.aid = aid;
        this.serviceType = serviceType;
        this.ds0 = ds0;
        this.unitType = unitType;
        this.vlanId = vlanId;
        this.destPort = destPort;
        this.srcPort = srcPort;
        this.clkMaster = clkMaster;
        this.enable = enable;
        this.clkRec = clkRec;
        this.vsiId = vsiId;
        this.jbsize = jbsize;
        this.rxsize = rxsize;
        this.wintx = wintx;
        this.dusize = dusize;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
        this.cesBandwidth = cesBandwidth;
        this.tsPos = tsPos;
        this.tsLen = tsLen;
        this.syncDate = syncDate;
    }
}
