package com.woorinet.plugin.demo.DTO.TL1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Data
@Table(name = "tl1_inventory")
public class Tl1Inventory {

    @Id
    @GeneratedValue
    int inventoryId;
    String tid;
    String unitType;
    String vendor;
    String dat;
    String serialNum;
    String syncDate;

    public Tl1Inventory() {
    }

    public Tl1Inventory(String tid, String unitType, String vendor, String dat, String serialNum, String syncDate) {
        this.tid = tid;
        this.unitType = unitType;
        this.vendor = vendor;
        this.dat = dat;
        this.serialNum = serialNum;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Inventory{" +
                "tid='" + tid + '\'' +
                ", unitType='" + unitType + '\'' +
                ", vendor='" + vendor + '\'' +
                ", dat='" + dat + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }

    public Tl1Inventory(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.unitType = fields[1];
        this.vendor = fields[2];
        this.dat = fields[3];
        this.serialNum = fields[4];
        this.syncDate = syncDate;
    }


}
