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
@Table(name = "tl1_tunnel_port")
public class Tl1TunnelPort {
    @Id
    @GeneratedValue
    int tunnelPortId;
    String tid;
    String protId;
    String tunnelName;
    String descr;
    String tunnelId;
    String ingLsrId;
    String egrLsrId;
    String protType;
    String revertMode;
    String holdOffTimeMsec;
    String wtrTimeSec;
    String active;
    String state;
    String remainWtrTimeSec;
    String command;
    String workingPid;
    String protectionPid;
    String adminStatus;
    String operStatus;
    String creationDate;
    String modifiedDate;
    String syncDate;

    public Tl1TunnelPort() {

    }

    public Tl1TunnelPort(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.protId = fields[1];
        this.tunnelName = fields[2];
        this.descr = fields[3];
        this.tunnelId = fields[4];
        this.ingLsrId = fields[5];
        this.egrLsrId = fields[6];
        this.protType = fields[7];
        this.revertMode = fields[8];
        this.holdOffTimeMsec = fields[9];
        this.wtrTimeSec = fields[10];
        this.active = fields[11];
        this.state = fields[12];
        this.remainWtrTimeSec = fields[13];
        this.command = fields[14];
        this.workingPid = fields[15];
        this.protectionPid = fields[16];
        this.adminStatus = fields[17];
        this.operStatus = fields[18];
        this.creationDate = fields[19];
        this.modifiedDate = fields[20];
        this.syncDate = syncDate;
    }



}
