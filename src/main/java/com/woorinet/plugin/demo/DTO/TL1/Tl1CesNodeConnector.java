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
@Table(name = "tl1_ces_node_connector")
public class Tl1CesNodeConnector {
    @Id
    @GeneratedValue
    int cesNodeConnectorId;
    String tidId;
    String tid;
    String aid;
    String subnetId;
    String subnet;
    String localId;
    String requestId;
    String name;
    String number;
    String portType;
    String portRole;
    String portStatus;
    String shelfType;
    String shelfIndex;
    String slotType;
    String slotIndex;
    String subSlotType;
    String subSlotIndex;
    String portType2;
    String portIndex;
    String macAddr;
    String cesName;
    String cesDescr;
    String cesSd;
    String cesPortSutdown;
    String slotService;
    String syncDate;

    public Tl1CesNodeConnector() {

    }


    public Tl1CesNodeConnector(String tidId, String tid, String aid, String subnetId, String subnet, String localId, String requestId, String name, String number, String portType, String portRole, String portStatus, String shelfType, String shelfIndex, String slotType, String slotIndex, String subSlotType, String subSlotIndex, String portType2, String portIndex, String macAddr, String cesName, String cesDescr, String cesSd, String cesPortSutdown, String slotService, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.aid = aid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.number = number;
        this.portType = portType;
        this.portRole = portRole;
        this.portStatus = portStatus;
        this.shelfType = shelfType;
        this.shelfIndex = shelfIndex;
        this.slotType = slotType;
        this.slotIndex = slotIndex;
        this.subSlotType = subSlotType;
        this.subSlotIndex = subSlotIndex;
        this.portType2 = portType2;
        this.portIndex = portIndex;
        this.macAddr = macAddr;
        this.cesName = cesName;
        this.cesDescr = cesDescr;
        this.cesSd = cesSd;
        this.cesPortSutdown = cesPortSutdown;
        this.slotService = slotService;
        this.syncDate = syncDate;
    }

    public Tl1CesNodeConnector(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.aid = fields[2];
        this.subnetId = fields[3];
        this.subnet = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.number = fields[8];
        this.portType = fields[9];
        this.portRole = fields[10];
        this.portStatus = fields[11];
        this.shelfType = fields[12];
        this.shelfIndex = fields[13];
        this.slotType = fields[14];
        this.slotIndex = fields[15];
        this.subSlotType = fields[16];
        this.subSlotIndex = fields[17];
        this.portType2 = fields[18];
        this.portIndex = fields[19];
        this.macAddr = fields[20];
        this.cesName = fields[21];
        this.cesDescr = fields[22];
        this.cesSd = fields[23];
        this.cesPortSutdown = fields[24];
        this.slotService = fields[25];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1CesNodeConnector{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", aid='" + aid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", portType='" + portType + '\'' +
                ", portRole='" + portRole + '\'' +
                ", portStatus='" + portStatus + '\'' +
                ", shelfType='" + shelfType + '\'' +
                ", shelfIndex='" + shelfIndex + '\'' +
                ", slotType='" + slotType + '\'' +
                ", slotIndex='" + slotIndex + '\'' +
                ", subSlotType='" + subSlotType + '\'' +
                ", subSlotIndex='" + subSlotIndex + '\'' +
                ", portType2='" + portType2 + '\'' +
                ", portIndex='" + portIndex + '\'' +
                ", macAddr='" + macAddr + '\'' +
                ", cesName='" + cesName + '\'' +
                ", cesDescr='" + cesDescr + '\'' +
                ", cesSd='" + cesSd + '\'' +
                ", cesPortSutdown='" + cesPortSutdown + '\'' +
                ", slotService='" + slotService + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
