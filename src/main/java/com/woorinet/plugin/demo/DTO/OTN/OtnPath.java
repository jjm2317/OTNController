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
@Table(name="otn_path")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPath {
    @GeneratedValue
    @Id
    int id;
    int emsId;
    String serviceId;
    String pathType;
    String connectionIdx;
    String connectionType;
    String directionType;
    String tpType;
    String instanceType;
    String instanceRef;
    String refType;
    String syncDate;

    public OtnPath() {

    }

    public OtnPath(int emsId, String serviceId, String pathType, String connectionIdx, String connectionType, String directionType, String tpType, String instanceType, String instanceRef, String refType,String syncDate) {
        this.emsId = emsId;
        this.serviceId = serviceId;
        this.pathType = pathType;
        this.connectionIdx = connectionIdx;
        this.connectionType = connectionType;
        this.directionType = directionType;
        this.tpType = tpType;
        this.instanceType = instanceType;
        this.instanceRef = instanceRef;
        this.refType = refType;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "OtnPath{" +
                "emsId=" + emsId +
                ", serviceId='" + serviceId + '\'' +
                ", pathType='" + pathType + '\'' +
                ", connectionIdx='" + connectionIdx + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", directionType='" + directionType + '\'' +
                ", tpType='" + tpType + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", instanceRef='" + instanceRef + '\'' +
                ", refType='" + refType + '\'' +
                '}';
    }
}
