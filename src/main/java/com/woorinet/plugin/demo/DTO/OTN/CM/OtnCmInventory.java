package com.woorinet.plugin.demo.DTO.OTN.CM;


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
@Table(name="otn_cm_inventory")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnCmInventory {
    @Id
    @GeneratedValue
    int otnCmInventoryId;
    String tid;
    String slot;
    String unitType;
    String pkgVersion;
    String pkgFilename;
    String pkgVersionDate;
    String pkgSize;
    String fpgaVersion;
    String fpgaVersionDate;
    String fpgaSize;
    String cpldVersion;
    String cpldVersionDate;
    String cpldSize;
    String hwVersion;

    public OtnCmInventory() {
    }

    public OtnCmInventory(String tid, String slot, String unitType, String pkgVersion, String pkgFilename, String pkgVersionDate, String pkgSize, String fpgaVersion, String fpgaVersionDate, String fpgaSize, String cpldVersion, String cpldVersionDate, String cpldSize, String hwVersion) {
        this.tid = tid;
        this.slot = slot;
        this.unitType = unitType;
        this.pkgVersion = pkgVersion;
        this.pkgFilename = pkgFilename;
        this.pkgVersionDate = pkgVersionDate;
        this.pkgSize = pkgSize;
        this.fpgaVersion = fpgaVersion;
        this.fpgaVersionDate = fpgaVersionDate;
        this.fpgaSize = fpgaSize;
        this.cpldVersion = cpldVersion;
        this.cpldVersionDate = cpldVersionDate;
        this.cpldSize = cpldSize;
        this.hwVersion = hwVersion;
    }

    @Override
    public String toString() {
        return "OtnCmInventory{" +
                "tid='" + tid + '\'' +
                ", slot='" + slot + '\'' +
                ", unitType='" + unitType + '\'' +
                ", pkgVersion='" + pkgVersion + '\'' +
                ", pkgFilename='" + pkgFilename + '\'' +
                ", pkgVersionDate='" + pkgVersionDate + '\'' +
                ", pkgSize='" + pkgSize + '\'' +
                ", fpgaVersion='" + fpgaVersion + '\'' +
                ", fpgaVersionDate='" + fpgaVersionDate + '\'' +
                ", fpgaSize='" + fpgaSize + '\'' +
                ", cpldVersion='" + cpldVersion + '\'' +
                ", cpldVersionDate='" + cpldVersionDate + '\'' +
                ", cpldSize='" + cpldSize + '\'' +
                ", hwVersion='" + hwVersion + '\'' +
                '}';
    }
}
