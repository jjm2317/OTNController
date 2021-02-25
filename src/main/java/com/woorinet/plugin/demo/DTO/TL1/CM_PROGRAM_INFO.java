package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@Data
public class CM_PROGRAM_INFO {
    @Id
    @GeneratedValue
    int CM_PROGRAM_INFO_ID;
    String TID;
    String SUBNETWORK;
    String AID;
    String UNIT_TYPE;
    String PKG_VERSION;
    String PKG_FILENAME;
    String PKG_VERSION_DATE;
    String PKG_SIZE;
    String FPGA_VERSION;
    String FPGA_VERSION_DATE;
    String FPGA_SIZE;
    String CPLD_VERSION;
    String CPLD_VERSION_DATE;
    String CPLD_SIZE;
    String HW_VERSION;

    public CM_PROGRAM_INFO() {
    }

    public CM_PROGRAM_INFO(String TID, String SUBNETWORK, String AID, String UNIT_TYPE, String PKG_VERSION, String PKG_FILENAME, String PKG_VERSION_DATE, String PKG_SIZE, String FPGA_VERSION, String FPGA_VERSION_DATE, String FPGA_SIZE, String CPLD_VERSION, String CPLD_VERSION_DATE, String CPLD_SIZE, String HW_VERSION) {
        this.TID = TID;
        this.SUBNETWORK = SUBNETWORK;
        this.AID = AID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.PKG_VERSION = PKG_VERSION;
        this.PKG_FILENAME = PKG_FILENAME;
        this.PKG_VERSION_DATE = PKG_VERSION_DATE;
        this.PKG_SIZE = PKG_SIZE;
        this.FPGA_VERSION = FPGA_VERSION;
        this.FPGA_VERSION_DATE = FPGA_VERSION_DATE;
        this.FPGA_SIZE = FPGA_SIZE;
        this.CPLD_VERSION = CPLD_VERSION;
        this.CPLD_VERSION_DATE = CPLD_VERSION_DATE;
        this.CPLD_SIZE = CPLD_SIZE;
        this.HW_VERSION = HW_VERSION;
    }

    public CM_PROGRAM_INFO(String[] fields) {
        this.TID = fields[0];
        this.SUBNETWORK = fields[1];
        this.AID = fields[2];
        this.UNIT_TYPE = fields[3];
        this.PKG_VERSION = fields[4];
        this.PKG_FILENAME = fields[5];
        this.PKG_VERSION_DATE = fields[6];
        this.PKG_SIZE = fields[7];
        this.FPGA_VERSION = fields[8];
        this.FPGA_VERSION_DATE = fields[9];
        this.FPGA_SIZE = fields[10];
        this.CPLD_VERSION = fields[11];
        this.CPLD_VERSION_DATE = fields[12];
        this.CPLD_SIZE = fields[13];
        this.HW_VERSION = fields[14];
    }

    @Override
    public String toString() {
        return "CM_PROGRAM_INFO{" +
                "TID='" + TID + '\'' +
                ", SUBNETWORK='" + SUBNETWORK + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", PKG_VERSION='" + PKG_VERSION + '\'' +
                ", PKG_FILENAME='" + PKG_FILENAME + '\'' +
                ", PKG_VERSION_DATE='" + PKG_VERSION_DATE + '\'' +
                ", PKG_SIZE='" + PKG_SIZE + '\'' +
                ", FPGA_VERSION='" + FPGA_VERSION + '\'' +
                ", FPGA_VERSION_DATE='" + FPGA_VERSION_DATE + '\'' +
                ", FPGA_SIZE='" + FPGA_SIZE + '\'' +
                ", CPLD_VERSION='" + CPLD_VERSION + '\'' +
                ", CPLD_VERSION_DATE='" + CPLD_VERSION_DATE + '\'' +
                ", CPLD_SIZE='" + CPLD_SIZE + '\'' +
                ", HW_VERSION='" + HW_VERSION + '\'' +
                '}';
    }
}
