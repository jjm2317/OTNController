package com.woorinet.plugin.demo.DTO.PORTAL;


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
@Table(name="portal_otn_node_usage")
public class PortalOtnNodeUsage {
    @Id
    @GeneratedValue
    int holaSdnOtnNodeUsageId;
    String area;
    String city;
    String mountingStatus;

    public PortalOtnNodeUsage() {
    }

    public PortalOtnNodeUsage(String area, String city, String mountingStatus) {
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
