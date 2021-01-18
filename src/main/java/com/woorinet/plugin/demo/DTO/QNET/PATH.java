package com.woorinet.plugin.demo.DTO.QNET;

public class PATH {
    String ID;
    String FAILBACKMODE;
    String FAILBACKPERIOD;
    String CONSUMERLINK;
    String PRIMARYSTR;
    String SECONDARY;
    String REMARK;

    public PATH(String ID, String FAILBACKMODE, String FAILBACKPERIOD, String CONSUMERLINK, String PRIMARYSTR, String SECONDARY, String REMARK) {
        this.ID = ID;
        this.FAILBACKMODE = FAILBACKMODE;
        this.FAILBACKPERIOD = FAILBACKPERIOD;
        this.CONSUMERLINK = CONSUMERLINK;
        this.PRIMARYSTR = PRIMARYSTR;
        this.SECONDARY = SECONDARY;
        this.REMARK = REMARK;
    }

    public PATH(String[] fields) {
        ID = fields[0];
        FAILBACKMODE = fields[1];
        FAILBACKPERIOD = fields[2];
        CONSUMERLINK = fields[3];
        PRIMARYSTR = fields[4];
        SECONDARY = fields[5];
        REMARK = fields[6];
    }

    @Override
    public String toString() {
        return "PATH{" +
                "ID='" + ID + '\'' +
                ", FAILBACKMODE='" + FAILBACKMODE + '\'' +
                ", FAILBACKPERIOD='" + FAILBACKPERIOD + '\'' +
                ", CONSUMERLINK='" + CONSUMERLINK + '\'' +
                ", PRIMARYSTR='" + PRIMARYSTR + '\'' +
                ", SECONDARY='" + SECONDARY + '\'' +
                ", REMARK='" + REMARK + '\'' +
                '}';
    }
}
