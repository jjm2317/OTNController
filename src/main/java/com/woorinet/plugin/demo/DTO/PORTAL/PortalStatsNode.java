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

@Getter
@Setter
@Data
@Entity
@Table(name="portal_stats_node")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsNode {
    @Id
    @GeneratedValue
    int portalStatsNodeId;
    String area;
    String city;
    String mountingStatus;

    public PortalStatsNode() {
    }

    public PortalStatsNode(String area, String city, String mountingStatus) {
        this.area = area;
        this.city = city;
        this.mountingStatus = mountingStatus;
    }

    @Override
    public String toString() {
        return "PortalOtnNodeUsage{" +
                "area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", mountingStatus='" + mountingStatus + '\'' +
                '}';
    }
}
