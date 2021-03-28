package com.woorinet.plugin.demo.DTO.TL1.CM;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name="tl1_bypass_info")
public class Tl1BypassInfo {
    @Id
    @GeneratedValue
    int bypassInfoId;
    String tid;
    String subnetwork;
    String aid;
    String mode;
    String action;
    String currentAction;
    String peerMode;
    String peerAction;
    String peerCurrentAction;
    String syncDate;

    public Tl1BypassInfo() {
    }

    public Tl1BypassInfo(String tid, String subnetwork, String aid, String mode, String action, String currentAction, String peerMode, String peerAction, String peerCurrentAction, String syncDate) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.mode = mode;
        this.action = action;
        this.currentAction = currentAction;
        this.peerMode = peerMode;
        this.peerAction = peerAction;
        this.peerCurrentAction = peerCurrentAction;
        this.syncDate = syncDate;
    }

    public Tl1BypassInfo(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.mode = fields[3];
        this.action = fields[4];
        this.currentAction = fields[5];
        this.peerMode = fields[6];
        this.peerAction = fields[7];
        this.peerCurrentAction = fields[8];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1BypassInfo{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", mode='" + mode + '\'' +
                ", action='" + action + '\'' +
                ", currentAction='" + currentAction + '\'' +
                ", peerMode='" + peerMode + '\'' +
                ", peerAction='" + peerAction + '\'' +
                ", peerCurrentAction='" + peerCurrentAction + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}