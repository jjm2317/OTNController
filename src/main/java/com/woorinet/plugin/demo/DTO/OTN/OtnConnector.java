package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@Table(name="otn_connector")
public class OtnConnector {
    int emsId;
    @Id
    @Generated
    String connectId;
    String connectName;
    String connectType;
    String neId;
    String neName;
    String rackId;
    String shelfId;
    String slotId;
    String subslotId;
    String portId;
    String connectStatus;
    String connectRole;
    String connectIdle;
    String connectLlcf;
    String connectLambda;
    String moduleName;
    String connectPec;
    String connectSerial;
    String unitType;

    public OtnConnector() {

    }

    public OtnConnector(int emsId, String connectId, String connectName, String connectType, String neId, String neName, String rackId, String shelfId, String slotId, String subslotId, String portId, String connectStatus, String connectRole, String connectIdle, String connectLlcf, String connectLambda, String moduleName, String connectPec, String connectSerial, String unitType) {
        this.emsId = emsId;
        this.connectId = connectId;
        this.connectName = connectName;
        this.connectType = connectType;
        this.neId = neId;
        this.neName = neName;
        this.rackId = rackId;
        this.shelfId = shelfId;
        this.slotId = slotId;
        this.subslotId = subslotId;
        this.portId = portId;
        this.connectStatus = connectStatus;
        this.connectRole = connectRole;
        this.connectIdle = connectIdle;
        this.connectLlcf = connectLlcf;
        this.connectLambda = connectLambda;
        this.moduleName = moduleName;
        this.connectPec = connectPec;
        this.connectSerial = connectSerial;
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "OtnConnector{" +
                "emsId=" + emsId +
                ", connectId='" + connectId + '\'' +
                ", connectName='" + connectName + '\'' +
                ", connectType='" + connectType + '\'' +
                ", neId='" + neId + '\'' +
                ", neName='" + neName + '\'' +
                ", rackId='" + rackId + '\'' +
                ", shelfId='" + shelfId + '\'' +
                ", slotId='" + slotId + '\'' +
                ", subslotId='" + subslotId + '\'' +
                ", portId='" + portId + '\'' +
                ", connectStatus='" + connectStatus + '\'' +
                ", connectRole='" + connectRole + '\'' +
                ", connectIdle='" + connectIdle + '\'' +
                ", connectLlcf='" + connectLlcf + '\'' +
                ", connectLambda='" + connectLambda + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", connectPec='" + connectPec + '\'' +
                ", connectSerial='" + connectSerial + '\'' +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
