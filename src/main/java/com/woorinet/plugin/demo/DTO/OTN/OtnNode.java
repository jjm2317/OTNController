package com.woorinet.plugin.demo.DTO.OTN;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@Table(name="otn_node")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnNode {
    @Id
    @GeneratedValue
    String id;
    int emsId;
    String neId;
    String neName;
    String neType;
    String neModel;
    String neStatus;
    String swVer;
    String ipAddr;
    String vendor;
    String serialNum;
    String sysType;
    String syncDate;

    public OtnNode() {

    }

    public OtnNode(int emsId, String neId, String neName, String neType, String neModel, String neStatus, String swVer, String ipAddr, String vendor, String serialNum, String sysType, String syncDate) {
        this.emsId = emsId;
        this.neId = neId;
        this.neName = neName;
        this.neType = neType;
        this.neModel = neModel;
        this.neStatus = neStatus;
        this.swVer = swVer;
        this.ipAddr = ipAddr;
        this.vendor = vendor;
        this.serialNum = serialNum;
        this.sysType = sysType;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnNode{" +
                "emsId=" + emsId +
                ", neId='" + neId + '\'' +
                ", neName='" + neName + '\'' +
                ", neType='" + neType + '\'' +
                ", neModel='" + neModel + '\'' +
                ", neStatus='" + neStatus + '\'' +
                ", swVer='" + swVer + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", vendor='" + vendor + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", sysType='" + sysType + '\'' +
                '}';
    }
}
