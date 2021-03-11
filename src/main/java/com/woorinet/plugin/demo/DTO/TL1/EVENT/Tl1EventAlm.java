package com.woorinet.plugin.demo.DTO.TL1.EVENT;

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
@Table(name = "tl1_event_alm")
public class Tl1EventAlm {
    @Id
    @GeneratedValue
    int TL1_EVENT_ALM_ID;
    String TID;
    String AID;
    String NAME;
    String UNIT;
    String REASON;
    String SEV;
    String SA;
    String DATETIME;
    String EVENT_DATETIME;

    public Tl1EventAlm() {
    }

    public Tl1EventAlm(int TL1_EVENT_ALM_ID, String TID, String AID, String NAME, String UNIT, String REASON, String SEV, String SA, String DATETIME, String EVENT_DATETIME) {
        this.TL1_EVENT_ALM_ID = TL1_EVENT_ALM_ID;
        this.TID = TID;
        this.AID = AID;
        this.NAME = NAME;
        this.UNIT = UNIT;
        this.REASON = REASON;
        this.SEV = SEV;
        this.SA = SA;
        this.DATETIME = DATETIME;
        this.EVENT_DATETIME = EVENT_DATETIME;
    }

    public Tl1EventAlm(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.NAME = fields[2];
        this.UNIT = fields[3];
        this.REASON = fields[4];
        this.SEV = fields[5];
        this.SA = fields[6];
        this.DATETIME = fields[7];
        this.EVENT_DATETIME = fields[8];
    }
}
