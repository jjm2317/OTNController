package com.woorinet.plugin.demo.DTO.OTN;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name="otn_crypto_session")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnCryptoSession {
    @Id
    @GeneratedValue
    int cryptoSessionId;
    String aid;
    String localIp;
    String remoteIp;
    String kspMode;
    String deadTime;
    String retryRequestInterval;
    String dstLid;
    String keySourceMode;
    String keyFailoverMode;
    String keyLifeTime;
    String txKeyState;
    String txKeyBankState;
    String rxKeyState;
    String rxKeyBankState;

    public OtnCryptoSession() {

    }

    public OtnCryptoSession(String aid, String localIp, String remoteIp, String kspMode, String deadTime, String retryRequestInterval, String dstLid, String keySourceMode, String keyFailoverMode, String keyLifeTime, String txKeyState, String txKeyBankState, String rxKeyState, String rxKeyBankState) {
        this.aid = aid;
        this.localIp = localIp;
        this.remoteIp = remoteIp;
        this.kspMode = kspMode;
        this.deadTime = deadTime;
        this.retryRequestInterval = retryRequestInterval;
        this.dstLid = dstLid;
        this.keySourceMode = keySourceMode;
        this.keyFailoverMode = keyFailoverMode;
        this.keyLifeTime = keyLifeTime;
        this.txKeyState = txKeyState;
        this.txKeyBankState = txKeyBankState;
        this.rxKeyState = rxKeyState;
        this.rxKeyBankState = rxKeyBankState;
    }

    @Override
    public String toString() {
        return "OtnCryptoSession{" +
                "aid='" + aid + '\'' +
                ", localIp='" + localIp + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", kspMode='" + kspMode + '\'' +
                ", deadTime='" + deadTime + '\'' +
                ", retryRequestInterval='" + retryRequestInterval + '\'' +
                ", dstLid='" + dstLid + '\'' +
                ", keySourceMode='" + keySourceMode + '\'' +
                ", keyFailoverMode='" + keyFailoverMode + '\'' +
                ", keyLifeTime='" + keyLifeTime + '\'' +
                ", txKeyState='" + txKeyState + '\'' +
                ", txKeyBankState='" + txKeyBankState + '\'' +
                ", rxKeyState='" + rxKeyState + '\'' +
                ", rxKeyBankState='" + rxKeyBankState + '\'' +
                '}';
    }
}
