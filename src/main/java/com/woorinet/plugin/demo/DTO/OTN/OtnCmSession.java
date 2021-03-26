package com.woorinet.plugin.demo.DTO.OTN;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OtnCmSession {
    @Id
    @GeneratedValue
    int otnCmSessionId;
    String tid;
    String slot;
    String port;
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
    String txKeyState;
    String txKeyBankState;
    String rxKeyState;
    String rxKeyBankState;
    String bypassMode;
    String bypassAction;
    String bypassCurrentAction;
    String bypassPeerMode;
    String bypassPeerAction;
    String bypassPeerCurrentAction;

    public OtnCmSession() {
    }

    public OtnCmSession(String tid, String slot, String port, String localIp, String remoteIp, String kspMode, String deadTime, String keyLifeTime, String keySrcMode, String keyFailover, String retryReqInterval, String sessionState, String dstLid, String currentTxKeySrcMode, String currentRxKeySrcMode, String txKeyState, String txKeyBankState, String rxKeyState, String rxKeyBankState, String bypassMode, String bypassAction, String bypassCurrentAction, String bypassPeerMode, String bypassPeerAction, String bypassPeerCurrentAction) {
        this.tid = tid;
        this.slot = slot;
        this.port = port;
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
        this.txKeyState = txKeyState;
        this.txKeyBankState = txKeyBankState;
        this.rxKeyState = rxKeyState;
        this.rxKeyBankState = rxKeyBankState;
        this.bypassMode = bypassMode;
        this.bypassAction = bypassAction;
        this.bypassCurrentAction = bypassCurrentAction;
        this.bypassPeerMode = bypassPeerMode;
        this.bypassPeerAction = bypassPeerAction;
        this.bypassPeerCurrentAction = bypassPeerCurrentAction;
    }

    @Override
    public String toString() {
        return "OtnCmSession{" +
                "tid='" + tid + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
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
                ", txKeyState='" + txKeyState + '\'' +
                ", txKeyBankState='" + txKeyBankState + '\'' +
                ", rxKeyState='" + rxKeyState + '\'' +
                ", rxKeyBankState='" + rxKeyBankState + '\'' +
                ", bypassMode='" + bypassMode + '\'' +
                ", bypassAction='" + bypassAction + '\'' +
                ", bypassCurrentAction='" + bypassCurrentAction + '\'' +
                ", bypassPeerMode='" + bypassPeerMode + '\'' +
                ", bypassPeerAction='" + bypassPeerAction + '\'' +
                ", bypassPeerCurrentAction='" + bypassPeerCurrentAction + '\'' +
                '}';
    }
}
