package com.woorinet.plugin.demo.DTO.HOLA;


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
@Table(name="hola_otn_node_usage")
public class HolaOtnNodeUsage {
    @Id
    @GeneratedValue
    int HOLA_SDN_OTN_NODE_USAGE;
    String AREA;
    String CITY;
    String MOUNTING_STATUS;

    public HolaOtnNodeUsage() {
    }

    public HolaOtnNodeUsage(String AREA, String CITY, String MOUNTING_STATUS) {
        this.AREA = AREA;
        this.CITY = CITY;
        this.MOUNTING_STATUS = MOUNTING_STATUS;
    }

    @Override
    public String toString() {
        return "HolaSdnOtnNodeUsage{" +
                "HOLA_SDN_OTN_NODE_USAGE=" + HOLA_SDN_OTN_NODE_USAGE +
                ", AREA='" + AREA + '\'' +
                ", CITY='" + CITY + '\'' +
                ", MOUNTING_STATUS='" + MOUNTING_STATUS + '\'' +
                '}';
    }
}
