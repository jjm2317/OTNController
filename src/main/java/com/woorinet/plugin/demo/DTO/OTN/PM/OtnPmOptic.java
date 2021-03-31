package com.woorinet.plugin.demo.DTO.OTN.PM;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name = "otn_pm_optic")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPmOptic {
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
    String syncDate;

    public OtnPmOptic() {
    }

    public OtnPmOptic(String tid, String systemType, String slot, String port, String pmType, String rxMinPower, String rxMaxPower, String rxAvgPower, String txMinPower, String txMaxPower, String txAvgPower, String date, String syncDate) {
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
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnPmOptic{" +
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
