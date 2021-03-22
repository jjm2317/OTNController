package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Setter
@Getter
@Data
@Entity
@Table(name="tn2_stats_supplies")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsSupplies {
    @Id
    @GeneratedValue
    @Column(name="tn2_stats_supplies_id")
    int portalStatsSuppliesId;
    String vendor;
    String cell;
    String node;
    String ip;
    String shelf;
    String unitList;

    public PortalStatsSupplies() {
    }

    public PortalStatsSupplies(String vendor, String cell, String node, String ip, String shelf, String unitList) {
        this.vendor = vendor;
        this.cell = cell;
        this.node = node;
        this.ip = ip;
        this.shelf = shelf;
        this.unitList = unitList;
    }

    @Override
    public String toString() {
        return "PortalOtnMaterial{" +
                "vendor='" + vendor + '\'' +
                ", cell='" + cell + '\'' +
                ", node='" + node + '\'' +
                ", ip='" + ip + '\'' +
                ", shelf='" + shelf + '\'' +
                ", unitList='" + unitList + '\'' +
                '}';
    }

    public String getUnit(String[] fields) {
        try {
            Unit unit = new Unit(fields);
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(unit);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }

    }

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    class Unit {
        String unitType;
        String unitCount;
        String allPortCount;
        String usagePortCount;
        String usageRatio;

        public Unit() {
        }

        public Unit(String[] fields) {
            this.unitType = fields[0];
            this.unitCount = fields[1];
            this.allPortCount = fields[2];
            this.usagePortCount = fields[3];
            this.usageRatio = fields[4];
        }


    }
}
