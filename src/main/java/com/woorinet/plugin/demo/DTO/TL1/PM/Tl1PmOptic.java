package com.woorinet.plugin.demo.DTO.TL1.PM;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@Table(name = "tl1_pm_optic")
public class Tl1PmOptic {
    @Id
    @GeneratedValue
    int pmOpticId;
    String tid;
    String systemType;
    String slot;
    String port;
    String pmType;
    String rxMinPower;
    String rxMaxPower;
    String rxAvgPower;
    String txMinPower;
    String txMaxPower;
    String txAvgPower;
    String date;

    public Tl1PmOptic(String tid, String systemType, String slot, String port, String pmType, String rxMinPower, String rxMaxPower, String rxAvgPower, String txMinPower, String txMaxPower, String txAvgPower, String date) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.pmType = pmType;
        this.rxMinPower = rxMinPower;
        this.rxMaxPower = rxMaxPower;
        this.rxAvgPower = rxAvgPower;
        this.txMinPower = txMinPower;
        this.txMaxPower = txMaxPower;
        this.txAvgPower = txAvgPower;
        this.date = date;
    }

    public Tl1PmOptic(String[] fields) {
        this.tid = fields[0];
        this.systemType = fields[1];
        this.slot = fields[2];
        this.port = fields[3];
        this.pmType = fields[4];
        this.rxMinPower = fields[5];
        this.rxMaxPower = fields[6];
        this.rxAvgPower = fields[7];
        this.txMinPower = fields[8];
        this.txMaxPower = fields[9];
        this.txAvgPower = fields[10];
        this.date = fields[11];
    }

    @Override
    public String toString() {
        return "Tl1PmOptic{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", pmType='" + pmType + '\'' +
                ", rxMinPower='" + rxMinPower + '\'' +
                ", rxMaxPower='" + rxMaxPower + '\'' +
                ", rxAvgPower='" + rxAvgPower + '\'' +
                ", txMinPower='" + txMinPower + '\'' +
                ", txMaxPower='" + txMaxPower + '\'' +
                ", txAvgPower='" + txAvgPower + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
