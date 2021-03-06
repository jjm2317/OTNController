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
@Data
@Entity
@Table(name="otn_connector")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnConnector {
    @Id
    @GeneratedValue
    int id;
    int emsId;
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
    String syncDate;

    public OtnConnector() {

    }

    public OtnConnector(int emsId, String connectId, String connectName, String connectType, String neId, String neName, String rackId, String shelfId, String slotId, String subslotId, String portId, String connectStatus, String connectRole, String connectIdle, String connectLlcf, String connectLambda, String moduleName, String connectPec, String connectSerial, String unitType, String syncDate) {
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
        this.syncDate = syncDate;
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
