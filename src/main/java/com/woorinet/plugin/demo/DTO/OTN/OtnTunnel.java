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
@Table(name="otn_tunnel")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnTunnel {
    @Id
    @GeneratedValue
    int id;
    int emsId;
    String tunnelId;
    String srcNeId;
    String srcNeName;
    String dstNeId;
    String dstNeName;
    String rateType;
    String multipleRate;
    String localId;
    String requestId;
    String tunnelName;
    String tunnelType;
    String tunnelStatus;
    String configurationAction;
    String configurationResultType;
    String tunnelOamEnabler;
    String deploymentEnabler;
    String deploymentStatus;
    String activePath;
    String srcNodeRef;
    String dstNodeRef;
    String serviceRef;
    String accessifRef;
    String protectionType;
    String workingPath;
    String protectionPath;
    String serviceMapping;
    String creationDate;
    String syncDate;

    public OtnTunnel() {
    }

    public OtnTunnel(int emsId, String tunnelId, String srcNeId, String srcNeName, String dstNeId, String dstNeName, String rateType, String multipleRate, String localId, String requestId, String tunnelName, String tunnelType, String tunnelStatus, String configurationAction, String configurationResultType, String tunnelOamEnabler, String deploymentEnabler, String deploymentStatus, String activePath, String srcNodeRef, String dstNodeRef, String serviceRef, String accessifRef, String protectionType, String workingPath, String protectionPath, String serviceMapping, String creationDate, String syncDate) {
        this.emsId = emsId;
        this.tunnelId = tunnelId;
        this.srcNeId = srcNeId;
        this.srcNeName = srcNeName;
        this.dstNeId = dstNeId;
        this.dstNeName = dstNeName;
        this.rateType = rateType;
        this.multipleRate = multipleRate;
        this.localId = localId;
        this.requestId = requestId;
        this.tunnelName = tunnelName;
        this.tunnelType = tunnelType;
        this.tunnelStatus = tunnelStatus;
        this.configurationAction = configurationAction;
        this.configurationResultType = configurationResultType;
        this.tunnelOamEnabler = tunnelOamEnabler;
        this.deploymentEnabler = deploymentEnabler;
        this.deploymentStatus = deploymentStatus;
        this.activePath = activePath;
        this.srcNodeRef = srcNodeRef;
        this.dstNodeRef = dstNodeRef;
        this.serviceRef = serviceRef;
        this.accessifRef = accessifRef;
        this.protectionType = protectionType;
        this.workingPath = workingPath;
        this.protectionPath = protectionPath;
        this.serviceMapping = serviceMapping;
        this.creationDate = creationDate;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnTunnel{" +
                "emsId=" + emsId +
                ", tunnelId='" + tunnelId + '\'' +
                ", srcNeId='" + srcNeId + '\'' +
                ", srcNeName='" + srcNeName + '\'' +
                ", dstNeId='" + dstNeId + '\'' +
                ", dstNeName='" + dstNeName + '\'' +
                ", rateType='" + rateType + '\'' +
                ", multipleRate='" + multipleRate + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", tunnelName='" + tunnelName + '\'' +
                ", tunnelType='" + tunnelType + '\'' +
                ", tunnelStatus='" + tunnelStatus + '\'' +
                ", configurationAction='" + configurationAction + '\'' +
                ", configurationResultType='" + configurationResultType + '\'' +
                ", tunnelOamEnabler='" + tunnelOamEnabler + '\'' +
                ", deploymentEnabler='" + deploymentEnabler + '\'' +
                ", deploymentStatus='" + deploymentStatus + '\'' +
                ", activePath='" + activePath + '\'' +
                ", srcNodeRef='" + srcNodeRef + '\'' +
                ", dstNodeRef='" + dstNodeRef + '\'' +
                ", serviceRef='" + serviceRef + '\'' +
                ", accessifRef='" + accessifRef + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", workingPath='" + workingPath + '\'' +
                ", protectionPath='" + protectionPath + '\'' +
                ", serviceMapping='" + serviceMapping + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
