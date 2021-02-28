package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name = "TL1_PM_PORT")
public class PM_PORT {
    @Id
    @GeneratedValue
    int PM_PORT_ID;
    String TID;
    String AID;
    String UNIT;
    String TYPE;
    String DATE;
    String TIME;
    String IN_OCTETS;
    String IN_OK_PACKETS;
    String IN_UNICAST_PACKETS;
    String IN_NON_UNICAST_PACKETS;
    String IN_DISCARD_PACKETS;
    String IN_ERROR_PACKETS;
    String IN_BROADCAST_PACKETS;
    String IN_MULTICAST_PACKETS;
    String IN_PACKETS_64_OCTETS;
    String IN_PACKETS_65_TO_127_OCTETS;
    String IN_PACKETS_128_TO_255_OCTETS;
    String IN_PACKETS_256_TO_511_OCTETS;
    String IN_PACKETS_512_TO_1023_OCTETS;
    String IN_PACKETS_1024_TO_1518_OCTETS;
    String IN_PACKETS_1519_TO_MAX_OCTETS;
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

    public PM_PORT() {

    }

    public PM_PORT(String []fields) {
        this.TID = fields[0];
        this.AID = fields[1];
        this.UNIT = fields[2];
        this.TYPE = fields[3];
        this.DATE = fields[4];
        this.TIME = fields[5];
        this.IN_OCTETS = fields[6];
        this.IN_OK_PACKETS = fields[7];
        this.IN_UNICAST_PACKETS = fields[8];
        this.IN_NON_UNICAST_PACKETS = fields[9];
        this.IN_DISCARD_PACKETS = fields[10];
        this.IN_ERROR_PACKETS = fields[11];
        this.IN_BROADCAST_PACKETS = fields[12];
        this.IN_MULTICAST_PACKETS = fields[13];
        this.IN_PACKETS_64_OCTETS = fields[14];
        this.IN_PACKETS_65_TO_127_OCTETS = fields[15];
        this.IN_PACKETS_128_TO_255_OCTETS = fields[16];
        this.IN_PACKETS_256_TO_511_OCTETS = fields[17];
        this.IN_PACKETS_512_TO_1023_OCTETS = fields[18];
        this.IN_PACKETS_1024_TO_1518_OCTETS = fields[19];
        this.IN_PACKETS_1519_TO_MAX_OCTETS = fields[20];
        this.IN_PAUSE_PACKETS = fields[21];
        this.IN_ALIGNMENT_ERRORS = fields[22];
        this.IN_FCS_ERRORS = fields[23];
        this.IN_SYMBOL_ERRORS = fields[24];
        this.OUT_OCTETS = fields[25];
        this.OUT_OK_PACKETS = fields[26];
        this.OUT_UNICAST_PACKETS = fields[27];
        this.OUT_NON_UNICAST_PACKETS = fields[28];
        this.OUT_DISCARD_PACKETS = fields[29];
        this.OUT_ERROR_PACKETS = fields[30];
        this.OUT_BROADCAST_PACKETS = fields[31];
        this.OUT_MULTICAST_PACKETS = fields[32];
        this.OUT_PAUSE_PACKETS = fields[33];
        this.IN_RATE = fields[34];
        this.OUT_RATE = fields[35];
        this.IN_LOSS_RATIO = fields[36];
        this.OUT_LOSS_RATIO = fields[37];
    }

    public PM_PORT(String TID, String AID, String UNIT, String TYPE, String DATE, String TIME, String IN_OCTETS, String IN_OK_PACKETS, String IN_UNICAST_PACKETS, String IN_NON_UNICAST_PACKETS, String IN_DISCARD_PACKETS, String IN_ERROR_PACKETS, String IN_BROADCAST_PACKETS, String IN_MULTICAST_PACKETS, String IN_PACKETS_64_OCTETS, String IN_PACKETS_65_TO_127_OCTETS, String IN_PACKETS_128_TO_255_OCTETS, String IN_PACKETS_256_TO_511_OCTETS, String IN_PACKETS_512_TO_1023_OCTETS, String IN_PACKETS_1024_TO_1518_OCTETS, String IN_PACKETS_1519_TO_MAX_OCTETS, String IN_PAUSE_PACKETS, String IN_ALIGNMENT_ERRORS, String IN_FCS_ERRORS, String IN_SYMBOL_ERRORS, String OUT_OCTETS, String OUT_OK_PACKETS, String OUT_UNICAST_PACKETS, String OUT_NON_UNICAST_PACKETS, String OUT_DISCARD_PACKETS, String OUT_ERROR_PACKETS, String OUT_BROADCAST_PACKETS, String OUT_MULTICAST_PACKETS, String OUT_PAUSE_PACKETS, String IN_RATE, String OUT_RATE, String IN_LOSS_RATIO, String OUT_LOSS_RATIO) {
        this.TID = TID;
        this.AID = AID;
        this.UNIT = UNIT;
        this.TYPE = TYPE;
        this.DATE = DATE;
        this.TIME = TIME;
        this.IN_OCTETS = IN_OCTETS;
        this.IN_OK_PACKETS = IN_OK_PACKETS;
        this.IN_UNICAST_PACKETS = IN_UNICAST_PACKETS;
        this.IN_NON_UNICAST_PACKETS = IN_NON_UNICAST_PACKETS;
        this.IN_DISCARD_PACKETS = IN_DISCARD_PACKETS;
        this.IN_ERROR_PACKETS = IN_ERROR_PACKETS;
        this.IN_BROADCAST_PACKETS = IN_BROADCAST_PACKETS;
        this.IN_MULTICAST_PACKETS = IN_MULTICAST_PACKETS;
        this.IN_PACKETS_64_OCTETS = IN_PACKETS_64_OCTETS;
        this.IN_PACKETS_65_TO_127_OCTETS = IN_PACKETS_65_TO_127_OCTETS;
        this.IN_PACKETS_128_TO_255_OCTETS = IN_PACKETS_128_TO_255_OCTETS;
        this.IN_PACKETS_256_TO_511_OCTETS = IN_PACKETS_256_TO_511_OCTETS;
        this.IN_PACKETS_512_TO_1023_OCTETS = IN_PACKETS_512_TO_1023_OCTETS;
        this.IN_PACKETS_1024_TO_1518_OCTETS = IN_PACKETS_1024_TO_1518_OCTETS;
        this.IN_PACKETS_1519_TO_MAX_OCTETS = IN_PACKETS_1519_TO_MAX_OCTETS;
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
}
