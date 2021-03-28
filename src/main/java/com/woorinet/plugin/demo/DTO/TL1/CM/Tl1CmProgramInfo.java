package com.woorinet.plugin.demo.DTO.TL1.CM;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Data
@Table(name = "tl1_cm_program_info")
public class Tl1CmProgramInfo {
    @Id
    @GeneratedValue
    int cmProgramInfoId;
    String tid;
    String subnetwork;
    String aid;
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
    String syncDate;

    public Tl1CmProgramInfo() {
    }

    public Tl1CmProgramInfo(String tid, String subnetwork, String aid, String unitType, String pkgVersion, String pkgFilename, String pkgVersionDate, String pkgSize, String fpgaVersion, String fpgaVersionDate, String fpgaSize, String cpldVersion, String cpldVersionDate, String cpldSize, String hwVersion) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
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

    public Tl1CmProgramInfo(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.unitType = fields[3];
        this.pkgVersion = fields[4];
        this.pkgFilename = fields[5];
        this.pkgVersionDate = fields[6];
        this.pkgSize = fields[7];
        this.fpgaVersion = fields[8];
        this.fpgaVersionDate = fields[9];
        this.fpgaSize = fields[10];
        this.cpldVersion = fields[11];
        this.cpldVersionDate = fields[12];
        this.cpldSize = fields[13];
        this.hwVersion = fields[14];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1CmProgramInfo{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
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
