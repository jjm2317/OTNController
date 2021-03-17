package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Generated;
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
@Table(name="otn_constraint")
public class OtnConstraint {
    @Id
    @GeneratedValue
    @Generated
    int id;
    int emsId;
    String serviceId;
    String constId;
    String constType;
    String constName;
    String constValue;
    String constOperator;

    public OtnConstraint() {

    }

    public OtnConstraint(int emsId, String serviceId, String constId, String constType, String constName, String constValue, String constOperator) {
        this.emsId = emsId;
        this.serviceId = serviceId;
        this.constId = constId;
        this.constType = constType;
        this.constName = constName;
        this.constValue = constValue;
        this.constOperator = constOperator;
    }

    @Override
    public String toString() {
        return "OtnConstraint{" +
                "emsId=" + emsId +
                ", serviceId='" + serviceId + '\'' +
                ", constId='" + constId + '\'' +
                ", constType='" + constType + '\'' +
                ", constName='" + constName + '\'' +
                ", constValue='" + constValue + '\'' +
                ", constOperator='" + constOperator + '\'' +
                '}';
    }
}
