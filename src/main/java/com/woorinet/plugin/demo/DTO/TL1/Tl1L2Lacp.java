package com.woorinet.plugin.demo.DTO.TL1;

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
@Table(name = "tl1_l2_lacp")
public class Tl1L2Lacp {
    @Id
    @GeneratedValue
    int L2_LACP_ID;
    String TID;
    String LAG_ID;
    String AID;
    String LACP_MODE;
    String ACTOR_SYS_ID;
    String PARTNER_SYS_ID;
    String LINK_SYNC;

    public Tl1L2Lacp() {

    }

    public Tl1L2Lacp(String[] fields) {
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
