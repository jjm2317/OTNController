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
    int ETH_PORT_ID;
    String TID;
    String AID;
    String NAME;
    String DESCR;
    String STATE;
    String SPEED;
    String DUPLEX;
    String AUTO_NEGO;
    String TX_FX;
    String PAUSE_TX;
    String PAUSE_RX;
    String MAX_FRAME;
    String LOOPBACK;
    String MAX_LEARNING_MAC;
    String ETH_PTM;
    String PORT_SHUTDOWN;
    String TPID_PROF_ID;
    String LINK_STATUS;
    String STP_STATE;
    String TX_STATUS;
    String COUNTER;
    String POLL_RATE;
    String PREPORT_PM;
    String MOUNITE_NO_PKT;
    String SD_ENABLE;
    String SD_TH_COUNT;

    public Tl1EthPort() {

    }

    public Tl1EthPort(String TID, String AID, String NAME, String DESCR, String STATE, String SPEED, String DUPLEX, String AUTO_NEGO, String TX_FX, String PAUSE_TX, String PAUSE_RX, String MAX_FRAME, String LOOPBACK, String MAX_LEARNING_MAC, String ETH_PTM, String PORT_SHUTDOWN, String TPID_PROF_ID, String LINK_STATUS, String STP_STATE, String TX_STATUS, String COUNTER, String POLL_RATE, String PREPORT_PM, String MOUNITE_NO_PKT, String SD_ENABLE, String SD_TH_COUNT) {
        this.TID = TID;
        this.AID = AID;
        this.NAME = NAME;
        this.DESCR = DESCR;
        this.STATE = STATE;
        this.SPEED = SPEED;
        this.DUPLEX = DUPLEX;
        this.AUTO_NEGO = AUTO_NEGO;
        this.TX_FX = TX_FX;
        this.PAUSE_TX = PAUSE_TX;
        this.PAUSE_RX = PAUSE_RX;
        this.MAX_FRAME = MAX_FRAME;
        this.LOOPBACK = LOOPBACK;
        this.MAX_LEARNING_MAC = MAX_LEARNING_MAC;
        this.ETH_PTM = ETH_PTM;
        this.PORT_SHUTDOWN = PORT_SHUTDOWN;
        this.TPID_PROF_ID = TPID_PROF_ID;
        this.LINK_STATUS = LINK_STATUS;
        this.STP_STATE = STP_STATE;
        this.TX_STATUS = TX_STATUS;
        this.COUNTER = COUNTER;
        this.POLL_RATE = POLL_RATE;
        this.PREPORT_PM = PREPORT_PM;
        this.MOUNITE_NO_PKT = MOUNITE_NO_PKT;
        this.SD_ENABLE = SD_ENABLE;
        this.SD_TH_COUNT = SD_TH_COUNT;
    }

    public Tl1EthPort(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.NAME = fields[2];
        this.DESCR = fields[3];
        this.STATE = fields[4];
        this.SPEED = fields[5];
        this.DUPLEX = fields[6];
        this.AUTO_NEGO = fields[7];
        this.TX_FX = fields[8];
        this.PAUSE_TX = fields[9];
        this.PAUSE_RX = fields[10];
        this.MAX_FRAME = fields[11];
        this.LOOPBACK = fields[11];
        this.MAX_LEARNING_MAC = fields[12];
        this.ETH_PTM = fields[13];
        this.PORT_SHUTDOWN = fields[14];
        this.TPID_PROF_ID = fields[15];
        this.LINK_STATUS = fields[16];
        this.STP_STATE = fields[17];
        this.TX_STATUS = fields[18];
        this.COUNTER = fields[19];
        this.POLL_RATE = fields[20];
        this.PREPORT_PM = fields[21];
        this.MOUNITE_NO_PKT = fields[22];
        this.SD_ENABLE = fields[23];
        this.SD_TH_COUNT = fields[24];
    }

    @Override
    public String toString() {
        return "EthPort{" +
                "TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", DESCR='" + DESCR + '\'' +
                ", STATE='" + STATE + '\'' +
                ", SPEED='" + SPEED + '\'' +
                ", DUPLEX='" + DUPLEX + '\'' +
                ", AUTO_NEGO='" + AUTO_NEGO + '\'' +
                ", TX_FX='" + TX_FX + '\'' +
                ", PAUSE_TX='" + PAUSE_TX + '\'' +
                ", PAUSE_RX='" + PAUSE_RX + '\'' +
                ", MAX_FRAME='" + MAX_FRAME + '\'' +
                ", LOOPBACK='" + LOOPBACK + '\'' +
                ", MAX_LEARNING_MAC='" + MAX_LEARNING_MAC + '\'' +
                ", ETH_PTM='" + ETH_PTM + '\'' +
                ", PORT_SHUTDOWN='" + PORT_SHUTDOWN + '\'' +
                ", TPID_PROF_ID='" + TPID_PROF_ID + '\'' +
                ", LINK_STATUS='" + LINK_STATUS + '\'' +
                ", STP_STATE='" + STP_STATE + '\'' +
                ", TX_STATUS='" + TX_STATUS + '\'' +
                ", COUNTER='" + COUNTER + '\'' +
                ", POLL_RATE='" + POLL_RATE + '\'' +
                ", PREPORT_PM='" + PREPORT_PM + '\'' +
                ", MOUNITE_NO_PKT='" + MOUNITE_NO_PKT + '\'' +
                ", SD_ENABLE='" + SD_ENABLE + '\'' +
                ", SD_TH_COUNT='" + SD_TH_COUNT + '\'' +
                '}';
    }
}
