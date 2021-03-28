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
    int l2LacpId;
    String tid;
    String lagId;
    String aid;
    String lacpMode;
    String actorSysId;
    String partnerSysId;
    String linkSync;
    String syncDate;

    public Tl1L2Lacp() {

    }

    public Tl1L2Lacp(String tid, String lagId, String aid, String lacpMode, String actorSysId, String partnerSysId, String linkSync, String syncDate) {
        this.tid = tid;
        this.lagId = lagId;
        this.aid = aid;
        this.lacpMode = lacpMode;
        this.actorSysId = actorSysId;
        this.partnerSysId = partnerSysId;
        this.linkSync = linkSync;
        this.syncDate = syncDate;
    }

    public Tl1L2Lacp(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.lagId = fields[1];
        this.aid = fields[2];
        this.lacpMode = fields[3];
        this.actorSysId = fields[4];
        this.partnerSysId = fields[5];
        this.linkSync = fields[6];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1L2Lacp{" +
                "tid='" + tid + '\'' +
                ", lagId='" + lagId + '\'' +
                ", aid='" + aid + '\'' +
                ", lacpMode='" + lacpMode + '\'' +
                ", actorSysId='" + actorSysId + '\'' +
                ", partnerSysId='" + partnerSysId + '\'' +
                ", linkSync='" + linkSync + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
