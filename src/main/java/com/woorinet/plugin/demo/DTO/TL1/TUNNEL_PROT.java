package com.woorinet.plugin.demo.DTO.TL1;

public class TUNNEL_PROT {
    String TID;
    String Prot_ID;
    String Tunnel_Name;
    String Descr;
    String Tunnel_ID;
    String ING_LSR_ID;
    String EGR_LSR_ID;
    String Prot_Type;
    String Revert_Mode;
    String Hold_Off_Time_msec;
    String WTR_Time_sec;
    String Active;
    String State;
    String Remain_WTR_Time_sec_;
    String Command;
    String WORKING_PID;
    String PROTECTION_PID;
    String Admin_Status;
    String Oper_Status;
    String Creation_Date;
    String Modified_Date;

    public TUNNEL_PROT(String[] fields) {
        this.TID = fields[0];
        this.Prot_ID = fields[1];
        this.Tunnel_Name = fields[2];
        this.Descr = fields[3];
        this.Tunnel_ID = fields[4];
        this.ING_LSR_ID = fields[5];
        this.EGR_LSR_ID = fields[6];
        this.Prot_Type = fields[7];
        this.Revert_Mode = fields[8];
        this.Hold_Off_Time_msec = fields[9];
        this.WTR_Time_sec = fields[10];
        this.Active = fields[11];
        this.State = fields[12];
        this.Remain_WTR_Time_sec_ = fields[13];
        this.Command = fields[14];
        this.WORKING_PID = fields[15];
        this.PROTECTION_PID = fields[16];
        this.Admin_Status = fields[17];
        this.Oper_Status = fields[18];
        this.Creation_Date = fields[19];
        this.Modified_Date = fields[20];
    }

    @Override
    public String toString() {
        return "TUNNEL_PROT{" +
                "TID='" + TID + '\'' +
                ", Prot_ID='" + Prot_ID + '\'' +
                ", Tunnel_Name='" + Tunnel_Name + '\'' +
                ", Descr='" + Descr + '\'' +
                ", Tunnel_ID='" + Tunnel_ID + '\'' +
                ", ING_LSR_ID='" + ING_LSR_ID + '\'' +
                ", EGR_LSR_ID='" + EGR_LSR_ID + '\'' +
                ", Prot_Type='" + Prot_Type + '\'' +
                ", Revert_Mode='" + Revert_Mode + '\'' +
                ", Hold_Off_Time_msec='" + Hold_Off_Time_msec + '\'' +
                ", WTR_Time_sec='" + WTR_Time_sec + '\'' +
                ", Active='" + Active + '\'' +
                ", State='" + State + '\'' +
                ", Remain_WTR_Time_sec_='" + Remain_WTR_Time_sec_ + '\'' +
                ", Command='" + Command + '\'' +
                ", WORKING_PID='" + WORKING_PID + '\'' +
                ", PROTECTION_PID='" + PROTECTION_PID + '\'' +
                ", Admin_Status='" + Admin_Status + '\'' +
                ", Oper_Status='" + Oper_Status + '\'' +
                ", Creation_Date='" + Creation_Date + '\'' +
                ", Modified_Date='" + Modified_Date + '\'' +
                '}';
    }
}
