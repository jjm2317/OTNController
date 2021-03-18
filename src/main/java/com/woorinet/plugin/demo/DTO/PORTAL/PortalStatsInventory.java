package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name="portal_inventory_detail")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsInventory {
    @Id
    @GeneratedValue
    int portalStatsInventoryId;
    String vendor;
    String cell;
    String tid;
    String shelfId;
    String ip;
    String neType;
    String unitType;
    String unitPec;
    String serialNumber;
    String slotId;
    String portId;
    String connectStatus;
    String llcf;
    String moduleName;
    String modulePec;
    String distance;
    String moduleDescription;
    String cableName;
    String remarksList;

    public PortalStatsInventory() {
    }

    public PortalStatsInventory(String vendor, String cell, String tid, String shelfId, String ip, String neType, String unitType, String unitPec, String serialNumber, String slotId, String portId, String connectStatus, String llcf, String moduleName, String modulePec, String distance, String moduleDescription, String cableName, String remarksList) {
        this.vendor = vendor;
        this.cell = cell;
        this.tid = tid;
        this.shelfId = shelfId;
        this.ip = ip;
        this.neType = neType;
        this.unitType = unitType;
        this.unitPec = unitPec;
        this.serialNumber = serialNumber;
        this.slotId = slotId;
        this.portId = portId;
        this.connectStatus = connectStatus;
        this.llcf = llcf;
        this.moduleName = moduleName;
        this.modulePec = modulePec;
        this.distance = distance;
        this.moduleDescription = moduleDescription;
        this.cableName = cableName;
        this.remarksList = remarksList;
    }

    @Override
    public String toString() {
        return "PortalInventoryDetail{" +
                "vendor='" + vendor + '\'' +
                ", cell='" + cell + '\'' +
                ", tid='" + tid + '\'' +
                ", shelfId='" + shelfId + '\'' +
                ", ip='" + ip + '\'' +
                ", neType='" + neType + '\'' +
                ", unitType='" + unitType + '\'' +
                ", unitPec='" + unitPec + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", slotId='" + slotId + '\'' +
                ", portId='" + portId + '\'' +
                ", connectStatus='" + connectStatus + '\'' +
                ", llcf='" + llcf + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", modulePec='" + modulePec + '\'' +
                ", distance='" + distance + '\'' +
                ", moduleDescription='" + moduleDescription + '\'' +
                ", cableName='" + cableName + '\'' +
                ", remarksList='" + remarksList + '\'' +
                '}';
    }
}
