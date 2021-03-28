package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name = "tl1_access_if")
public class Tl1AccessIf {
    String tidId;
    String tid;
    String subnetId;
    String subnet;
    @Id
    @Generated
    String accessIfId;
    String localId;
    String requestId;
    String name;
    String accessIfType;
    String accessIfOperationalStatus;
    String accessIfConfigurationAction;
    String accessIfConfigurationResult;
    String deploymentEnabler;
    String deploymentStatus;
    String cir;
    String pir;
    String serviceType;
    String constraintId;
    String commonConstraintName;
    String commonConstraintValue;
    String commonConstraintOperator;
    String portConstraintType;
    String ac2acType;
    String syncDate;

    public Tl1AccessIf() {

    }

    public Tl1AccessIf(String tidId, String tid, String subnetId, String subnet, String accessIfId, String localId, String requestId, String name, String accessIfType, String accessIfOperationalStatus, String accessIfConfigurationAction, String accessIfConfigurationResult, String deploymentEnabler, String deploymentStatus, String cir, String pir, String serviceType, String constraintId, String commonConstraintName, String commonConstraintValue, String commonConstraintOperator, String portConstraintType, String ac2acType, String syncDate) {
        this.tidId = tidId;
        this.tid = tid;
        this.subnetId = subnetId;
        this.subnet = subnet;
        this.accessIfId = accessIfId;
        this.localId = localId;
        this.requestId = requestId;
        this.name = name;
        this.accessIfType = accessIfType;
        this.accessIfOperationalStatus = accessIfOperationalStatus;
        this.accessIfConfigurationAction = accessIfConfigurationAction;
        this.accessIfConfigurationResult = accessIfConfigurationResult;
        this.deploymentEnabler = deploymentEnabler;
        this.deploymentStatus = deploymentStatus;
        this.cir = cir;
        this.pir = pir;
        this.serviceType = serviceType;
        this.constraintId = constraintId;
        this.commonConstraintName = commonConstraintName;
        this.commonConstraintValue = commonConstraintValue;
        this.commonConstraintOperator = commonConstraintOperator;
        this.portConstraintType = portConstraintType;
        this.ac2acType = ac2acType;
        this.syncDate =syncDate;
    }

    public Tl1AccessIf(String[] fields, String syncDate) {
        this.tidId = fields[0];
        this.tid = fields[1];
        this.subnetId = fields[2];
        this.subnet = fields[3];
        this.accessIfId = fields[4];
        this.localId = fields[5];
        this.requestId = fields[6];
        this.name = fields[7];
        this.accessIfType = fields[8];
        this.accessIfOperationalStatus = fields[9];
        this.accessIfConfigurationAction = fields[10];
        this.accessIfConfigurationResult = fields[11];
        this.deploymentEnabler = fields[12];
        this.deploymentStatus = fields[13];
        this.cir = fields[14];
        this.pir = fields[15];
        this.serviceType = fields[16];
        this.constraintId = fields[17];
        this.commonConstraintName = fields[18];
        this.commonConstraintValue = fields[19];
        this.commonConstraintOperator = fields[20];
        this.portConstraintType = fields[21];
        this.ac2acType = fields[22];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1AccessIf{" +
                "tidId='" + tidId + '\'' +
                ", tid='" + tid + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnet='" + subnet + '\'' +
                ", accessIfId='" + accessIfId + '\'' +
                ", localId='" + localId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", name='" + name + '\'' +
                ", accessIfType='" + accessIfType + '\'' +
                ", accessIfOperationalStatus='" + accessIfOperationalStatus + '\'' +
                ", accessIfConfigurationAction='" + accessIfConfigurationAction + '\'' +
                ", accessIfConfigurationResult='" + accessIfConfigurationResult + '\'' +
                ", deploymentEnabler='" + deploymentEnabler + '\'' +
                ", deploymentStatus='" + deploymentStatus + '\'' +
                ", cir='" + cir + '\'' +
                ", pir='" + pir + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", constraintId='" + constraintId + '\'' +
                ", commonConstraintName='" + commonConstraintName + '\'' +
                ", commonConstraintValue='" + commonConstraintValue + '\'' +
                ", commonConstraintOperator='" + commonConstraintOperator + '\'' +
                ", portConstraintType='" + portConstraintType + '\'' +
                ", ac2acType='" + ac2acType + '\'' +
                '}';
    }
}
