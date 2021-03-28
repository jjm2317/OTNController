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
@Table(name = "tl1_sess_state")
public class Tl1SessState {
    @Id
    @GeneratedValue
    int sessStateId;
    String tid;
    String subnetwork;
    String aid;
    String localIp;
    String remoteIp;
    String kspMode;
    String deadTime;
    String keyLifeTime;
    String keySrcMode;
    String keyFailover;
    String retryReqInterval;
    String sessionState;
    String dstLid;
    String currentTxKeySrcMode;
    String currentRxKeySrcMode;
    String syncDate;

    public Tl1SessState() {
    }

    public Tl1SessState(String tid, String subnetwork, String aid, String localIp, String remoteIp, String kspMode, String deadTime, String keyLifeTime, String keySrcMode, String keyFailover, String retryReqInterval, String sessionState, String dstLid, String currentTxKeySrcMode, String currentRxKeySrcMode) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.localIp = localIp;
        this.remoteIp = remoteIp;
        this.kspMode = kspMode;
        this.deadTime = deadTime;
        this.keyLifeTime = keyLifeTime;
        this.keySrcMode = keySrcMode;
        this.keyFailover = keyFailover;
        this.retryReqInterval = retryReqInterval;
        this.sessionState = sessionState;
        this.dstLid = dstLid;
        this.currentTxKeySrcMode = currentTxKeySrcMode;
        this.currentRxKeySrcMode = currentRxKeySrcMode;
    }

    public Tl1SessState(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.localIp = fields[3];
        this.remoteIp = fields[4];
        this.kspMode = fields[5];
        this.deadTime = fields[6];
        this.keyLifeTime = fields[7];
        this.keySrcMode = fields[8];
        this.keyFailover = fields[9];
        this.retryReqInterval = fields[10];
        this.sessionState = fields[11];
        this.dstLid = fields[12];
        this.currentTxKeySrcMode = fields[13];
        this.currentRxKeySrcMode = fields[14];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1SessState{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", localIp='" + localIp + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", kspMode='" + kspMode + '\'' +
                ", deadTime='" + deadTime + '\'' +
                ", keyLifeTime='" + keyLifeTime + '\'' +
                ", keySrcMode='" + keySrcMode + '\'' +
                ", keyFailover='" + keyFailover + '\'' +
                ", retryReqInterval='" + retryReqInterval + '\'' +
                ", sessionState='" + sessionState + '\'' +
                ", dstLid='" + dstLid + '\'' +
                ", currentTxKeySrcMode='" + currentTxKeySrcMode + '\'' +
                ", currentRxKeySrcMode='" + currentRxKeySrcMode + '\'' +
                '}';
    }
}
