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
@Table(name = "tl1_optic_power")
public class Tl1OpticPower {
    @Id
    @GeneratedValue
    int opticPowerId;
    String tid;
    String aid;
    String unitType;
    String moduleEquip;
    String core;
    String lcorsc;
    String upcorapc;
    String supportSignal;
    String moduleType;
    String txChannel;
    String txWavelength;
    String rxChannel;
    String rxWavelength;
    String distance;
    String txPower;
    String rxPower;
    String txBiasCurrent;
    String faultNumber;
    String faultDistance;
    String vendor;
    String partNumber;
    String serial;
    String syncDate;

    public Tl1OpticPower() {

    }

    public Tl1OpticPower(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.aid = fields[1];
        this.unitType = fields[2];
        this.moduleEquip = fields[3];
        this.core = fields[4];
        this.lcorsc = fields[5];
        this.upcorapc = fields[6];
        this.supportSignal = fields[7];
        this.moduleType = fields[8];
        this.txChannel = fields[9];
        this.txWavelength = fields[10];
        this.rxChannel = fields[11];
        this.rxWavelength = fields[12];
        this.distance = fields[13];
        this.txPower = fields[14];
        this.rxPower = fields[15];
        this.txBiasCurrent = fields[16];
        this.faultNumber = fields[17];
        this.faultDistance = fields[18];
        this.vendor = fields[19];
        this.partNumber = fields[20];
        this.serial = fields[21];
        this.syncDate = syncDate;
    }


    public Tl1OpticPower(String tid, String aid, String unitType, String moduleEquip, String core, String lcorsc, String upcorapc, String supportSignal, String moduleType, String txChannel, String txWavelength, String rxChannel, String rxWavelength, String distance, String txPower, String rxPower, String txBiasCurrent, String faultNumber, String faultDistance, String vendor, String partNumber, String serial, String syncDate) {
        this.tid = tid;
        this.aid = aid;
        this.unitType = unitType;
        this.moduleEquip = moduleEquip;
        this.core = core;
        this.lcorsc = lcorsc;
        this.upcorapc = upcorapc;
        this.supportSignal = supportSignal;
        this.moduleType = moduleType;
        this.txChannel = txChannel;
        this.txWavelength = txWavelength;
        this.rxChannel = rxChannel;
        this.rxWavelength = rxWavelength;
        this.distance = distance;
        this.txPower = txPower;
        this.rxPower = rxPower;
        this.txBiasCurrent = txBiasCurrent;
        this.faultNumber = faultNumber;
        this.faultDistance = faultDistance;
        this.vendor = vendor;
        this.partNumber = partNumber;
        this.serial = serial;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1OpticPower{" +
                "tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", unitType='" + unitType + '\'' +
                ", moduleEquip='" + moduleEquip + '\'' +
                ", core='" + core + '\'' +
                ", lcorsc='" + lcorsc + '\'' +
                ", upcorapc='" + upcorapc + '\'' +
                ", supportSignal='" + supportSignal + '\'' +
                ", moduleType='" + moduleType + '\'' +
                ", txChannel='" + txChannel + '\'' +
                ", txWavelength='" + txWavelength + '\'' +
                ", rxChannel='" + rxChannel + '\'' +
                ", rxWavelength='" + rxWavelength + '\'' +
                ", distance='" + distance + '\'' +
                ", txPower='" + txPower + '\'' +
                ", rxPower='" + rxPower + '\'' +
                ", txBiasCurrent='" + txBiasCurrent + '\'' +
                ", faultNumber='" + faultNumber + '\'' +
                ", faultDistance='" + faultDistance + '\'' +
                ", vendor='" + vendor + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", serial='" + serial + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
