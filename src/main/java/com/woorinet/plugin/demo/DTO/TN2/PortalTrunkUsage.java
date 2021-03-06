package com.woorinet.plugin.demo.DTO.TN2;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Data
@Entity
@Table(name="tn2_trunkusage")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalTrunkUsage {
    @Id
    @GeneratedValue
    @Column(name="tn2_trunkusage_id")
    int portalTrunkUsageId;
    String vendor;
    String link;
    String adminWeight;
    String maximumUsageRatio;
    String memory;
    String usageRatio;
    String distance;
    String srlg;
    String roadmPath;
    String remarks;

    public PortalTrunkUsage() {
    }

    public PortalTrunkUsage(String vendor, String link, String adminWeight, String maximumUsageRatio, String memory, String usageRatio, String distance, String srlg, String roadmPath, String remarks) {
        this.vendor = vendor;
        this.link = link;
        this.adminWeight = adminWeight;
        this.maximumUsageRatio = maximumUsageRatio;
        this.memory = memory;
        this.usageRatio = usageRatio;
        this.distance = distance;
        this.srlg = srlg;
        this.roadmPath = roadmPath;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PortalTrunkUsage{" +
                "vendor='" + vendor + '\'' +
                ", link='" + link + '\'' +
                ", adminWeight='" + adminWeight + '\'' +
                ", maximumUsageRatio='" + maximumUsageRatio + '\'' +
                ", memory='" + memory + '\'' +
                ", usageRatio='" + usageRatio + '\'' +
                ", distance='" + distance + '\'' +
                ", srlg='" + srlg + '\'' +
                ", roadmPath='" + roadmPath + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
