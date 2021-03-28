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
@Table(name = "tl1_eth_port")
public class Tl1EthPort {
    @Id
    @GeneratedValue
    int ethPortId;
    String tid;
    String aid;
    String name;
    String descr;
    String state;
    String speed;
    String duplex;
    String autoNego;
    String txFx;
    String pauseTx;
    String pauseRx;
    String maxFrame;
    String loopback;
    String maxLearningMac;
    String ethPtm;
    String portShutdown;
    String tpidProfId;
    String linkStatus;
    String stpState;
    String txStatus;
    String counter;
    String pollRate;
    String preportPm;
    String mouniteNoPkt;
    String sdEnable;
    String sdThCount;
    String syncDate;

    public Tl1EthPort() {

    }

    public Tl1EthPort(String tid, String aid, String name, String descr, String state, String speed, String duplex, String autoNego, String txFx, String pauseTx, String pauseRx, String maxFrame, String loopback, String maxLearningMac, String ethPtm, String portShutdown, String tpidProfId, String linkStatus, String stpState, String txStatus, String counter, String pollRate, String preportPm, String mouniteNoPkt, String sdEnable, String sdThCount, String syncDate) {
        this.tid = tid;
        this.aid = aid;
        this.name = name;
        this.descr = descr;
        this.state = state;
        this.speed = speed;
        this.duplex = duplex;
        this.autoNego = autoNego;
        this.txFx = txFx;
        this.pauseTx = pauseTx;
        this.pauseRx = pauseRx;
        this.maxFrame = maxFrame;
        this.loopback = loopback;
        this.maxLearningMac = maxLearningMac;
        this.ethPtm = ethPtm;
        this.portShutdown = portShutdown;
        this.tpidProfId = tpidProfId;
        this.linkStatus = linkStatus;
        this.stpState = stpState;
        this.txStatus = txStatus;
        this.counter = counter;
        this.pollRate = pollRate;
        this.preportPm = preportPm;
        this.mouniteNoPkt = mouniteNoPkt;
        this.sdEnable = sdEnable;
        this.sdThCount = sdThCount;
        this.syncDate = syncDate;
    }

    public Tl1EthPort(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.aid = fields[1];
        this.name = fields[2];
        this.descr = fields[3];
        this.state = fields[4];
        this.speed = fields[5];
        this.duplex = fields[6];
        this.autoNego = fields[7];
        this.txFx = fields[8];
        this.pauseTx = fields[9];
        this.pauseRx = fields[10];
        this.maxFrame = fields[11];
        this.loopback = fields[11];
        this.maxLearningMac = fields[12];
        this.ethPtm = fields[13];
        this.portShutdown = fields[14];
        this.tpidProfId = fields[15];
        this.linkStatus = fields[16];
        this.stpState = fields[17];
        this.txStatus = fields[18];
        this.counter = fields[19];
        this.pollRate = fields[20];
        this.preportPm = fields[21];
        this.mouniteNoPkt = fields[22];
        this.sdEnable = fields[23];
        this.sdThCount = fields[24];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1EthPort{" +
                "tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", state='" + state + '\'' +
                ", speed='" + speed + '\'' +
                ", duplex='" + duplex + '\'' +
                ", autoNego='" + autoNego + '\'' +
                ", txFx='" + txFx + '\'' +
                ", pauseTx='" + pauseTx + '\'' +
                ", pauseRx='" + pauseRx + '\'' +
                ", maxFrame='" + maxFrame + '\'' +
                ", loopback='" + loopback + '\'' +
                ", maxLearningMac='" + maxLearningMac + '\'' +
                ", ethPtm='" + ethPtm + '\'' +
                ", portShutdown='" + portShutdown + '\'' +
                ", tpidProfId='" + tpidProfId + '\'' +
                ", linkStatus='" + linkStatus + '\'' +
                ", stpState='" + stpState + '\'' +
                ", txStatus='" + txStatus + '\'' +
                ", counter='" + counter + '\'' +
                ", pollRate='" + pollRate + '\'' +
                ", preportPm='" + preportPm + '\'' +
                ", mouniteNoPkt='" + mouniteNoPkt + '\'' +
                ", sdEnable='" + sdEnable + '\'' +
                ", sdThCount='" + sdThCount + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
