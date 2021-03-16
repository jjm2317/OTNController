package com.woorinet.plugin.demo.DTO.OTN;

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
@Table(name="sdn_pm_port")
public class OtnPmPort {
    @Id
    @GeneratedValue
    int PM_PORT_ID;
    String TID;
    String AID;
    String UNIT;
    String DATE;
    String TIME;
    String IN_OCTETS;
    String IN_OK_PACKETS;
    String IN_DISCARD_PACKETS;
    String IN_ERROR_PACKETS;
    String IN_PAUSE_PACKETS;
    String IN_ALIGNMENT_ERRORS;
    String IN_FCS_ERRORS;
    String IN_SYMBOL_ERRORS;
    String OUT_OCTETS;
    String OUT_OK_PACKETS;
    String OUT_UNICAST_PACKETS;
    String OUT_NON_UNICAST_PACKETS;
    String OUT_DISCARD_PACKETS;
    String OUT_ERROR_PACKETS;
    String OUT_BROADCAST_PACKETS;
    String OUT_MULTICAST_PACKETS;
    String OUT_PAUSE_PACKETS;
    String IN_RATE;
    String OUT_RATE;
    String IN_LOSS_RATIO;
    String OUT_LOSS_RATIO;

    public OtnPmPort() {

    }

    public OtnPmPort(String TID, String AID, String UNIT, String DATE, String TIME, String IN_OCTETS, String IN_OK_PACKETS, String IN_DISCARD_PACKETS, String IN_ERROR_PACKETS, String IN_PAUSE_PACKETS, String IN_ALIGNMENT_ERRORS, String IN_FCS_ERRORS, String IN_SYMBOL_ERRORS, String OUT_OCTETS, String OUT_OK_PACKETS, String OUT_UNICAST_PACKETS, String OUT_NON_UNICAST_PACKETS, String OUT_DISCARD_PACKETS, String OUT_ERROR_PACKETS, String OUT_BROADCAST_PACKETS, String OUT_MULTICAST_PACKETS, String OUT_PAUSE_PACKETS, String IN_RATE, String OUT_RATE, String IN_LOSS_RATIO, String OUT_LOSS_RATIO) {
        this.TID = TID;
        this.AID = AID;
        this.UNIT = UNIT;
        this.DATE = DATE;
        this.TIME = TIME;
        this.IN_OCTETS = IN_OCTETS;
        this.IN_OK_PACKETS = IN_OK_PACKETS;
        this.IN_DISCARD_PACKETS = IN_DISCARD_PACKETS;
        this.IN_ERROR_PACKETS = IN_ERROR_PACKETS;
        this.IN_PAUSE_PACKETS = IN_PAUSE_PACKETS;
        this.IN_ALIGNMENT_ERRORS = IN_ALIGNMENT_ERRORS;
        this.IN_FCS_ERRORS = IN_FCS_ERRORS;
        this.IN_SYMBOL_ERRORS = IN_SYMBOL_ERRORS;
        this.OUT_OCTETS = OUT_OCTETS;
        this.OUT_OK_PACKETS = OUT_OK_PACKETS;
        this.OUT_UNICAST_PACKETS = OUT_UNICAST_PACKETS;
        this.OUT_NON_UNICAST_PACKETS = OUT_NON_UNICAST_PACKETS;
        this.OUT_DISCARD_PACKETS = OUT_DISCARD_PACKETS;
        this.OUT_ERROR_PACKETS = OUT_ERROR_PACKETS;
        this.OUT_BROADCAST_PACKETS = OUT_BROADCAST_PACKETS;
        this.OUT_MULTICAST_PACKETS = OUT_MULTICAST_PACKETS;
        this.OUT_PAUSE_PACKETS = OUT_PAUSE_PACKETS;
        this.IN_RATE = IN_RATE;
        this.OUT_RATE = OUT_RATE;
        this.IN_LOSS_RATIO = IN_LOSS_RATIO;
        this.OUT_LOSS_RATIO = OUT_LOSS_RATIO;
    }

    @Override
    public String toString() {
        return "SdnPmPort{" +
                "TID='" + TID + '\'' +
                ", AID='" + AID + '\'' +
                ", UNIT='" + UNIT + '\'' +
                ", DATE='" + DATE + '\'' +
                ", TIME='" + TIME + '\'' +
                ", IN_OCTETS='" + IN_OCTETS + '\'' +
                ", IN_OK_PACKETS='" + IN_OK_PACKETS + '\'' +
                ", IN_DISCARD_PACKETS='" + IN_DISCARD_PACKETS + '\'' +
                ", IN_ERROR_PACKETS='" + IN_ERROR_PACKETS + '\'' +
                ", IN_PAUSE_PACKETS='" + IN_PAUSE_PACKETS + '\'' +
                ", IN_ALIGNMENT_ERRORS='" + IN_ALIGNMENT_ERRORS + '\'' +
                ", IN_FCS_ERRORS='" + IN_FCS_ERRORS + '\'' +
                ", IN_SYMBOL_ERRORS='" + IN_SYMBOL_ERRORS + '\'' +
                ", OUT_OCTETS='" + OUT_OCTETS + '\'' +
                ", OUT_OK_PACKETS='" + OUT_OK_PACKETS + '\'' +
                ", OUT_UNICAST_PACKETS='" + OUT_UNICAST_PACKETS + '\'' +
                ", OUT_NON_UNICAST_PACKETS='" + OUT_NON_UNICAST_PACKETS + '\'' +
                ", OUT_DISCARD_PACKETS='" + OUT_DISCARD_PACKETS + '\'' +
                ", OUT_ERROR_PACKETS='" + OUT_ERROR_PACKETS + '\'' +
                ", OUT_BROADCAST_PACKETS='" + OUT_BROADCAST_PACKETS + '\'' +
                ", OUT_MULTICAST_PACKETS='" + OUT_MULTICAST_PACKETS + '\'' +
                ", OUT_PAUSE_PACKETS='" + OUT_PAUSE_PACKETS + '\'' +
                ", IN_RATE='" + IN_RATE + '\'' +
                ", OUT_RATE='" + OUT_RATE + '\'' +
                ", IN_LOSS_RATIO='" + IN_LOSS_RATIO + '\'' +
                ", OUT_LOSS_RATIO='" + OUT_LOSS_RATIO + '\'' +
                '}';
    }
}