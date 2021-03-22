package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Setter
@Getter
@Data
@Entity
@Table(name="tn2_stats_inventory")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsInventory {
    @Id
    @GeneratedValue
    @Column(name="tn2_stats_inventory_id")
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
    @Column(length = 1000)
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

    public void setRemarksList(String[] firstLinkFields, String[] secondLinkFields) {
        try {
            PortalStatsInventory.Remarks firstRemarks = new PortalStatsInventory.Remarks(firstLinkFields);
            PortalStatsInventory.Remarks secondRemarks = new PortalStatsInventory.Remarks(secondLinkFields);

            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

            String[] result = {mapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstRemarks), mapper.writerWithDefaultPrettyPrinter().writeValueAsString(secondRemarks)};
            this.remarksList = Arrays.toString(result);
            System.out.println(this.remarksList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    class Remarks {
        String remarks;
        String creationDate;
        String writer;

        public Remarks(String[] fields) {
            this.remarks = fields[0];
            this.creationDate = fields[1];
            this.writer = fields[2];
        }
    }
}
