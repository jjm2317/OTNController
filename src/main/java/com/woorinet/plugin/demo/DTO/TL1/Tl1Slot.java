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
@Table(name = "tl1_slot")
public class Tl1Slot {
    @GeneratedValue
    @Id
    int slotId;
    String tid;
    String slotPrvUnit;
    String eqUnit;
    String eqState;
    String adminState;
    String initOk;
    String bpState;
    String ipcState;
    String failState;
    String hwVer;
    String swVer;
    String fpgaVer;
    String fpgaDate;
    String syncDate;

    public Tl1Slot() {

    }

    public Tl1Slot(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.slotPrvUnit = fields[1];
        this.eqUnit = fields[2];
        this.eqState = fields[3];
        this.adminState = fields[3];
        this.initOk = fields[4];
        this.bpState = fields[5];
        this.ipcState = fields[6];
        this.failState = fields[7];
        this.hwVer = fields[8];
        this.swVer = fields[9];
        this.fpgaVer = fields[10];
        this.fpgaDate = fields[11];
        this.syncDate = syncDate;
    }

    public Tl1Slot(String tid, String slotPrvUnit, String eqUnit, String eqState, String adminState, String initOk, String bpState, String ipcState, String failState, String hwVer, String swVer, String fpgaVer, String fpgaDate, String syncDate) {
        this.tid = tid;
        this.slotPrvUnit = slotPrvUnit;
        this.eqUnit = eqUnit;
        this.eqState = eqState;
        this.adminState = adminState;
        this.initOk = initOk;
        this.bpState = bpState;
        this.ipcState = ipcState;
        this.failState = failState;
        this.hwVer = hwVer;
        this.swVer = swVer;
        this.fpgaVer = fpgaVer;
        this.fpgaDate = fpgaDate;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Slot{" +
                "tid='" + tid + '\'' +
                ", slotPrvUnit='" + slotPrvUnit + '\'' +
                ", eqUnit='" + eqUnit + '\'' +
                ", eqState='" + eqState + '\'' +
                ", adminState='" + adminState + '\'' +
                ", initOk='" + initOk + '\'' +
                ", bpState='" + bpState + '\'' +
                ", ipcState='" + ipcState + '\'' +
                ", failState='" + failState + '\'' +
                ", hwVer='" + hwVer + '\'' +
                ", swVer='" + swVer + '\'' +
                ", fpgaVer='" + fpgaVer + '\'' +
                ", fpgaDate='" + fpgaDate + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
