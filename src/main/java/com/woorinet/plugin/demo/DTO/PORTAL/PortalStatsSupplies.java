package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.Gson;
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
@Table(name="portal_otn_material")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsSupplies {
    @Id
    @GeneratedValue
    int portalOtnMaterialId;
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
       Unit unit = new Unit(fields);
       return (new Gson()).toJson(unit);
    }

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
