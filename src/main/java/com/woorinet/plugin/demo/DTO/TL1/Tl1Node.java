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
@Data
@Entity
@Table(name="tl1_node")
public class Tl1Node {
    @Id
    @GeneratedValue
    int nodeId;
    String tidId;
    String tid;
    String nodeType;
    String ipAddr;
    String manufacture;
    String hardware;
    String software;
    String serialNumber;
    String nodeStatus;
    String subnet;
    String subnetId;
    String systemType;
    String syncDate;

    public Tl1Node() {

    }

    public Tl1Node(String tidId, String tid, String nodeType, String ipAddr, String manufacture, String hardware, String software, String serialNumber, String nodeStatus, String subnet, String subnetId, String systemType, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.nodeType = nodeType;
        this.ipAddr = ipAddr;
        this.manufacture = manufacture;
        this.hardware = hardware;
        this.software = software;
        this.serialNumber = serialNumber;
        this.nodeStatus = nodeStatus;
        this.subnet = subnet;
        this.subnetId = subnetId;
        this.systemType = systemType;
        this.syncDate = syncDate;
    }

    public Tl1Node(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.nodeType = fields[2];
        this.ipAddr = fields[3];
        this.manufacture = fields[4];
        this.hardware = fields[5];
        this.software = fields[6];
        this.serialNumber = fields[7];
        this.nodeStatus = fields[8];
        this.subnet = fields[9];
        this.subnetId = fields[10];
        this.systemType = fields[11];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1Node{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", hardware='" + hardware + '\'' +
                ", software='" + software + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", nodeStatus='" + nodeStatus + '\'' +
                ", subnet='" + subnet + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", systemType='" + systemType + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
