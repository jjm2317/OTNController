package com.woorinet.plugin.demo.DTO.OTN;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
    String syncDate;

    public OtnConstraint() {

    }

    public OtnConstraint(int emsId, String serviceId, String constId, String constType, String constName, String constValue, String constOperator, String syncDate) {
        this.emsId = emsId;
        this.serviceId = serviceId;
        this.constId = constId;
        this.constType = constType;
        this.constName = constName;
        this.constValue = constValue;
        this.constOperator = constOperator;
        this.syncDate = syncDate;
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
