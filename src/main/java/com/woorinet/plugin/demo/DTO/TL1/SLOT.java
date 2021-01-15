package com.woorinet.plugin.demo.DTO.TL1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SLOT {
    String TID;
    String SLOT_PRV_UNIT;
    String EQ_UNIT;
    String EQ_STATE;
    String ADMIN_STATE;
    String INIT_OK;
    String BP_STATE;
    String IPC_STATE;
    String FAIL_STATE;
    String HW_VER;
    String SW_VER;
    String FPGA_VER;
    String FPGA_DATE;


    public SLOT(String TID, String SLOT_PRV_UNIT, String EQ_UNIT, String EQ_STATE, String ADMIN_STATE, String INIT_OK, String BP_STATE, String IPC_STATE, String FAIL_STATE, String HW_VER, String SW_VER, String FPGA_VER, String FPGA_DATE) {
        this.TID = TID;
        this.SLOT_PRV_UNIT = SLOT_PRV_UNIT;
        this.EQ_UNIT = EQ_UNIT;
        this.EQ_STATE = EQ_STATE;
        this.ADMIN_STATE = ADMIN_STATE;
        this.INIT_OK = INIT_OK;
        this.BP_STATE = BP_STATE;
        this.IPC_STATE = IPC_STATE;
        this.FAIL_STATE = FAIL_STATE;
        this.HW_VER = HW_VER;
        this.SW_VER = SW_VER;
        this.FPGA_VER = FPGA_VER;
        this.FPGA_DATE = FPGA_DATE;
    }

    public SLOT(String[] fields) {
        this.TID = fields[0];
        this.SLOT_PRV_UNIT = fields[1];
        this.EQ_UNIT = fields[2];
        this.EQ_STATE = fields[3];
        this.ADMIN_STATE = fields[3];
        this.INIT_OK = fields[4];
        this.BP_STATE = fields[5];
        this.IPC_STATE = fields[6];
        this.FAIL_STATE = fields[7];
        this.HW_VER = fields[8];
        this.SW_VER = fields[9];
        this.FPGA_VER = fields[10];
        this.FPGA_DATE = fields[11];
    }

    @Override
    public String toString() {
        return "Slot{" +
                "TID='" + TID + '\'' +
                ", PRV_UNIT='" + SLOT_PRV_UNIT + '\'' +
                ", EQ_UNIT='" + EQ_UNIT + '\'' +
                ", EQ_STATE='" + EQ_STATE + '\'' +
                ", ADMIN_STATE='" + ADMIN_STATE + '\'' +
                ", INIT_OK='" + INIT_OK + '\'' +
                ", BP_STATE='" + BP_STATE + '\'' +
                ", IPC_STATE='" + IPC_STATE + '\'' +
                ", FAIL_STATE='" + FAIL_STATE + '\'' +
                ", HW_VER='" + HW_VER + '\'' +
                ", SW_VER='" + SW_VER + '\'' +
                ", FPGA_VER='" + FPGA_VER + '\'' +
                ", FPGA_DATE='" + FPGA_DATE + '\'' +
                '}';
    }
}
