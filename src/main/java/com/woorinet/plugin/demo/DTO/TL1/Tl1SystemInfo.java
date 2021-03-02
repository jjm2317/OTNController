package com.woorinet.plugin.demo.DTO.TL1;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name = "tl1_system_info")
public class Tl1SystemInfo {
    @Id
    @Generated
    String TID;
    String UID;
    String LOCATION;
    String VENDOR;
    String PWOAM;
    String BOOT_TIME;
    String RESET_REASON;

    public Tl1SystemInfo() {
    }

    public Tl1SystemInfo(String TID, String UID, String LOCATION, String VENDOR, String PWOAM, String BOOT_TIME, String RESET_REASON) {
        this.TID = TID;
        this.UID = UID;
        this.LOCATION = LOCATION;
        this.VENDOR = VENDOR;
        this.PWOAM = PWOAM;
        this.BOOT_TIME = BOOT_TIME;
        this.RESET_REASON = RESET_REASON;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "TID='" + TID + '\'' +
                ", UID='" + UID + '\'' +
                ", LOCATION='" + LOCATION + '\'' +
                ", VENDOR='" + VENDOR + '\'' +
                ", PWOAM='" + PWOAM + '\'' +
                ", BOOT_TIME='" + BOOT_TIME + '\'' +
                ", RESET_REASON='" + RESET_REASON + '\'' +
                '}';
    }
}
