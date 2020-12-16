package com.woorinet.plugin.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SYSTEM_INFO {
    String TID;
    String UID;
    String LOCATION;
    String VENDOR;
    String PWOAM;
    String BOOT_TIME;
    String RESET_REASON;

    public SYSTEM_INFO(String TID, String UID, String LOCATION, String VENDOR, String PWOAM, String BOOT_TIME, String RESET_REASON) {
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
