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
    int HOLA_SDN_OTN_NODE_USAGE_ID;
    String AREA;
    String CITY;
    String MOUNTING_STATUS;

    public PortalOtnNodeUsage() {
    }

    public PortalOtnNodeUsage(String AREA, String CITY, String MOUNTING_STATUS) {
        this.AREA = AREA;
        this.CITY = CITY;
        this.MOUNTING_STATUS = MOUNTING_STATUS;
    }

    @Override
    public String toString() {
        return "HolaOtnNodeUsage{" +
                "HOLA_SDN_OTN_NODE_USAGE_ID=" + HOLA_SDN_OTN_NODE_USAGE_ID +
                ", AREA='" + AREA + '\'' +
                ", CITY='" + CITY + '\'' +
                ", MOUNTING_STATUS='" + MOUNTING_STATUS + '\'' +
                '}';
    }
}
