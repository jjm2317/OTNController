package com.woorinet.plugin.demo.DTO.TL1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class L2_LACP {
    String TID;
    String LAG_ID;
    String AID;
    String LACP_MODE;
    String ACTOR_SYS_ID;
    String PARTNER_SYS_ID;
    String LINK_SYNC;

    public L2_LACP(String[] fields) {
        this.TID = fields[0];
        this.LAG_ID = fields[1];
        this.AID = fields[2];
        this.LACP_MODE = fields[3];
        this.ACTOR_SYS_ID = fields[4];
        this.PARTNER_SYS_ID = fields[5];
        this.LINK_SYNC = fields[6];
    }

    @Override
    public String toString() {
        return "L2_LACP{" +
                "TID='" + TID + '\'' +
                ", LAG_ID='" + LAG_ID + '\'' +
                ", AID='" + AID + '\'' +
                ", LACP_MODE='" + LACP_MODE + '\'' +
                ", ACTOR_SYS_ID='" + ACTOR_SYS_ID + '\'' +
                ", PARTNER_SYS_ID='" + PARTNER_SYS_ID + '\'' +
                ", LINK_SYNC='" + LINK_SYNC + '\'' +
                '}';
    }
}
