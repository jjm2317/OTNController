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
@Table(name="otn_access_if")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnAccessIf {
    @Id
    @GeneratedValue
    String id;
    int emsId;
    String accessifId;
    String accessifName;
    String neId;
    String connectorId;
    String accessifType;
    String accessifStatus;
    String serviceRef;
    String nodeConnectorRef;
    String syncDate;

    public OtnAccessIf() {

    }

    public OtnAccessIf(int emsId, String accessifId, String accessifName, String neId, String connectorId, String accessifType, String accessifStatus, String serviceRef, String nodeConnectorRef, String syncDate) {
        this.emsId = emsId;
        this.accessifId = accessifId;
        this.accessifName = accessifName;
        this.neId = neId;
        this.connectorId = connectorId;
        this.accessifType = accessifType;
        this.accessifStatus = accessifStatus;
        this.serviceRef = serviceRef;
        this.nodeConnectorRef = nodeConnectorRef;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnAccessIf{" +
                "emsId=" + emsId +
                ", accessifId='" + accessifId + '\'' +
                ", accessifName='" + accessifName + '\'' +
                ", neId='" + neId + '\'' +
                ", connectorId='" + connectorId + '\'' +
                ", accessifType='" + accessifType + '\'' +
                ", accessifStatus='" + accessifStatus + '\'' +
                ", serviceRef='" + serviceRef + '\'' +
                ", nodeConnectorRef='" + nodeConnectorRef + '\'' +
                '}';
    }
}
