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
@Table(name = "tl1_cm_port")
public class Tl1CmPort {
    @Id
    @GeneratedValue
    int cmPortId;
    String tid;
    String subnetwork;
    String aid;
    String unitType;
    String signal;
    String vlanId;
    String syncDate;

    public Tl1CmPort() {
    }

    public Tl1CmPort(String tid, String subnetwork, String aid, String unitType, String signal, String vlanId) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.unitType = unitType;
        this.signal = signal;
        this.vlanId = vlanId;
    }

    public Tl1CmPort(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.unitType = fields[3];
        this.signal = fields[4];
        this.vlanId = fields[5];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1CmPort{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", unitType='" + unitType + '\'' +
                ", signal='" + signal + '\'' +
                ", vlanId='" + vlanId + '\'' +
                '}';
    }
}
