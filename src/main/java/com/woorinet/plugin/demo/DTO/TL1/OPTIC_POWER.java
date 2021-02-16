package com.woorinet.plugin.demo.DTO.TL1;

public class OPTIC_POWER {
    String TID;
    String AID;
    String UNIT_TYPE;
    String MODULE_EQUIP;
    String CORE;
    String LCORSC;
    String UPCORAPC;
    String SUPPORT_SIGNAL;
    String MODULE_TYPE;
    String TX_CHANNEL;
    String TX_WAVELENGTH;
    String RX_CHANNEL;
    String RX_WAVELENGTH;
    String DISTANCE;
    String TX_POWER;
    String RX_POWER;
    String TX_BIAS_CURRENT;
    String FAULT_NUMBER;
    String FAULT_DISTANCE;
    String VENDOR;
    String PART_NUMBER;
    String SERIAL;

    public OPTIC_POWER(String TID, String AID, String UNIT_TYPE, String MODULE_EQUIP, String CORE, String LCORSC, String UPCORAPC, String SUPPORT_SIGNAL, String MODULE_TYPE, String TX_CHANNEL, String TX_WAVELENGTH, String RX_CHANNEL, String RX_WAVELENGTH, String DISTANCE, String TX_POWER, String RX_POWER, String TX_BIAS_CURRENT, String FAULT_NUMBER, String FAULT_DISTANCE, String VENDOR, String PART_NUMBER, String SERIAL) {
        this.TID = TID;
        this.AID = AID;
        this.UNIT_TYPE = UNIT_TYPE;
        this.MODULE_EQUIP = MODULE_EQUIP;
        this.CORE = CORE;
        this.LCORSC = LCORSC;
        this.UPCORAPC = UPCORAPC;
        this.SUPPORT_SIGNAL = SUPPORT_SIGNAL;
        this.MODULE_TYPE = MODULE_TYPE;
        this.TX_CHANNEL = TX_CHANNEL;
        this.TX_WAVELENGTH = TX_WAVELENGTH;
        this.RX_CHANNEL = RX_CHANNEL;
        this.RX_WAVELENGTH = RX_WAVELENGTH;
        this.DISTANCE = DISTANCE;
        this.TX_POWER = TX_POWER;
        this.RX_POWER = RX_POWER;
        this.TX_BIAS_CURRENT = TX_BIAS_CURRENT;
        this.FAULT_NUMBER = FAULT_NUMBER;
        this.FAULT_DISTANCE = FAULT_DISTANCE;
        this.VENDOR = VENDOR;
        this.PART_NUMBER = PART_NUMBER;
        this.SERIAL = SERIAL;
    }
    public OPTIC_POWER(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.UNIT_TYPE = fields[2];
        this.MODULE_EQUIP = fields[3];
        this.CORE = fields[4];
        this.LCORSC = fields[5];
        this.UPCORAPC = fields[6];
        this.SUPPORT_SIGNAL = fields[7];
        this.MODULE_TYPE = fields[8];
        this.TX_CHANNEL = fields[9];
        this.TX_WAVELENGTH = fields[10];
        this.RX_CHANNEL = fields[11];
        this.RX_WAVELENGTH = fields[12];
        this.DISTANCE = fields[13];
        this.TX_POWER = fields[14];
        this.RX_POWER = fields[15];
        this.TX_BIAS_CURRENT = fields[16];
        this.FAULT_NUMBER = fields[17];
        this.FAULT_DISTANCE = fields[18];
        this.VENDOR = fields[19];
        this.PART_NUMBER = fields[20];
        this.SERIAL = fields[21];
    }

    @Override
    public String toString() {
        return "OPTIC_POWER{" +
                "TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT_TYPE='" + UNIT_TYPE + '\'' +
                ", MODULE_EQUIP='" + MODULE_EQUIP + '\'' +
                ", CORE='" + CORE + '\'' +
                ", LCORSC='" + LCORSC + '\'' +
                ", UPCORAPC='" + UPCORAPC + '\'' +
                ", SUPPORT_SIGNAL='" + SUPPORT_SIGNAL + '\'' +
                ", MODULE_TYPE='" + MODULE_TYPE + '\'' +
                ", TX_CHANNEL='" + TX_CHANNEL + '\'' +
                ", TX_WAVELENGTH='" + TX_WAVELENGTH + '\'' +
                ", RX_CHANNEL='" + RX_CHANNEL + '\'' +
                ", RX_WAVELENGTH='" + RX_WAVELENGTH + '\'' +
                ", DISTANCE='" + DISTANCE + '\'' +
                ", TX_POWER='" + TX_POWER + '\'' +
                ", RX_POWER='" + RX_POWER + '\'' +
                ", TX_BIAS_CURRENT='" + TX_BIAS_CURRENT + '\'' +
                ", FAULT_NUMBER='" + FAULT_NUMBER + '\'' +
                ", FAULT_DISTANCE='" + FAULT_DISTANCE + '\'' +
                ", VENDOR='" + VENDOR + '\'' +
                ", PART_NUMBER='" + PART_NUMBER + '\'' +
                ", SERIAL='" + SERIAL + '\'' +
                '}';
    }
}
