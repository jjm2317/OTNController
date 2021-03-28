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
    String tid;
    String uid;
    String location;
    String vendor;
    String pwoam;
    String bootTime;
    String resetReason;
    String syncDate;


    public Tl1SystemInfo() {
    }

    public Tl1SystemInfo(String tid, String uid, String location, String vendor, String pwoam, String bootTime, String resetReason, String syncDate) {
        this.tid = tid;
        this.uid = uid;
        this.location = location;
        this.vendor = vendor;
        this.pwoam = pwoam;
        this.bootTime = bootTime;
        this.resetReason = resetReason;
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1SystemInfo{" +
                "tid='" + tid + '\'' +
                ", uid='" + uid + '\'' +
                ", location='" + location + '\'' +
                ", vendor='" + vendor + '\'' +
                ", pwoam='" + pwoam + '\'' +
                ", bootTime='" + bootTime + '\'' +
                ", resetReason='" + resetReason + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
