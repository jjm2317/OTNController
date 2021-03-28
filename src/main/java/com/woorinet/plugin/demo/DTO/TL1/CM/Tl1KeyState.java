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
@Table(name = "tl1_key_state")
public class Tl1KeyState {
    @Id
    @GeneratedValue
    int keyStateId;
    String tid;
    String subnetwork;
    String aid;
    String txKeyState;
    String txKeyBankState;
    String rxKeyState;
    String rxKeyBankState;
    String syncDate;

    public Tl1KeyState() {
    }

    public Tl1KeyState(String tid, String subnetwork, String aid, String txKeyState, String txKeyBankState, String rxKeyState, String rxKeyBankState) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.txKeyState = txKeyState;
        this.txKeyBankState = txKeyBankState;
        this.rxKeyState = rxKeyState;
        this.rxKeyBankState = rxKeyBankState;
    }

    public Tl1KeyState(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.txKeyState = fields[3];
        this.txKeyBankState = fields[4];
        this.rxKeyState = fields[5];
        this.rxKeyBankState = fields[6];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1KeyState{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", txKeyState='" + txKeyState + '\'' +
                ", txKeyBankState='" + txKeyBankState + '\'' +
                ", rxKeyState='" + rxKeyState + '\'' +
                ", rxKeyBankState='" + rxKeyBankState + '\'' +
                '}';
    }
}
