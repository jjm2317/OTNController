package com.woorinet.plugin.demo.DTO.OTN;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name = "otn_service")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnService {
    int emsId;
    @Id
    @Generated
    String serviceId;
    String srcNeId;
    String srcNeName;
    String srcConnectorId;
    String srcAccessifType;
    String dstNeId;
    String dstNeName;
    String dstConnectorId;
    String dstAccessifType;
    String serviceType;
    String serviceName;
    String networkType;
    String serviceStatus;
    String rateType;
    String serviceRate;
    String latency;
    String wavelength;
    String activePath;
    String creationDate;
    String syncDate;

    public OtnService() {
    }

    public OtnService(int emsId, String serviceId, String srcNeId, String srcNeName, String srcConnectorId, String srcAccessifType, String dstNeId, String dstNeName, String dstConnectorId, String dstAccessifType, String serviceType, String serviceName, String networkType, String serviceStatus, String rateType, String serviceRate, String latency, String wavelength, String activePath, String creationDate, String syncDate) {
        this.emsId = emsId;
        this.serviceId = serviceId;
        this.srcNeId = srcNeId;
        this.srcNeName = srcNeName;
        this.srcConnectorId = srcConnectorId;
        this.srcAccessifType = srcAccessifType;
        this.dstNeId = dstNeId;
        this.dstNeName = dstNeName;
        this.dstConnectorId = dstConnectorId;
        this.dstAccessifType = dstAccessifType;
        this.serviceType = serviceType;
        this.serviceName = serviceName;
        this.networkType = networkType;
        this.serviceStatus = serviceStatus;
        this.rateType = rateType;
        this.serviceRate = serviceRate;
        this.latency = latency;
        this.wavelength = wavelength;
        this.activePath = activePath;
        this.creationDate = creationDate;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnService{" +
                "emsId=" + emsId +
                ", serviceId='" + serviceId + '\'' +
                ", srcNeId='" + srcNeId + '\'' +
                ", srcNeName='" + srcNeName + '\'' +
                ", srcConnectorId='" + srcConnectorId + '\'' +
                ", srcAccessifType='" + srcAccessifType + '\'' +
                ", dstNeId='" + dstNeId + '\'' +
                ", dstNeName='" + dstNeName + '\'' +
                ", dstConnectorId='" + dstConnectorId + '\'' +
                ", dstAccessifType='" + dstAccessifType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", networkType='" + networkType + '\'' +
                ", serviceStatus='" + serviceStatus + '\'' +
                ", rateType='" + rateType + '\'' +
                ", serviceRate='" + serviceRate + '\'' +
                ", latency='" + latency + '\'' +
                ", wavelength='" + wavelength + '\'' +
                ", activePath='" + activePath + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
