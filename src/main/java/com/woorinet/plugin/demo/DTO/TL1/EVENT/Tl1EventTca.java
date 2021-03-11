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
@Table(name = "tl1_event_tca")
public class Tl1EventTca {
    @Id
    @GeneratedValue
    int TL1_EVENT_TCA_ID;
    String TID;
    String AID;
    String UNIT;
    String SIGNAL;
    String TIME;
    String PM_ELEMENT;
    String DATETIME;
    String EVENT_DATETIME;

    public Tl1EventTca() {
    }
    public Tl1EventTca(String TID, String AID, String UNIT, String SIGNAL, String TIME, String PM_ELEMENT, String DATETIME, String EVENT_DATETIME) {
        this.TID = TID;
        this.AID = AID;
        this.UNIT = UNIT;
        this.SIGNAL = SIGNAL;
        this.TIME = TIME;
        this.PM_ELEMENT = PM_ELEMENT;
        this.DATETIME = DATETIME;
        this.EVENT_DATETIME = EVENT_DATETIME;
    }
    public Tl1EventTca(String[] fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.UNIT = fields[2];
        this.SIGNAL = fields[3];
        this.TIME = fields[4];
        this.PM_ELEMENT = fields[5];
        this.DATETIME = fields[6];
        this.EVENT_DATETIME = fields[7];
    }


}
